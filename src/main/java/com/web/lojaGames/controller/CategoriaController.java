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
import com.web.lojaGames.repository.CategoriaRepository;

/*PORTUGUES
 * caminho
 * ENGLISH
 * path
 * ESPAÑOL
 * camino
 */

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")   //permicoes / permits / permisos
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;
	
	//Seleciona e mostra todos os dados / Selects and shows all data / Selecciona y muestra todos los datos
	
	@GetMapping("/all")
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	//seleciona por ID / selects by ID /seleccionar por ID
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable long id){
		return repository.findById(id).
				map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	//seleciona por DESCRICAO / selects by DESCRIPTION /seleccionar por DESCRIPCIÓN
	
	@GetMapping("/descricao")
	public ResponseEntity<List<Categoria>> getByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	//POSTAGEM / POST / PUBLICACIÓN
	
	@PostMapping
	public ResponseEntity<Categoria> post (@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	// ATUALIZACAO / UPDATE / ACTUALIZACIÓN
	
	@PutMapping
	public ResponseEntity<Categoria> put (@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
