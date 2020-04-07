package com.rest.api.userservice.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rest.api.userservice.model.User;

public interface UserDao extends PagingAndSortingRepository<User, String> {}