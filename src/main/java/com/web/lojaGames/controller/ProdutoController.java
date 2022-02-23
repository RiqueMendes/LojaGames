package com.web.lojaGames.controller;

/*
 * PORTUGUES
 * A classe CONTROLLER serve para organizar as requisicoes que serao feitas: get, post, put, delete
 * 
 * ENGLISH 
 * The CONTROLLER class is used to organize the requests that will be made: get, post, put, delete
 * 
 * ESPAÑOL
 * La clase CONTROLLER se utiliza para organizar las peticiones que se harán: get, post, put, delete
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.lojaGames.Model.Categoria;
import com.web.lojaGames.Model.Produto;
import com.web.lojaGames.repository.CategoriaRepository;
import com.web.lojaGames.repository.ProdutoRepository;

/*PORTUGUES
 * caminho
 * ENGLISH
 * path
 * ESPAÑOL
 * camino
 */

@RestController
@RequestMapping("/produto")
@CrossOrigin("*") //permicoes / permits / permisos
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	//Seleciona e mostra todos os dados / Selects and shows all data / Selecciona y muestra todos los datos
	
	@GetMapping("/all") 
	public ResponseEntity<List<Produto>> getAll(){    
		return ResponseEntity.ok(repository.findAll());
	}
	
	//seleciona por ID / selects by ID /seleccionar por ID
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable long id){
		return repository.findById(id).
				map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	//seleciona por DESCRICAO / selects by DESCRIPTION /seleccionar por DESCRIPCIÓN
	
	@GetMapping("/descricao")
	public ResponseEntity<List<Produto>> getByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	//POSTAGEM / POST / PUBLICACIÓN
	
	@PostMapping
	public ResponseEntity<Produto> post (@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	// ATUALIZACAO / UPDATE / ACTUALIZACIÓN
	
	@PutMapping
	public ResponseEntity<Produto> put (@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
