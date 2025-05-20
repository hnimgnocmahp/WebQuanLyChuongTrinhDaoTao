package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.repository.CtdtKhungchuongtrinhNhomkienthucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CtdtKhungchuongtrinhNhomkienthucController {

    @Autowired
    private CtdtKhungchuongtrinhNhomkienthucRepository CtdtKhungchuongtrinhNhomkienthucRepository;

    @GetMapping("/ctdt_khungchuongtrinh_nhomkienthuc")
    public String listCtdtKhungchuongtrinhNhomkienthuc(Model model) {
        model.addAttribute("ctdt_khungchuongtrinh_nhomkienthuc", CtdtKhungchuongtrinhNhomkienthucRepository.findAll());
        return "ctdt_khungchuongtrinh_nhomkienthuc_list";
    }
}