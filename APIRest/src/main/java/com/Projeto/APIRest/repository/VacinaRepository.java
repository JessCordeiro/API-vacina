package com.Projeto.APIRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Projeto.APIRest.model.Vacina;


@Repository

public interface VacinaRepository extends JpaRepository<Vacina, Long>{

}
