package com.Projeto.APIRest.model;


import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;


import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.modelmapper.ModelMapper;


import com.Projeto.APIRest.data.vo.VacinaVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name= "vacina")

public class Vacina {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nomeVacina;
	
	@Temporal(TemporalType.DATE)
	private Date dataVacina;

	@ManyToOne
	@JsonIgnoreProperties("vacina")
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

	public static Vacina create(VacinaVO vacinaVO) {
		return new ModelMapper().map(vacinaVO, Vacina.class);
	}
	
}
