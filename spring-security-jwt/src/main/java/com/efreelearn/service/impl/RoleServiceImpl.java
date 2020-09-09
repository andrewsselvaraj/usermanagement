package com.efreelearn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.efreelearn.dao.RoleDao;
import com.efreelearn.dao.UserDao;
import com.efreelearn.model.Role;
import com.efreelearn.model.User;
import com.efreelearn.model.UserDto;
import com.efreelearn.service.RoleService;
import com.efreelearn.service.UserService;

import java.util.*;


@Service(value = "roleService")
public class RoleServiceImpl implements  RoleService {
	
	@Autowired
	private RoleDao roleDao;



	@Override
	public Role findById(Long id) {
		return roleDao.findById(id).get();
	}



	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public User findOne(String username) {
		// TODO Auto-generated method stub
		return null;
	}


}
