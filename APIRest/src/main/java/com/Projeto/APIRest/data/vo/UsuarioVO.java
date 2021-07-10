package com.Projeto.APIRest.data.vo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;


import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import com.Projeto.APIRest.model.Usuario;
import com.Projeto.APIRest.model.Vacina;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioVO extends RepresentationModel<UsuarioVO>{

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("nomeUsuario")
	private String nomeUsuario;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("cpf")
	private String cpf;
	
	@JsonProperty("dataNascimento")
	private Date dataNascimento;
    
	@JsonProperty("vacina")
	private List<Vacina> vacina;

	
	
	public List<Vacina> getVacina() {
		return vacina;
	}




	public void setVacina(List<Vacina> vacina) {
		this.vacina = vacina;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNomeUsuario() {
		return nomeUsuario;
	}




	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getCpf() {
		return cpf;
	}




	public void setCpf(String cpf) {
		this.cpf = cpf;
	}





	public Date getDataNascimento() {
		return dataNascimento;
	}




	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}




	public static UsuarioVO create(Usuario usuario) {
		return new ModelMapper().map(usuario, UsuarioVO.class);
	}
	
}
