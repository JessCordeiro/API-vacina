package com.Projeto.APIRest.data.vo;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.ManyToOne;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import com.Projeto.APIRest.model.Usuario;
import com.Projeto.APIRest.model.Vacina;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VacinaVO extends RepresentationModel<VacinaVO>{
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("nomeVacina")
	private String nomeVacina;
	
	
	@JsonProperty("dataVacina")
	private Date dataVacina;
	
	
	@JsonProperty("usuario")
	private Usuario usuario;
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeVacina() {
		return nomeVacina;
	}
	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}
	
		
	public Date getDataVacina() {
		return dataVacina;
	}
	public void setDataVacina(Date dataVacina) {
		this.dataVacina = dataVacina;
	}
	public static VacinaVO create(Vacina vacina) {
		return new ModelMapper().map(vacina, VacinaVO.class);
	}
	
	
}
