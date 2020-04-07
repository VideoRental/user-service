package com.rest.api.userservice.controller;

import static org.slf4j.LoggerFactory.getLogger;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.userservice.dto.BaseUserDto;
import com.rest.api.userservice.dto.UserDto;
import com.rest.api.userservice.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger LOG = getLogger(UserController.class);
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private UserService userService;

	@ApiOperation(value = "Add new user")
	@PostMapping
	public ResponseEntity<HttpStatus> addUser(@RequestBody(required = true) @Valid BaseUserDto userDto) {
		LOG.debug("UserController - addUser: {}", userDto.toString());
		userService.addUser(userDto);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}

	@ApiOperation(value = "Delete user")
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String userId) throws Exception {
		LOG.debug("UserController - deleteUser: {}", userId);
		userService.removeUser(userId);
		return ResponseEntity.ok(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "Find user")
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> findUser(@PathVariable("id") String userId) throws Exception {
		LOG.debug("UserController - findUser: {}", userId);
		UserDto dto = mapper.map(userService.findUser(userId), UserDto.class);
		return ResponseEntity.ok(dto);
	}
}
