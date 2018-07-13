package com.planning.dao;

import org.springframework.data.repository.CrudRepository;

import com.planning.model.Charge;

public interface ChargeDao extends CrudRepository<Charge, Long> {

}
