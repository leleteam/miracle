package com.dream.admin.controller.restful.index;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/index")
public class AdminIndexController {

    @GetMapping
    public String indexPage() {
        return "hello";
    }
}