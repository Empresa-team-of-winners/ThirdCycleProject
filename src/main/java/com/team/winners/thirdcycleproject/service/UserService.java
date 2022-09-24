package com.team.winners.thirdcycleproject.service;


import com.team.winners.thirdcycleproject.models.Employee;
import com.team.winners.thirdcycleproject.models.Transaction;
import com.team.winners.thirdcycleproject.models.User;
import com.team.winners.thirdcycleproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public <S extends User> S save(S entity) {
        return userRepository.save(entity);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public Boolean deleteById(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
