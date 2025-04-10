package org.quanlychuongtrinhdaotao.model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "hocphan")
public class HocPhan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ctkienthuc_id")
    private CtKienThuc ctkienThuc;

    @Column(name = "tenHocPhan")
    private String tenHocPhan;

    @Column(name = "soTinChi")
    private int soTinChi;

    @Column(name = "lythuyet")
    private boolean lyThuyet;

    @Column(name = "thucHanh")
    private boolean thucHanh;

    @Column(name = "thucTap")
    private boolean thucTap;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CtKienThuc getCtkienThuc() {
        return ctkienThuc;
    }

    public void setCtkienThuc(CtKienThuc ctkienThuc) {
        this.ctkienThuc = ctkienThuc;
    }

    public String getTenHocPhan() {
        return tenHocPhan;
    }

    public void setTenHocPhan(String tenHocPhan) {
        this.tenHocPhan = tenHocPhan;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public boolean isLyThuyet() {
        return lyThuyet;
    }

    public void setLyThuyet(boolean lyThuyet) {
        this.lyThuyet = lyThuyet;
    }

    public boolean isThucHanh() {
        return thucHanh;
    }

    public void setThucHanh(boolean thucHanh) {
        this.thucHanh = thucHanh;
    }

    public boolean isThucTap() {
        return thucTap;
    }

    public void setThucTap(boolean thucTap) {
        this.thucTap = thucTap;
    }
// Getter và Setter
}
