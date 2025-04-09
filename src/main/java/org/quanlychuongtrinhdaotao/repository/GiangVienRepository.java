package org.quanlychuongtrinhdaotao.repository;

import org.quanlychuongtrinhdaotao.model.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiangVienRepository extends JpaRepository<GiangVien, Integer> {
}
