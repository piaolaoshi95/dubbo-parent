package com.dubboscaffold.sys.auth.service;

import com.dubboscaffold.sys.auth.model.param.AuthParam;

public interface AuthService {

    String login(AuthParam authParam);
}
