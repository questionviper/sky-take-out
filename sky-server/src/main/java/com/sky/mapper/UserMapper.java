package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserMapper {
    @Select("select * from user where openid = #{openId}")

    User getByOpenId(String openId);

    @Insert("insert into user (openid, name, phone, sex, id_number, avatar, create_time)" +
            "values (#{openid},#{name},#{phone},#{sex},#{idNumber},#{avatar},#{createTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(User user);

    @Select("select * from user where id = #{usrId}")
    User getById(Long userId);

    Integer countByMap(Map map);
}
