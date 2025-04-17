package org.quanlychuongtrinhdaotao.controller;

import org.quanlychuongtrinhdaotao.model.ChuongTrinhDaoTao;
import org.quanlychuongtrinhdaotao.repository.ChuongTrinhDaoTaoRepository;
import org.quanlychuongtrinhdaotao.service.ChuongTrinhDaoTaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin/chuongtrinhdaotao")
public class ChuongTrinhDaoTaoController {
    private final ChuongTrinhDaoTaoService chuongTrinhDaoTaoService;

    @Autowired
    public ChuongTrinhDaoTaoController(ChuongTrinhDaoTaoService chuongTrinhDaoTaoService) {
        this.chuongTrinhDaoTaoService = chuongTrinhDaoTaoService;
    }

    @GetMapping("")
    public String listCTDT(Model model) {
        model.addAttribute("listCTDT", chuongTrinhDaoTaoService.getAllChuongTrinhDaoTao());
        return "admin/chuongtrinhdaotao/index";
    }

    @GetMapping("/create")
    public String createCTDTForm(Model model) {
        model.addAttribute("CTDT", new ChuongTrinhDaoTao());
        return "admin/chuongtrinhdaotao/create";  // Đường dẫn tới trang tạo blog
    }

    @PostMapping("/save")
    public String saveCTDT(@ModelAttribute("CTDT") ChuongTrinhDaoTao chuongTrinhDaoTao) {
        chuongTrinhDaoTaoService.createChuongTrinhDaoTao(chuongTrinhDaoTao);
        return "redirect:/admin/chuongtrinhdaotao"; // sau khi lưu, chuyển về trang danh sách
    }



}
