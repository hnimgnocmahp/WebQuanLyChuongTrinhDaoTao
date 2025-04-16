package org.quanlychuongtrinhdaotao.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "kehoachmonhom")
public class KeHoachMoNhom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "hocphan_id")
    private HocPhan hocPhan;

    @Column(name = "maNhom")
    private String maNhom;

    @Column(name = "namHoc")
    private String namHoc;

    @Column(name = "soLuongSinhVien")
    private int soLuongSinhVien;

    @Column(name = "soLuongNhom")
    private int soLuongNhom;
}
