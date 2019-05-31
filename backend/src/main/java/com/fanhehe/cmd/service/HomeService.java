package com.fanhehe.cmd.service;

import java.util.Map;
import java.util.Optional;
import com.fanhehe.cmd.entity.User;

public interface HomeService {
    Map<String, String> handleIndex(Optional<User> user);

    Map<String, Object> handleJson();
}
