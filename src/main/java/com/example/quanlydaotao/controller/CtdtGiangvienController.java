package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.entity.CtdtGiangvien;
import com.example.quanlydaotao.repository.CtdtGiangvienRepository;
import com.example.quanlydaotao.service.GiangVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ctdt_giangvien")
public class CtdtGiangvienController {

    private final GiangVienService service;

    @Autowired
    private GiangVienService giangVienService;
    public CtdtGiangvienController(GiangVienService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("ctdt_giangvien", service.findAll());
    @GetMapping("/ctdt_giangvien")
    public String listCtdtGiangvien(Model model) {
        model.addAttribute("ctdt_giangvien", giangVienService.findAll());
        return "ctdt_giangvien_list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("giangVien", new CtdtGiangvien());
        return "giangvien_form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        CtdtGiangvien giangVien = service.findById(id);
        model.addAttribute("giangVien", giangVien);
        return "giangvien_form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteById(id);
        return "redirect:/ctdt_giangvien";
    @GetMapping("/ctdt_giangvien/phancong")
    public String phanCong(Model m){
        List<CtdtGiangvien> list = giangVienService.getPhanCong();
        m.addAttribute("giangviens", list);
        // sau khi gọi service, mỗi gv đã có assignments, groupsPerCourse và hocphanMap
        return "giangvien_phancong";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("giangVien") CtdtGiangvien giangVien,
                       BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "giangvien_form";
        }
        boolean userIdExists = service.isUserIdDuplicate(giangVien.getUserId(), giangVien.getId());
        boolean maGvExists = service.isMaGvDuplicate(giangVien.getMaGv(), giangVien.getId());
        if (userIdExists || maGvExists) {
            if (userIdExists) model.addAttribute("error", "User ID đã tồn tại!");
            if (maGvExists) model.addAttribute("error", "Mã GV đã tồn tại!");
            model.addAttribute("giangVien", giangVien);
            return "giangvien_form";
        }
        service.save(giangVien);
        return "redirect:/ctdt_giangvien";
    }
}