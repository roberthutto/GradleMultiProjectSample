package com.robert.springmvcwebapp;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Programmatic configuration of the instead of web.xml
 */
public class Bootstrap implements WebApplicationInitializer {


    /**
     *  Listener Initialized first to load rootSpringContext. RootContext should contain business objects
     *  or data access objects. ServletContext are cannot access beans from other ServletContext. ServletContext should
     *  contains beans specific to the Servlet such as controllers
     *
     * @param container the servlet context for this webapplication
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext container) throws ServletException {

        /**
         * If you plan to map the DispatcherServlet to the application root, make sure you account for static resources
         * such as HTML pages, CSS and JavaScript files, and images. Some online tutorials demonstrate how to set up
         * Spring Framework to serve static resources, but doing so is not necessary and does not perform well. When
         * any Servlet is mapped to the application root (without an asterisk), more-specific URL patterns always
         * override it. So permitting your Servlet container to serve static resources is as simple as adding mappings
         * for those resources to the Servlet named default (which all containers provide automatically). This can be
         * accomplished in the deployment descriptor like so:
         */
        container.getServletRegistration("default").addMapping( "/resources/*", "*.css", "*.js", "*.png", "*.gif", "*.jpg");


        /**
         * Register rootContext
         * The root application context should hold services, repositories, and other pieces of business logic, whereas
         * the DispatcherServlet’s application context should contain web controllers
         */
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootContextConfiguration.class);
        container.addListener(new ContextLoaderListener(rootContext));

        //Register servletContext and Create Dispatcher servlet
        AnnotationConfigWebApplicationContext servletContext = new AnnotationConfigWebApplicationContext();
        servletContext.register(ServletContextConfiguration.class);
        ServletRegistration.Dynamic dispatcher = container.addServlet("springDispatcher", new DispatcherServlet(servletContext));
        dispatcher.setLoadOnStartup(1);

        /**
         * The lone forward slash without an asterisk is sufficient to get the Servlet to respond to all URLs in your
         * application and while still enabling the Servlet container’s JSP mechanism to handle JSP requests A trailing
         * asterisk causes the Servlet container to send even internal JSP requests to that Servlet, which is not desirable
         */
        dispatcher.addMapping("/");


    }
}
