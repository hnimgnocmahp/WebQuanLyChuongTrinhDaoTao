package com.example.quanlydaotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeRedirectController {

    @GetMapping("/")
    public String redirectToHocPhan() {
        return "redirect:/auth/login";
    }
}
