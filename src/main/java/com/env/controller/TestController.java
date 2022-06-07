package com.env.controller;

import com.env.constants.Constants;
import com.env.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class TestController {


    @Resource
    private TestService testService;

    @GetMapping(value = "/test")
    public void test() {
        testService.test();
    }


    @PostMapping(value = "/refresh")
    public void refresh(@RequestBody Map<String, String> param) {
        Constants.getInstance().refresh(param);
        System.out.println(Constants.PAY_TIMEOUT_TIME);
    }
}
