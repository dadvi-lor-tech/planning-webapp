package io.github.trochel.planning.dao;

import org.springframework.data.repository.CrudRepository;

import io.github.trochel.planning.model.Charge;

public interface ChargeDao extends CrudRepository<Charge, Long> {

}
