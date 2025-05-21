package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.CtdtKhungchuongtrinhNhomkienthuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CtdtKhungchuongtrinhNhomkienthucRepository extends JpaRepository<CtdtKhungchuongtrinhNhomkienthuc, Integer> {
    List<CtdtKhungchuongtrinhNhomkienthuc> findByIdKhungchuongtrinh(Integer id);
}