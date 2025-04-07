package org.quanlychuongtrinhdaotao.service;

import org.quanlychuongtrinhdaotao.model.KeHoachDayHoc;
import org.quanlychuongtrinhdaotao.model.KeHoachDayHoc;
import org.quanlychuongtrinhdaotao.repository.KeHoachDayHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeHoachDayHocService {
    private final KeHoachDayHocRepository keHoachDayHocRepository;

    @Autowired
    public KeHoachDayHocService(KeHoachDayHocRepository keHoachDayHocRepository){
        this.keHoachDayHocRepository = keHoachDayHocRepository;
    }

    public KeHoachDayHoc createKeHoachDayHoc(KeHoachDayHoc keHoachDayHoc){
        return keHoachDayHocRepository.save(keHoachDayHoc);
    }

    public KeHoachDayHoc getKeHoachDayHocByID(int id){
        return keHoachDayHocRepository.findById(id).orElse(null);
    }

    public List<KeHoachDayHoc> getAllKeHoachDayHoc(){
        return keHoachDayHocRepository.findAll();
    }

    public boolean deleteKeHoachDayHoc (int id){
        if(keHoachDayHocRepository.existsById(id)){
            keHoachDayHocRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

    public KeHoachDayHoc updateKeHoachDayHoc(int id,KeHoachDayHoc UpdatekeHoachDayHoc){
        KeHoachDayHoc existKeHoachDayHoc = keHoachDayHocRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not exist" + id));
        existKeHoachDayHoc.setNamHoc(UpdatekeHoachDayHoc.getNamHoc());
        existKeHoachDayHoc.setHocPhan(UpdatekeHoachDayHoc.getHocPhan());
        existKeHoachDayHoc.setHockiThucHien(UpdatekeHoachDayHoc.getHockiThucHien());

        return keHoachDayHocRepository.save(existKeHoachDayHoc);
    }
}
