package com.example.quanlydaotao.service;

import com.example.quanlydaotao.entity.*;
import com.example.quanlydaotao.repository.*;
import com.example.quanlydaotao.entity.CtdtGiangvien;
import com.example.quanlydaotao.repository.CtdtGiangvienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;

@Service
public class GiangVienService {
    private final CtdtGiangvienRepository gvrepo;
    private final CtdtPhanconggiangdayRepository phanconggiangdayRepository;
    private final CtdtKehoachmonhomRepository kehoachmonhomRepository;
    private final CtdtHocphanRepository hocphanRepository;
    private final CtdtUserRepository userRepository;

    public GiangVienService(CtdtGiangvienRepository gvrepo, CtdtPhanconggiangdayRepository phanconggiangdayRepository, CtdtKehoachmonhomRepository kehoachmonhomRepository, CtdtHocphanRepository hocphanRepository, CtdtUserRepository userRepository) {
        this.gvrepo = gvrepo;
        this.phanconggiangdayRepository = phanconggiangdayRepository;
        this.kehoachmonhomRepository = kehoachmonhomRepository;
        this.hocphanRepository = hocphanRepository;
        this.userRepository = userRepository;
    }

    public List<CtdtGiangvien> findAll() { return gvrepo.findAll(); }

    public List<CtdtGiangvien> getPhanCong(){
        List<CtdtGiangvien> giangviens = gvrepo.findAll();
        for(CtdtGiangvien giangvien: giangviens){
            List<CtdtPhanconggiangday> phanconggiangdays = phanconggiangdayRepository.findByGiangVienId(giangvien.getId());
            int namSinh = userRepository.findById(giangvien.getUserId()).get().getNamSinh();
            giangvien.setNamSinh(namSinh);

            Map<Integer, List<Integer>> HocKi = new HashMap<>();
            HashMap<Integer, Long> map = new HashMap<>();
            HashMap<Integer, CtdtHocphan> hocphanMap = new HashMap<>();
            for (CtdtPhanconggiangday phanconggiangday : phanconggiangdays){
                long count = phanconggiangdays.stream()
                        .filter(p -> p.getGroup().getHocPhanId().equals(phanconggiangday.getGroup().getHocPhanId()))
                        .map(p -> p.getGroup().getId())
                        .distinct()
                        .count();
                hocphanMap.put(phanconggiangday.getGroup().getHocPhanId(),hocphanRepository.findById(phanconggiangday.getGroup().getHocPhanId()).orElse(null));
                map.put(phanconggiangday.getGroup().getHocPhanId(),count);
                if(HocKi.get(phanconggiangday.getGroup().getHocPhanId()) == null){
                    HocKi.put(phanconggiangday.getGroup().getHocPhanId(),  new ArrayList<>(Arrays.asList(0,0,0)));
                    List<Integer> list = HocKi.get(phanconggiangday.getGroup().getHocPhanId());
                    int updatedValue = list.get((phanconggiangday.getGroup().getHocKy() - 1)) + 1;
                    list.set(phanconggiangday.getGroup().getHocKy() - 1, updatedValue); // Gán lại phần tử đầu
                } else {
                    List<Integer> list = HocKi.get(phanconggiangday.getGroup().getHocPhanId());
                    int updatedValue = list.get((phanconggiangday.getGroup().getHocKy() - 1)) + 1;
                    list.set(phanconggiangday.getGroup().getHocKy() - 1, updatedValue);
                }
            }
            giangvien.setHocphanMap(hocphanMap);
            giangvien.setGroupsPerCourse(map);
            giangvien.setHockyMap(HocKi);
        }
        return giangviens;
    }


    public CtdtGiangvien findById(Integer id) {
        return gvrepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid giảng viên Id:" + id));
    }

    public CtdtGiangvien save(CtdtGiangvien giangVien) {
        return gvrepo.save(giangVien);
    }

    public void deleteById(Integer id) {
        gvrepo.deleteById(id);
    }

    public boolean isUserIdDuplicate(Integer userId, Integer id) {
        return gvrepo.existsByUserIdAndIdNot(userId, id == null ? -1 : id);
    }

    public boolean isMaGvDuplicate(String maGv, Integer id) {
        return gvrepo.existsByMaGvAndIdNot(maGv, id == null ? -1 : id);
    }
}