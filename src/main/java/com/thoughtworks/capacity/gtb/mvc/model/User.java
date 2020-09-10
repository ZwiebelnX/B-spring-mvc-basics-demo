package com.thoughtworks.capacity.gtb.mvc.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class User {

    @NotNull(message = "用户名不能为空")
    @Length(min = 3, max = 10, message = "用户名长度需要在3-10之间")
    @Pattern(regexp = "(\\w)+", message = "用户名包含不合法字符")
    private String username;

    @NotNull(message = "密码不能为空")
    @Length(min = 5, max = 12, message = "密码长度需要在5-12之间")
    private String password;

    @Pattern(regexp = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,})$", message = "邮箱不符合规范")
    private String email;
}
