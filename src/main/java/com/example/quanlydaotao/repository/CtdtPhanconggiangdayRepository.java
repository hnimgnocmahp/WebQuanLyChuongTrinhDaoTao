package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.CtdtPhanconggiangday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CtdtPhanconggiangdayRepository extends JpaRepository<CtdtPhanconggiangday, Integer> {
    List<CtdtPhanconggiangday> findByNhomId(Integer nhomId);

    List<CtdtPhanconggiangday> findByGiangVienId(Integer gvId);
}