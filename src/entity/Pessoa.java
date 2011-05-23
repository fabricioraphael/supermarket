package entity;

public abstract class Pessoa {

	private int id;
	private String nome;
	private String nascimento;
	private String endereco;
	private Integer telefone;
	


	//	Getters and Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	public Integer getTelefone() {
		return telefone;
	}






}
