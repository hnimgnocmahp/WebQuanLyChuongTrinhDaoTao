package com.example.quanlydaotao.controller;


import com.example.quanlydaotao.entity.CtdtDecuongchitiet;
import com.example.quanlydaotao.entity.CtdtHocphan;
import com.example.quanlydaotao.entity.CtdtThongtinchung;
import com.example.quanlydaotao.service.HocPhanService;
import com.example.quanlydaotao.service.NhomKienThucService;
import com.example.quanlydaotao.service.ThongTinChungService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.Optional;

@Controller
@RequestMapping("/ctdt_thongtinchung")
public class CtdtThongtinchungController {
    private final ThongTinChungService service;

    public CtdtThongtinchungController(ThongTinChungService service) {
        this.service = service;
    }

    @GetMapping
    public String listCtdtThongtinchung(Model model) {
        model.addAttribute("ctdt_thongtinchung", service.findAll());
        return "ctdt_thongtinchung_list";
    }

    @GetMapping("/new")
    public String showCreate(Model m) {
        CtdtThongtinchung thongTinChung = new CtdtThongtinchung();
        thongTinChung.setNamBanHanh(Year.now().getValue());
        m.addAttribute("thongTinChung", thongTinChung);
        m.addAttribute("thongTinChungList", service.findAll());
        return "thongtinchung_form";
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("thongTinChung") CtdtThongtinchung thongtinchung,
                       BindingResult errs,
                       Model model) {
        if (errs.hasErrors()) {
            return "thongtinchung_form";
        }

        Optional<CtdtThongtinchung> existing = service.findByMaCtdt(thongtinchung.getMaCtdt());
        if (existing.isPresent() && !existing.get().getId().equals(thongtinchung.getId())) {
            errs.rejectValue("maCtdt", "error.thongTinChung", "Mã CTDT đã tồn tại!");
            return "thongtinchung_form";
        }

        service.save(thongtinchung);
        return "redirect:/ctdt_thongtinchung";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        CtdtThongtinchung thongtinchung = service.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy thông tin chung với id: " + id));

        model.addAttribute("thongTinChung", thongtinchung);
        model.addAttribute("thongTinChungList", service.findAll());
        return "thongtinchung_form";
    }


    @GetMapping("/kehoachdayhoc/{id}")
    public String showChiTietThongTinChung(@PathVariable Integer id, Model model) {
        CtdtThongtinchung thongtin = service.getChiTietThongTin(id);
        if (thongtin == null) {
            return "redirect:/ctdt_thongtinchung?error=notfound";
        }
        model.addAttribute("thongTinChung", thongtin);
        return "kehoachdayhoc_detail";
    }
}