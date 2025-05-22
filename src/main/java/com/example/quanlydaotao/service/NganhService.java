package com.example.quanlydaotao.service;

import com.example.quanlydaotao.entity.CtdtNganh;
import com.example.quanlydaotao.entity.CtdtNhomkienthuc;
import com.example.quanlydaotao.repository.CtdtNganhRepository;
import com.example.quanlydaotao.repository.CtdtNhomkienthucRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NganhService {
    private final CtdtNganhRepository repo;
    public NganhService(CtdtNganhRepository repo) {
        this.repo = repo;
    }
    public List<CtdtNganh> findAll() { return repo.findAll(); }
    public Optional<CtdtNganh> findById(Integer id) { return repo.findById(id); }
}
