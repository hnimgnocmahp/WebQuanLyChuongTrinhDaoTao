package org.quanlychuongtrinhdaotao.service;

import org.quanlychuongtrinhdaotao.model.DanhGiaBoPhan;
import org.quanlychuongtrinhdaotao.repository.DanhGiaBoPhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DanhGiaBoPhanService {

    private final DanhGiaBoPhanRepository danhGiaBoPhanRepository;

    @Autowired
    public DanhGiaBoPhanService(DanhGiaBoPhanRepository danhGiaBoPhanRepository) {
        this.danhGiaBoPhanRepository = danhGiaBoPhanRepository;
    }

    // Lấy tất cả các danh giá bộ phận
    public List<DanhGiaBoPhan> getAllDanhGiaBoPhan() {
        return danhGiaBoPhanRepository.findAll();
    }

    // Lấy danh giá bộ phận theo id
    public Optional<DanhGiaBoPhan> getDanhGiaBoPhanById(int id) {
        return danhGiaBoPhanRepository.findById(id);
    }

    // Tạo mới một danh giá bộ phận
    public DanhGiaBoPhan createDanhGiaBoPhan(DanhGiaBoPhan danhGiaBoPhan) {
        return danhGiaBoPhanRepository.save(danhGiaBoPhan);
    }

    // Cập nhật một danh giá bộ phận
    public DanhGiaBoPhan updateDanhGiaBoPhan(int id, DanhGiaBoPhan updatedDanhGiaBoPhan) {
        Optional<DanhGiaBoPhan> existDanhGiaBoPhan = danhGiaBoPhanRepository.findById(id);
        if (existDanhGiaBoPhan.isPresent()) {
            DanhGiaBoPhan danhGiaBoPhan = existDanhGiaBoPhan.get();
            danhGiaBoPhan.setHinhThucDanhGia(updatedDanhGiaBoPhan.getHinhThucDanhGia());
            danhGiaBoPhan.setDiemDanhGiaBoPhan(updatedDanhGiaBoPhan.getDiemDanhGiaBoPhan());
            danhGiaBoPhan.setTrongSo(updatedDanhGiaBoPhan.getTrongSo());
            danhGiaBoPhan.setDeCuongChiTiet(updatedDanhGiaBoPhan.getDeCuongChiTiet());
            return danhGiaBoPhanRepository.save(danhGiaBoPhan);
        } else {
            return null; // Hoặc ném một ngoại lệ nếu không tìm thấy đối tượng
        }
    }

    // Xóa danh giá bộ phận
    public boolean deleteDanhGiaBoPhan(int id) {
        if (danhGiaBoPhanRepository.existsById(id)) {
            danhGiaBoPhanRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
