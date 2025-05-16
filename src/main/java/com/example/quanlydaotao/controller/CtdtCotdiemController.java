package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.repository.CtdtCotdiemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CtdtCotdiemController {

    @Autowired
    private CtdtCotdiemRepository CtdtCotdiemRepository;

    @GetMapping("/ctdt_cotdiem")
    public String listCtdtCotdiem(Model model) {
        model.addAttribute("ctdt_cotdiem", CtdtCotdiemRepository.findAll());
        return "ctdt_cotdiem_list";
    }
}