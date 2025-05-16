package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.repository.CtdtNhomkienthucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CtdtNhomkienthucController {

    @Autowired
    private CtdtNhomkienthucRepository CtdtNhomkienthucRepository;

    @GetMapping("/ctdt_nhomkienthuc")
    public String listCtdtNhomkienthuc(Model model) {
        model.addAttribute("ctdt_nhomkienthuc", CtdtNhomkienthucRepository.findAll());
        return "ctdt_nhomkienthuc_list";
    }
}