package com.dubboscaffold.sys.auth.model.param;

import lombok.Data;

@Data
public class AuthParam {
    /**
     * 账号
     */
    String username;

    /**
     * 密码
     */
    String password;
}
