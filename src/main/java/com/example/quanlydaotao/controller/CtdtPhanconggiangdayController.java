package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.repository.CtdtPhanconggiangdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CtdtPhanconggiangdayController {

    @Autowired
    private CtdtPhanconggiangdayRepository CtdtPhanconggiangdayRepository;

    @GetMapping("/ctdt_phanconggiangday")
    public String listCtdtPhanconggiangday(Model model) {
        model.addAttribute("ctdt_phanconggiangday", CtdtPhanconggiangdayRepository.findAll());
        return "ctdt_phanconggiangday_list";
    }
}