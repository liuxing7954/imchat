package com.example.im.config;

import com.example.im.client.ChatGroupClient;
import com.example.im.client.TokenClient;
import com.example.im.client.UserClient;
import com.example.im.helper.TokenHelper;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static feign.FeignException.errorStatus;

@SuppressWarnings("Duplicates")
@Configuration
@Slf4j
public class FeignConfig {
    @Autowired
    EaseConfig easeConfig;
    @Autowired
    TokenHelper tokenHelper;

    @Bean
    public TokenClient getTokenClient() {
        TokenClient client = Feign.builder()
                .logLevel(Logger.Level.FULL)
                .logger(new Slf4jLogger())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(TokenClient.class, "http://a1.easemob.com/" + easeConfig.getOrgname() + "/" + easeConfig.getAppname());
        return client;
    }
    @Bean
    public UserClient getEaseClient() {
        UserClient client = Feign.builder()
                .logLevel(Logger.Level.FULL)
                .logger(new Slf4jLogger())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .requestInterceptor(template -> template.header("Authorization", "Bearer " + tokenHelper.getToken()))
                .errorDecoder((methodKey, response) -> {
                    log.error("请求访问失败,方法名:{},状态码:{}", methodKey, response.status());
                    return errorStatus(methodKey, response);
                })
                .target(UserClient.class, "http://a1.easemob.com/" + easeConfig.getOrgname() + "/" + easeConfig.getAppname());
        return client;
    }

    @Bean
    public ChatGroupClient getChatGroupClient() {
        ChatGroupClient client = Feign.builder()
                .logLevel(Logger.Level.FULL)
                .logger(new Slf4jLogger())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .requestInterceptor(template -> template.header("Authorization", "Bearer " + tokenHelper.getToken()))
                .errorDecoder((methodKey, response) -> {
                    log.error("请求访问失败,方法名:{},状态码:{}", methodKey, response.status());
                    return errorStatus(methodKey, response);
                })
                .target(ChatGroupClient.class, "http://a1.easemob.com/" + easeConfig.getOrgname() + "/" + easeConfig.getAppname());
        return client;
    }
}