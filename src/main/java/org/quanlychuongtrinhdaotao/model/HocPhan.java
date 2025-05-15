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

    @Column(name = "tenHocPhan")
    private String tenHocPhan;

    @Column(name = "maHocPhan")
    private String maHocPhan;

    @Column(name = "maHocPhanTruoc")
    private String maHocPhanTruoc;

    @Column(name = "soTinChi")
    private int soTinChi;

    @Column(name = "lythuyet")
    private boolean lyThuyet;

    @Column(name = "thucHanh")
    private boolean thucHanh;

    @Column(name = "thucTap")
    private boolean thucTap;

    @Column(name = "loaiKienThuc")
    private boolean loaiKienThuc;

    @ManyToOne
    @JoinColumn(name = "ctkt_id")
    private ChiTietKienThuc chiTietKienThuc;

}
