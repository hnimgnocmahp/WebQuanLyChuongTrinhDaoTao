package com.example.quanlydaotao.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ctdt_thongtinchung")
public class CtdtThongtinchung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_ctdt")
    private String maCtdt;

    @Column(name = "ten_ctdt")
    private String tenCtdt;

    @ManyToOne(fetch = FetchType.EAGER)            // hoặc mặc định EAGER
    @JoinColumn(name = "id_nganh")
    private CtdtNganh nganh;

    @Column(name = "khoa_quan_ly")
    private String khoaQuanLy;

    @Column(name = "he_dao_tao")
    private String heDaoTao;

    @Column(name = "trinh_do")
    private String trinhDo;

    @Column(name = "tong_tin_chi")
    private Integer tongTinChi;

    @Column(name = "thoi_gian_dao_tao")
    private String thoiGianDaoTao;

    @Column(name = "nam_ban_hanh")
    private Integer namBanHanh;

    @Column(name = "trang_thai")
    private String trangThai;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getMaCtdt() { return maCtdt; }
    public void setMaCtdt(String maCtdt) { this.maCtdt = maCtdt; }

    public String getTenCtdt() { return tenCtdt; }
    public void setTenCtdt(String tenCtdt) { this.tenCtdt = tenCtdt; }

    public String getKhoaQuanLy() { return khoaQuanLy; }
    public void setKhoaQuanLy(String khoaQuanLy) { this.khoaQuanLy = khoaQuanLy; }

    public CtdtNganh getNganh() {
        return nganh;
    }

    public void setNganh(CtdtNganh nganh) {
        this.nganh = nganh;
    }

    public String getHeDaoTao() { return heDaoTao; }
    public void setHeDaoTao(String heDaoTao) { this.heDaoTao = heDaoTao; }

    public String getTrinhDo() { return trinhDo; }
    public void setTrinhDo(String trinhDo) { this.trinhDo = trinhDo; }

    public Integer getTongTinChi() { return tongTinChi; }
    public void setTongTinChi(Integer tongTinChi) { this.tongTinChi = tongTinChi; }

    public String getThoiGianDaoTao() { return thoiGianDaoTao; }
    public void setThoiGianDaoTao(String thoiGianDaoTao) { this.thoiGianDaoTao = thoiGianDaoTao; }

    public Integer getNamBanHanh() { return namBanHanh; }
    public void setNamBanHanh(Integer namBanHanh) { this.namBanHanh = namBanHanh; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }

    @Transient
    private List<CtdtKhungchuongtrinh> khungchuongtrinhs;

    // Getter/Setter cho tất cả
    public List<CtdtKhungchuongtrinh> getKhungchuongtrinhs() {
        return khungchuongtrinhs;
    }

    public void setKhungchuongtrinhs(List<CtdtKhungchuongtrinh> khungchuongtrinhs) {
        this.khungchuongtrinhs = khungchuongtrinhs;
    }
}