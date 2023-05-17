package com.project.service.internal;


import com.project.model.User;
import com.project.repository.UserRepository;
import com.project.service.UserInternalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserInternalServiceImpl implements UserInternalService {

    private  final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(int id) {
       return userRepository.findById(id).get();
    }

    @Override
    public void DeleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> AllUser() {
        return userRepository.findAll();
    }
}
