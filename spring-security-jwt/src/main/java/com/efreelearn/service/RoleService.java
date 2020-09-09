package com.efreelearn.service;

import com.efreelearn.model.Role;
import com.efreelearn.model.User;

public interface RoleService {


    void delete(long id);
    User findOne(String username);

    Role findById(Long id);
}
