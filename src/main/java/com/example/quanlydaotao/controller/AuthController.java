package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.repository.CtdtUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private CtdtUserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm() {
        // Trả về template Thymeleaf tại src/main/resources/templates/auth/login.html
        return "auth/login";
    }
}
