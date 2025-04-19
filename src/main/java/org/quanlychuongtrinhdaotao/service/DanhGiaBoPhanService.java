package org.quanlychuongtrinhdaotao.service;

import org.quanlychuongtrinhdaotao.model.DanhGiaBoPhan;
import org.quanlychuongtrinhdaotao.repository.DanhGiaBoPhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DanhGiaBoPhanService {

    @Autowired
    private DanhGiaBoPhanRepository repository;

    public List<DanhGiaBoPhan> getAll() {
        return repository.findAll();
    }

    public DanhGiaBoPhan getById(int id) {
        Optional<DanhGiaBoPhan> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public DanhGiaBoPhan save(DanhGiaBoPhan obj) {
        return repository.save(obj);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
