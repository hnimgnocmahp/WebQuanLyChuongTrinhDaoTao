package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.entity.CtdtCotdiem;
import com.example.quanlydaotao.repository.CtdtCotdiemRepository;
import com.example.quanlydaotao.repository.CtdtDecuongchitietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;

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
        // Lấy tất cả đề cương
        List<com.example.quanlydaotao.entity.CtdtDecuongchitiet> allDecuong = ctdtDecuongchitietRepository.findAll();
        // Lấy tất cả decuongId đã có cột điểm
        List<Integer> usedDecuongIds = ctdtCotdiemRepository.findByDecuongIdIsNotNull()
            .stream().map(com.example.quanlydaotao.entity.CtdtCotdiem::getDecuongId).distinct().toList();
        // Lọc ra các đề cương chưa có cột điểm
        List<com.example.quanlydaotao.entity.CtdtDecuongchitiet> availableDecuong = allDecuong.stream()
            .filter(dc -> !usedDecuongIds.contains(dc.getId())).toList();
        model.addAttribute("decuongList", availableDecuong);
        return "cotdiem_form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        CtdtCotdiem ctdtCotdiem = ctdtCotdiemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid cột điểm Id:" + id));
        Integer decuongId = ctdtCotdiem.getDecuongId();
        List<CtdtCotdiem> cotDiemList = ctdtCotdiemRepository.findByDecuongId(decuongId);
        model.addAttribute("cotDiemList", cotDiemList);
        model.addAttribute("decuongId", decuongId);
        model.addAttribute("decuongList", ctdtDecuongchitietRepository.findAll());
        return "cotdiem_form";
    }

    @PostMapping("/save")
    public String saveCtdtCotdiem(
            @RequestParam("decuongId") Integer decuongId,
            @RequestParam(value = "id[]", required = false) List<Integer> idList,
            @RequestParam("tenCotDiem[]") List<String> tenCotDiemList,
            @RequestParam("tyLePhanTram[]") List<BigDecimal> tyLePhanTramList,
            @RequestParam("hinhThuc[]") List<String> hinhThucList,
            RedirectAttributes redirectAttributes
    ) {
        // Kiểm tra tổng tỷ lệ
        BigDecimal total = BigDecimal.ZERO;
        for (BigDecimal tyLe : tyLePhanTramList) {
            total = total.add(tyLe);
        }
        if (total.compareTo(new BigDecimal("100")) != 0) {
            redirectAttributes.addFlashAttribute("error", "Tổng tỷ lệ các cột điểm phải bằng 100%. Hiện tại: " + total + "%");
            return "redirect:/ctdt_cotdiem/new";
        }

        // Lấy danh sách id cũ trong DB
        List<CtdtCotdiem> oldCotDiemList = ctdtCotdiemRepository.findByDecuongId(decuongId);
        List<Integer> oldIds = oldCotDiemList.stream().map(CtdtCotdiem::getId).toList();
        // Danh sách id còn lại sau khi submit
        List<Integer> newIds = idList != null ? idList.stream().filter(i -> i != null).toList() : List.of();

        // Xóa các cột điểm cũ không còn trong form
        for (Integer oldId : oldIds) {
            if (!newIds.contains(oldId)) {
                ctdtCotdiemRepository.deleteById(oldId);
            }
        }

        // Lưu hoặc cập nhật các cột điểm
        for (int i = 0; i < tenCotDiemList.size(); i++) {
            Integer id = (idList != null && idList.size() > i) ? idList.get(i) : null;
            CtdtCotdiem cotDiem;
            if (id != null) {
                cotDiem = ctdtCotdiemRepository.findById(id).orElse(new CtdtCotdiem());
                cotDiem.setId(id);
            } else {
                cotDiem = new CtdtCotdiem();
            }
            cotDiem.setDecuongId(decuongId);
            cotDiem.setTenCotDiem(tenCotDiemList.get(i));
            cotDiem.setTyLePhanTram(tyLePhanTramList.get(i));
            cotDiem.setHinhThuc(hinhThucList.get(i));
            ctdtCotdiemRepository.save(cotDiem);
        }

        // --- Cập nhật phuong_phap_danh_gia cho ctdt_decuongchitiet ---
        List<CtdtCotdiem> cotDiemList = ctdtCotdiemRepository.findByDecuongId(decuongId);
        StringBuilder danhGia = new StringBuilder();
        for (CtdtCotdiem cot : cotDiemList) {
            if (danhGia.length() > 0) danhGia.append(", ");
            danhGia.append(cot.getTenCotDiem())
                   .append(": ")
                   .append(cot.getTyLePhanTram())
                   .append("%");
        }
        ctdtDecuongchitietRepository.findById(decuongId).ifPresent(decuong -> {
            decuong.setPhuongPhapDanhGia(danhGia.toString());
            ctdtDecuongchitietRepository.save(decuong);
        });
        // --- END cập nhật phuong_phap_danh_gia ---

        redirectAttributes.addFlashAttribute("success", "Lưu các cột điểm thành công!");
        return "redirect:/ctdt_cotdiem";
    }

    @GetMapping("/delete/{id}")
    public String deleteCtdtCotdiem(@PathVariable Integer id) {
        ctdtCotdiemRepository.deleteById(id);
        return "redirect:/ctdt_cotdiem";
    }

    @GetMapping("/deleteByDecuongId/{decuongId}")
    public String deleteByDecuongId(@PathVariable Integer decuongId) {
        ctdtCotdiemRepository.deleteAll(ctdtCotdiemRepository.findByDecuongId(decuongId));
        return "redirect:/ctdt_cotdiem";
    }
}