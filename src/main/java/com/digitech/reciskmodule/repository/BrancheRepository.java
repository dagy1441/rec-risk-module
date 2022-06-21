package com.digitech.reciskmodule.repository;

import com.digitech.reciskmodule.model.Branche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrancheRepository extends JpaRepository<Branche, String> {
}
