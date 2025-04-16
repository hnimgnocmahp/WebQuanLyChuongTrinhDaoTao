package org.quanlychuongtrinhdaotao.model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "danhgiabophan")
public class DanhGiaBoPhan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "dcct_id")
    private DeCuongChiTiet deCuongChiTiet;

    @Column(name = "diemDanhGiaBoPhan")
    private float diemDanhGiaBoPhan;

    @Column(name = "trongSo")
    private float trongSo;

    @Column(name = "hinhThucDanhGia")
    private String hinhThucDanhGia;

}
