package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.CtdtNhomkienthuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CtdtNhomkienthucRepository extends JpaRepository<CtdtNhomkienthuc, Integer> {}