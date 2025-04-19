package org.quanlychuongtrinhdaotao.service;

import org.quanlychuongtrinhdaotao.model.HocPhan;
import org.quanlychuongtrinhdaotao.repository.HocPhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HocPhanService {

    @Autowired
    private HocPhanRepository hocPhanRepository;

    public List<HocPhan> getAllHocPhan() {
        return hocPhanRepository.findAll();
    }

    public HocPhan getHocPhanById(int id) {
        Optional<HocPhan> optional = hocPhanRepository.findById(id);
        return optional.orElse(null);
    }

    public HocPhan saveHocPhan(HocPhan hocPhan) {
        return hocPhanRepository.save(hocPhan);
    }

    public void deleteHocPhan(int id) {
        hocPhanRepository.deleteById(id);
    }
}
