package com.fanhehe.cmd.dao;

import com.fanhehe.cmd.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    @Select("select * from user where id = #{id}")
    User getUserById (long id);
}
