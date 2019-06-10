package com.example.im.client;

import com.alibaba.fastjson.JSONObject;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface UserClient {

    @RequestLine("GET /users/{username}")
    Object getUser(@Param("username") String username);

    @RequestLine("POST /users/{username}/deactivate")
    Object deactivateUser(@Param("username") String username);

    @RequestLine("POST /users/{username}/activate")
    Object activateUser(@Param("username") String username);
}
