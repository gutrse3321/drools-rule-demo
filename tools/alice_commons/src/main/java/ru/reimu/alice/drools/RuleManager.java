package ru.reimu.alice.drools;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.kie.builder.impl.InternalKieModule;
import org.drools.compiler.kie.builder.impl.KieContainerImpl;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.builder.model.KieBaseModel;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.definition.KiePackage;
import org.kie.api.definition.rule.Rule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.reimu.alice.constant.ErrorCode;
import ru.reimu.alice.drools.model.RuleDataModel;
import ru.reimu.alice.exception.EXPF;

import java.util.Collection;
import java.util.List;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-07-20 11:27
 */
public class RuleManager {

    protected static final Logger log = LoggerFactory.getLogger(ru.reimu.alice.drools.RuleManager.class);

    private final KieServices kieServices;
    private final KieFileSystem kieFileSystem;
    private final KieModuleModel kieModuleModel; //虚拟kmodule.xml
    private KieContainer kieContainer; //全局唯一规则容器

    public RuleManager(KieServices kieServices,
                       KieFileSystem kieFileSystem,
                       KieModuleModel kieModuleModel) {
        this.kieServices = kieServices;
        this.kieFileSystem = kieFileSystem;
        this.kieModuleModel = kieModuleModel;
    }

    /**
     * 获取规则会话
     * @param kieBaseName
     * @return
     */
    public KieSession getSession(String kieBaseName) {
        return kieContainer.newKieSession(kieBaseName + "-session");
    }

    /**
     * 触发规则
     * @param kieBaseName
     * @param insertParam
     * @param <T> 插入值
     * @param <R> 返回对象
     * @return
     */
    public <T, R> RuleDataModel<R> fireRule(String kieBaseName,
                                            T insertParam) throws Exception {
        KieSession session;
        try {
            session = getSession(kieBaseName);
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                throw EXPF.exception(ErrorCode.DataNotExists, "没有找到此规则", true);
            }
            throw EXPF.exception(ErrorCode.DataException, "获取规则会话失败", true);
        }
        RuleDataModel<R> model = new RuleDataModel<>();
        model.setKieBaseName(kieBaseName);
        session.setGlobal("ruleData", model);
        session.insert(insertParam);
        session.fireAllRules();
        session.dispose();
        return model;
    }

    /**
     * 判断该kbase是否存在
     */
    public boolean existsKieBase(String kieBaseName) {
        if (null == kieContainer) {
            return false;
        }
        Collection<String> kieBaseNames = kieContainer.getKieBaseNames();
        if (kieBaseNames.contains(kieBaseName)) {
            return true;
        }
        log.info("需要创建KieBase: {}", kieBaseName);
        return false;
    }

    /**
     * 删除kieBase包的某个规则规则
     * @param kieBaseName
     * @param packageName
     * @param ruleName
     */
    public void deleteDroolsRule(String kieBaseName,
                                 String packageName,
                                 String ...ruleName) {
        if (existsKieBase(kieBaseName)) {
            KieBase kieBase = kieContainer.getKieBase(kieBaseName);
            if (ruleName.length > 0) {
                for (String s : ruleName) {
                    kieBase.removeRule(packageName, s);
                }
            } else {
                KiePackage kiePackage = kieBase.getKiePackage(packageName);
                for (Rule rule : kiePackage.getRules()) {
                    kieBase.removeRule(packageName, rule.getName());
                }
            }

            log.info("删除kieBase:[{}]包:[{}]下的规则", kieBaseName, packageName);
        }
    }

    public void addOrUpdateRule(Long ruleId,
                                String kieBaseName,
                                String kiePackageName,
                                String ruleContent) throws Exception {
        // 判断该kbase是否存在
        boolean existsKieBase = existsKieBase(kieBaseName);
        // 该对象对应kmodule.xml中的kbase标签
        KieBaseModel kieBaseModel;
        if (!existsKieBase) {
            // 创建一个kbase
            kieBaseModel = kieModuleModel.newKieBaseModel(kieBaseName);
            // 不是默认的kieBase
            kieBaseModel.setDefault(false);
            // 设置该KieBase需要加载的包路径
            kieBaseModel.addPackage(kiePackageName);
            // 设置kieSession
            kieBaseModel.newKieSessionModel(kieBaseName + "-session")
                    // 不是默认session
                    .setDefault(false);
        } else {
            // 获取到已经存在的kbase对象
            kieBaseModel = kieModuleModel.getKieBaseModels().get(kieBaseName);
            // 获取到packages
            List<String> packages = kieBaseModel.getPackages();
            if (!packages.contains(kiePackageName)) {
                kieBaseModel.addPackage(kiePackageName);
                log.info("kieBase:{}添加一个新的包:{}", kieBaseName, kiePackageName);
            } else {
                kieBaseModel = null;
            }
        }
        String file = "src/main/resources/" + kiePackageName + "/" + ruleId + ".drl";
        log.info("加载虚拟规则文件:{}", file);
        kieFileSystem.write(file, ruleContent);

        if (kieBaseModel != null) {
            String kmoduleXml = kieModuleModel.toXML();
            log.info("加载kmodule.xml:[\n{}]", kmoduleXml);
            kieFileSystem.writeKModuleXML(kmoduleXml);
        }

        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        // 通过KieBuilder构建KieModule下所有的KieBase
        kieBuilder.buildAll();
        // 获取构建过程中的结果
        Results results = kieBuilder.getResults();
        // 获取错误信息
        List<Message> messages = results.getMessages(Message.Level.ERROR);
        if (null != messages && !messages.isEmpty()) {
            for (Message message : messages) {
                log.error(message.getText());
            }
            throw EXPF.exception(ErrorCode.NoPermissionToUse, "规则内容语法有误", true);
        }
        // KieContainer只有第一次时才需要创建，之后就是使用这个
        if (null == kieContainer) {
            kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
        } else {
            // 实现动态更新
            ((KieContainerImpl) kieContainer).updateToKieModule((InternalKieModule) kieBuilder.getKieModule());
        }
    }
}
