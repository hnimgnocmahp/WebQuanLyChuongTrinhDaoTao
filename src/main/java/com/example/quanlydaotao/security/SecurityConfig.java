package com.example.quanlydaotao.security;

import com.example.quanlydaotao.entity.CtdtUser;
import com.example.quanlydaotao.repository.CtdtUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**", "/css/**", "/js/**", "/images/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/auth/login")
                        .loginProcessingUrl("/auth/login")
                        .defaultSuccessUrl("/ctdt_thongtinchung", true)
                        // nếu form login dùng field 'username' và 'password' chuẩn thì có thể bỏ dòng usernameParameter()
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/auth/login?logout")
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(CtdtUserRepository userRepo) {
        return username -> {
            CtdtUser user = userRepo.findByUsername(username)
                    .orElseThrow(() ->
                            new UsernameNotFoundException("Không tìm thấy user: " + username)
                    );
            return User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    // Nếu bạn lưu trường 'vaiTro' trong bảng ctdt_user, có thể map thành role:
                    .roles(user.getVaiTro().toUpperCase())
                    .build();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
