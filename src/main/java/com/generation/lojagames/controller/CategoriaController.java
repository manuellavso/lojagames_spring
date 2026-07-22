package com.generation.lojagames.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.lojagames.model.Categoria;
import com.generation.lojagames.repository.CategoriaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	//MÉTODOS GET
	//1. LISTAR TUDO
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(categoriaRepository.findAll());
			
		// SELECT * FROM tb_categorias;
	}
		
	//2. CONSULTA POR ID
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Long id){
		return categoriaRepository.findById(id)
				.map(resposta  -> ResponseEntity.ok(resposta)) 
				.orElse(ResponseEntity.notFound().build()); 
			
		//SELECT * FROM tb_categorias WHERE id = ?;
	}
		
	//3. PESQUISA POR DESCRIÇÃO
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Categoria>> getAllByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(categoriaRepository.findAllByDescricaoContainingIgnoreCase(descricao));
			
		//SELECT + FROM tb_categorias WHERE descricao LIKE "%?%";
	}
		
		
	//MÉTODO POST
	//CADASTRAR CATEGORIA
	@PostMapping
	public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria categoria){ 
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
				
		//INSERT INTO tb_temas(descricao) VALUES (?);
	}
		
	
	//MÉTODO PUT
	//ATUALIZAÇÃO
	@PutMapping
	public ResponseEntity<Categoria> put(@Valid @RequestBody Categoria categoria){ 
				
		if(categoriaRepository.existsById(categoria.getId()))
			return ResponseEntity.ok(categoriaRepository.save(categoria));
			//UPDATE tb_categorias SET descricao = ? WHERE id = ?;
				
			return ResponseEntity.notFound().build();
	}
		
		
	//MÉTODO DELETE
	@ResponseStatus(HttpStatus.NO_CONTENT) //SE DER CERTO, RETORNA O NO_CONTENT (204)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
				
		Optional<Categoria> categoria = categoriaRepository.findById(id);
				
		if(categoria.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				
		categoriaRepository.deleteById(id);
					
		//DELETE * FROM tb_categorias WHERE id = ?;
	}

}
