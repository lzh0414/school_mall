package com.gxks.mall_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping(value = {"/index" , "/admin/login" , "/"})
    public String toLoginPage(){
        return "login";
    }

    @PostMapping("/admin/login")
    public String login(String username ,
                        String password ,
                        HttpSession session,
                        Model model){
        if(username != null && username.equalsIgnoreCase("admin")
            && password != null && password.equalsIgnoreCase("123123")){
            session.setAttribute("username","admin");
            return "redirect:/admin/main";
        }
        model.addAttribute("error","用户名密码不匹配！");
        return "login";
    }

}
