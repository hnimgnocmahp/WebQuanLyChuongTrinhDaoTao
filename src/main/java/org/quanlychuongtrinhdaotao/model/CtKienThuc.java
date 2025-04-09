package org.quanlychuongtrinhdaotao.model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ctkienthuc")
public class CtKienThuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "kct_id")
    private KhungChuongTrinh khungChuongTrinh;

    @Column(name = "tenKienThuc")
    private String tenKienThuc;

    @Column(name = "loaiKienThuc")
    private String loaiKienThuc;

    @Column(name = "soTinChi")
    private int soTinChi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public KhungChuongTrinh getKhungChuongTrinh() {
        return khungChuongTrinh;
    }

    public void setKhungChuongTrinh(KhungChuongTrinh khungChuongTrinh) {
        this.khungChuongTrinh = khungChuongTrinh;
    }

    public String getTenKienThuc() {
        return tenKienThuc;
    }

    public void setTenKienThuc(String tenKienThuc) {
        this.tenKienThuc = tenKienThuc;
    }

    public String getLoaiKienThuc() {
        return loaiKienThuc;
    }

    public void setLoaiKienThuc(String loaiKienThuc) {
        this.loaiKienThuc = loaiKienThuc;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }
// Getter và Setter
}
