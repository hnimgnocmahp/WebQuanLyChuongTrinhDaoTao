package com.example.quanlydaotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ctdt_giangvien_front")
public class GiangVienFrontController {
    @GetMapping
    public String giangVienFront() {
        return "user/ctdt_giangvien_front";
    }
} 