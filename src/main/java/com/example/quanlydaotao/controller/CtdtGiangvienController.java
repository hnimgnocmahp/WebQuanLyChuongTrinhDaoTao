package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.entity.CtdtGiangvien;
import com.example.quanlydaotao.repository.CtdtGiangvienRepository;
import com.example.quanlydaotao.service.GiangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class CtdtGiangvienController {

    @Autowired
    private GiangVienService giangVienService;

    @GetMapping("/ctdt_giangvien")
    public String listCtdtGiangvien(Model model) {
        model.addAttribute("ctdt_giangvien", giangVienService.findAll());
        return "ctdt_giangvien_list";
    }

    @GetMapping("/ctdt_giangvien/phancong")
    public String phanCong(Model m){
        List<CtdtGiangvien> list = giangVienService.getPhanCong();
        m.addAttribute("giangviens", list);
        // sau khi gọi service, mỗi gv đã có assignments, groupsPerCourse và hocphanMap
        return "giangvien_phancong";
    }

}