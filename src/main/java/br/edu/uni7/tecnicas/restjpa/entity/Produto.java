package br.edu.uni7.tecnicas.restjpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "preco")
	private Double preço;

//	@ManyToMany(mappedBy = "produtos", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@ManyToMany(mappedBy = "produtos", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	
	public Produto() {	
	}

	public Produto(Integer id, String nome, Double preço) {
		this.id = id;
		this.nome = nome;
		this.preço = preço;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreço() {
		return preço;
	}

	public void setPreço(Double preço) {
		this.preço = preço;
	}
		
	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}
	
	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
}
