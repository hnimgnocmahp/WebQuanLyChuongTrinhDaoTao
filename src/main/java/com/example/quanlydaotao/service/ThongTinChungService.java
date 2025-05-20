package com.example.quanlydaotao.service;

import com.example.quanlydaotao.entity.*;
import com.example.quanlydaotao.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThongTinChungService {
    private final CtdtKhungchuongtrinhNhomkienthucRepository khungchuongtrinhNhomkienthucRepository;
    private final CtdtNhomkienthucRepository nhomkienthucRepository;
    private final CtdtThongtinchungRepository repo;
    private final CtdtHocphanRepository hocphanRepo;
    private final CtdtKhungchuongtrinhRepository khungRepo;
    private final CtdtKehoachdayhocRepository kehoachdayhocRepo;
    public ThongTinChungService(CtdtThongtinchungRepository CtdtThongtinchungRepository, CtdtHocphanRepository hocphanRepo, CtdtKhungchuongtrinhRepository khungRepo, CtdtKehoachdayhocRepository kehoachdayhocRepo, CtdtNhomkienthucRepository nhomkienthucRepository, CtdtKhungchuongtrinhNhomkienthucRepository khungchuongtrinhNhomkienthucRepository) {
        this.repo = CtdtThongtinchungRepository;
        this.hocphanRepo = hocphanRepo;
        this.khungRepo = khungRepo;
        this.kehoachdayhocRepo = kehoachdayhocRepo;
        this.nhomkienthucRepository = nhomkienthucRepository;
        this.khungchuongtrinhNhomkienthucRepository = khungchuongtrinhNhomkienthucRepository;
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
            // Gán số tín chỉ bắt buộc và tự chọn nếu có
            List<CtdtKhungchuongtrinhNhomkienthuc> nhomKienThucList = khungNhomRepo.findByIdKhungchuongtrinh(khungchuongtrinh.getId());
            if (!nhomKienThucList.isEmpty()) {
                CtdtKhungchuongtrinhNhomkienthuc nhomKienThuc = nhomKienThucList.get(0);
                khungchuongtrinh.setSoTinChiBatBuoc(nhomKienThuc.getSotinchibatbuoc());
                khungchuongtrinh.setSoTinChiTuChon(nhomKienThuc.getSotinchituchon());
            }
        }

    public CtdtThongtinchung getCtKhung(Integer id){
        CtdtThongtinchung ctdt = repo.findById(id).orElse(null);
        List<CtdtKhungchuongtrinh> nhomList = khungRepo.findByCtdtId(id);

        for (CtdtKhungchuongtrinh khungchuongtrinh : nhomList){
            List<CtdtKhungchuongtrinhNhomkienthuc> khungchuongtrinhNhomkienthucs = khungchuongtrinhNhomkienthucRepository.findByIdKhungchuongtrinh(khungchuongtrinh.getId());
            System.out.println(khungchuongtrinh.getId());
            int batbuoc = 0;
            int tuchon = 0;
            for(CtdtKhungchuongtrinhNhomkienthuc khungchuongtrinhNhomkienthuc : khungchuongtrinhNhomkienthucs){
//                System.out.println(khungchuongtrinhNhomkienthuc.getIdManhom());
                CtdtNhomkienthuc nhomkienthuc = nhomkienthucRepository.findById(khungchuongtrinhNhomkienthuc.getIdManhom()).orElse(null);
                khungchuongtrinhNhomkienthuc.setNhomkienthuc(nhomkienthuc);
                batbuoc += khungchuongtrinhNhomkienthuc.getSotinchibatbuoc();
                tuchon += khungchuongtrinhNhomkienthuc.getSotinchituchon();
            }
            khungchuongtrinh.setKhungchuongtrinhNhomkienthucs(khungchuongtrinhNhomkienthucs);
            khungchuongtrinh.setTongSoTinChiBatBuoc(batbuoc);
            khungchuongtrinh.setTongSoTinChiTuChon(tuchon);
        }
        ctdt.setKhungchuongtrinhs(nhomList);
        return ctdt;
    }

}
