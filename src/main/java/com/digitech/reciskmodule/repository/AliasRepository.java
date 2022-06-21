package com.digitech.reciskmodule.repository;

import com.digitech.reciskmodule.model.Alias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AliasRepository extends JpaRepository<Alias, String> {
}
