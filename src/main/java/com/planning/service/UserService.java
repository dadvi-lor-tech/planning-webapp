package com.planning.service;

import java.util.List;

import com.planning.model.User;

public interface UserService {
	
	List<User> getAllUsers();

	User findUserById(long id);

	User findAdminByProjectId(long projectId);

}
