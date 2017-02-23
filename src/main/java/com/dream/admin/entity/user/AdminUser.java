package com.dream.admin.entity.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminUser {
    private int id;
    private String phone;
    private String password;
    private String name;
    private String job_number;
    private boolean active;
    private int status;
}
