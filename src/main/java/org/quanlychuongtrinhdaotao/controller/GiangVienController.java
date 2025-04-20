package org.quanlychuongtrinhdaotao.controller;

import org.quanlychuongtrinhdaotao.model.GiangVien;
import org.quanlychuongtrinhdaotao.service.GiangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/giangvien")
public class GiangVienController {

    @Autowired
    private GiangVienService giangVienService;

    // Hiển thị danh sách giảng viên
    @GetMapping
    public String listGiangVien(Model model) {
        List<GiangVien> giangVienList = giangVienService.getAllGiangVien();
        model.addAttribute("giangViens", giangVienList);
        return "admin/giangvien/list";
    }

    // Form thêm giảng viên mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("giangVien", new GiangVien());
        return "admin/giangvien/add";
    }

    // Xử lý thêm giảng viên
    @PostMapping("/add")
    public String saveGiangVien(@ModelAttribute("giangVien") GiangVien giangVien) {
        giangVienService.saveGiangVien(giangVien);
        return "redirect:/admin/giangvien";
    }

    // Form sửa giảng viên
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        GiangVien giangVien = giangVienService.getGiangVienById(id);
        if (giangVien != null) {
            model.addAttribute("giangVien", giangVien);
            return "admin/giangvien/edit";
        }
        return "redirect:/admin/giangvien";
    }

    // Xử lý cập nhật giảng viên
    @PostMapping("/edit/{id}")
    public String updateGiangVien(@PathVariable("id") int id, @ModelAttribute("giangVien") GiangVien giangVienDetails) {
        GiangVien giangVien = giangVienService.getGiangVienById(id);
        if (giangVien != null) {
            giangVien.setMaCB(giangVienDetails.getMaCB());
            giangVien.setMatKhau(giangVienDetails.getMatKhau());
            giangVien.setHoTen(giangVienDetails.getHoTen());
            giangVien.setNamSinh(giangVienDetails.getNamSinh());
            giangVien.setHocVi(giangVienDetails.getHocVi());
            giangVienService.saveGiangVien(giangVien);
        }
        return "redirect:/admin/giangvien";
    }

    // Xóa giảng viên
    @GetMapping("/delete/{id}")
    public String deleteGiangVien(@PathVariable("id") int id) {
        giangVienService.deleteGiangVien(id);
        return "redirect:/admin/giangvien";
    }
}
