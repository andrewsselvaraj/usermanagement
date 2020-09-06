package com.efreelearn.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.efreelearn.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
