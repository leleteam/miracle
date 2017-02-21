package com.dream.site.controller.page.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class SiteIndexController {

    @GetMapping
    public String index() {
        return "site/index";
    }


}
