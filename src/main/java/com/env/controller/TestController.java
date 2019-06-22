package com.env.controller;

import com.env.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {


    @Resource
    private TestService testService;

    @GetMapping(value = "/test")
    public void test() {
        testService.test();
    }
}
