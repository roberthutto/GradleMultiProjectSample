package com.robert.springaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by rhutto@ on 2/22/15.
 */
public class Application {

    public static void main(String [] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

    }
}
