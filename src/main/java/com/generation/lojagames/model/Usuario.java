package com.generation.lojagames.model;

import java.time.LocalDate;
import java.time.Period;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@JsonPropertyOrder({ "id", "foto", "nome", "data_nascimento", "usuario", "senha"})

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

	@Id //PRIMARY KEY
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O atributo nome é obrigatório!")
	@Column(length = 255)
	private String nome;

	@NotBlank(message = "O atributo usuário é obrigatório!")
	@Email(message = "O atributo usuário deve ser um email válido!")
	@Column(length = 255)
	private String usuario;

	@NotBlank(message = "O atributo senha é obrigatório!")
	@Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
	@Column(length = 255)
	private String senha;

	@Size(max = 500, message = "O link da foto não pode ser maior do que 500 caracteres")
	@Column(length = 500)
	private String foto;
	
	
	@NotNull(message = "O atributo data de nascimento é obrigatório")
	@Past(message = "A data de nascimento deve ser anterior à data atual!")
    @Column(name = "data_nascimento", nullable = false)
	private LocalDate data_nascimento;

	//GETTERS AND SETTERS
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

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	public LocalDate getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	
	
	//VERIFICAR SE É MAIOR DE IDADE
	public int calcularIdade() {
		 return Period.between(this.data_nascimento, LocalDate.now()).getYears();
	}
	
}
