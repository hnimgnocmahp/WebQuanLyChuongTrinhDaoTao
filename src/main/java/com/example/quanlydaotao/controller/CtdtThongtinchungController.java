package com.example.quanlydaotao.controller;


import com.example.quanlydaotao.entity.CtdtHocphan;
import com.example.quanlydaotao.entity.CtdtKhungchuongtrinh;
import com.example.quanlydaotao.entity.CtdtKhungchuongtrinhNhomkienthuc;
import com.example.quanlydaotao.entity.CtdtThongtinchung;
import com.example.quanlydaotao.service.HocPhanService;
import com.example.quanlydaotao.service.NhomKienThucService;
import com.example.quanlydaotao.service.ThongTinChungService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        m.addAttribute("thongTinChung", new CtdtThongtinchung());
        m.addAttribute("thongTinChungList", service.findAll());
        return "thongtinchung_form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("thongTinChung") CtdtThongtinchung thongtinchung,
                       BindingResult errs) {
        if (errs.hasErrors()) {
            return "thongtinchung_form";
        }
        service.save(thongtinchung);
        return "redirect:/ctdt_thongtinchung";
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

    @GetMapping("/{id}/khung")
    public String viewKhung(
            @PathVariable Integer id,
            Model model
    ) {
        // 1) Lấy toàn bộ cấu trúc khung – nhóm kiến thức
        CtdtThongtinchung ctdt = service.getCtKhung(id);
        model.addAttribute("ctdt", ctdt);

        // 2) Tính tổng tín chỉ bắt buộc + tự chọn để in dòng "Tổng"
        int totalBB = 0, totalTC = 0;
        for (CtdtKhungchuongtrinh frame : ctdt.getKhungchuongtrinhs()) {
            for (CtdtKhungchuongtrinhNhomkienthuc ent : frame.getKhungchuongtrinhNhomkienthucs()) {
                totalBB += ent.getSotinchibatbuoc();
                totalTC += ent.getSotinchituchon();
            }
        }
        model.addAttribute("totalBB", totalBB);
        model.addAttribute("totalTC", totalTC);

        return "thongtinchung_detail";
    }
}