package com.example.quanlydaotao.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ctdt_nhomkienthuc")
public class CtdtNhomkienthuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "manhom")
    private String manhom;

    @Column(name = "ten_nhom")
    private String tenNhom;

    @Column(name = "trangthai")
    private String trangthai;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getManhom() { return manhom; }
    public void setManhom(String manhom) { this.manhom = manhom; }

    public String getTenNhom() { return tenNhom; }
    public void setTenNhom(String tenNhom) { this.tenNhom = tenNhom; }

    public String getTrangthai() { return trangthai; }
    public void setTrangthai(String trangthai) { this.trangthai = trangthai; }

}