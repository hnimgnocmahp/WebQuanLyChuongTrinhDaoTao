package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.entity.CtdtDecuongchitiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CtdtDecuongchitietRepository extends JpaRepository<CtdtDecuongchitiet, Integer> {}