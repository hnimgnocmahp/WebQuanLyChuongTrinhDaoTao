package com.example.quanlydaotao.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.quanlydaotao.service.KeHoachDayHocService;
import com.example.quanlydaotao.service.ThongTinChungService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.validation.Valid;

import com.example.quanlydaotao.entity.CtdtHocphan;
import com.example.quanlydaotao.entity.CtdtKehoachdayhoc;
import com.example.quanlydaotao.service.HocPhanService;

@Controller
@RequestMapping("/ctdt_kehoachdayhoc")
public class KeHoachDayHocController {

    private final KeHoachDayHocService service;
    private final ThongTinChungService ctdtService;
    private final HocPhanService hocphanService;

    public KeHoachDayHocController(KeHoachDayHocService service, ThongTinChungService ctdtService, HocPhanService hocphanService) {
        this.service = service;
        this.ctdtService = ctdtService;
        this.hocphanService = hocphanService;
    }

    @GetMapping("/form")
    public String form(@RequestParam(required = false) Integer id, Model model) {
        // nếu id != null thì load để sửa, ngược lại tạo mới
        var obj = (id == null)
            ? new CtdtKehoachdayhoc()
            : service.findById(id).orElseThrow();
        model.addAttribute("kehoach", obj);
        // để dropdown
        model.addAttribute("ctdtList", ctdtService.findAll());
        model.addAttribute("hocphanList", hocphanService.findAll());
        return "kehoachdayhoc_form";
    }


    @PostMapping("/save")
    public String save(
            @Valid @ModelAttribute("kehoach") CtdtKehoachdayhoc keHoach,
            BindingResult errs,
            Model model
    ) {
        if (errs.hasErrors()) {
            model.addAttribute("ctdtList", ctdtService.findAll());
            model.addAttribute("hocphanList", hocphanService.findAll());
            return "kehoachdayhoc_form";
        }
        service.save(keHoach);
        return "redirect:/ctdt_kehoachdayhoc";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id,
                         RedirectAttributes redirectAttrs) {
        service.deleteById(id);
        return "redirect:/ctdt_kehoachdayhoc";
    }

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("ctdt_kehoachdayhoc", service.findAll());
        return "ctdt_kehoachdayhoc_list";
    }
}
