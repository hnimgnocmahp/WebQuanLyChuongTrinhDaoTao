package org.quanlychuongtrinhdaotao.service;

import org.quanlychuongtrinhdaotao.model.User;
import org.quanlychuongtrinhdaotao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User getUserByName(String name) {
        return userRepository.getById(name);
    }
    public boolean existsByMssv(String mssv) {
        return userRepository.existsById(mssv);
    }
}




