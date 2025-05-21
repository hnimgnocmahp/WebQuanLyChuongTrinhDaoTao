package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.entity.CtdtHocphan;
import com.example.quanlydaotao.service.HocPhanService;
import com.example.quanlydaotao.service.NhomKienThucService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/ctdt_hocphan")

public class CtdtHocphanController {
        private final HocPhanService service;
        private final NhomKienThucService nhomKienThucService;
        public CtdtHocphanController(HocPhanService service, NhomKienThucService nhomKienThucService) {
            this.service = service;
            this.nhomKienThucService = nhomKienThucService;
        }

    @GetMapping
    public String list(@RequestParam(value = "keyword", required = false) String keyword, Model m) {
        if (keyword != null && !keyword.isEmpty()) {
            m.addAttribute("ctdt_hocphan", service.searchByMaOrTen(keyword));
            m.addAttribute("keyword", keyword);
        } else {
            m.addAttribute("ctdt_hocphan", service.findAll());
        }
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
        public String save(@Valid @ModelAttribute("hocPhan") CtdtHocphan hp,
                           BindingResult errs) {
            if (errs.hasErrors()) {
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
            return "hocphan_form";
        }

        // 5. DELETE
        @GetMapping("/delete/{id}")
        public String delete(@PathVariable Integer id) {
            service.deleteById(id);
            return "redirect:/ctdt_hocphan";
        }


}
