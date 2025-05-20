package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.entity.CtdtGiangvien;
import com.example.quanlydaotao.entity.CtdtKehoachmonhom;
import com.example.quanlydaotao.entity.CtdtPhanconggiangday;
import com.example.quanlydaotao.repository.CtdtKehoachmonhomRepository;
import com.example.quanlydaotao.service.KeHoachMoNhomService;
import com.example.quanlydaotao.service.PhanCongGiangDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/ctdt_kehoachmonhom")
public class CtdtKehoachmonhomController {

    @Autowired
    private CtdtKehoachmonhomRepository CtdtKehoachmonhomRepository;


    private final KeHoachMoNhomService khmnService;
    private final PhanCongGiangDayService pcService;

    public CtdtKehoachmonhomController(KeHoachMoNhomService groupService,PhanCongGiangDayService assignService){
        this.khmnService = groupService;
        this.pcService = assignService;
    }


    @GetMapping()
    @GetMapping("/ctdt_kehoachmonhom")
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

}