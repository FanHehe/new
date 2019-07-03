package com.fanhehe.cmd.service;

import com.fanhehe.cmd.entity.User;

public interface UserService {
    User getUserInfoBy(long uid);
    User createUser(long uid, String name);
}
