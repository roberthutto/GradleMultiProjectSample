package com.robert.springmvcwebapp;

import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Class bridges java util logging to slf4j
 */
@Component
public class JulToSlf4jLoggingBridge {    
    @PostConstruct
    private void init() {

        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }    
}
