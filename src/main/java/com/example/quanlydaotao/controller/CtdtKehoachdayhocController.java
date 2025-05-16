package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.repository.CtdtKehoachdayhocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CtdtKehoachdayhocController {

    @Autowired
    private CtdtKehoachdayhocRepository CtdtKehoachdayhocRepository;

    @GetMapping("/ctdt_kehoachdayhoc")
    public String listCtdtKehoachdayhoc(Model model) {
        model.addAttribute("ctdt_kehoachdayhoc", CtdtKehoachdayhocRepository.findAll());
        return "ctdt_kehoachdayhoc_list";
    }
}