package com.example.quanlydaotao.service;

import com.example.quanlydaotao.entity.CtdtHocphan;
import com.example.quanlydaotao.entity.CtdtKehoachdayhoc;
import com.example.quanlydaotao.entity.CtdtKhungchuongtrinh;
import com.example.quanlydaotao.entity.CtdtThongtinchung;
import com.example.quanlydaotao.repository.CtdtHocphanRepository;
import com.example.quanlydaotao.repository.CtdtKehoachdayhocRepository;
import com.example.quanlydaotao.repository.CtdtKhungchuongtrinhRepository;
import com.example.quanlydaotao.repository.CtdtThongtinchungRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThongTinChungService {
    private final CtdtThongtinchungRepository repo;
    private final CtdtHocphanRepository hocphanRepo;
    private final CtdtKhungchuongtrinhRepository khungRepo;
    private final CtdtKehoachdayhocRepository kehoachdayhocRepo;
    public ThongTinChungService(CtdtThongtinchungRepository CtdtThongtinchungRepository, CtdtHocphanRepository hocphanRepo, CtdtKhungchuongtrinhRepository khungRepo, CtdtKehoachdayhocRepository kehoachdayhocRepo) {
        this.repo = CtdtThongtinchungRepository;
        this.hocphanRepo = hocphanRepo;
        this.khungRepo = khungRepo;
        this.kehoachdayhocRepo = kehoachdayhocRepo;
    }
    public List<CtdtThongtinchung> findAll() { return repo.findAll(); }
    public Optional<CtdtThongtinchung> findById(Integer id) { return repo.findById(id); }
    public CtdtThongtinchung save(CtdtThongtinchung thongtinchung) { return repo.save(thongtinchung); }

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
        }

        ctdt.setKhungchuongtrinhs(nhomList);
        return ctdt;
    }

}
