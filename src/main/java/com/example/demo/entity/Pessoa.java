package com.example.demo.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.example.demo.serializer.DataHoraSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = -405507874181420581L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 16, scale = 0)
	private Long id;

	// @JsonIgnore
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_hora_criada")
	@JsonProperty(access = Access.READ_ONLY)
	@JsonSerialize(using = DataHoraSerializer.class)
	private Date dataHoraCriada;	

	@Column(name = "nome", length = 14)
	private String nome = "";

	@Column(name = "login", length = 60)
	private String login = "";

	@Column(name = "senha", length = 60)
	private String senha = "";

	@PrePersist
	public void onPrePersist() {
		this.dataHoraCriada = new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome= nome;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.nome= login;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha= senha;
	}
}

