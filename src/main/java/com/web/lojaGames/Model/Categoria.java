package com.web.lojaGames.Model;

/* PORTUGUES
 * Este código cria a tabela CATEGORIA, com os campo: ID, GENERO, PRODUTORA e DESCRICAO.
 * Incluso os gets e sets necessários para sua funcionalização.
 * 
 * ENGLISH
 * This code creates a table called CATEGORIA(CATEGORY) with the ID, NOME(NAME), VALOR (VALUE) 
 * and  CATEGORIA (CATEGORY) as fields.
 * 
 * * ESPAÑOL
 ** Este código crea la tabla CATEGORIA(CATEGORÍA), con los campos: ID, GENERO, PRODUTORA(PRODUCTOR) y DESCRICAO(DESCRIPCIÓN).
 * Incluye los gets y sets necesarios para su funcionalización.
 */

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String genero;

	@NotNull
	private String produtora;

	@NotNull
	private String descricao;

	/*
	 * POTUGUES
	 * Cria a relao.
	 * 
	 * ENGLISH 
	 * Creates the relationship
	 * 
	 * ESPAÑOL
	 * Crea la relación.
	 */
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produtos;

	/*
	 * Get/set
	 */
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getProdutora() {
		return produtora;
	}

	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
