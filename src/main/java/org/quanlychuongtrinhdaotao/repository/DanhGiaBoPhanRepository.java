package org.quanlychuongtrinhdaotao.repository;

import org.quanlychuongtrinhdaotao.model.DanhGiaBoPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhGiaBoPhanRepository extends JpaRepository<DanhGiaBoPhan, Integer> {
}
