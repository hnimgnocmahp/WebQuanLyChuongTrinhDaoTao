package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.repository.CtdtKehoachmonhomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CtdtKehoachmonhomController {

    @Autowired
    private CtdtKehoachmonhomRepository CtdtKehoachmonhomRepository;

    @GetMapping("/ctdt_kehoachmonhom")
    public String listCtdtKehoachmonhom(Model model) {
        model.addAttribute("ctdt_kehoachmonhom", CtdtKehoachmonhomRepository.findAll());
        return "ctdt_kehoachmonhom_list";
    }
}