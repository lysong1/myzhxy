package com.atguigu.myzhxy.pojo;

import lombok.Data;

/**
 * @author liuyusong
 * @create 2022-06-07 13:46
 */
@Data
public class LoginForm {
    private String username;
    private String password;
    private String verifiCode;
    private Integer userType;

}
