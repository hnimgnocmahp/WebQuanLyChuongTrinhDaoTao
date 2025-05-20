package com.example.quanlydaotao.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ctdt_cotdiem")
public class CtdtCotdiem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "decuong_id")
    private Integer decuongId;

    @Column(name = "ten_cot_diem")
    private String tenCotDiem;

    @Column(name = "ty_le_phan_tram")
    private BigDecimal tyLePhanTram;

    @Column(name = "hinh_thuc")
    private String hinhThuc;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getDecuongId() { return decuongId; }
    public void setDecuongId(Integer decuongId) { this.decuongId = decuongId; }

    public String getTenCotDiem() { return tenCotDiem; }
    public void setTenCotDiem(String tenCotDiem) { this.tenCotDiem = tenCotDiem; }

    public BigDecimal getTyLePhanTram() { return tyLePhanTram; }
    public void setTyLePhanTram(BigDecimal tyLePhanTram) { this.tyLePhanTram = tyLePhanTram; }

    public String getHinhThuc() { return hinhThuc; }
    public void setHinhThuc(String hinhThuc) { this.hinhThuc = hinhThuc; }

}