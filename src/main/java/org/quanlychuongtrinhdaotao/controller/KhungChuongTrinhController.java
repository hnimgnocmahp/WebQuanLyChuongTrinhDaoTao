package org.quanlychuongtrinhdaotao.controller;

import org.quanlychuongtrinhdaotao.model.KhungChuongTrinh;
import org.quanlychuongtrinhdaotao.service.KhungChuongTrinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/khungchuongtrinh")
public class KhungChuongTrinhController {

    @Autowired
    private KhungChuongTrinhService khungChuongTrinhService;

    @GetMapping
    public String listKhungChuongTrinh(Model model) {
        List<KhungChuongTrinh> list = khungChuongTrinhService.getAllKhungChuongTrinh();
        model.addAttribute("khungChuongTrinhs", list);
        return "khungchuongtrinh/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("khungChuongTrinh", new KhungChuongTrinh());
        return "khungchuongtrinh/add.html";
    }

    @PostMapping("/add")
    public String saveKhungChuongTrinh(@ModelAttribute("khungChuongTrinh") KhungChuongTrinh khungChuongTrinh) {
        khungChuongTrinhService.saveKhungChuongTrinh(khungChuongTrinh);
        return "redirect:/khungchuongtrinh";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        KhungChuongTrinh khungChuongTrinh = khungChuongTrinhService.getKhungChuongTrinhById(id);
        if (khungChuongTrinh != null) {
            model.addAttribute("khungChuongTrinh", khungChuongTrinh);
            return "khungchuongtrinh/edit";
        }
        return "redirect:/khungchuongtrinh";
    }

    @PostMapping("/edit/{id}")
    public String updateKhungChuongTrinh(@PathVariable("id") int id, @ModelAttribute("khungChuongTrinh") KhungChuongTrinh updated) {
        KhungChuongTrinh khungChuongTrinh = khungChuongTrinhService.getKhungChuongTrinhById(id);
        if (khungChuongTrinh != null) {
            khungChuongTrinh.setTenKienThuc(updated.getTenKienThuc());
            khungChuongTrinh.setKhoiKenThuc(updated.getKhoiKenThuc());
            khungChuongTrinh.setSoTinChi(updated.getSoTinChi());
            khungChuongTrinh.setSoTinChiBatBuoc(updated.getSoTinChiBatBuoc());
            khungChuongTrinhService.saveKhungChuongTrinh(khungChuongTrinh);
        }
        return "redirect:/khungchuongtrinh";
    }

    @GetMapping("/delete/{id}")
    public String deleteKhungChuongTrinh(@PathVariable("id") int id) {
        khungChuongTrinhService.deleteKhungChuongTrinh(id);
        return "redirect:/khungchuongtrinh";
    }
}
