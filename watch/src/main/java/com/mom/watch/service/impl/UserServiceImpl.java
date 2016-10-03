package com.mom.watch.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mom.watch.model.User;
import com.mom.watch.repository.UserRepository;
import com.mom.watch.service.ICommonService;
import com.mom.watch.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;
	
	@Override
	public User create(User user) {
		User _user = userRepository.save(user);
		return _user;
	}

	@Override
	public User delete(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User shop) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
