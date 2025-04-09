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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DeCuongChiTiet getDeCuongChiTiet() {
        return deCuongChiTiet;
    }

    public void setDeCuongChiTiet(DeCuongChiTiet deCuongChiTiet) {
        this.deCuongChiTiet = deCuongChiTiet;
    }

    public float getDiemDanhGiaBoPhan() {
        return diemDanhGiaBoPhan;
    }

    public void setDiemDanhGiaBoPhan(float diemDanhGiaBoPhan) {
        this.diemDanhGiaBoPhan = diemDanhGiaBoPhan;
    }

    public float getTrongSo() {
        return trongSo;
    }

    public void setTrongSo(float trongSo) {
        this.trongSo = trongSo;
    }

    public String getHinhThucDanhGia() {
        return hinhThucDanhGia;
    }

    public void setHinhThucDanhGia(String hinhThucDanhGia) {
        this.hinhThucDanhGia = hinhThucDanhGia;
    }
// Getter và Setter
}
