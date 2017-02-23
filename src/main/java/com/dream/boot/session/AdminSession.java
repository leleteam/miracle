package com.dream.boot.session;

import com.dream.admin.dto.user.AdminUserDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AdminSession implements Serializable {
    protected AdminUserDTO user;

    public AdminUserDTO getUser() {
        return user;
    }

    public boolean login(AdminUserDTO user) {
        this.user = user;
        return true;
    }

    public boolean isLogined() {
        return this.user != null;
    }

    public void logout() {
        this.user = null;
    }

}
