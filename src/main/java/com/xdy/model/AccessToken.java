package com.xdy.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Copyright (C), 2011-2017 温州贷
 * FileName: AccessToken.java
 * Description:
 * History:
 */
public class AccessToken {
    @ApiModelProperty(value = "token,登录之后的接口访问都需要提交该参数")
    private String accessToken;
    private String tokenType;
    private Long expires;
    @ApiModelProperty(value = "userId")
    private Integer userId;

    public AccessToken() {
    }

    public AccessToken(String accessToken, String tokenType, Long expires) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expires = expires;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Long getExpires() {
        return expires;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}
