package com.example.quanlydaotao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.quanlydaotao.entity.CtdtDecuongchitiet;
import com.example.quanlydaotao.entity.CtdtCotdiem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.quanlydaotao.repository.CtdtDecuongchitietRepository;
import com.example.quanlydaotao.repository.CtdtCotdiemRepository;

@Controller
public class CtdtDecuongchitietController {

    @Autowired
    private CtdtDecuongchitietRepository CtdtDecuongchitietRepository;

    @Autowired
    private CtdtCotdiemRepository ctdtCotdiemRepository;

    @GetMapping("/ctdt_decuongchitiet")
    public String listCtdtDecuongchitiet(Model model) {
        model.addAttribute("ctdt_decuongchitiet", CtdtDecuongchitietRepository.findAll());
        return "ctdt_decuongchitiet_list";
    }

    // API trả về JSON chi tiết đề cương theo hocPhanId
    @ResponseBody
    @GetMapping("/decuong/{hocPhanId}")
    public ResponseEntity<?> getDeCuongByHocPhanId(@PathVariable Integer hocPhanId) {
        CtdtDecuongchitiet decuong = CtdtDecuongchitietRepository.findByHocPhanId(hocPhanId);
        if (decuong != null) {
            // Chỉ trả về các trường cần thiết
            Map<String, Object> result = new HashMap<>();
            result.put("muc_tieu", decuong.getMucTieu());
            result.put("noi_dung", decuong.getNoiDung());
            result.put("phuong_phap_giang_day", decuong.getPhuongPhapGiangDay());
            // Lấy danh sách cột điểm liên quan
            List<CtdtCotdiem> cotDiemList = ctdtCotdiemRepository.findByDecuongId(decuong.getId());
            result.put("cot_diem", cotDiemList);
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}