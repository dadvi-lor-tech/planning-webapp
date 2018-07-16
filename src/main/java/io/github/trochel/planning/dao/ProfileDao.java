package io.github.trochel.planning.dao;

import org.springframework.data.repository.CrudRepository;

import io.github.trochel.planning.model.Profile;

public interface ProfileDao extends CrudRepository<Profile, Long> {

}
