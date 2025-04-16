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

    @Column(name = "tenKienThuc")
    private String tenKienThuc;

    @Column(name = "khoiKenThuc")
    private String khoiKenThuc;

    @Column(name = "soTinChi")
    private int soTinChi;

    @Column(name = "soTinChiBatBuoc")
    private int soTinChiBatBuoc;

    @ManyToOne
    @JoinColumn(name = "ctdt_id")
    private ChuongTrinhDaoTao chuongTrinhDaoTao;

}
