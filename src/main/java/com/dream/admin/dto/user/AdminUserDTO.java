package com.dream.admin.dto.user;

import com.dream.admin.dto.user.validated.AddAdminUser;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class AdminUserDTO implements Serializable {
    private int id;
    @NotNull(groups = {AddAdminUser.class})
    private String phone;
    @NotNull(groups = {AddAdminUser.class})
    private String password;
    @NotNull(groups = {AddAdminUser.class})
    private String name;
    private String job_number;
    private boolean active;
    private int status;

    public AdminUserDTO(String phone, String password, String name, String job_number, boolean active) {
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.job_number = job_number;
        this.active = active;
    }
}
