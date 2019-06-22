package com.env.service;

import com.alibaba.fastjson.JSON;
import com.env.mapper.StudentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestService.class);

    @Value("${envName}")
    private String envName;

    @Value("${age}")
    private String age;

    @Value("${address}")
    private String address;

    @Resource
    private StudentMapper studentMapper;

    public void test() {
        LOGGER.info("student = {}", JSON.toJSONString(studentMapper.selectOne(1)));
        LOGGER.info("envName = {}, age = {}, address = {}", envName, age, address);
    }
}
