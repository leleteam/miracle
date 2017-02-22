package com.dream.site.controller.page.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteUserPageController {

    @GetMapping("/register")
    public String registerPage() {
        return "site/user/register";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "site/user/login";
    }
}
