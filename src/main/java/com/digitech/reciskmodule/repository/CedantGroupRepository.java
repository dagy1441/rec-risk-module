package com.digitech.reciskmodule.repository;

import com.digitech.reciskmodule.model.Cedant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CedantGroupRepository extends JpaRepository<Cedant, String> {
}
