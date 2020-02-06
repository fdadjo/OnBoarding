package com.pkfrc.digital.onboarding.digital_onboarding.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }
}