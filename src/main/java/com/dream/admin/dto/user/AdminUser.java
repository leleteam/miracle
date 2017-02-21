package com.dream.admin.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AdminUser implements Serializable {
    private Long id;
    private String name;
    private String password;
}
