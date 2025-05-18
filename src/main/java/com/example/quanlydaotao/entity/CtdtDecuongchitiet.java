package com.example.quanlydaotao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "ctdt_decuongchitiet")
public class CtdtDecuongchitiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "hoc_phan_id")
    private Integer hocPhanId;

    @Column(name = "muc_tieu")
    private String mucTieu;

    @Column(name = "noi_dung")
    private String noiDung;

    @Column(name = "phuong_phap_giang_day")
    private String phuongPhapGiangDay;

    @Column(name = "phuong_phap_danh_gia")
    private String phuongPhapDanhGia;

    @Column(name = "tai_lieu_tham_khao")
    private String taiLieuThamKhao;

    @Column(name = "trang_thai")
    private String trangThai;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getHocPhanId() { return hocPhanId; }
    public void setHocPhanId(Integer hocPhanId) { this.hocPhanId = hocPhanId; }

    public String getMucTieu() { return mucTieu; }
    public void setMucTieu(String mucTieu) { this.mucTieu = mucTieu; }

    public String getNoiDung() { return noiDung; }
    public void setNoiDung(String noiDung) { this.noiDung = noiDung; }

    public String getPhuongPhapGiangDay() { return phuongPhapGiangDay; }
    public void setPhuongPhapGiangDay(String phuongPhapGiangDay) { this.phuongPhapGiangDay = phuongPhapGiangDay; }

    public String getPhuongPhapDanhGia() { return phuongPhapDanhGia; }
    public void setPhuongPhapDanhGia(String phuongPhapDanhGia) { this.phuongPhapDanhGia = phuongPhapDanhGia; }

    public String getTaiLieuThamKhao() { return taiLieuThamKhao; }
    public void setTaiLieuThamKhao(String taiLieuThamKhao) { this.taiLieuThamKhao = taiLieuThamKhao; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }

}