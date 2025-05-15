package org.quanlychuongtrinhdaotao.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "chitietkienthuc")
public class ChiTietKienThuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tenKienThuc;

    private int soTinChiKhongBatBuoc;

    private int soTinChiBatBuoc;

    @ManyToOne
    @JoinColumn(name = "kct_id")
    private KhungChuongTrinh khungChuongTrinh;
}
