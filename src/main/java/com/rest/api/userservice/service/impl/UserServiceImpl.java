package com.rest.api.userservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.userservice.dao.UserDao;
import com.rest.api.userservice.dto.BaseUserDto;
import com.rest.api.userservice.model.User;
import com.rest.api.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public void addUser(BaseUserDto userDto) {
		User userNew = mapper.map(userDto, User.class);
		userDao.save(userNew);
	}

	@Override
	public void removeUser(String userId) throws Exception {
		User user = findUser(userId);
		userDao.delete(user);
	}

	@Override
	public User findUser(String userId) throws Exception {
		return userDao.findById(userId).orElseThrow(() -> new Exception());
	}
}