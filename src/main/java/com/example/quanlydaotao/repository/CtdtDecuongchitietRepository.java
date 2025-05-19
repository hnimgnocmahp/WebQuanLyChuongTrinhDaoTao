package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.CtdtDecuongchitiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CtdtDecuongchitietRepository extends JpaRepository<CtdtDecuongchitiet, Integer> {
    List<CtdtDecuongchitiet> findByHocPhanId(Integer hocPhanId);
}