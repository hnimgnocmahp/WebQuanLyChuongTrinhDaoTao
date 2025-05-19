package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.entity.CtdtCotdiem;
import com.example.quanlydaotao.entity.CtdtDecuongchitiet;
import com.example.quanlydaotao.entity.CtdtHocphan;
import com.example.quanlydaotao.repository.CtdtCotdiemRepository;
import com.example.quanlydaotao.repository.CtdtDecuongchitietRepository;
import com.example.quanlydaotao.repository.CtdtHocphanRepository;
import com.example.quanlydaotao.service.DecuongchitietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ctdt_decuongchitiet")
public class CtdtDecuongchitietController {

    private final DecuongchitietService service;
    private final CtdtCotdiemRepository ctdtCotdiemRepository;
    private final CtdtHocphanRepository ctdtHocphanRepository;
    private final CtdtDecuongchitietRepository ctdtDecuongchitietRepository;

    @Autowired
    public CtdtDecuongchitietController(DecuongchitietService service, CtdtCotdiemRepository ctdtCotdiemRepository, CtdtHocphanRepository ctdtHocphanRepository, CtdtDecuongchitietRepository ctdtDecuongchitietRepository) {
        this.service = service;
        this.ctdtCotdiemRepository = ctdtCotdiemRepository;
        this.ctdtHocphanRepository = ctdtHocphanRepository;
        this.ctdtDecuongchitietRepository = ctdtDecuongchitietRepository;
    }

    @GetMapping
    public String listCtdtDecuongchitiet(Model model) {
        model.addAttribute("ctdt_decuongchitiet", service.findAll());
        return "ctdt_decuongchitiet_list";
    }

    // API trả về JSON chi tiết đề cương theo hocPhanId
    @ResponseBody
    @GetMapping("/decuong/{hocPhanId}")
    public ResponseEntity<?> getDeCuongByHocPhanId(@PathVariable Integer hocPhanId) {
        List<CtdtDecuongchitiet> decuongList = service.findByHocPhanId(hocPhanId);
        if (!decuongList.isEmpty()) {
            CtdtDecuongchitiet decuong = decuongList.get(0);
            Map<String, Object> result = new HashMap<>();
            result.put("muc_tieu", decuong.getMucTieu());
            result.put("noi_dung", decuong.getNoiDung());
            result.put("phuong_phap_giang_day", decuong.getPhuongPhapGiangDay());
            result.put("trang_thai", decuong.getTrangThai());
            List<CtdtCotdiem> cotDiemList = ctdtCotdiemRepository.findByDecuongId(decuong.getId());
            result.put("cot_diem", cotDiemList);
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Hiển thị form thêm mới
    @GetMapping("/new")
    public String showNewForm(Model model) {
        // Lấy tất cả học phần
        List<CtdtHocphan> allHocPhan = ctdtHocphanRepository.findAll();
        // Lấy tất cả họcPhanId đã có đề cương chi tiết
        List<Integer> usedHocPhanIds = ctdtDecuongchitietRepository.findAll()
            .stream().map(CtdtDecuongchitiet::getHocPhanId).distinct().toList();
        // Lọc ra các học phần chưa có đề cương chi tiết
        List<CtdtHocphan> availableHocPhan = allHocPhan.stream()
            .filter(hp -> !usedHocPhanIds.contains(hp.getId())).toList();
        model.addAttribute("hocPhanList", availableHocPhan);
        model.addAttribute("decuongchitiet", new CtdtDecuongchitiet());
        return "decuongchitiet_form";
    }

    // Hiển thị form sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        CtdtDecuongchitiet decuongchitiet = service.findById(id);
        if (decuongchitiet != null) {
            model.addAttribute("decuongchitiet", decuongchitiet);
            model.addAttribute("hocPhanList", ctdtHocphanRepository.findAll());
            return "decuongchitiet_form";
        }
        return "redirect:/ctdt_decuongchitiet";
    }

    // Xử lý thêm mới và cập nhật
    @PostMapping("/save")
    public String save(@ModelAttribute("decuongchitiet") CtdtDecuongchitiet decuongchitiet) {
        service.save(decuongchitiet);
        return "redirect:/ctdt_decuongchitiet";
    }

    // Xử lý xóa
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        // Xóa tất cả cột điểm liên quan trước
        ctdtCotdiemRepository.deleteAll(ctdtCotdiemRepository.findByDecuongId(id));
        // Sau đó xóa đề cương
        service.deleteById(id);
        return "redirect:/ctdt_decuongchitiet";
    }

}