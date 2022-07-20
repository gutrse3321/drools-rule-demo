package ru.reimu.alice.appserver.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ru.reimu.alice.constant.DefaultConstant;
import ru.reimu.alice.constant.ErrorCode;
import ru.reimu.alice.exception.EXPF;
import ru.reimu.alice.support.StringUtility;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-05-14 21:57
 */
@Aspect
@Component
@Slf4j
public class WeChatAuthAspect {

    @Pointcut("@annotation(ru.reimu.alice.appserver.aop.annotation.Auth)")
    public void WeChatAuthPointCut() {}

    @Before("WeChatAuthPointCut()")
    public void doBefore(JoinPoint jp) throws Exception {
        Exception loginFail = EXPF.exception(ErrorCode.NotLogin, "登录过期", true);
        String reqToken = getToken();

        if (!StringUtility.allNotBlank(reqToken)) {
            throw loginFail;
        }
    }

    private String getToken() {
        try {
            String token = getRequest().getHeader(DefaultConstant.WECHAT_TOKEN);
            return StringUtility.substringAfter(token, "rabbit ");
        } catch (Exception e) {
            log.warn("【AUTH token传参异常】");
        }

        return null;
    }

    private HttpServletRequest getRequest() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        return request;
    }
}
