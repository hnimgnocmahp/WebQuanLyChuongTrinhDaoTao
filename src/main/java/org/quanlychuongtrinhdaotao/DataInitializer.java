package org.quanlychuongtrinhdaotao;


import jakarta.transaction.Transactional;
import org.quanlychuongtrinhdaotao.model.GiangVien;
import org.quanlychuongtrinhdaotao.repository.GiangVienRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final GiangVienRepository giangVienRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(GiangVienRepository giangVienRepository, PasswordEncoder passwordEncoder) {
        this.giangVienRepository = giangVienRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Tạo tài khoản mặc định nếu chưa có
        String maCB = "admin";
        if (giangVienRepository.findByMaCB(maCB).isEmpty()) {
            GiangVien admin = new GiangVien();
            admin.setMaCB(maCB);
            admin.setHoTen("Quản trị viên");
            admin.setMatKhau(passwordEncoder.encode("123456")); // Đặt mật khẩu mặc định
            giangVienRepository.save(admin);
            System.out.println("✔ Tài khoản admin đã được tạo tự động.");
        } else {
            System.out.println("ℹ Tài khoản admin đã tồn tại.");
        }
    }
}
