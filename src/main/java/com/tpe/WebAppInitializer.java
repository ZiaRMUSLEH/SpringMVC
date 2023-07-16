package com.tpe;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Instead of the web.xml we had earlier, we are going to use this class for configurations.
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Getting the configurations related to the Hibernate and Database.
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                RootContextConfig.class
        };
    }

    // MVC Configurations
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebMvcConfig.class
        };
    }

    // Which url would go to which servlet
    @Override
    protected String[] getServletMappings() {
        return new String[]{
                "/"
        };
    }
}