package io.github.trochel.planning.dao;

import org.springframework.data.repository.CrudRepository;

import io.github.trochel.planning.model.User;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userDao
//CRUD refers Create, Read, Update, Delete

public interface UserDAO extends CrudRepository<User, Long> {

}