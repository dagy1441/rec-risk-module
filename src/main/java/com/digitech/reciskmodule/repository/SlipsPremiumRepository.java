package com.digitech.reciskmodule.repository;

import com.digitech.reciskmodule.model.SlipsPremium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlipsPremiumRepository extends JpaRepository<SlipsPremium, String> {
}
