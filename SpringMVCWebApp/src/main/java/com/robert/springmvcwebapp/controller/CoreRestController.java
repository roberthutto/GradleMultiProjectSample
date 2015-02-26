package com.robert.springmvcwebapp.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoreRestController {

    @RequestMapping(value = "/reflect/{value}", method = RequestMethod.GET)
    public Wrapper getOffers(@PathVariable String value) {

        Wrapper wrapper = new Wrapper();
        wrapper.value = value;
        return wrapper;
    }
}
