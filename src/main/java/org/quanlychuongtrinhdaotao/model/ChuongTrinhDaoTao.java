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

    @Column(name = "loai_bang_cdt")
    private String loaiBangCdt;

    private String loaiHinhDaotao;

    @Column(name = "thoi_gian")
    private String thoiGian;

    @Column(name = "so_tin_chi_toi_thieu")
    private int soTinChiToiThieu;

    @Column(name = "ngon_ngu")
    private String ngonNgu;

    @ManyToOne
    @JoinColumn(name = "nganh_id")
    private Nganh nganh;
}
