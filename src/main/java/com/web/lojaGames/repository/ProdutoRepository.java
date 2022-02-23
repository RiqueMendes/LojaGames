package com.web.lojaGames.repository;

/*
 * PORTUGES
 * codigo utilizado para realizar consultas na tabela PRODUTOS no BANCO DE DADOS
 * 
 * ENGLISH
 * code used to query the PRODUTOS(PRODUCTS) table in the DATABASE
 * 
 * ESPAÑOL
 * código utilizado para realizar consultas en la tabla PRODUTOS(PRODUCTOS) de la BASE DE DATOS
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.lojaGames.Model.Categoria;
import com.web.lojaGames.Model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public List<Produto> findAllByDescricaoContainingIgnoreCase(String descricao);
	
	public List<Produto> findAllByValor(Double valor);
}
