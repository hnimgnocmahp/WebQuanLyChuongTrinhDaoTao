package org.quanlychuongtrinhdaotao.model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "kehoachdayhoc")
public class KeHoachDayHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "maHocPhan")
    private HocPhan hocPhan;

    @Column(name = "hockiThucHien")
    private String hockiThucHien;

    @Column(name = "namHoc")
    private int namHoc;

    // Getter và Setter
}
