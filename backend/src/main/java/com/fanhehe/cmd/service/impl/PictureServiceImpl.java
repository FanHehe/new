package com.fanhehe.cmd.service.impl;

import java.util.Map;
import java.util.HashMap;
import com.fanhehe.cmd.service.PictureService;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService {

    public Map<String, Object> getPictureList() {
        Map<String, Object> result = new HashMap<>();

        result.put("key", 1);
        result.put("value", "value");

        return result;
    }
}
