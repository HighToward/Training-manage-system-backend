package com.company.training.mapper;

import com.company.training.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User findByUsername(@Param("username") String username);

    // 用于更新用户最后登录时间等信息
    int updateUserLoginInfo(User user);
    
    // 新增方法
    User findById(@Param("id") Long id);
    int updateUserProfile(User user);
}