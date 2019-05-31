
package com.fanhehe.cmd.service.impl;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

import com.fanhehe.cmd.entity.User;
import com.fanhehe.cmd.service.HomeService;
import com.fanhehe.cmd.service.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("Base")
class BaseHomeServiceImpl implements  HomeService {

    private static final Logger logger = LoggerFactory.getLogger(BaseHomeServiceImpl.class);

    @Autowired
    private PictureService pictureService;

    /**
     *
     * @param user user
     * @return result
     */
    public Map<String, String> handleIndex(Optional<User> user) {

        Map<String, String> result = new HashMap<>();

        logger.info("it's hanldeIndex aaaaaaaaaaaaa");

        if (!user.isPresent()) {
            return result;
        }

        long uid = user.get().getId();

        String password = user.get().getPassword();

        String value = String.valueOf(uid) + ":" + password;

        result.put("format", value);

        return result;
    }

    public Map<String, Object> handleJson() {
        return pictureService.getPictureList();
    }
}
