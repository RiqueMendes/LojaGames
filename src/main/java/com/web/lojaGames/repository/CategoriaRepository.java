package com.web.lojaGames.repository;

/*
 * PORTUGES
 * codigo utilizado para realizar consultas na tabela CATEGORIA no BANCO DE DADOS
 * 
 * ENGLISH
 * code used to query the CATEGORIA(CATEGORY) table in the DATABASE
 * 
 * ESPAÑOL
 * código utilizado para realizar consultas en la tabla CATEGORIA(CATEGORY) de la BASE DE DATOS
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.lojaGames.Model.Categoria;

@Repository 
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	public List<Categoria> findAllByGeneroContainingIgnoreCase(String genero);

	public List<Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);
}