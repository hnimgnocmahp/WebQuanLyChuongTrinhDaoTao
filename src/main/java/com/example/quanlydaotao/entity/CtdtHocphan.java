package com.example.quanlydaotao.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name = "ctdt_hocphan")
public class CtdtHocphan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Mã học phần không được để trống")
    @Size(max = 20, message = "Mã học phần tối đa 20 ký tự")
    @Column(name = "ma_hp")
    private String maHp;

    @NotBlank(message = "Tên học phần không được để trống")
    @Column(name = "ten_hp")
    private String tenHp;


    @NotNull(message = "Số tín chỉ không được để trống")
    @Min(value = 1, message = "Số tín chỉ phải lớn hơn 0")
    @Column(name = "so_tin_chi")
    private Integer soTinChi;


    @NotNull(message = "Số tiết lý thuyết không được để trống")
    @Min(value = 0, message = "Số tiết lý thuyết không được âm")
    @Column(name = "so_tiet_ly_thuyet")
    private Integer soTietLyThuyet;

    @NotNull(message = "Số tiết thực hành không được để trống")
    @Min(value = 0, message = "Số tiết thực hành không được âm")
    @Column(name = "so_tiet_thuc_hanh")
    private Integer soTietThucHanh;

    @Column(name = "nhom_id")
    private Integer nhomId;

    @NotBlank(message = "Loại học phần không được để trống")
    @Column(name = "loai_hp")
    private String loaiHp;

    @Column(name = "hoc_phan_tien_quyet")
    private String hocPhanTienQuyet;

    @NotNull(message = "Hệ số học phần không được để trống")
    @DecimalMin(value = "0.0", inclusive = false, message = "Giá trịị phải lớn hơn 0")
    @DecimalMax(value = "1.0", inclusive = false, message = "Giá trị phải nhỏ hơn 1")
    @Column(name= "he_so_hoc_phan")
    private Float heSoHocPhan;

    @OneToMany(mappedBy = "hocPhan", fetch = FetchType.LAZY)
    private List<CtdtKehoachdayhoc> keHoachDayHocs;

    @OneToMany(mappedBy = "hocPhan", fetch = FetchType.LAZY)
    private List<CtdtKehoachmonhom> keHoachMonNhoms;




    public Float getHeSoHocPhan() {
        return heSoHocPhan;
    }

    public void setHeSoHocPhan(Float heSoHocPhan) {
        this.heSoHocPhan = heSoHocPhan;
    }

    public Integer getId() { return id; }

    public List<CtdtKehoachdayhoc> getKeHoachDayHocs() {
        return keHoachDayHocs;
    }

    public void setKeHoachDayHocs(List<CtdtKehoachdayhoc> keHoachDayHocs) {
        this.keHoachDayHocs = keHoachDayHocs;
    }

    public List<CtdtKehoachmonhom> getKeHoachMonNhoms() {
        return keHoachMonNhoms;
    }

    public void setKeHoachMonNhoms(List<CtdtKehoachmonhom> keHoachMonNhoms) {
        this.keHoachMonNhoms = keHoachMonNhoms;
    }

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