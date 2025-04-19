package org.quanlychuongtrinhdaotao.controller;

import org.quanlychuongtrinhdaotao.model.DanhGiaBoPhan;
import org.quanlychuongtrinhdaotao.service.DanhGiaBoPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/danhgiabophan")
public class DanhGiaBoPhanController {

    @Autowired
    private DanhGiaBoPhanService service;

    @GetMapping
    public String list(Model model) {
        List<DanhGiaBoPhan> list = service.getAll();
        model.addAttribute("danhGiaBoPhans", list);
        return "danhgiabophan/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("danhGiaBoPhan", new DanhGiaBoPhan());
        return "danhgiabophan/add.html";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("danhGiaBoPhan") DanhGiaBoPhan obj) {
        service.save(obj);
        return "redirect:/danhgiabophan";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        DanhGiaBoPhan obj = service.getById(id);
        if (obj != null) {
            model.addAttribute("danhGiaBoPhan", obj);
            return "danhgiabophan/edit";
        }
        return "redirect:/danhgiabophan";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable int id, @ModelAttribute("danhGiaBoPhan") DanhGiaBoPhan objUpdate) {
        DanhGiaBoPhan obj = service.getById(id);
        if (obj != null) {
            obj.setDiemDanhGiaBoPhan(objUpdate.getDiemDanhGiaBoPhan());
            obj.setTrongSo(objUpdate.getTrongSo());
            obj.setHinhThucDanhGia(objUpdate.getHinhThucDanhGia());
            service.save(obj);
        }
        return "redirect:/danhgiabophan";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/danhgiabophan";
    }
}
