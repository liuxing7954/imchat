package com.example.im.helper;

import com.example.im.client.TokenClient;
import com.example.im.config.EaseConfig;
import com.example.im.model.TokenBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TokenHelper {
    private long gotTokenTime;
    private TokenBean tokenBean;
    @Autowired
    private TokenClient tokenClient;
    @Autowired
    EaseConfig config;

    public TokenHelper() {
        this.gotTokenTime = System.currentTimeMillis();
    }

    public String getToken() {
        if (tokenBean == null || (tokenBean.getExpires_in() + this.gotTokenTime) <= System.currentTimeMillis()-10*1000) {
            log.info("token过期或不存在,重新获取token");
            tokenBean = tokenClient.getToken("client_credentials", config.getClient_iD(), config.getClient_secret());
        }
        log.info("token:{}",tokenBean.getAccess_token());
        return tokenBean.getAccess_token();
    }
}
