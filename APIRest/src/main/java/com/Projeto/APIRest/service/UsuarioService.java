package com.Projeto.APIRest.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.Projeto.APIRest.data.vo.UsuarioVO;
import com.Projeto.APIRest.exception.ResourceNotFoundException;
import com.Projeto.APIRest.model.Usuario;
import com.Projeto.APIRest.repository.UsuarioRepository;



@Service

public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public UsuarioVO create(UsuarioVO usuarioVO) {
	 	UsuarioVO usuarioVoRetorno = UsuarioVO.create(repository.save(Usuario.create(usuarioVO)));
	 
		return usuarioVoRetorno;
	}
	
	public UsuarioVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return UsuarioVO.create(entity);
	}
	
	
}
