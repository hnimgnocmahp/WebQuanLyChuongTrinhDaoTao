package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.entity.CtdtKhungchuongtrinhNhomkienthuc;
import com.example.quanlydaotao.entity.CtdtKhungchuongtrinh;
import com.example.quanlydaotao.service.NhomKienThucService;
import com.example.quanlydaotao.service.ThongTinChungService;
import com.example.quanlydaotao.repository.CtdtKhungchuongtrinhRepository;
import com.example.quanlydaotao.repository.CtdtKhungchuongtrinhNhomkienthucRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ctdt_khungchuongtrinh")
public class CtdtKhungchuongtrinhController {

    private final CtdtKhungchuongtrinhNhomkienthucRepository khungchuongtrinhNhomkienthucRepository;
    private final CtdtKhungchuongtrinhRepository ctdtKhungchuongtrinhRepository;
    private final ThongTinChungService thongTinChungService;
    private final NhomKienThucService nhomKienThucService;

    public CtdtKhungchuongtrinhController(CtdtKhungchuongtrinhNhomkienthucRepository khungchuongtrinhNhomkienthucRepository, CtdtKhungchuongtrinhRepository ctdtKhungchuongtrinhRepository, ThongTinChungService thongTinChungService, NhomKienThucService nhomKienThucService) {
        this.khungchuongtrinhNhomkienthucRepository = khungchuongtrinhNhomkienthucRepository;
        this.ctdtKhungchuongtrinhRepository = ctdtKhungchuongtrinhRepository;
        this.thongTinChungService = thongTinChungService;
        this.nhomKienThucService = nhomKienThucService;
    }

    @GetMapping()
    public String listCtdtKhungchuongtrinh(Model model) {
        model.addAttribute("ctdt_khungchuongtrinh", ctdtKhungchuongtrinhRepository.findAll());
        return "ctdt_khungchuongtrinh_list";
    }

    @GetMapping("/new")
    public String showCreate(Model m) {
        m.addAttribute("khungchuongtrinh", new CtdtKhungchuongtrinh());
//        m.addAttribute("nhomlist", nhomKienThucService.findAll());
        m.addAttribute("thongtinchung", thongTinChungService.findAll());
        return "khungchuongtrinh_form";
    }

    // 3. HANDLE CREATE & UPDATE (POST)
    @PostMapping("/save")
    public String save(
            @Valid @ModelAttribute("khungchuongtrinh") CtdtKhungchuongtrinh kct,
            BindingResult errs,
            Model m
    ) {
        Optional<CtdtKhungchuongtrinh> existing = ctdtKhungchuongtrinhRepository
                .findByMaNhomAndCtdtId(kct.getMaNhom(), kct.getCtdtId());

        // Nếu đã tồn tại bản ghi trùng cặp (maNhom, thongTinChung) và không phải là chính nó (nếu đang update)
        if (existing.isPresent() && !existing.get().getId().equals(kct.getId())) {
            errs.rejectValue(
                    "maNhom",
                    "error.khungchuongtrinh",
                    "Mã nhóm này đã tồn tại trong chương trình đào tạo đã chọn."
            );
        }
        if(kct.getId() != null){
            int i = 0;
            List<CtdtKhungchuongtrinhNhomkienthuc> khungchuongtrinhNhomkienthucs = khungchuongtrinhNhomkienthucRepository.findByIdKhungchuongtrinh(kct.getId());
            for (CtdtKhungchuongtrinhNhomkienthuc khungchuongtrinhNhomkienthuc : khungchuongtrinhNhomkienthucs){
                i += khungchuongtrinhNhomkienthuc.getSotinchibatbuoc();
                i += khungchuongtrinhNhomkienthuc.getSotinchituchon();
            }
            kct.setSoTinChiToiThieu(i);
        }
        else {
            kct.setSoTinChiToiThieu(0);
        }

        if (errs.hasErrors()) {
            m.addAttribute("thongtinchung", thongTinChungService.findAll());
            return "khungchuongtrinh_form";
        }

        ctdtKhungchuongtrinhRepository.save(kct);
        return "redirect:/ctdt_khungchuongtrinh";
    }


    // 4. SHOW EDIT FORM
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Integer id, Model model) {
        CtdtKhungchuongtrinh khung = ctdtKhungchuongtrinhRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID không hợp lệ: " + id));

        model.addAttribute("khungchuongtrinh", khung);
        model.addAttribute("thongtinchung", thongTinChungService.findAll());
        return "khungchuongtrinh_form";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttrs) {
        Optional<CtdtKhungchuongtrinh> khung = ctdtKhungchuongtrinhRepository.findById(id);
        if (khung.isPresent()) {
            ctdtKhungchuongtrinhRepository.deleteById(id);
        } else {
            redirectAttrs.addFlashAttribute("deleteError", "Không tìm thấy bản ghi để xóa.");
        }
        return "redirect:/ctdt_khungchuongtrinh";
    }


}