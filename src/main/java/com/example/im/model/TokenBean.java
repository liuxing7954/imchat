package com.example.im.model;

import lombok.Data;

@Data
public class TokenBean {
    private String access_token;
    private long expires_in;
    private String application;
}
