package com.example.quanlydaotao.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "ctdt_kehoachdayhoc")
public class CtdtKehoachdayhoc {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "CTĐT không được để trống")
    @Column(name = "ctdt_id")
    private Integer ctdtId;

    @NotNull(message = "Học phần không được để trống")
    @Column(name = "hoc_phan_id")
    private Integer hocPhanId;

    @NotNull(message = "Học kỳ không được để trống")
    @Min(value = 1, message = "Học kỳ phải từ 1 trở lên")
    @Max(value = 12, message = "Học kỳ không được vượt quá 12") // tuỳ quy định của bạn
    @Column(name = "hoc_ky")
    private Integer hocKy;

    @NotNull(message = "Năm học không được để trống")
    @Column(name = "nam_hoc")
    @Min(value = 2000, message = "Năm học phải từ năm 2000 trở lên")
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