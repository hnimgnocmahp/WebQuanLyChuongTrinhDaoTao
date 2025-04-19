package org.quanlychuongtrinhdaotao.controller;

import org.quanlychuongtrinhdaotao.model.HocPhan;
import org.quanlychuongtrinhdaotao.service.HocPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hocphan")
public class HocPhanController {

    @Autowired
    private HocPhanService hocPhanService;

    // Hiển thị danh sách học phần
    @GetMapping
    public String listHocPhan(Model model) {
        List<HocPhan> hocPhanList = hocPhanService.getAllHocPhan();
        model.addAttribute("hocPhans", hocPhanList);
        return "hocphan/list";  // return view: src/main/resources/templates/hocphan/list.html
    }

    // Hiển thị form thêm học phần
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("hocPhan", new HocPhan());
        return "hocphan/add.html";  // src/main/resources/templates/hocphan/add.html.html
    }

    // Xử lý thêm học phần
    @PostMapping("/add")
    public String saveHocPhan(@ModelAttribute("hocPhan") HocPhan hocPhan) {
        hocPhanService.saveHocPhan(hocPhan);
        return "redirect:/hocphan"; // redirect về danh sách
    }

    // Hiển thị form sửa học phần
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        HocPhan hocPhan = hocPhanService.getHocPhanById(id);
        if (hocPhan != null) {
            model.addAttribute("hocPhan", hocPhan);
            return "hocphan/edit"; // src/main/resources/templates/hocphan/edit.html
        }
        return "redirect:/hocphan";
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
        return "redirect:/hocphan";
    }

    // Xóa học phần
    @GetMapping("/delete/{id}")
    public String deleteHocPhan(@PathVariable("id") int id) {
        hocPhanService.deleteHocPhan(id);
        return "redirect:/hocphan";
    }
}
