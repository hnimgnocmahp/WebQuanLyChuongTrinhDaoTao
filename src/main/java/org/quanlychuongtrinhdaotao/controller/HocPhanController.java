package org.quanlychuongtrinhdaotao.controller;

import org.quanlychuongtrinhdaotao.model.HocPhan;
import org.quanlychuongtrinhdaotao.service.HocPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/hocphan")
public class HocPhanController {

    @Autowired
    private HocPhanService hocPhanService;

    // Hiển thị danh sách học phần
    @GetMapping
    public String listHocPhan(Model model) {
        List<HocPhan> hocPhanList = hocPhanService.getAllHocPhan();
        model.addAttribute("hocPhans", hocPhanList);
        return "admin/hocphan/list";  // view: src/main/resources/templates/admin/hocphan/list.html
    }

    // Form thêm học phần
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("hocPhan", new HocPhan());
        return "admin/hocphan/add"; // view: src/main/resources/templates/admin/hocphan/add.html
    }

    // Xử lý thêm học phần
    @PostMapping("/add")
    public String saveHocPhan(@ModelAttribute("hocPhan") HocPhan hocPhan) {
        hocPhanService.saveHocPhan(hocPhan);
        return "redirect:/admin/hocphan"; // quay lại danh sách
    }

    // Form sửa học phần
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        HocPhan hocPhan = hocPhanService.getHocPhanById(id);
        if (hocPhan != null) {
            model.addAttribute("hocPhan", hocPhan);
            return "admin/hocphan/edit"; // view: src/main/resources/templates/admin/hocphan/edit.html
        }
        return "redirect:/admin/hocphan";
    }

    // Xử lý cập nhật học phần
    @PostMapping("/edit/{id}")
    public String updateHocPhan(@PathVariable("id") int id, @ModelAttribute("hocPhan") HocPhan hocPhanDetails) {
        HocPhan hocPhan = hocPhanService.getHocPhanById(id);
        if (hocPhan != null) {
            hocPhan.setTenHocPhan(hocPhanDetails.getTenHocPhan());
            hocPhan.setMaHocPhan(hocPhanDetails.getMaHocPhan());
            hocPhan.setMaHocPhanTruoc(hocPhanDetails.getMaHocPhanTruoc());
            hocPhan.setSoTinChi(hocPhanDetails.getSoTinChi());
            hocPhan.setLyThuyet(hocPhanDetails.isLyThuyet());
            hocPhan.setThucHanh(hocPhanDetails.isThucHanh());
            hocPhan.setThucTap(hocPhanDetails.isThucTap());
            hocPhan.setLoaiKienThuc(hocPhanDetails.isLoaiKienThuc());
            hocPhanService.saveHocPhan(hocPhan);
        }
        return "redirect:/admin/hocphan";
    }

    // Xóa học phần
    @GetMapping("/delete/{id}")
    public String deleteHocPhan(@PathVariable("id") int id) {
        hocPhanService.deleteHocPhan(id);
        return "redirect:/admin/hocphan";
    }
}
