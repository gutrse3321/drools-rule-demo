package ru.reimu.alice.springExtension.interceptor;

import ru.reimu.alice.springExtension.resolver.CurrentUserMethodArgumentResolver;
import ru.reimu.alice.springExtension.resolver.RequestModelMethodArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @date 2020-09-23 15:06
 *
 * 参数映射解析器
 */
@Configuration
public class AdapterConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new RequestModelMethodArgumentResolver());
        argumentResolvers.add(new CurrentUserMethodArgumentResolver());
    }
}
