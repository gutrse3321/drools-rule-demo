package ru.reimu.alice.appserver.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.reimu.alice.constant.Constant;
import ru.reimu.alice.persist.entity.RuleEntity;
import ru.reimu.alice.service.DroolsService;
import ru.reimu.alice.springExtension.view.MVF;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-07-20 17:30
 */
@RequestMapping("/")
@RestController
public class DroolsController {

    private DroolsService droolsService;

    public DroolsController(DroolsService droolsService) {
        this.droolsService = droolsService;
    }

    @PostMapping("addRule")
    public ModelAndView addRule(String baseName,
                                String packageName,
                                String content) throws Exception {
        RuleEntity ent = new RuleEntity();
        ent.setKieBaseName(baseName);
        ent.setKiePackageName(packageName);
        ent.setRuleContent(content);
        droolsService.insertRule(ent);
        return MVF.msgData(Constant.MsgData.Add);
    }

    @PostMapping("triggerRule")
    public ModelAndView triggerRule(String baseName,
                                    Integer param) throws Exception {
        return MVF.filterData(droolsService.triggerRule(baseName, param));
    }

    @PostMapping("deleteRule")
    public ModelAndView deleteRule(Long ruleId) throws Exception {
        RuleEntity ent = new RuleEntity();
        ent.setId(ruleId);
        droolsService.deleteRule(ent, null);
        return MVF.msgData(Constant.MsgData.Del);
    }
}
