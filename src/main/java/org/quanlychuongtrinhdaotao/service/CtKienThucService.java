package org.quanlychuongtrinhdaotao.service;

import org.quanlychuongtrinhdaotao.model.CtKienThuc;
import org.quanlychuongtrinhdaotao.model.DeCuongChiTiet;
import org.quanlychuongtrinhdaotao.repository.CtKienThucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CtKienThucService {

    private final CtKienThucRepository ctKienThucRepository;

    @Autowired
    public CtKienThucService(CtKienThucRepository ctKienThucRepository) {
        this.ctKienThucRepository = ctKienThucRepository;
    }

    // Lấy tất cả các kiến thức
    public List<CtKienThuc> getAllCtKienThuc() {
        return ctKienThucRepository.findAll();
    }

    // Lấy kiến thức theo id
    public Optional<CtKienThuc> getCtKienThucById(int id) {
        return ctKienThucRepository.findById(id);
    }

    // Tạo mới một kiến thức
    public CtKienThuc createCtKienThuc(CtKienThuc ctkienThuc) {
        return ctKienThucRepository.save(ctkienThuc);
    }

    // Cập nhật một kiến thức
    public CtKienThuc updateCtKienThuc(int id, CtKienThuc updateCtKienThuc){
        Optional<CtKienThuc> existCtKienThuc = ctKienThucRepository.findById(id);
        if (existCtKienThuc.isPresent()){
            CtKienThuc ctKienThuc = existCtKienThuc.get();
            ctKienThuc.setLoaiKienThuc(updateCtKienThuc.getLoaiKienThuc());
            ctKienThuc.setTenKienThuc(updateCtKienThuc.getTenKienThuc());
            ctKienThuc.setSoTinChi(updateCtKienThuc.getSoTinChi());
            ctKienThuc.setKhungChuongTrinh(updateCtKienThuc.getKhungChuongTrinh());

            return ctKienThucRepository.save(ctKienThuc);
        }
        else {
            return null;
        }
    }

    // Xóa kiến thức
    public boolean deleteCtKienThuc(int id) {
        if (ctKienThucRepository.existsById(id)) {
            ctKienThucRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
