package com.xdy.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * User: xuedaiyao
 * Date: 2017/8/11
 * Time: 15:17
 * Description:
 */
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    @ApiModelProperty(value = "用户名", required = true)
    private String userName;

    @Column(name = "password")
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @Column(name = "phone_number")
    @ApiModelProperty(value = "手机号码", required = true)
    private String phoneNumber;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
