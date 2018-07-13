package com.planning.dao;

import org.springframework.data.repository.CrudRepository;

import com.planning.model.Profile;

public interface ProfileDao extends CrudRepository<Profile, Long> {

}
