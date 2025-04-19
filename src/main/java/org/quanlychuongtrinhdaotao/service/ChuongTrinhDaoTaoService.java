package org.quanlychuongtrinhdaotao.service;

import org.quanlychuongtrinhdaotao.model.ChuongTrinhDaoTao;
import org.quanlychuongtrinhdaotao.repository.ChuongTrinhDaoTaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChuongTrinhDaoTaoService {

    @Autowired
    private ChuongTrinhDaoTaoRepository repository;

    public List<ChuongTrinhDaoTao> getAll() {
        return repository.findAll();
    }

    public ChuongTrinhDaoTao getById(int id) {
        Optional<ChuongTrinhDaoTao> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public ChuongTrinhDaoTao save(ChuongTrinhDaoTao obj) {
        return repository.save(obj);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
