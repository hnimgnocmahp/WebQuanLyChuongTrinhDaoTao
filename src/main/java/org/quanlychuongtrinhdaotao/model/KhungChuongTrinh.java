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
}
