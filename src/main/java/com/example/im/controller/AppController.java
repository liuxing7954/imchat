package com.example.im.controller;

import com.example.im.client.ChatGroupClient;
import com.example.im.client.UserClient;
import com.example.im.config.EaseConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AppController {

    @Autowired
    UserClient userClient;
    @Autowired
    ChatGroupClient chatGroupClient;

    @Autowired
    EaseConfig config;

    @RequestMapping("/hello")
    public String hello() {
        return "hello world~";
    }

    @RequestMapping("/getUser")
    public Object getUser(String username) {
        return userClient.getUser(username);
    }

    @RequestMapping("/deactivateUser")
    public Object deactivateUser(String username) {
        return userClient.deactivateUser(username);
    }
    @RequestMapping("/activateUser")
    public Object activateUser(String username) {
        return userClient.activateUser(username);
    }
    @RequestMapping("/getAdminList")
    public Object getAdminList(String id) {
        return chatGroupClient.getAdmin(id);
    }

}
