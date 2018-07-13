package com.planning.service;

import java.util.List;

import com.planning.model.Project;

public interface ProjectService {
	
	Project findProjectById(long id);

	List<Project> getAllProjects();

}
