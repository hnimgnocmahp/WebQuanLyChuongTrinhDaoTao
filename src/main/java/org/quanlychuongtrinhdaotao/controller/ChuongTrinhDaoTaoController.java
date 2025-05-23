package org.quanlychuongtrinhdaotao.controller;

import org.quanlychuongtrinhdaotao.model.ChuongTrinhDaoTao;
import org.quanlychuongtrinhdaotao.service.ChuongTrinhDaoTaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/chuongtrinhdaotao")
public class ChuongTrinhDaoTaoController {

    @Autowired
    private ChuongTrinhDaoTaoService service;

    @GetMapping
    public String list(Model model) {
        List<ChuongTrinhDaoTao> list = service.getAll();
        model.addAttribute("chuongTrinhDaoTaos", list);
        return "admin/chuongtrinhdaotao/list"; // ✅ Không có .html
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("chuongTrinhDaoTao", new ChuongTrinhDaoTao());
        return "admin/chuongtrinhdaotao/add"; // ✅ Không có .html
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("chuongTrinhDaoTao") ChuongTrinhDaoTao obj) {
        service.save(obj);
        return "redirect:/admin/chuongtrinhdaotao"; // ✅
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        ChuongTrinhDaoTao obj = service.getById(id);
        if (obj != null) {
            model.addAttribute("chuongTrinhDaoTao", obj);
            return "admin/chuongtrinhdaotao/edit"; // ✅
        }
        return "redirect:/admin/chuongtrinhdaotao"; // Nếu không tìm thấy thì quay về list
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable int id, @ModelAttribute("chuongTrinhDaoTao") ChuongTrinhDaoTao objUpdate) {
        ChuongTrinhDaoTao obj = service.getById(id);
        if (obj != null) {
            obj.setTenCdt(objUpdate.getTenCdt());
            obj.setBacCdt(objUpdate.getBacCdt());
            obj.setLoaiBangCdt(objUpdate.getLoaiBangCdt());
            obj.setThoiGian(objUpdate.getThoiGian());
            obj.setSoTinChiToiThieu(objUpdate.getSoTinChiToiThieu());
//            obj.setKhoaQuanLy(objUpdate.getKhoaQuanLy());
            obj.setNgonNgu(objUpdate.getNgonNgu());
            service.save(obj);
        }
        return "redirect:/admin/chuongtrinhdaotao"; // ✅
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/admin/chuongtrinhdaotao"; // ✅
    }
}
