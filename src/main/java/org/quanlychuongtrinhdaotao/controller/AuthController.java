package org.quanlychuongtrinhdaotao.controller;


import org.quanlychuongtrinhdaotao.model.GiangVien;
import org.quanlychuongtrinhdaotao.service.GiangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private GiangVienService giangVienService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "auth/login";
    }
}

