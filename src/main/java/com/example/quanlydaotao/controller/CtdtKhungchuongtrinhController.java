package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.repository.CtdtKhungchuongtrinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CtdtKhungchuongtrinhController {

    @Autowired
    private CtdtKhungchuongtrinhRepository CtdtKhungchuongtrinhRepository;

    @GetMapping("/ctdt_khungchuongtrinh")
    public String listCtdtKhungchuongtrinh(Model model) {
        model.addAttribute("ctdt_khungchuongtrinh", CtdtKhungchuongtrinhRepository.findAll());
        return "ctdt_khungchuongtrinh_list";
    }
}