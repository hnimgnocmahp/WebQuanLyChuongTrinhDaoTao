package com.example.quanlydaotao.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ctdt_kehoachdayhoc")
public class CtdtKehoachdayhoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ctdt_id")
    private Integer ctdtId;

    @Column(name = "hoc_phan_id")
    private Integer hocPhanId;

    @Column(name = "hoc_ky")
    private Integer hocKy;

    @Column(name = "nam_hoc")
    private Integer namHoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hoc_phan_id", insertable = false, updatable = false)
    private CtdtHocphan hocPhan;

    public CtdtHocphan getHocPhan() {
        return hocPhan;
    }

    public void setHocPhan(CtdtHocphan hocPhan) {
        this.hocPhan = hocPhan;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getCtdtId() { return ctdtId; }
    public void setCtdtId(Integer ctdtId) { this.ctdtId = ctdtId; }

    public Integer getHocPhanId() { return hocPhanId; }
    public void setHocPhanId(Integer hocPhanId) { this.hocPhanId = hocPhanId; }

    public Integer getHocKy() { return hocKy; }
    public void setHocKy(Integer hocKy) { this.hocKy = hocKy; }

    public Integer getNamHoc() { return namHoc; }
    public void setNamHoc(Integer namHoc) { this.namHoc = namHoc; }

}