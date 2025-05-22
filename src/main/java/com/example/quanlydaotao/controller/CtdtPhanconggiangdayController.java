package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.entity.CtdtPhanconggiangday;
import com.example.quanlydaotao.repository.CtdtPhanconggiangdayRepository;
import com.example.quanlydaotao.service.GiangVienService;
import com.example.quanlydaotao.service.KeHoachMoNhomService;
import com.example.quanlydaotao.service.NhomKienThucService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ctdt_phanconggiangday")
public class CtdtPhanconggiangdayController {

    @Autowired
    private CtdtPhanconggiangdayRepository CtdtPhanconggiangdayRepository;

    private KeHoachMoNhomService kehoachmonhom;

    private GiangVienService giangVienService;


    public CtdtPhanconggiangdayController(CtdtPhanconggiangdayRepository CtdtPhanconggiangdayRepository, KeHoachMoNhomService kehoachmonhom, GiangVienService giangVienService) {
        this.CtdtPhanconggiangdayRepository = CtdtPhanconggiangdayRepository;
        this.kehoachmonhom = kehoachmonhom;
        this.giangVienService = giangVienService;
    }


    @GetMapping()
    public String listCtdtPhanconggiangday(Model model) {
        model.addAttribute("ctdt_phanconggiangday", CtdtPhanconggiangdayRepository.findAll());
        return "ctdt_phanconggiangday_list";
    }

       @GetMapping({"/create", "/edit/{id}"})
    public String showForm(@PathVariable(required = false) Integer id, Model model) {
        CtdtPhanconggiangday phancong = (id == null)
            ? new CtdtPhanconggiangday()
            : CtdtPhanconggiangdayRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID: " + id));

        model.addAttribute("phancong", phancong);
        model.addAttribute("groupList", kehoachmonhom.findAll());
        model.addAttribute("giangVienList", giangVienService.findAll());
        return "phanconggiangday_form";
    }

    @PostMapping("/save")
    public String save(
        @Valid @ModelAttribute("phancong") CtdtPhanconggiangday phancong,
        BindingResult result,
        Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("groupList", kehoachmonhom.findAll());
            model.addAttribute("giangVienList", giangVienService.findAll());
            return "ctdt_phanconggiangday/form";
        }
        CtdtPhanconggiangdayRepository.save(phancong);
        return "redirect:/ctdt_phanconggiangday";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        CtdtPhanconggiangdayRepository.deleteById(id);
        return "redirect:/ctdt_phanconggiangday";
    }
}