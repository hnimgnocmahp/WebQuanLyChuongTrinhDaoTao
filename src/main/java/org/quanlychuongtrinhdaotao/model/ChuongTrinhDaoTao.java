package org.quanlychuongtrinhdaotao.model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "chuongtrinhdaotao")
public class ChuongTrinhDaoTao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ten_cdt")
    private String tenCdt;

    @Column(name = "bac_cdt")
    private String bacCdt;

    @Column(name = "loaiBang_cdt")
    private String loaiBangCdt;

    @Column(name = "thoiGian")
    private String thoiGian;

    @Column(name = "soTinChiToiThieu")
    private int soTinChiToiThieu;

    @Column(name = "khoaQuanLy")
    private String khoaQuanLy;

    @Column(name = "ngonNgu")
    private String ngonNgu;

    @ManyToOne
    @JoinColumn(name = "nganh_id")
    private Nganh nganh;
}
