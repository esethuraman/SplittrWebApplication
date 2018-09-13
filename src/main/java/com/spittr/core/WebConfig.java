package com.spittr.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


// the EnableWebMVC annotation activates the MVC mode
@Configuration
@EnableWebMvc
@ComponentScan("com.spittr.web")
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver(){

        // InternalResourceViewResolver is meant for jsp view rendering
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();

        resourceViewResolver.setPrefix("/WEB-INF/views/");
        resourceViewResolver.setSuffix(".jsp");
        resourceViewResolver.setExposeContextBeansAsAttributes(true);

        // if JSTL (java standard library tags list) are to be used for resolving,
//        resourceViewResolver.setViewClass(JstlView.class);

        return resourceViewResolver;
    }

    public void configuredefaultServiceHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }

}
