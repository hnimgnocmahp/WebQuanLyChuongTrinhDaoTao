package com.example.quanlydaotao.service;

import com.example.quanlydaotao.entity.CtdtNhomkienthuc;
import com.example.quanlydaotao.repository.CtdtNhomkienthucRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhomKienThucService {
    private final CtdtNhomkienthucRepository repo;
    public NhomKienThucService(CtdtNhomkienthucRepository repo) {
        this.repo = repo;
    }
    public List<CtdtNhomkienthuc> findAll() { return repo.findAll(); }
    public Optional<CtdtNhomkienthuc> findById(Integer id) { return repo.findById(id); }
    public CtdtNhomkienthuc save(CtdtNhomkienthuc nhomkienthuc) { return repo.save(nhomkienthuc); }
    public void deleteById(Integer id) { repo.deleteById(id); }
}
