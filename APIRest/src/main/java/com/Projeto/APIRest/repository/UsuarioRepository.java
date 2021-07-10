package com.Projeto.APIRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Projeto.APIRest.model.Usuario;
@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
}


