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
import com.efreelearn.service.UserService;

import java.util.*;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			//authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
		//return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userDao.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User findById(Long id) {
		return userDao.findById(id).get();
	}

	@Override
    public User save(UserDto user) {
	    User newUser = new User();
	    newUser.setUsername(user.getUsername());
	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
	    newUser.setPrimaryskill(user.getPrimaryskill());
	   // newUser.setUsername(username);
		   Long longid = null;

		   System.out.println(" user.getUsertype()"+user.getUsertype());
	    if(user.getUsertype() !=null && user.getUsertype().equalsIgnoreCase("admin"))
	    {
	    	longid = new Long(1).longValue();
	    }
	    else
	    {
	    	longid = new Long(2).longValue();
	    }
	    Set<Role> roles = new HashSet<Role>();
	    Role r = new Role();
 System.out.println("   user.getROLE_ID() "+user.getROLE_ID());
	    	
	   
	    r.setId(longid);
	  r=  roleDao.findById(longid).get();
	    roles.add(r);
	    newUser.setRoles(roles);
		
        return userDao.save(newUser);
    }
}
