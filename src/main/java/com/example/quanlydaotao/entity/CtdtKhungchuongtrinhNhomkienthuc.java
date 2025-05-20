package com.example.quanlydaotao.entity;

import com.example.quanlydaotao.repository.CtdtNhomkienthucRepository;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ctdt_khungchuongtrinh_nhomkienthuc")
public class CtdtKhungchuongtrinhNhomkienthuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_khungchuongtrinh")
    private Integer idKhungchuongtrinh;

    @Column(name = "id_manhom")
    private Integer idManhom;

    @Column(name = "sotinchibatbuoc")
    private Integer sotinchibatbuoc;

    @Column(name = "sotinchituchon")
    private Integer sotinchituchon;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getIdKhungchuongtrinh() { return idKhungchuongtrinh; }
    public void setIdKhungchuongtrinh(Integer idKhungchuongtrinh) { this.idKhungchuongtrinh = idKhungchuongtrinh; }

    public Integer getIdManhom() { return idManhom; }
    public void setIdManhom(Integer idManhom) { this.idManhom = idManhom; }

    public Integer getSotinchibatbuoc() { return sotinchibatbuoc; }
    public void setSotinchibatbuoc(Integer sotinchibatbuoc) { this.sotinchibatbuoc = sotinchibatbuoc; }

    public Integer getSotinchituchon() { return sotinchituchon; }
    public void setSotinchituchon(Integer sotinchituchon) { this.sotinchituchon = sotinchituchon; }

    @Transient
    private CtdtNhomkienthuc nhomkienthuc;

    public CtdtNhomkienthuc getNhomkienthuc() {
        return nhomkienthuc;
    }

    public void setNhomkienthuc(CtdtNhomkienthuc nhomkienthuc) {
        this.nhomkienthuc = nhomkienthuc;
    }
}