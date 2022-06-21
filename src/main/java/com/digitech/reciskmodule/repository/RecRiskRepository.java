package com.digitech.reciskmodule.repository;

import com.digitech.reciskmodule.model.RecRisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecRiskRepository extends JpaRepository<RecRisk, String> {
}
