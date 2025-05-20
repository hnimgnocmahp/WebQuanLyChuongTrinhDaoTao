package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.repository.CtdtGiangvienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CtdtGiangvienController {

    @Autowired
    private CtdtGiangvienRepository CtdtGiangvienRepository;

    @GetMapping("/ctdt_giangvien")
    public String listCtdtGiangvien(Model model) {
        model.addAttribute("ctdt_giangvien", CtdtGiangvienRepository.findAll());
        return "ctdt_giangvien_list";
    }
}