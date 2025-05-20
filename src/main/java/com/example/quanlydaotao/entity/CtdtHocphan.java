package com.example.quanlydaotao.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ctdt_hocphan")
public class CtdtHocphan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_hp")
    private String maHp;

    @Column(name = "ten_hp")
    private String tenHp;

    @Column(name = "so_tin_chi")
    private Integer soTinChi;

    @Column(name = "so_tiet_ly_thuyet")
    private Integer soTietLyThuyet;

    @Column(name = "so_tiet_thuc_hanh")
    private Integer soTietThucHanh;

    @Column(name = "nhom_id")
    private Integer nhomId;

    @Column(name = "loai_hp")
    private String loaiHp;

    @Column(name = "hoc_phan_tien_quyet")
    private String hocPhanTienQuyet;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getMaHp() { return maHp; }
    public void setMaHp(String maHp) { this.maHp = maHp; }

    public String getTenHp() { return tenHp; }
    public void setTenHp(String tenHp) { this.tenHp = tenHp; }

    public Integer getSoTinChi() { return soTinChi; }
    public void setSoTinChi(Integer soTinChi) { this.soTinChi = soTinChi; }

    public Integer getSoTietLyThuyet() { return soTietLyThuyet; }
    public void setSoTietLyThuyet(Integer soTietLyThuyet) { this.soTietLyThuyet = soTietLyThuyet; }

    public Integer getSoTietThucHanh() { return soTietThucHanh; }
    public void setSoTietThucHanh(Integer soTietThucHanh) { this.soTietThucHanh = soTietThucHanh; }

    public Integer getNhomId() { return nhomId; }
    public void setNhomId(Integer nhomId) { this.nhomId = nhomId; }

    public String getLoaiHp() { return loaiHp; }
    public void setLoaiHp(String loaiHp) { this.loaiHp = loaiHp; }

    public String getHocPhanTienQuyet() { return hocPhanTienQuyet; }
    public void setHocPhanTienQuyet(String hocPhanTienQuyet) { this.hocPhanTienQuyet = hocPhanTienQuyet; }

    @Transient
    private List<CtdtKehoachdayhoc> kehoachs;

    // Getter/Setter cho tất cả
    public List<CtdtKehoachdayhoc> getKehoachs() {
        return kehoachs;
    }

    public void setKehoachs(List<CtdtKehoachdayhoc> kehoachs) {
        this.kehoachs = kehoachs;
    }

    public boolean hasHocKy(int hocKy) {
        if (kehoachs == null) return false;
        for (CtdtKehoachdayhoc k : kehoachs) {
            if (k.getHocKy() != null && k.getHocKy() == hocKy) {
                return true;
            }
        }
        return false;
    }

}