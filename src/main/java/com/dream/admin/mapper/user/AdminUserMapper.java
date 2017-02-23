package com.dream.admin.mapper.user;

import com.dream.admin.entity.user.AdminUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface AdminUserMapper {

    @Insert(" insert into a_users(phone, password, name, job_number, active) " +
            " values(#{phone}, #{password}, #{name}, #{job_number}, #{active}) ")
    @Options(useGeneratedKeys=true)
    int save(AdminUser adminUser);
}
