package com.dream.admin.controller.restful.user;

import com.dream.admin.dto.user.AdminUserDTO;
import com.dream.admin.dto.user.validated.AddAdminUser;
import com.dream.admin.service.user.AdminUserServiceImpl;
import com.dream.common.dto.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/user")
public class AdminUserController {
    @Autowired
    private AdminUserServiceImpl userService;

    @GetMapping
    public Result getUser() {
        return Result.success();
    }

    @PostMapping
    public Result addUser(@Validated(value = {AddAdminUser.class}) @RequestBody AdminUserDTO user) {
        userService.save(user);
        return Result.success();
    }
}
