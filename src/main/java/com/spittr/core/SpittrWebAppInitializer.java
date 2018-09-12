package com.spittr.core;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// THE DISPATCHER SERVLET
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // loads the application context with beans defined in RootConfig class
    // basically, the core level beans
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    // loads the application context with beans defined in WebConfig class
    // basically, the web related beans
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"} ;
    }
}
