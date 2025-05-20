package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.CtdtKhungchuongtrinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CtdtKhungchuongtrinhRepository extends JpaRepository<CtdtKhungchuongtrinh, Integer> {
    List<CtdtKhungchuongtrinh> findByCtdtId(Integer ctdtId);

}