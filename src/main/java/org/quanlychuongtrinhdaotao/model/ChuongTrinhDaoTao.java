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

    @Column(name = "thoi_gian")
    private String thoiGian;

    @Column(name = "so_tin_chi_toi_thieu")
    private int soTinChiToiThieu;

    @Column(name = "khoa_quan_ly")
    private String khoaQuanLy;

    @Column(name = "ngon_ngu")
    private String ngonNgu;

    @ManyToOne
    @JoinColumn(name = "nganh_id")
    private Nganh nganh;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenCdt() {
        return tenCdt;
    }

    public void setTenCdt(String tenCdt) {
        this.tenCdt = tenCdt;
    }

    public String getBacCdt() {
        return bacCdt;
    }

    public void setBacCdt(String bacCdt) {
        this.bacCdt = bacCdt;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getLoaiBangCdt() {
        return loaiBangCdt;
    }

    public void setLoaiBangCdt(String loaiBangCdt) {
        this.loaiBangCdt = loaiBangCdt;
    }

    public int getSoTinChiToiThieu() {
        return soTinChiToiThieu;
    }

    public void setSoTinChiToiThieu(int soTinChiToiThieu) {
        this.soTinChiToiThieu = soTinChiToiThieu;
    }

    public String getKhoaQuanLy() {
        return khoaQuanLy;
    }

    public void setKhoaQuanLy(String khoaQuanLy) {
        this.khoaQuanLy = khoaQuanLy;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public Nganh getNganh() {
        return nganh;
    }

    public void setNganh(Nganh nganh) {
        this.nganh = nganh;
    }
}
