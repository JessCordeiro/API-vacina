package com.Projeto.APIRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.Projeto.APIRest.data.vo.VacinaVO;
import com.Projeto.APIRest.exception.ResourceNotFoundException;

import com.Projeto.APIRest.model.Vacina;
import com.Projeto.APIRest.repository.VacinaRepository;




@Service

public class VacinaService {

	@Autowired
	private VacinaRepository repository;

	
	
	public VacinaVO create(VacinaVO vacinaVO) {
	 	VacinaVO vacinaVoRetorno = VacinaVO.create(repository.save(Vacina.create(vacinaVO)));
	 
		return vacinaVoRetorno;
	}
	
	public VacinaVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return VacinaVO.create(entity);
	}
	
	public Page<VacinaVO> findAll(Pageable pageable) {
		var page = repository.findAll(pageable);
		return page.map(this::convertToVacinaVO);
	}

	private VacinaVO convertToVacinaVO(Vacina produto) {
		return VacinaVO.create(produto);
	}
	
}
