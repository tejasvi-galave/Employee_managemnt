package com.security.service;

import com.security.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User save(User user);
}
