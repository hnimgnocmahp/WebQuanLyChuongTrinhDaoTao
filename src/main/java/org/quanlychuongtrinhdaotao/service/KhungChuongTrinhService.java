package org.quanlychuongtrinhdaotao.service;

import org.quanlychuongtrinhdaotao.model.KhungChuongTrinh;
import org.quanlychuongtrinhdaotao.repository.KhungChuongTrinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhungChuongTrinhService {

    @Autowired
    private KhungChuongTrinhRepository khungChuongTrinhRepository;

    public List<KhungChuongTrinh> getAllKhungChuongTrinh() {
        return khungChuongTrinhRepository.findAll();
    }

    public KhungChuongTrinh getKhungChuongTrinhById(int id) {
        Optional<KhungChuongTrinh> optional = khungChuongTrinhRepository.findById(id);
        return optional.orElse(null);
    }

    public KhungChuongTrinh saveKhungChuongTrinh(KhungChuongTrinh khungChuongTrinh) {
        return khungChuongTrinhRepository.save(khungChuongTrinh);
    }

    public void deleteKhungChuongTrinh(int id) {
        khungChuongTrinhRepository.deleteById(id);
    }
}
