package com.example.im.client;

import com.example.im.model.TokenBean;
import feign.Param;
import feign.RequestLine;

public interface TokenClient {
    @RequestLine("POST /token")
    TokenBean getToken(@Param("grant_type") String grantType, @Param("client_id") String clientId, @Param("client_secret") String clientSecret);
}
