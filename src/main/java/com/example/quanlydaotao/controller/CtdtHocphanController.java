package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.entity.CtdtHocphan;
import com.example.quanlydaotao.service.HocPhanService;
import com.example.quanlydaotao.service.NhomKienThucService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Optional;

@Controller
@RequestMapping("/ctdt_hocphan")

public class CtdtHocphanController {
        private final HocPhanService service;
        private final NhomKienThucService nhomKienThucService;
        public CtdtHocphanController(HocPhanService service, NhomKienThucService nhomKienThucService) {
            this.service = service;
            this.nhomKienThucService = nhomKienThucService;
        }

        // 1. LIST
        @GetMapping
        public String list(Model m) {
            m.addAttribute("ctdt_hocphan", service.findAll());
            return "ctdt_hocphan_list";
        }

        // 2. SHOW CREATE FORM
        @GetMapping("/new")
        public String showCreate(Model m) {
            m.addAttribute("hocPhan", new CtdtHocphan());
            m.addAttribute("nhomlist", nhomKienThucService.findAll());
            m.addAttribute("hocphanlist", service.findAll());
            return "hocphan_form";
        }

    // 3. HANDLE CREATE & UPDATE (POST)
    @PostMapping("/save")
    public String save(
            @Valid @ModelAttribute("hocPhan") CtdtHocphan hp,
            BindingResult errs,
            Model m
    ) {
        // 1) Kiểm tra trùng mã HP
        boolean exists = service.existsByMaHp(hp.getMaHp());
        // nếu là update thì trừ bản ghi chính nó ra
        if (exists && (hp.getId() == null
                || !service.findByMaHp(hp.getMaHp()).get().getId().equals(hp.getId()))) {

            errs.rejectValue(
                    "maHp",
                    "error.hocPhan",
                    "Mã học phần này đã tồn tại"
            );
        }

        // 2) Kiểm tra mã tiên quyết không được trùng
        if (hp.getHocPhanTienQuyet() != null
                && hp.getHocPhanTienQuyet().equals(hp.getMaHp())) {
            errs.rejectValue(
                    "hocPhanTienQuyet",
                    "error.hocPhanTienQuyet",
                    "Mã học phần tiên quyết không được trùng mã hiện tại"
            );
        }
        // Nếu có lỗi, phải add lại các danh sách để render form
        if (errs.hasErrors()) {
            m.addAttribute("nhomlist", nhomKienThucService.findAll());
            m.addAttribute("hocphanlist", service.findAll());
            return "hocphan_form";
        }

        service.save(hp);
        return "redirect:/ctdt_hocphan";
    }


    // 4. SHOW EDIT FORM
        @GetMapping("/edit/{id}")
        public String showEdit(@PathVariable Integer id, Model m) {
            CtdtHocphan hp = service.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid ID:" + id));
            m.addAttribute("hocPhan", hp);
            m.addAttribute("nhomlist", nhomKienThucService.findAll());
            m.addAttribute("hocphanlist", service.findAll());
            return "hocphan_form";
        }

    // 5. DELETE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id,
                         RedirectAttributes redirectAttrs) {
        Optional<CtdtHocphan> hp = service.findById(id);
        // nếu đang là tiên quyết của HP khác
        if (service.isReferencedAsPrerequisite(hp.get().getMaHp())) {
            redirectAttrs.addFlashAttribute("deleteError",
                    "Không thể xóa: học phần này đang là học phần tiên quyết của HP khác.");
            return "redirect:/ctdt_hocphan";
        }
        service.deleteById(id);
        return "redirect:/ctdt_hocphan";
    }

}
