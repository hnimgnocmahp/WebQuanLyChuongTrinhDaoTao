package com.example.quanlydaotao.service;

import com.example.quanlydaotao.entity.CtdtHocphan;
import com.example.quanlydaotao.repository.CtdtHocphanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HocPhanService {
    private final CtdtHocphanRepository repo;
    public HocPhanService(CtdtHocphanRepository repo) {
        this.repo = repo;
    }
    public List<CtdtHocphan> findAll() { return repo.findAll(); }
    public Optional<CtdtHocphan> findById(Integer id) { return repo.findById(id); }
    public CtdtHocphan save(CtdtHocphan hp) { return repo.save(hp); }
    public void deleteById(Integer id) { repo.deleteById(id); }
    public Optional<CtdtHocphan> findByMaHp(String maHp){
        return repo.findByMaHp(maHp);
    }
    public boolean existsByMaHp(String maHp){
        return repo.existsByMaHp(maHp);
    }
    public boolean isReferencedAsPrerequisite(String maHp) {
        return repo.existsByHocPhanTienQuyet(maHp);
    }
    public List<CtdtHocphan> searchByMaOrTen(String keyword) {
        return repo.findByMaHpContainingIgnoreCaseOrTenHpContainingIgnoreCase(keyword, keyword);
    }

//    Optional<CtdtHocphan> findByMaHp(String maHp);
//    boolean existsByMaHp(String maHp);
}
