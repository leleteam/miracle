package com.dream.boot.config;

import com.dream.boot.interceptors.SiteACLInterceptor;
import com.dream.boot.support.Java8TimeModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import javax.validation.Validator;

@Configuration
@ComponentScan({"com.dream.admin.controller", "com.dream.site.controller"})
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    protected SiteACLInterceptor aclInterceptor;

    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/bower_components/**").addResourceLocations("file:./src-web/bower_components/");
        registry.addResourceHandler("/site/styles/**").addResourceLocations("file:./src-web/site/app/styles/");
        registry.addResourceHandler("/admin/styles/**").addResourceLocations("file:./src-web/admin/app/styles/");
        registry.addResourceHandler("/site/images/**").addResourceLocations("file:./src-web/site/app/images/");
        registry.addResourceHandler("/admin/images/**").addResourceLocations("file:./src-web/admin/app/images/");
        registry.addResourceHandler("/site/scripts/**").addResourceLocations("file:./src-web/site/app/scripts/");
        registry.addResourceHandler("/admin/scripts/**").addResourceLocations("file:./src-web/admin/app/scripts/");
        registry.addResourceHandler("/files/**").addResourceLocations("file:../files/");
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/swagger/v2/api-docs", "/v2/api-docs?group=restful-api");
        registry.addRedirectViewController("/swagger/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui");
        registry.addRedirectViewController("/swagger/swagger-resources/configuration/security", "/swagger-resources/configuration/security");
        registry.addRedirectViewController("/swagger/swagger-resources", "/swagger-resources");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(aclInterceptor).addPathPatterns("/**");
    }

    @PostConstruct
    private void jacksonConfig() {
        objectMapper.registerModule(new Java8TimeModule());
    }

    @Bean(name = "validator")
    public Validator createBeanValidator() {
        return new LocalValidatorFactoryBean();
    }

}
