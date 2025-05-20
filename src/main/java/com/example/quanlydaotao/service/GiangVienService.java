package com.example.quanlydaotao.service;

import com.example.quanlydaotao.entity.CtdtGiangvien;
import com.example.quanlydaotao.repository.CtdtGiangvienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiangVienService {
    
    private final CtdtGiangvienRepository giangVienRepository;

    @Autowired
    public GiangVienService(CtdtGiangvienRepository giangVienRepository) {
        this.giangVienRepository = giangVienRepository;
    }

    public List<CtdtGiangvien> findAll() {
        return giangVienRepository.findAll();
    }

    public CtdtGiangvien findById(Integer id) {
        return giangVienRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid giảng viên Id:" + id));
    }

    public CtdtGiangvien save(CtdtGiangvien giangVien) {
        return giangVienRepository.save(giangVien);
    }

    public void deleteById(Integer id) {
        giangVienRepository.deleteById(id);
    }

    public boolean isUserIdDuplicate(Integer userId, Integer id) {
        return giangVienRepository.existsByUserIdAndIdNot(userId, id == null ? -1 : id);
    }

    public boolean isMaGvDuplicate(String maGv, Integer id) {
        return giangVienRepository.existsByMaGvAndIdNot(maGv, id == null ? -1 : id);
    }
} 