package com.dream.admin.service.user;

import com.dream.admin.dto.user.AdminUserDTO;
import com.dream.admin.entity.user.AdminUser;
import com.dream.admin.mapper.user.AdminUserMapper;
import com.dream.boot.exception.BusinessException;
import com.dream.common.dto.enums.EnumCommonError;
import com.dream.utils.BeanMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class AdminUserServiceImpl {
    @Autowired
    private AdminUserMapper userMapper;

    public void save(AdminUserDTO user) {
        user.setPassword(securePassword(user.getPassword()));
        user.setJob_number(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmssnnnnnnnnn")).substring(0,16));
        user.setActive(true);
        if (userMapper.save(BeanMapper.map(user, AdminUser.class)) != 1) {
            throw new BusinessException(EnumCommonError.系统出错.toString());
        }
    }



    public String securePassword(String password) {
        return DigestUtils.md5Hex("abc" + DigestUtils.md5Hex("123" + password + "@@@") + "$#@");
    }

}
