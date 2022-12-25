package com.sula.ranjith_learners.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfigs {

    @Configuration
    @EnableWebMvc
    public class WebConfig implements WebMvcConfigurer {

        /*@Value("${appName.allowedApi}")
        private String myAllowedApi;

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins(myAllowedApi);
        }*/
    }

}
