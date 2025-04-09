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

    // Getter và Setter
}
