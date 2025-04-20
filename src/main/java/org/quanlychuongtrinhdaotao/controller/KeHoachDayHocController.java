package org.quanlychuongtrinhdaotao.controller;

import org.quanlychuongtrinhdaotao.model.KeHoachDayHoc;
import org.quanlychuongtrinhdaotao.service.KeHoachDayHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/kehoachdayhoc")
public class KeHoachDayHocController {

    @Autowired
    private KeHoachDayHocService keHoachDayHocService;

    @GetMapping
    public String listKeHoachDayHoc(Model model) {
        List<KeHoachDayHoc> list = keHoachDayHocService.getAllKeHoachDayHoc();
        model.addAttribute("keHoachDayHocs", list);
        return "admin/kehoachdayhoc/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("keHoachDayHoc", new KeHoachDayHoc());
        return "admin/kehoachdayhoc/add";
    }

    @PostMapping("/add")
    public String saveKeHoachDayHoc(@ModelAttribute("keHoachDayHoc") KeHoachDayHoc keHoachDayHoc) {
        keHoachDayHocService.saveKeHoachDayHoc(keHoachDayHoc);
        return "redirect:/admin/kehoachdayhoc";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        KeHoachDayHoc keHoachDayHoc = keHoachDayHocService.getKeHoachDayHocById(id);
        if (keHoachDayHoc != null) {
            model.addAttribute("keHoachDayHoc", keHoachDayHoc);
            return "admin/kehoachdayhoc/edit";
        }
        return "redirect:/admin/kehoachdayhoc";
    }

    @PostMapping("/edit/{id}")
    public String updateKeHoachDayHoc(@PathVariable("id") int id, @ModelAttribute("keHoachDayHoc") KeHoachDayHoc updated) {
        KeHoachDayHoc keHoachDayHoc = keHoachDayHocService.getKeHoachDayHocById(id);
        if (keHoachDayHoc != null) {
            keHoachDayHoc.setHockiThucHien(updated.getHockiThucHien());
            keHoachDayHoc.setNamHoc(updated.getNamHoc());
            keHoachDayHocService.saveKeHoachDayHoc(keHoachDayHoc);
        }
        return "redirect:/admin/kehoachdayhoc";
    }

    @GetMapping("/delete/{id}")
    public String deleteKeHoachDayHoc(@PathVariable("id") int id) {
        keHoachDayHocService.deleteKeHoachDayHoc(id);
        return "redirect:/admin/kehoachdayhoc";
    }
}
