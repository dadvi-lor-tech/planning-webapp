package io.github.trochel.planning.dao;

import org.springframework.data.repository.CrudRepository;

import io.github.trochel.planning.model.Project;

public interface ProjectDao extends CrudRepository<Project, Long> {

}
