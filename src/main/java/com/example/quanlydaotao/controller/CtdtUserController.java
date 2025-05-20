package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.repository.CtdtUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CtdtUserController {

    @Autowired
    private CtdtUserRepository CtdtUserRepository;

    @GetMapping("/ctdt_user")
    public String listCtdtUser(Model model) {
        model.addAttribute("ctdt_user", CtdtUserRepository.findAll());
        return "ctdt_user_list";
    }
}