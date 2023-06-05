package entity;

import utils.CriptografiaAES;

public class Usuario {
	
	private long id;
	private String nome;
	private String idade;
	private String login;
	private String senha;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "ID: " + this.id + " | Nome: " + CriptografiaAES.descriptografar(nome) + " | Idade: " + CriptografiaAES.descriptografar(idade) + " | Login: " + CriptografiaAES.descriptografar(login) + " | Senha: " + CriptografiaAES.descriptografar(senha);
	}
}
