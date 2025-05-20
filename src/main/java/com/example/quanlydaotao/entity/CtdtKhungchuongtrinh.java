package com.example.quanlydaotao.entity;

import jakarta.persistence.*;

import java.beans.Transient;
import java.util.List;

@Entity
@Table(name = "ctdt_khungchuongtrinh")
public class CtdtKhungchuongtrinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ctdt_id")
    private Integer ctdtId;

    @Column(name = "ma_nhom")
    private String maNhom;

    @Column(name = "ten_nhom")
    private String tenNhom;

    @Column(name = "so_tin_chi_toi_thieu")
    private Integer soTinChiToiThieu;

    private Integer tongSoTinChiBatBuoc;

    public Integer getTongSoTinChiBatBuoc() {
        return tongSoTinChiBatBuoc;
    }

    public void setTongSoTinChiBatBuoc(Integer tongSoTinChiBatBuoc) {
        this.tongSoTinChiBatBuoc = tongSoTinChiBatBuoc;
    }

    public Integer getTongSoTinChiTuChon() {
        return tongSoTinChiTuChon;
    }

    public void setTongSoTinChiTuChon(Integer tongSoTinChiTuChon) {
        this.tongSoTinChiTuChon = tongSoTinChiTuChon;
    }

    private Integer tongSoTinChiTuChon;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getCtdtId() { return ctdtId; }
    public void setCtdtId(Integer ctdtId) { this.ctdtId = ctdtId; }

    public String getMaNhom() { return maNhom; }
    public void setMaNhom(String maNhom) { this.maNhom = maNhom; }

    public String getTenNhom() { return tenNhom; }
    public void setTenNhom(String tenNhom) { this.tenNhom = tenNhom; }

    public Integer getSoTinChiToiThieu() { return soTinChiToiThieu; }
    public void setSoTinChiToiThieu(Integer soTinChiToiThieu) { this.soTinChiToiThieu = soTinChiToiThieu; }

    @jakarta.persistence.Transient
    private List<CtdtHocphan> hocphans;

    // Getter/Setter cho tất cả
    public List<CtdtHocphan> getHocphans() {
        return hocphans;
    }

    public void setHocphans(List<CtdtHocphan> hocphans) {
        this.hocphans = hocphans;
    }

    @jakarta.persistence.Transient

    private List<CtdtKhungchuongtrinhNhomkienthuc> khungchuongtrinhNhomkienthucs;
    private Integer soTinChiBatBuoc;

    @jakarta.persistence.Transient
    private Integer soTinChiTuChon;

    public List<CtdtKhungchuongtrinhNhomkienthuc> getKhungchuongtrinhNhomkienthucs() {
        return khungchuongtrinhNhomkienthucs;
    }
    public Integer getSoTinChiBatBuoc() {
        return soTinChiBatBuoc;
    }

    public void setKhungchuongtrinhNhomkienthucs(List<CtdtKhungchuongtrinhNhomkienthuc> khungchuongtrinhNhomkienthucs) {
        this.khungchuongtrinhNhomkienthucs = khungchuongtrinhNhomkienthucs;
    }
    public void setSoTinChiBatBuoc(Integer soTinChiBatBuoc) {
        this.soTinChiBatBuoc = soTinChiBatBuoc;
    }

    public Integer getSoTinChiTuChon() {
        return soTinChiTuChon;
    }

    public void setSoTinChiTuChon(Integer soTinChiTuChon) {
        this.soTinChiTuChon = soTinChiTuChon;
    }
}