package org.quanlychuongtrinhdaotao.model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "giangvien")
public class GiangVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "maCB")
    private String maCB;

    @Column(name = "matKhau")
    private String matKhau;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "namSinh")
    private int namSinh;

    @Column(name = "hocVi")
    private String hocVi;

    @ManyToOne
    @JoinColumn(name = "nganh_id")
    private Nganh nganh;

}
