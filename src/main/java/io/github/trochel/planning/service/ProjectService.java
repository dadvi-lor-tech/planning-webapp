package io.github.trochel.planning.service;

import java.util.List;

import io.github.trochel.planning.model.Project;

public interface ProjectService {
	
	Project findProjectById(long id);

	List<Project> getAllProjects();

}
