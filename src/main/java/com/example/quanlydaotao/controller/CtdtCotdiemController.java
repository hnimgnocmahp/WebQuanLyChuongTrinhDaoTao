package com.example.quanlydaotao.controller;

import java.math.BigDecimal;
import java.util.List;

import com.example.quanlydaotao.entity.CtdtCotdiem;
import com.example.quanlydaotao.repository.CtdtCotdiemRepository;
import com.example.quanlydaotao.repository.CtdtDecuongchitietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ctdt_cotdiem")
public class CtdtCotdiemController {

    @Autowired
    private CtdtCotdiemRepository ctdtCotdiemRepository;

    @Autowired
    private CtdtDecuongchitietRepository ctdtDecuongchitietRepository;

    @GetMapping
    public String listCtdtCotdiem(Model model) {
        model.addAttribute("ctdt_cotdiem", ctdtCotdiemRepository.findAll());
        return "ctdt_cotdiem_list";
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("ctdt_cotdiem", new CtdtCotdiem());
        model.addAttribute("decuongList", ctdtDecuongchitietRepository.findAll());
        return "cotdiem_form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        CtdtCotdiem ctdtCotdiem = ctdtCotdiemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid cột điểm Id:" + id));
        model.addAttribute("ctdt_cotdiem", ctdtCotdiem);
        model.addAttribute("decuongList", ctdtDecuongchitietRepository.findAll());
        return "cotdiem_form";
    }

    @PostMapping("/save")
    public String saveCtdtCotdiem(@ModelAttribute CtdtCotdiem ctdtCotdiem, RedirectAttributes redirectAttributes) {
        // Lấy danh sách cột điểm theo đề cương ID
        List<CtdtCotdiem> existingCotDiem = ctdtCotdiemRepository.findByDecuongId(ctdtCotdiem.getDecuongId());
        
        // Tính tổng tỷ lệ phần trăm hiện tại
        BigDecimal totalPercentage = BigDecimal.ZERO;
        for (CtdtCotdiem cd : existingCotDiem) {
            if (!cd.getId().equals(ctdtCotdiem.getId())) { // Không tính cột điểm đang sửa
                totalPercentage = totalPercentage.add(cd.getTyLePhanTram());
            }
        }
        
        // Thêm tỷ lệ phần trăm mới
        totalPercentage = totalPercentage.add(ctdtCotdiem.getTyLePhanTram());
        
        // Kiểm tra nếu tổng tỷ lệ > 100%
        if (totalPercentage.compareTo(new BigDecimal("100")) > 0) {
            // Tính phần trăm còn lại có thể tạo
            BigDecimal remainingPercentage = new BigDecimal("100").subtract(totalPercentage.subtract(ctdtCotdiem.getTyLePhanTram()));
            redirectAttributes.addFlashAttribute("error", 
                "Tổng tỷ lệ phần trăm không được vượt quá 100%. " +
                "Tỷ lệ phần trăm còn lại có thể tạo: " + remainingPercentage + "%");
            return "redirect:/ctdt_cotdiem/new";
        }
        
        ctdtCotdiemRepository.save(ctdtCotdiem);
        redirectAttributes.addFlashAttribute("success", "Lưu cột điểm thành công!");
        return "redirect:/ctdt_cotdiem";
    }

    @GetMapping("/delete/{id}")
    public String deleteCtdtCotdiem(@PathVariable Integer id) {
        ctdtCotdiemRepository.deleteById(id);
        return "redirect:/ctdt_cotdiem";
    }
}