package com.fanhehe.cmd.service;

import java.util.Map;
import java.util.Optional;
import com.fanhehe.cmd.entity.User;
import org.aspectj.lang.annotation.Before;

public interface HomeService {

    Map<String, String> handleIndex(Optional<User> user);

    Map<String, Object> handleJson();
}
