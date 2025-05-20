package com.example.quanlydaotao.config;

import com.example.quanlydaotao.entity.CtdtUser;
import com.example.quanlydaotao.repository.CtdtUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CtdtUserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        String adminUsername = "admin";
        if (userRepo.findByUsername(adminUsername).isEmpty()) {
            CtdtUser admin = new CtdtUser();
            admin.setUsername(adminUsername);
            // Mật khẩu “123456” sẽ được mã hóa bằng BCrypt
            admin.setPassword(passwordEncoder.encode("123456"));
            admin.setHoTen("Administrator");
            admin.setEmail("admin@truong.edu.vn");
            admin.setVaiTro("ADMIN");
            admin.setTrangThai(1);
            userRepo.save(admin);
            System.out.println(">>> Tạo tài khoản admin / mật khẩu 123456");
        }
    }
}
