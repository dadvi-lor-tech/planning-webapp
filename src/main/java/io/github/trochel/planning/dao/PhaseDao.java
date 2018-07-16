package io.github.trochel.planning.dao;

import org.springframework.data.repository.CrudRepository;

import io.github.trochel.planning.model.Phase;

public interface PhaseDao extends CrudRepository<Phase, Long> {

}
