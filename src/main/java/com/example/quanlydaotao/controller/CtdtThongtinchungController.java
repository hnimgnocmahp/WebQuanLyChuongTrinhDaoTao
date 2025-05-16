package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.repository.CtdtThongtinchungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CtdtThongtinchungController {

    @Autowired
    private CtdtThongtinchungRepository CtdtThongtinchungRepository;

    @GetMapping("/ctdt_thongtinchung")
    public String listCtdtThongtinchung(Model model) {
        model.addAttribute("ctdt_thongtinchung", CtdtThongtinchungRepository.findAll());
        return "ctdt_thongtinchung_list";
    }
}