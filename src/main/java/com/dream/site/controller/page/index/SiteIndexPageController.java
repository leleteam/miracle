package com.dream.site.controller.page.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteIndexPageController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "site/index";
    }


}
