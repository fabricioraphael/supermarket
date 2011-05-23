package entity;

public class Cliente extends Pessoa{
	
	public String email;
	public String descricao;

	public Cliente(){
		super();
	}
	public Cliente(int id, String nome, String nascimento, String endereco, Integer telefone, String email, String descricao){
		this.setId(id);
		this.setNome(nome);
		this.setNascimento(nascimento);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
		this.setEmail(email);
		this.setDescricao(descricao);
	}
	public String getEmail() {
		return email;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
