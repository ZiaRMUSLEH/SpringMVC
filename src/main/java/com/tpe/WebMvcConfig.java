package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan//("com.tpe")
public class WebMvcConfig implements WebMvcConfigurer {

    // ViewResolver     -->     ModelAndView --> View
    @Bean
    public InternalResourceViewResolver resolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        // Setting the View class to .jsp
        resolver.setViewClass(JstlView.class);
        // Specify the folder to check for views
        resolver.setPrefix("/WEB-INF/views/");
        // Specify the extension
        resolver.setSuffix(".jsp");
        return resolver;
    }

    // Specifying the Resources That'll be Used For My Front-End
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Find the resources from the path I give
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/")
                .setCachePeriod(0);     // Giving a period time for caching
    }
}