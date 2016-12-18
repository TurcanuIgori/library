package com.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
@Configuration
@EnableWebMvc
@ComponentScan("com.library")
//@EnableJpaRepositories
//@EnableTransactionManagement
public class WebbAppConfig extends WebMvcConfigurerAdapter{
	
	@Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
	    }
	 
	 @Bean
	 public UrlBasedViewResolver setupViewResolver() {
		 UrlBasedViewResolver resolver = new UrlBasedViewResolver();
	     resolver.setPrefix("/pages/");
	     resolver.setSuffix(".jsp");
	     resolver.setViewClass(JstlView.class);
	     return resolver;
	 }

	 @Bean
    public CommonsMultipartResolver multipartResolver(){
    	return new CommonsMultipartResolver();
    }
}
