package com.example.demo;

import com.example.demo.formatter.NationFormatter;
import com.example.demo.service.NationService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class WebConfig implements WebMvcConfigurer, ApplicationContextAware {

    private ApplicationContext appContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new NationFormatter(appContext.getBean(NationService.class)));
    }

}