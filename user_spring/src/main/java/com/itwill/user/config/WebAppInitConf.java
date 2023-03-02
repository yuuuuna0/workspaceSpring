package com.itwill.user.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
/*
 * web.xml설정을 대신할 클래스
 * -  톰캣실행시 기본설정
 */
public class WebAppInitConf implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
				AnnotationConfigWebApplicationContext context = 
						new AnnotationConfigWebApplicationContext();
				context.register(WebConfig.class);
				ServletRegistration.Dynamic dynamic=
						servletContext.addServlet("dispatcherSevlet", new DispatcherServlet(context));
				dynamic.setLoadOnStartup(0);
				dynamic.addMapping("/");
				/*
				//ApplicationConfig.java : config 설정 클래스를 지정해주는 것
				AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
				applicationContext.register(ApplicationConfig.class);
				//Listener
				servletContext.addListener(new ContextLoaderListener(applicationContext));
				//WebConfig.java
				AnnotationConfigWebApplicationContext servletConfig = new AnnotationConfigWebApplicationContext();
				servletConfig.register(WebConfig.class);
				ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(servletConfig));
				dispatcherServlet.setLoadOnStartup(1);
				dispatcherServlet.addMapping("/");
				//encodingFilter
				FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter("UTF-8", true));
				filterRegistration.addMappingForUrlPatterns(null, true, "/*");
				*/
	}
	
}
