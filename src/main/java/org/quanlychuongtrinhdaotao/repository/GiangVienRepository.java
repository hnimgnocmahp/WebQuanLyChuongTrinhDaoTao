package org.quanlychuongtrinhdaotao.repository;

import org.quanlychuongtrinhdaotao.model.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface GiangVienRepository extends JpaRepository<GiangVien, Integer> {
    // Tìm giảng viên theo mã cán bộ
    Optional<GiangVien> findByMaCB(String maCB);

    boolean existsByMaCB(String maCB);
}
