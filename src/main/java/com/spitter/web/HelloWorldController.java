package com.spitter.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Controllers are nothing but Components according to spring but for Web context
// hence the respective beans are created the same way as for Components
@Controller
public class HelloWorldController {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String display(){
        return "Hello Word! Elavazhagan Sethuraman";
    }
}
