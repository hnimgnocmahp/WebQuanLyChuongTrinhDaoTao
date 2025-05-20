package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.CtdtThongtinchung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CtdtThongtinchungRepository extends JpaRepository<CtdtThongtinchung, Integer> {}