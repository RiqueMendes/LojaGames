package com.web.lojaGames.Model;

/* PORTUGUES
 * Este código cria a tabela PRODUTO, com os campo: ID, DESCRICAO, NOME, VALOR e CATEGORIA.
 * incluso os gets e sets necessários para sua funcionalização.
 * 
 * ENGLISH
 * This code creates a table called PRODUTO (PRODUCTS) with the ID, NOME(NAME), VALOR (VALUE) 
 * and  CATEGORIA (CATEGORY) as fields.
 * Including Gets and sets needed for it's use.
 * 
 * ESPAÑOL
 * Este código crea la tabla PRODUCTO, con los campos: ID, NOME(DESCRIPCIÓN), NOME(NOMBRE), VALOR y CATEGORIA(CATEGORÍA).
 * Incluyendo los gets y sets necesarios para su funcionalización
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String descricao;

	@NotNull
	private String nome;

	@NotNull
	private double valor;
	
	/*
	 * POTUGUES
	 * Cria a relacao.
	 * 
	 * ENGLISH 
	 * Creates the relationship
	 * 
	 * ESPAÑOL
	 * Crea la relación.
	 */
		
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;

	/*
	 * Get/set
	 */
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
