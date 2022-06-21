package com.digitech.reciskmodule.repository;

import com.digitech.reciskmodule.model.Branche;
import com.digitech.reciskmodule.model.CaseNotLifePremium;
import com.digitech.reciskmodule.model.Cedant;
import com.digitech.reciskmodule.model.SlipsPremium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CaseNotLifePremiumRepository extends JpaRepository<CaseNotLifePremium, String> {
    @Query("SELECT c FROM CaseNotLifePremium c WHERE c.branche := branche AND c.cedant := cedant AND c.slipesPrime := slipesPrime")
    public Optional<CaseNotLifePremium> findByBrancheAndCedant(String branche, String cedant, String slipesPrime);
}
