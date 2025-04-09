package org.quanlychuongtrinhdaotao.model;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "khungchuongtrinh")
public class KhungChuongTrinh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ctd_id")
    private ChuongTrinhDaoTao chuongTrinhDaoTao;

    @Column(name = "khoiKenThuc")
    private String khoiKenThuc;

    @Column(name = "soTinChi")
    private int soTinChi;

    // Getter và Setter

    public ChuongTrinhDaoTao getChuongTrinhDaoTao() {
        return chuongTrinhDaoTao;
    }

    public void setChuongTrinhDaoTao(ChuongTrinhDaoTao chuongTrinhDaoTao) {
        this.chuongTrinhDaoTao = chuongTrinhDaoTao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKhoiKenThuc() {
        return khoiKenThuc;
    }

    public void setKhoiKenThuc(String khoiKenThuc) {
        this.khoiKenThuc = khoiKenThuc;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }
}
