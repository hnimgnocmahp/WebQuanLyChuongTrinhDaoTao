package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.entity.*;
import com.example.quanlydaotao.repository.CtdtGiangvienRepository;
import com.example.quanlydaotao.repository.CtdtKehoachmonhomRepository;
import com.example.quanlydaotao.repository.CtdtPhanconggiangdayRepository;
import com.example.quanlydaotao.repository.CtdtUserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ctdt_giangvien_front")
public class GiangVienFrontController {
    @Autowired
    private CtdtUserRepository userRepository;
    @Autowired
    private CtdtGiangvienRepository giangvienRepository;
    @Autowired
    private CtdtPhanconggiangdayRepository phancongRepo;
    @Autowired
    private CtdtKehoachmonhomRepository kehoachRepo;

    @GetMapping
    public String giangVienFront() {
        return "user/ctdt_giangvien_front";
    }

    @GetMapping("/user/ctdt_phancongcongtac")
    public String phanCongCongTacUser(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            model.addAttribute("error", "Không tìm thấy thông tin đăng nhập trong phiên làm việc.");
            return "user/ctdt_phancongcongtac_user";
        }
        CtdtUser user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            model.addAttribute("error", "Không tìm thấy tài khoản người dùng trong hệ thống.");
            return "user/ctdt_phancongcongtac_user";
        }
        CtdtGiangvien gv = giangvienRepository.findByUserId(user.getId()).orElse(null);
        if (gv == null) {
            model.addAttribute("error", "Không tìm thấy thông tin giảng viên tương ứng với tài khoản này.");
            return "user/ctdt_phancongcongtac_user";
        }

        // Tổng hợp dữ liệu phân công cho giảng viên
        List<CtdtPhanconggiangday> assignments = phancongRepo.findByGiangVienId(gv.getId());
        gv.setAssignments(assignments);
        Map<Integer, CtdtHocphan> hocphanMap = new LinkedHashMap<>();
        Map<Integer, Long> groupsPerCourse = new HashMap<>();
        Map<Integer, List<Integer>> hockyMap = new HashMap<>();

        for (CtdtPhanconggiangday pc : assignments) {
            CtdtKehoachmonhom nhom = kehoachRepo.findById(pc.getNhomId()).orElse(null);
            if (nhom == null) continue;
            CtdtHocphan hp = nhom.getHocPhan();
            if (hp == null) continue;
            hocphanMap.put(hp.getId(), hp);
            // Đếm số nhóm/lớp cho mỗi học phần
            groupsPerCourse.put(hp.getId(), groupsPerCourse.getOrDefault(hp.getId(), 0L) + 1);
            // Tổng hợp số tiết theo học kỳ
            List<Integer> hocky = hockyMap.getOrDefault(hp.getId(), Arrays.asList(0,0,0));
            int hk = nhom.getHocKy() != null ? nhom.getHocKy() : 1;
            List<Integer> newHocky = new ArrayList<>(hocky);
            newHocky.set(hk-1, newHocky.get(hk-1) + pc.getSoTiet());
            hockyMap.put(hp.getId(), newHocky);
        }
        gv.setHocphanMap(hocphanMap);
        gv.setGroupsPerCourse(groupsPerCourse);
        gv.setHockyMap(hockyMap);
        model.addAttribute("gv", gv);
        return "user/ctdt_phancongcongtac_user";
    }

    @GetMapping("/user/ctdt_phanconggiangday")
    public String phanCongGiangDayUser() {
        return "user/ctdt_phanconggiangday_user";
    }
} 