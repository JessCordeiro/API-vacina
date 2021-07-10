package com.Projeto.APIRest.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.Projeto.APIRest.data.vo.VacinaVO;

import com.Projeto.APIRest.repository.VacinaRepository;

import com.Projeto.APIRest.service.VacinaService;

@RestController
@RequestMapping("/vacinas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VacinaController {

	
	@Autowired
	private VacinaService vacinaService;
	private VacinaRepository vacinaRepository;
	
	
	@PostMapping
	public VacinaVO create(@RequestBody VacinaVO vacinaVO) {
		VacinaVO vacinaVo = vacinaService.create(vacinaVO);
		vacinaVo.add(linkTo(methodOn(UsuarioController.class).findById(vacinaVo.getId())).withSelfRel());
		return vacinaVo;
	}
	
	@GetMapping(value = "/{id}", produces = {"application/json","application/xml","application/x-yaml"})
	public VacinaVO findById(@PathVariable("id")  Long id) {
		VacinaVO vacinaVO = vacinaService.findById(id);
		vacinaVO.add(linkTo(methodOn(UsuarioController.class).findById(id)).withSelfRel());
		return vacinaVO;
	}
	
	
}
