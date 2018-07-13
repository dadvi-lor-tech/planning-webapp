package com.planning.dao;

import org.springframework.data.repository.CrudRepository;

import com.planning.model.User;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userDao
//CRUD refers Create, Read, Update, Delete

public interface UserDAO extends CrudRepository<User, Long> {

}