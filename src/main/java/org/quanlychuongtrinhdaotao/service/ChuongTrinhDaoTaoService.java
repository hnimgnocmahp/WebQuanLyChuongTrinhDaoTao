package org.quanlychuongtrinhdaotao.service;

import org.quanlychuongtrinhdaotao.model.ChuongTrinhDaoTao;
import org.quanlychuongtrinhdaotao.model.CtKienThuc;
import org.quanlychuongtrinhdaotao.repository.ChuongTrinhDaoTaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChuongTrinhDaoTaoService {

    private final ChuongTrinhDaoTaoRepository chuongTrinhDaoTaoRepository;

    @Autowired
    public ChuongTrinhDaoTaoService(ChuongTrinhDaoTaoRepository chuongTrinhDaoTaoRepository) {
        this.chuongTrinhDaoTaoRepository = chuongTrinhDaoTaoRepository;
    }

    // Lấy tất cả chương trình đào tạo
    public List<ChuongTrinhDaoTao> getAllChuongTrinhDaoTao() {
        return chuongTrinhDaoTaoRepository.findAll();
    }

    // Lấy chương trình đào tạo theo id
    public Optional<ChuongTrinhDaoTao> getChuongTrinhDaoTaoById(int id) {
        return chuongTrinhDaoTaoRepository.findById(id);
    }

    // Tạo mới chương trình đào tạo
    public ChuongTrinhDaoTao createChuongTrinhDaoTao(ChuongTrinhDaoTao chuongTrinhDaoTao) {
        return chuongTrinhDaoTaoRepository.save(chuongTrinhDaoTao);
    }

    // Cập nhật chương trình đào tạo
    public ChuongTrinhDaoTao updateChuongTrinhDaoTao(int id, ChuongTrinhDaoTao updatedChuongTrinhDaoTao) {
        Optional<ChuongTrinhDaoTao> existChuongTrinhDaoTao = chuongTrinhDaoTaoRepository.findById(id);
        if (existChuongTrinhDaoTao.isPresent()){
            ChuongTrinhDaoTao chuongTrinhDaoTao = existChuongTrinhDaoTao.get();
            chuongTrinhDaoTao.setBacCdt(updatedChuongTrinhDaoTao.getBacCdt());
            chuongTrinhDaoTao.setNgonNgu(updatedChuongTrinhDaoTao.getNgonNgu());
            chuongTrinhDaoTao.setThoiGian(updatedChuongTrinhDaoTao.getThoiGian());
            chuongTrinhDaoTao.setTenCdt(updatedChuongTrinhDaoTao.getTenCdt());
            chuongTrinhDaoTao.setKhoaQuanLy(updatedChuongTrinhDaoTao.getKhoaQuanLy());
            chuongTrinhDaoTao.setLoaiBangCdt(updatedChuongTrinhDaoTao.getLoaiBangCdt());
            chuongTrinhDaoTao.setSoTinChiToiThieu(updatedChuongTrinhDaoTao.getSoTinChiToiThieu());

            return chuongTrinhDaoTaoRepository.save(chuongTrinhDaoTao);
        }
        else {
            return null;
        }
    }
    // Xóa chương trình đào tạo
    public boolean deleteChuongTrinhDaoTao(int id) {
        if (chuongTrinhDaoTaoRepository.existsById(id)) {
            chuongTrinhDaoTaoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
