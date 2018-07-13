package com.planning.service;

import java.util.List;

import com.planning.model.Phase;

public interface PhaseService {

	List<Phase> findPhasesByProjectId(long id);

}
