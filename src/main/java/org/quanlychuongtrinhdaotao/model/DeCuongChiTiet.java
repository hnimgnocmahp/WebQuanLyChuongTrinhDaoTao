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

    @ManyToOne
    @JoinColumn(name = "hocphan_id")
    private HocPhan hocPhan;

    @Column(name = "boPhanDuocDanhGia")
    private String boPhanDuocDanhGia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HocPhan getHocPhan() {
        return hocPhan;
    }

    public void setHocPhan(HocPhan hocPhan) {
        this.hocPhan = hocPhan;
    }

    public String getBoPhanDuocDanhGia() {
        return boPhanDuocDanhGia;
    }

    public void setBoPhanDuocDanhGia(String boPhanDuocDanhGia) {
        this.boPhanDuocDanhGia = boPhanDuocDanhGia;
    }
// Getter và Setter
}

