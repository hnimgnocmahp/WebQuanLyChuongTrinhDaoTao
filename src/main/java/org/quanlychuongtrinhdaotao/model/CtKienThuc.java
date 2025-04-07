package org.quanlychuongtrinhdaotao.model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ctkienthuc")
public class CtKienThuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "kct_id")
    private KhungChuongTrinh khungChuongTrinh;

    @Column(name = "tenKienThuc")
    private String tenKienThuc;

    @Column(name = "loaiKienThuc")
    private String loaiKienThuc;

    @Column(name = "soTinChi")
    private int soTinChi;

    // Getter và Setter
}
