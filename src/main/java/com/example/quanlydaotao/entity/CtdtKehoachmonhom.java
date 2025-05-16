package com.example.quanlydaotao.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ctdt_kehoachmonhom")
public class CtdtKehoachmonhom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_nhom")
    private String maNhom;

    @Column(name = "hoc_phan_id")
    private Integer hocPhanId;

    @Column(name = "nam_hoc")
    private String namHoc;

    @Column(name = "hoc_ky")
    private Integer hocKy;

    @Column(name = "so_luong_sv")
    private Integer soLuongSv;

    @Column(name = "thoi_gian_bat_dau")
    private LocalDate thoiGianBatDau;

    @Column(name = "thoi_gian_ket_thuc")
    private LocalDate thoiGianKetThuc;

    @Column(name = "trang_thai")
    private String trangThai;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getMaNhom() { return maNhom; }
    public void setMaNhom(String maNhom) { this.maNhom = maNhom; }

    public Integer getHocPhanId() { return hocPhanId; }
    public void setHocPhanId(Integer hocPhanId) { this.hocPhanId = hocPhanId; }

    public String getNamHoc() { return namHoc; }
    public void setNamHoc(String namHoc) { this.namHoc = namHoc; }

    public Integer getHocKy() { return hocKy; }
    public void setHocKy(Integer hocKy) { this.hocKy = hocKy; }

    public Integer getSoLuongSv() { return soLuongSv; }
    public void setSoLuongSv(Integer soLuongSv) { this.soLuongSv = soLuongSv; }

    public LocalDate getThoiGianBatDau() { return thoiGianBatDau; }
    public void setThoiGianBatDau(LocalDate thoiGianBatDau) { this.thoiGianBatDau = thoiGianBatDau; }

    public LocalDate getThoiGianKetThuc() { return thoiGianKetThuc; }
    public void setThoiGianKetThuc(LocalDate thoiGianKetThuc) { this.thoiGianKetThuc = thoiGianKetThuc; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }

}