package com.fanhehe.cmd.service.impl;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

import com.fanhehe.cmd.entity.User;
import com.fanhehe.cmd.service.HomeService;
import org.springframework.stereotype.Service;

@Service("Extra")
public class ExtraHomeServiceImpl implements HomeService {

    public Map<String, Object> handleJson() { return new HashMap<>(); }

    public Map<String, String> handleIndex(Optional<User> user) {
        return null;
    }

}
