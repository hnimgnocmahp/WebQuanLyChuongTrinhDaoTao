package com.example.quanlydaotao.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ctdt_phanconggiangday")
public class CtdtPhanconggiangday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nhom_id")
    private Integer nhomId;

    @Column(name = "giang_vien_id")
    private Integer giangVienId;

    @Column(name = "vai_tro")
    private String vaiTro;

    @Column(name = "so_tiet")
    private Integer soTiet;

    public CtdtGiangvien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(CtdtGiangvien giangVien) {
        this.giangVien = giangVien;
    }

    public CtdtKehoachmonhom getGroup() {
        return group;
    }

    public void setGroup(CtdtKehoachmonhom group) {
        this.group = group;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nhom_id", insertable = false, updatable = false)
    private CtdtKehoachmonhom group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "giang_vien_id", insertable = false, updatable = false)
    private CtdtGiangvien giangVien;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getNhomId() { return nhomId; }
    public void setNhomId(Integer nhomId) { this.nhomId = nhomId; }

    public Integer getGiangVienId() { return giangVienId; }
    public void setGiangVienId(Integer giangVienId) { this.giangVienId = giangVienId; }

    public String getVaiTro() { return vaiTro; }
    public void setVaiTro(String vaiTro) { this.vaiTro = vaiTro; }

    public Integer getSoTiet() { return soTiet; }
    public void setSoTiet(Integer soTiet) { this.soTiet = soTiet; }

}