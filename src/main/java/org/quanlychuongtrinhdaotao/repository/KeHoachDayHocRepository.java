package org.quanlychuongtrinhdaotao.repository;

import org.quanlychuongtrinhdaotao.model.KeHoachDayHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeHoachDayHocRepository extends JpaRepository<KeHoachDayHoc, Integer> {
}
