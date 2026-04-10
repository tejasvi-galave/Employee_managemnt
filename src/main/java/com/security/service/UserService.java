package com.security.service;

import com.security.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User save(User user);

    List<User> getAllUsers();
}
