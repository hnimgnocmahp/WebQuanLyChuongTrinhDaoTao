package org.quanlychuongtrinhdaotao.model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "decuongchitiet")
public class DeCuongChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "boPhanDuocDanhGia")
    private String boPhanDuocDanhGia;

    @ManyToOne
    @JoinColumn(name = "hocphan_id")
    private HocPhan hocPhan;
}

