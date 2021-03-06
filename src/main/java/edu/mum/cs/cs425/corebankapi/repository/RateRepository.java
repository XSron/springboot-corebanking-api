package edu.mum.cs.cs425.corebankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.corebankapi.model.setting.Rate;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

}
