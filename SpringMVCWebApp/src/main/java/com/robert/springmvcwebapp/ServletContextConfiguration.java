package com.robert.springmvcwebapp;

import com.robert.springmvcwebapp.controller.CoreRestController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
/**
 * @EnableWebMvc activates annotation-driven controller request mapping and replaces <mvc:annotation-driven>.
 * This activates a very complex configuration, which you often must customize. You can customize the entire Web MVC
 * configuration by making your @Configuration class implement WebMvcConfigurer or, more easily, customize only the
 * pieces that you need to by extending WebMvcConfigurerAdapter.
 */
@EnableWebMvc
@ComponentScan(basePackageClasses = CoreRestController.class)
public class ServletContextConfiguration {
}
