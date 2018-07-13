package com.planning.dao;

import org.springframework.data.repository.CrudRepository;

import com.planning.model.Project;

public interface ProjectDao extends CrudRepository<Project, Long> {

}
