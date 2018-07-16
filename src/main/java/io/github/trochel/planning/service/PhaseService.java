package io.github.trochel.planning.service;

import java.util.List;

import io.github.trochel.planning.model.Phase;

public interface PhaseService {

	List<Phase> findPhasesByProjectId(long id);

}
