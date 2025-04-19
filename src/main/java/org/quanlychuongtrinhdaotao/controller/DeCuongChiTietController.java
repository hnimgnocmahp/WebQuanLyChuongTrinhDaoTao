package org.quanlychuongtrinhdaotao.controller;

import org.quanlychuongtrinhdaotao.model.DeCuongChiTiet;
import org.quanlychuongtrinhdaotao.service.DeCuongChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/decuongchitiet")
public class DeCuongChiTietController {

    @Autowired
    private DeCuongChiTietService service;

    @GetMapping
    public String list(Model model) {
        List<DeCuongChiTiet> list = service.getAll();
        model.addAttribute("deCuongChiTiets", list);
        return "decuongchitiet/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("deCuongChiTiet", new DeCuongChiTiet());
        return "decuongchitiet/add.html";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("deCuongChiTiet") DeCuongChiTiet obj) {
        service.save(obj);
        return "redirect:/decuongchitiet";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        DeCuongChiTiet obj = service.getById(id);
        if (obj != null) {
            model.addAttribute("deCuongChiTiet", obj);
            return "decuongchitiet/edit";
        }
        return "redirect:/decuongchitiet";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable int id, @ModelAttribute("deCuongChiTiet") DeCuongChiTiet objUpdate) {
        DeCuongChiTiet obj = service.getById(id);
        if (obj != null) {
            obj.setBoPhanDuocDanhGia(objUpdate.getBoPhanDuocDanhGia());
            service.save(obj);
        }
        return "redirect:/decuongchitiet";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/decuongchitiet";
    }
}
