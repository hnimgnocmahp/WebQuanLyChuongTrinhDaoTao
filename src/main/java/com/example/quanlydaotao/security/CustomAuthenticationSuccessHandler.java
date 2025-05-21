package com.example.quanlydaotao.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String redirectUrl = "/ctdt_giangvien_front"; // Mặc định
        boolean isAdmin = false;
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
                redirectUrl = "/ctdt_hocphan";
                isAdmin = true;
                break;
            }
        }
        // Lưu username vào session nếu không phải admin
        if (!isAdmin) {
            Object principal = authentication.getPrincipal();
            String username = null;
            if (principal instanceof org.springframework.security.core.userdetails.UserDetails) {
                username = ((org.springframework.security.core.userdetails.UserDetails) principal).getUsername();
            } else if (principal instanceof String) {
                username = (String) principal;
            }
            if (username != null) {
                request.getSession().setAttribute("username", username);
            }
        } else {
            // Nếu là admin thì xóa username khỏi session (nếu có)
            request.getSession().removeAttribute("username");
        }
        response.sendRedirect(redirectUrl);
    }
} 