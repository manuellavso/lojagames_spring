package com.generation.lojagames.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonPropertyOrder({ "id", "tipo"})

@Entity
@Table(name = "tb_categorias")
public class Categoria {
	
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@NotBlank(message = "O atributo tipo é obrigatório!")
		@Size(min = 3,max = 100, message = "O atributo tipo deve ter no mínimo 3 e no máximo 100 caracteres.")
		@Column(length = 100)
		private String tipo;
		
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.REMOVE) 
		@JsonIgnoreProperties(value = "categoria", allowSetters = true)
		private List<Produto> produto;

		
		//GETTERS AND SETTERS
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}

		
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		
		public List<Produto> getProduto() {
			return produto;
		}
		public void setProduto(List<Produto> produto) {
			this.produto = produto;
		}
		
		

}
