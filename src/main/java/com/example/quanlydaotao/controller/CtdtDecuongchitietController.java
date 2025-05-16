package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.repository.CtdtDecuongchitietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CtdtDecuongchitietController {

    @Autowired
    private CtdtDecuongchitietRepository CtdtDecuongchitietRepository;

    @GetMapping("/ctdt_decuongchitiet")
    public String listCtdtDecuongchitiet(Model model) {
        model.addAttribute("ctdt_decuongchitiet", CtdtDecuongchitietRepository.findAll());
        return "ctdt_decuongchitiet_list";
    }
}