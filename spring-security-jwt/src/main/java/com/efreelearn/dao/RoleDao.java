package com.efreelearn.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.efreelearn.model.Role;
import com.efreelearn.model.User;

@Repository
public interface RoleDao extends CrudRepository<Role, Long> {
	Optional<Role> findById(Long id);
}
