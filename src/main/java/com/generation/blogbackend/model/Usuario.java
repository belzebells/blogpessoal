package com.generation.blogbackend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuarios")

public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	
	@NotBlank(message="o atributo nome é obrigatório!")
	private String nome;
		
	@Schema(example = "email@email.com.br")
	@NotNull(message = "o atributo usuário é obrigatório!")
	@Email(message="o atributo usuário precisa de um e-mail válido!")
	private String usuario;
	
	@NotBlank(message="o atributo senha é obrigatório!")
	@Size(min=8, message="a senha precisa ter, no mínimo, 8 caracteres.")
	private String senha;
	
	@Size(max=4000, message="o link da foto inserida não pode passar 4000 caracteres.")
	private String foto;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="usuario", cascade=CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;
	
	
	public Usuario(Long id, String nome, String usuario,  String senha, String foto,
			List<Postagem> postagem) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.foto = foto;
		this.postagem = postagem;
	}
	
	
	public Usuario() {
	}

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

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
	
}
