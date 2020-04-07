package com.rest.api.userservice.service;

import com.rest.api.userservice.dto.BaseUserDto;
import com.rest.api.userservice.model.User;

public interface UserService {

	public void addUser(BaseUserDto userDto);

	public void removeUser(String userId) throws Exception;

	public User findUser(String userId) throws Exception;
}
