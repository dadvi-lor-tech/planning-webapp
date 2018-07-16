package io.github.trochel.planning.service;

import java.util.List;

import io.github.trochel.planning.model.User;

public interface UserService {
	
	List<User> getAllUsers();

	User findUserById(long id);

	User findAdminByProjectId(long projectId);

}
