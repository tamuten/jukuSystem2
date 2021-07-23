package com.example.demo.login.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.login.MEmployeeUserDetails;
import com.example.demo.login.domain.model.Employee;
import com.example.demo.login.domain.repository.MEmployeeDao;

@Service
public class MEmployeeService implements UserDetailsService {
	@Autowired
	private MEmployeeDao mEmployeeDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = mEmployeeDao.selectOne(username);
		if (employee == null) {
			throw new UsernameNotFoundException(username + " is not found");
		}
		return new MEmployeeUserDetails(employee);
	}

}
