package com.example.im;

import com.alibaba.fastjson.JSON;
import com.example.im.controller.AppController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoApplicationTests {


    @Autowired
    AppController appController;

    @Test
    public void contextLoads() {
        String username = "liuxing7954";
        Object user = appController.getUser(username);//linktreemap类型
        log.info("获取用户信息:{}", JSON.toJSONString(user));
        Object o = appController.deactivateUser(username);
        log.info("禁用用户:{}", JSON.toJSONString(o));
        Object o1 = appController.activateUser(username);
        log.info("解禁用户:{}", JSON.toJSONString(o1));
    }
    @Test
    public void contextLoads1() {

    }

}
