package com.spittr.core;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// THE DISPATCHER SERVLET
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // loads the application context with beans defined in RootConfig class
    // basically, the core level beans
    public Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    // loads the application context with beans defined in WebConfig class
    // basically, the web related beans
    public Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    public String[] getServletMappings() {
        return new String[] {"/"} ;
    }
}
