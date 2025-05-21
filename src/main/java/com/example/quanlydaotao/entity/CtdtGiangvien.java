package com.example.quanlydaotao.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "ctdt_giangvien")
public class CtdtGiangvien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "ma_gv")
    private String maGv;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "bo_mon")
    private String boMon;

    @Column(name = "khoa")
    private String khoa;

    @Column(name = "trinh_do")
    private String trinhDo;

    @Column(name = "chuyen_mon")
    private String chuyenMon;

    @Column(name = "trang_thai")
    private String trangThai;

    private Integer namSinh;

    public Integer getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Integer namSinh) {
        this.namSinh = namSinh;
    }

    @OneToMany(mappedBy = "giangVien", fetch = FetchType.LAZY)
    private List<CtdtPhanconggiangday> assignments;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    @Transient
    private Map<Integer, List<Integer>> hockyMap;

    public Map<Integer, List<Integer>> getHockyMap() {
        return hockyMap;
    }

    public void setHockyMap(Map<Integer, List<Integer>> hockyMap) {
        this.hockyMap = hockyMap;
    }

    @Transient
    private Map<Integer, CtdtHocphan> hocphanMap;

    public Map<Integer, CtdtHocphan> getHocphanMap() {
        return hocphanMap;
    }

    public void setHocphanMap(Map<Integer, CtdtHocphan> hocphanMap) {
        this.hocphanMap = hocphanMap;
    }

    @Transient
    private Map<Integer, Long> groupsPerCourse;

    public Map<Integer, Long> getGroupsPerCourse() {
        return groupsPerCourse;
    }

    public void setGroupsPerCourse(Map<Integer, Long> groupsPerCourse) {
        this.groupsPerCourse = groupsPerCourse;
    }

    public List<CtdtPhanconggiangday> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<CtdtPhanconggiangday> assignments) {
        this.assignments = assignments;
    }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getMaGv() { return maGv; }
    public void setMaGv(String maGv) { this.maGv = maGv; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public String getBoMon() { return boMon; }
    public void setBoMon(String boMon) { this.boMon = boMon; }

    public String getKhoa() { return khoa; }
    public void setKhoa(String khoa) { this.khoa = khoa; }

    public String getTrinhDo() { return trinhDo; }
    public void setTrinhDo(String trinhDo) { this.trinhDo = trinhDo; }

    public String getChuyenMon() { return chuyenMon; }
    public void setChuyenMon(String chuyenMon) { this.chuyenMon = chuyenMon; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }

}