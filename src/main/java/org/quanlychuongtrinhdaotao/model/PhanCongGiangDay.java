package org.quanlychuongtrinhdaotao.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "phanconggiangday")
public class PhanCongGiangDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "maCanBo")
    private GiangVien giangVien;

    @Column(name = "hocKy")
    private String hocKy;

    @ManyToOne
    @JoinColumn(name = "khmn_id")
    private KeHoachMoNhom keHoachMoNhom;
}
