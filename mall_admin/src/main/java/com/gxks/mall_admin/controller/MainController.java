package com.gxks.mall_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/admin/main")
    public String main(){
        return "main";
    }

}
