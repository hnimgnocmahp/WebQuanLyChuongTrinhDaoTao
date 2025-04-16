package org.quanlychuongtrinhdaotao.service;

import org.quanlychuongtrinhdaotao.model.HocPhan;
import org.quanlychuongtrinhdaotao.repository.HocPhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HocPhanService {

    private final HocPhanRepository hocPhanRepository;

    @Autowired
    public HocPhanService(HocPhanRepository hocPhanRepository) {
        this.hocPhanRepository = hocPhanRepository;
    }

    // Phương thức tạo mới HocPhan
    public HocPhan createHocPhan(HocPhan hocPhan) {
        return hocPhanRepository.save(hocPhan);
    }

    // Phương thức cập nhật HocPhan
    public HocPhan updateHocPhan(int id, HocPhan updatedHocPhan) {
        Optional<HocPhan> existingHocPhan = hocPhanRepository.findById(id);
        if (existingHocPhan.isPresent()) {
            HocPhan hocPhan = existingHocPhan.get();
            hocPhan.setTenHocPhan(updatedHocPhan.getTenHocPhan());
            hocPhan.setSoTinChi(updatedHocPhan.getSoTinChi());
            hocPhan.setLyThuyet(updatedHocPhan.isLyThuyet());
            hocPhan.setThucHanh(updatedHocPhan.isThucHanh());
            hocPhan.setThucTap(updatedHocPhan.isThucTap());
            return hocPhanRepository.save(hocPhan);
        } else {
            return null; // HocPhan không tồn tại
        }
    }

    // Phương thức lấy danh sách tất cả HocPhan
    public List<HocPhan> getAllHocPhan() {
        return hocPhanRepository.findAll();
    }

    // Phương thức lấy HocPhan theo id
    public HocPhan getHocPhanById(int id) {
        return hocPhanRepository.findById(id).orElse(null);
    }

    // Phương thức xóa HocPhan
    public boolean deleteHocPhan(int id) {
        if (hocPhanRepository.existsById(id)) {
            hocPhanRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
