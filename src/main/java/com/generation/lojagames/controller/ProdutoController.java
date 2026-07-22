package com.generation.lojagames.controller;

import java.math.BigDecimal;
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

import com.generation.lojagames.model.Produto;
import com.generation.lojagames.repository.CategoriaRepository;
import com.generation.lojagames.repository.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	

	//MÉTODO GET
	//1. LISTAR TUDO
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
			
		// SELECT * FROM tb_produtoss;
	}
		
	//2. CONSULTA POR ID
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Long id){ 
		return produtoRepository.findById(id) 
				.map(resposta  -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build()); 
		
		//SELECT * FROM tb_produtoss WHERE id = ?;
	}
		
	//3. PESQUISA POR NOME
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> getAllByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
		
		//SELECT + FROM tb_produtos WHERE nome LIKE "%?%";
	}
	
	//4. PESQUISA POR PREÇO MAIOR QUE EM ORDEM CRESC
	@GetMapping("/preco_maior/{preco}")
	public ResponseEntity<List<Produto>> findByPrecoGreaterThanOrderByPreco(@PathVariable BigDecimal preco){
		return ResponseEntity.ok(produtoRepository.findByPrecoGreaterThanOrderByPreco(preco));
	
		//SELECT * FROM tb_produtos WHERE preco > ? ORDER BY preco;
	}
	
	//5. PESQUISA POR PREÇO MENOR QUE EM ORDEM DECRESC
	@GetMapping("/preco_menor/{preco}")
	public ResponseEntity<List<Produto>> findByPrecoLessThanOrderByPrecoDesc(@PathVariable BigDecimal preco){
		return ResponseEntity.ok(produtoRepository.findByPrecoLessThanOrderByPrecoDesc(preco));
	
		//SELECT * FROM tb_produtos WHERE preco < ? ORDER BY preco DESC;
	}
	

	//MÉTODO POST
	//CADASTRO
	@PostMapping
	public ResponseEntity<Produto> post(@Valid @RequestBody Produto produto){ 

		if (categoriaRepository.existsById(produto.getCategoria().getId())){
			produto.setId(null);
				
				return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
			
			//INSERT INTO tb_produtos(nome, preco, foto, estoque) VALUES (?, ?);*/
		}
			
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A categoria não existe!", null); //ERRO 400
	}


	//MÉTODO PUT
	//ATUALIZAÇÃO
	@PutMapping
	public ResponseEntity<Produto> put(@Valid @RequestBody Produto produto){ 
			
		if(produtoRepository.existsById(produto.getId())) {
				
			if (categoriaRepository.existsById(produto.getCategoria().getId())){
				return ResponseEntity.ok(produtoRepository.save(produto));
				//UPDATE tb_produtos SET nome = "?", preco = "?" , foto = "?", estoque = "?"   WHERE id = ?;
			}
				
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A categoria não existe!", null); //ERRO 400

		}	
			
		return ResponseEntity.notFound().build();
	
	}


	//MÉTODO DELETE
	@ResponseStatus(HttpStatus.NO_CONTENT) //SE DER CERTO, RETORNA O NO_CONTENT (204)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
			
		Optional<Produto> produto = produtoRepository.findById(id);
			
		//SE NÃO ENCONTRAR A POSTAGEM (id) RETORNA NOT FOUND
		if(produto.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
		//SE ENCONTRAR, ELE DELETA
		produtoRepository.deleteById(id);
				
		//DELETE * FROM tb_produtos WHERE id = ?;
	}

}
