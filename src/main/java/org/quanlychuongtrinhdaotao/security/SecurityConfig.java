package org.quanlychuongtrinhdaotao.security;



//import org.quanlychuongtrinhdaotao.repository.UserRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/auth/**", "/css/**", "/js/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(form -> form
//                        .loginPage("/auth/login")
//                        .loginProcessingUrl("/auth/login")
//                        .defaultSuccessUrl("/", true)
//                        .usernameParameter("mssv")
//                        .passwordParameter("password")
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/auth/login?logout")
//                        .permitAll());
//
//        return http.build();
//    }
//
////    @Bean
////    public UserDetailsService userDetailsService(UserRepository userRepository) {
////        return mssv -> userRepository.findById(mssv)
////                .map(user -> org.springframework.security.core.userdetails.User.builder()
////                        .username(user.getMssv())
////                        .password(user.getPassword())
////                        .roles("USER")
////                        .build())
////                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy MSSV: " + mssv));
////    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}


