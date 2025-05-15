package org.quanlychuongtrinhdaotao.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "phanconggiangday")
public class PhanCongGiangDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "giangvien_id")
    private GiangVien giangVien;

    private int hocKy1;

    private int hocKy2;

    private int hocKy3;

    @ManyToOne
    @JoinColumn(name = "hocphan_id")
    private HocPhan hocPhan;

    @ManyToOne
    @JoinColumn(name = "khmn_id")
    private KeHoachMoNhom keHoachMoNhom;


}
