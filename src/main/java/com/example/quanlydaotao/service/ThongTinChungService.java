package com.example.quanlydaotao.service;

import com.example.quanlydaotao.entity.*;
import com.example.quanlydaotao.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThongTinChungService {
    private final CtdtThongtinchungRepository repo;
    private final CtdtHocphanRepository hocphanRepo;
    private final CtdtKhungchuongtrinhRepository khungRepo;
    private final CtdtKehoachdayhocRepository kehoachdayhocRepo;
    private final CtdtKhungchuongtrinhNhomkienthucRepository khungNhomRepo;
    public ThongTinChungService(CtdtThongtinchungRepository CtdtThongtinchungRepository, CtdtHocphanRepository hocphanRepo, CtdtKhungchuongtrinhRepository khungRepo, CtdtKehoachdayhocRepository kehoachdayhocRepo, CtdtKhungchuongtrinhNhomkienthucRepository khungNhomRepo) {
        this.repo = CtdtThongtinchungRepository;
        this.hocphanRepo = hocphanRepo;
        this.khungRepo = khungRepo;
        this.kehoachdayhocRepo = kehoachdayhocRepo;
        this.khungNhomRepo = khungNhomRepo;
    }
    public List<CtdtThongtinchung> findAll() { return repo.findAll(); }
    public Optional<CtdtThongtinchung> findById(Integer id) { return repo.findById(id); }
    public CtdtThongtinchung save(CtdtThongtinchung thongtinchung) { return repo.save(thongtinchung); }
    public Optional<CtdtThongtinchung> findByMaCtdt(String MaCtdt) { return repo.findByMaCtdt(MaCtdt); }
    public CtdtThongtinchung getChiTietThongTin(Integer ctdtId) {
        CtdtThongtinchung ctdt = repo.findById(ctdtId).orElse(null);
        List<CtdtKhungchuongtrinh> nhomList = khungRepo.findByCtdtId(ctdtId);

        for (CtdtKhungchuongtrinh khungchuongtrinh : nhomList) {
            List<CtdtHocphan> hocphans = hocphanRepo.findByNhomId(khungchuongtrinh.getId());

            for (CtdtHocphan hp : hocphans) {
                List<CtdtKehoachdayhoc> kehoachs = kehoachdayhocRepo.findByHocPhanId(hp.getId());
                hp.setKehoachs(kehoachs);
            }
            khungchuongtrinh.setHocphans(hocphans);

            // Gán số tín chỉ bắt buộc và tự chọn nếu có
            List<CtdtKhungchuongtrinhNhomkienthuc> nhomKienThucList = khungNhomRepo.findByIdKhungchuongtrinh(khungchuongtrinh.getId());
            if (!nhomKienThucList.isEmpty()) {
                CtdtKhungchuongtrinhNhomkienthuc nhomKienThuc = nhomKienThucList.get(0);
                khungchuongtrinh.setSoTinChiBatBuoc(nhomKienThuc.getSotinchibatbuoc());
                khungchuongtrinh.setSoTinChiTuChon(nhomKienThuc.getSotinchituchon());
            }
        }

        ctdt.setKhungchuongtrinhs(nhomList);
        return ctdt;
    }

}
