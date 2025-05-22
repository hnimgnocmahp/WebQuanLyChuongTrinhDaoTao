package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.entity.CtdtKehoachdayhoc;
import com.example.quanlydaotao.entity.CtdtKhungchuongtrinh;
import com.example.quanlydaotao.entity.CtdtKhungchuongtrinhNhomkienthuc;
import com.example.quanlydaotao.repository.CtdtKhungchuongtrinhNhomkienthucRepository;
import com.example.quanlydaotao.repository.CtdtKhungchuongtrinhRepository;
import com.example.quanlydaotao.service.KhungChuongTrinhNhomKienThucService;
import com.example.quanlydaotao.service.NhomKienThucService;
import com.example.quanlydaotao.service.ThongTinChungService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/ctdt_khungchuongtrinh_nhomkienthuc")
public class CtdtKhungchuongtrinhNhomkienthucController {

    private final ThongTinChungService thongTinChungService;
    private final KhungChuongTrinhNhomKienThucService service;
    private final NhomKienThucService nhomKienThucService;
    private final CtdtKhungchuongtrinhRepository repository;



    public CtdtKhungchuongtrinhNhomkienthucController(ThongTinChungService thongTinChungService, KhungChuongTrinhNhomKienThucService service, NhomKienThucService nhomKienThucService, CtdtKhungchuongtrinhRepository repository) {
        this.thongTinChungService = thongTinChungService;
        this.service = service;
        this.nhomKienThucService = nhomKienThucService;
        this.repository = repository;
    }
    

    @GetMapping()
    public String listCtdtKhungchuongtrinhNhomkienthuc(Model model) {
        model.addAttribute("ctdt_khungchuongtrinh_nhomkienthuc", service.findAll());
        return "ctdt_khungchuongtrinh_nhomkienthuc_list";
    }

    @GetMapping("form")
    public String openForm(@RequestParam(required = false) Integer id, Model model) {
        // nếu id != null thì load để sửa, ngược lại tạo mới
        var obj = (id == null)
            ? new CtdtKhungchuongtrinhNhomkienthuc()
            : service.findByid(id).orElseThrow();
        model.addAttribute("khungctNhom", obj);
        // để dropdown
        model.addAttribute("khungchuongtrinhList", repository.findAll());
        model.addAttribute("nhomKienthucList", nhomKienThucService.findAll());
        return "khungct_nhomkienthuc_form";
    };

    @PostMapping("/save")
    public String save(
        @Valid @ModelAttribute("khungctNhom") CtdtKhungchuongtrinhNhomkienthuc dto,
        BindingResult errs,
        Model m
    ) {
        // 1. Kiểm tra duplicate: cùng khung chương trình & cùng nhóm kiến thức
        Optional<CtdtKhungchuongtrinhNhomkienthuc> existed = 
            service.findByIdKhungchuongtrinhAndIdManhom(
                dto.getIdKhungchuongtrinh(), dto.getIdManhom());
        if (existed.isPresent() && !existed.get().getId().equals(dto.getId())) {
            errs.rejectValue(
                "idManhom",
                "error.duplicate",
                "Nhóm kiến thức này đã được thêm vào khung chương trình."
            );
        }

        if (errs.hasErrors()) {
            m.addAttribute("khungchuongtrinhList", repository.findAll());
            m.addAttribute("nhomKienthucList", nhomKienThucService.findAll());
            return "khungct_nhomkienthuc_form";
        }

        // 2. Lưu
          // 2. Lưu child
    CtdtKhungchuongtrinhNhomkienthuc saved = service.save(dto);

    // 3. Tính lại tổng tín chỉ của parent
    Integer parentId = saved.getIdKhungchuongtrinh();
    // Lấy tất cả child của parent này
    List<CtdtKhungchuongtrinhNhomkienthuc> children =
        service.findByIdKhungchuongtrinh(parentId);

    int sumFixed = 0, sumOptional = 0;
    for (CtdtKhungchuongtrinhNhomkienthuc c : children) {
        sumFixed    += Optional.ofNullable(c.getSotinchibatbuoc()).orElse(0);
        sumOptional += Optional.ofNullable(c.getSotinchituchon()).orElse(0);
    }

    // 4. Đẩy vào parent và save parent
    CtdtKhungchuongtrinh parent = repository.findById(parentId)
        .orElseThrow(() -> new IllegalStateException("Không tìm thấy khung CT với id=" + parentId));
    parent.setSoTinChiToiThieu(sumFixed + sumOptional);
    repository.save(parent);
        return "redirect:/ctdt_khungchuongtrinh_nhomkienthuc";
    }

     @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttrs) {
        Optional<CtdtKhungchuongtrinhNhomkienthuc> khung = service.findByid(id);
        if (khung.isPresent()) {
            service.deleteById(id);
        } else {
            redirectAttrs.addFlashAttribute("deleteError", "Không tìm thấy bản ghi để xóa.");
        }
        return "redirect:/ctdt_khungchuongtrinh_nhomkienthuc";
    }



    
}