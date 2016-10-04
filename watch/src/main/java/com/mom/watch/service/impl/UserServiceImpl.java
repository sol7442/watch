package com.mom.watch.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mom.watch.model.User;
import com.mom.watch.repository.UserRepository;
import com.mom.watch.service.ServiceException;
import com.mom.watch.service.UserService;
import com.mom.watch.service.exception.AlreadyExistsExeception;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User create(User user) throws ServiceException {
		if(userRepository.exists(user.getUserId())){
			throw new AlreadyExistsExeception();
		}
		return userRepository.save(user);
	}

	@Override
	public void delete(String id) throws ServiceException {
		userRepository.delete(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User update(User user) throws ServiceException {
		return userRepository.save(user);
	}

	@Override
	public User findById(String id) {
		return userRepository.findOne(id);
	}

}
