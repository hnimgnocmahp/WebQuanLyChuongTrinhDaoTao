package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.entity.CtdtKehoachmonhom;
import com.example.quanlydaotao.repository.CtdtKehoachmonhomRepository;
import com.example.quanlydaotao.repository.CtdtHocphanRepository;
import com.example.quanlydaotao.service.KeHoachMoNhomService;
import com.example.quanlydaotao.service.PhanCongGiangDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ctdt_kehoachmonhom")
public class CtdtKehoachmonhomController {

    @Autowired
    private CtdtKehoachmonhomRepository CtdtKehoachmonhomRepository;

    private final KeHoachMoNhomService khmnService;
    private final PhanCongGiangDayService pcService;
    private final CtdtHocphanRepository hocphanRepository;

    public CtdtKehoachmonhomController(KeHoachMoNhomService groupService, PhanCongGiangDayService assignService, CtdtHocphanRepository hocphanRepository) {
        this.khmnService = groupService;
        this.pcService = assignService;
        this.hocphanRepository = hocphanRepository;
    }

    @GetMapping()
    public String listCtdtKehoachmonhom(Model model) {
        model.addAttribute("ctdt_kehoachmonhom", CtdtKehoachmonhomRepository.findAll());
        return "ctdt_kehoachmonhom_list";
    }

    @GetMapping("/phanconggiangday")
    public String listActiveAssignments(Model m) {
        List<CtdtKehoachmonhom> courses = khmnService.getActiveFull();
        m.addAttribute("courses", courses);
        return "ctdt_kehoachmonhom_phanconggiangday";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("item", new CtdtKehoachmonhom());
        model.addAttribute("listHocphan", hocphanRepository.findAll());
        model.addAttribute("statusList", java.util.Arrays.asList("Đã kết thúc", "Đang diễn ra", "Chưa mở"));
        return "ctdt_kehoachmonhom_form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("item") CtdtKehoachmonhom item) {
        CtdtKehoachmonhomRepository.save(item);
        return "redirect:/ctdt_kehoachmonhom";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Optional<CtdtKehoachmonhom> item = CtdtKehoachmonhomRepository.findById(id);
        if (item.isPresent()) {
            model.addAttribute("item", item.get());
            model.addAttribute("listHocphan", hocphanRepository.findAll());
            model.addAttribute("statusList", java.util.Arrays.asList("Đã kết thúc", "Đang diễn ra", "Chưa mở"));
            return "ctdt_kehoachmonhom_form";
        } else {
            return "redirect:/ctdt_kehoachmonhom";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        CtdtKehoachmonhomRepository.deleteById(id);
        return "redirect:/ctdt_kehoachmonhom";
    }

    @GetMapping("/countByHocPhanId/{hocPhanId}")
    @ResponseBody
    public long countByHocPhanId(@PathVariable("hocPhanId") Integer hocPhanId) {
        return CtdtKehoachmonhomRepository.countByHocPhanId(hocPhanId);
    }

}