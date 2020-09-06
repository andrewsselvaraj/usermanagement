package com.efreelearn.service;

import java.util.List;

import com.efreelearn.model.User;
import com.efreelearn.model.UserDto;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);

    User findById(Long id);
}
