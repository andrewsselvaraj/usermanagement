package com.efreelearn.service;

import java.util.List;

import com.efreelearn.model.Role;
import com.efreelearn.model.User;
import com.efreelearn.model.UserDto;

public interface RoleService {


    void delete(long id);
    User findOne(String username);

    Role findById(Long id);
}
