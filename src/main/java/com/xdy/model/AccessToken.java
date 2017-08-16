package com.xdy.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Copyright (C), 2011-2017 温州贷
 * FileName: AccessToken.java
 * Description:
 * History:
 */
@Table(name = "user_token")
public class AccessToken {

    @ApiModelProperty(value = "token,登录之后的接口访问都需要提交该参数")
    @Column(name = "token")
    private String accessToken;

    @Column(name = "expire")
    @ApiModelProperty(value = "是否过期 0-未过期 1-过期")
    private Boolean expire;

    @ApiModelProperty(value = "userId")
    private Integer userId;

    public AccessToken() {
    }

    public AccessToken(String accessToken, Boolean expire) {
        this.accessToken = accessToken;
        this.expire = expire;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Boolean getExpire() {
        return expire;
    }

    public void setExpire(Boolean expire) {
        this.expire = expire;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}
