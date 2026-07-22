package com.generation.lojagames.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity 
@Table(name = "tb_produtos")
public class Produto {
	
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY) 
		private Long id;
		
		@NotBlank(message = "O atributo nome é obrigatório!")
		@Size(max = 255, message = "O atributo nome deve ter no máximo 255 caracteres.")
		@Column(length = 255)
		private String nome;
		
		@NotNull(message = "O atributo preço é obrigatório!")
		@DecimalMin("0.0")
		@DecimalMax("10000.00")
		@Column(nullable = false, precision = 7, scale = 2)
		private BigDecimal preco;
		
		@NotBlank(message = "O atributo foto é obrigatório!")
		@Size(max = 255, message = "O atributo foto deve ter no máximo 255 caracteres.")
		@Column(length = 255)
		private String foto;
		
		@NotBlank(message = "O atributo estoque é obrigatório!")
		@Size(max = 255, message = "O atributo estoque deve ter no máximo 255 caracteres.")
		@Column(length = 255)
		private Long estoque;

		//OBJETO DA CLASSE CATEGORIA
		@ManyToOne //FOREIGN KEY
		@JsonIgnoreProperties("produto") //PARA NÃO TER UM LOOP
		private Categoria categoria;

		
		//GETERS AND SETTERS
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}

		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}

		
		public BigDecimal getPreco() {
			return preco;
		}
		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}

		
		public String getFoto() {
			return foto;
		}
		public void setFoto(String foto) {
			this.foto = foto;
		}

		
		public Long getEstoque() {
			return estoque;
		}
		public void setEstoque(Long estoque) {
			this.estoque = estoque;
		}

		
		public Categoria getCategoria() {
			return categoria;
		}
		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}
		
}
