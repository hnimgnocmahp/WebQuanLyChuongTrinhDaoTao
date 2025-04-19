package org.quanlychuongtrinhdaotao.service;

import org.quanlychuongtrinhdaotao.model.GiangVien;
import org.quanlychuongtrinhdaotao.repository.GiangVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiangVienService {

    @Autowired
    private GiangVienRepository giangVienRepository;

    public List<GiangVien> getAllGiangVien() {
        return giangVienRepository.findAll();
    }

    public GiangVien getGiangVienById(int id) {
        Optional<GiangVien> optional = giangVienRepository.findById(id);
        return optional.orElse(null);
    }

    public GiangVien saveGiangVien(GiangVien giangVien) {
        return giangVienRepository.save(giangVien);
    }

    public void deleteGiangVien(int id) {
        giangVienRepository.deleteById(id);
    }
}
