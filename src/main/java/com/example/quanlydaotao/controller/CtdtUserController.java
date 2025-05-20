package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.entity.CtdtUser;
import com.example.quanlydaotao.repository.CtdtUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ctdt_user")
public class CtdtUserController {

    @Autowired
    private CtdtUserRepository CtdtUserRepository;

    @GetMapping("/ctdt_user")
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping
    public String listCtdtUser(Model model) {
        model.addAttribute("ctdt_user", CtdtUserRepository.findAll());
        return "ctdt_user_list";
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("ctdt_user", new CtdtUser());
        return "user_form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        CtdtUser ctdtUser = CtdtUserRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("ctdt_user", ctdtUser);
        return "user_form";
    }

    @PostMapping("/save")
    public String saveCtdtUser(@ModelAttribute CtdtUser ctdtUser, Model model, RedirectAttributes redirectAttributes) {
        boolean isDuplicate;
        if (ctdtUser.getId() == null) {
            isDuplicate = CtdtUserRepository.existsByUsername(ctdtUser.getUsername());
        } else {
            isDuplicate = CtdtUserRepository.existsByUsernameAndIdNot(ctdtUser.getUsername(), ctdtUser.getId());
        }
        if (isDuplicate) {
            model.addAttribute("error", "Username đã tồn tại!");
            model.addAttribute("ctdt_user", ctdtUser);
            return "user_form";
        }
        if (ctdtUser.getId() == null) {
            ctdtUser.setPassword(passwordEncoder.encode(ctdtUser.getPassword()));
        } else {
            CtdtUser existing = CtdtUserRepository.findById(ctdtUser.getId()).orElse(null);
            if (existing != null && !passwordEncoder.matches(ctdtUser.getPassword(), existing.getPassword())) {
                ctdtUser.setPassword(passwordEncoder.encode(ctdtUser.getPassword()));
            } else if (existing != null) {
                ctdtUser.setPassword(existing.getPassword());
            }
        }
        CtdtUserRepository.save(ctdtUser);
        redirectAttributes.addFlashAttribute("success", "Lưu người dùng thành công!");
        return "redirect:/ctdt_user";
    }

    @GetMapping("/delete/{id}")
    public String deleteCtdtUser(@PathVariable Integer id) {
        CtdtUserRepository.deleteById(id);
        return "redirect:/ctdt_user";
    }
}