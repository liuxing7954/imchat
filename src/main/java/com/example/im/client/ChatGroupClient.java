package com.example.im.client;

import feign.Param;
import feign.RequestLine;

public interface ChatGroupClient {
    @RequestLine("GET /chatgroups/{group_id}/admin")
    Object getAdmin(@Param("group_id") String group_id);
}
