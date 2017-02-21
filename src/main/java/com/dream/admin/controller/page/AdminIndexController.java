package com.dream.admin.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/index")
public class AdminIndexController {

    @GetMapping
    public String indexPage() {
        return "admin/index";
    }
}
