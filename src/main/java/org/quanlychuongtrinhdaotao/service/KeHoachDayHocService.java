package org.quanlychuongtrinhdaotao.service;

import org.quanlychuongtrinhdaotao.model.KeHoachDayHoc;
import org.quanlychuongtrinhdaotao.repository.KeHoachDayHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeHoachDayHocService {

    @Autowired
    private KeHoachDayHocRepository keHoachDayHocRepository;

    public List<KeHoachDayHoc> getAllKeHoachDayHoc() {
        return keHoachDayHocRepository.findAll();
    }

    public KeHoachDayHoc getKeHoachDayHocById(int id) {
        Optional<KeHoachDayHoc> optional = keHoachDayHocRepository.findById(id);
        return optional.orElse(null);
    }

    public KeHoachDayHoc saveKeHoachDayHoc(KeHoachDayHoc keHoachDayHoc) {
        return keHoachDayHocRepository.save(keHoachDayHoc);
    }

    public void deleteKeHoachDayHoc(int id) {
        keHoachDayHocRepository.deleteById(id);
    }
}
