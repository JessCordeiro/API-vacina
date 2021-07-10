package com.Projeto.APIRest.controller;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projeto.APIRest.data.vo.UsuarioVO;
import com.Projeto.APIRest.data.vo.VacinaVO;
import com.Projeto.APIRest.model.Vacina;
import com.Projeto.APIRest.repository.UsuarioRepository;
import com.Projeto.APIRest.service.UsuarioService;
import com.Projeto.APIRest.service.VacinaService;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	private UsuarioRepository usuarioRepository;
	private VacinaService vacinaService;
	//private Pageable pageable;
	
	
	@PostMapping
	public UsuarioVO create(@RequestBody UsuarioVO usuarioVO) {
		UsuarioVO usuarioVo = usuarioService.create(usuarioVO);
		usuarioVo.add(linkTo(methodOn(UsuarioController.class).findById(usuarioVo.getId())).withSelfRel());
		return usuarioVo;
	}
	
	@GetMapping(value = "/{id}", produces = {"application/json","application/xml","application/x-yaml"})
	public UsuarioVO findById(@PathVariable("id")  Long id) {
		UsuarioVO usuarioVO = usuarioService.findById(id);
		usuarioVO.add(linkTo(methodOn(UsuarioController.class).findById(id)).withSelfRel());
		return usuarioVO;
	}
	
	
	//@ModelAttribute("/vacinas")
	//public Page<VacinaVO> listaDeVacinas() {
		//return  vacinaService.findAll(pageable);
	//}	

}
