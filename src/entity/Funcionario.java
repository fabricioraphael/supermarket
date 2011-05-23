package entity;

public class Funcionario extends Pessoa{

	private Integer celular;
	private String email;
	private String cargo;
	private String dataAdimicao;
	private Double salario;
	private String observacoes;

	public Funcionario(){
		super();
	}

	public Funcionario(int id, String nome, String nascimento, String endereco, Integer telefone,Integer celular , String email, String cargo, String dataAdimicao, Double salario, String observacoes){
		setId(id);
		setNome(nome);
		setNascimento(nascimento);
		setEndereco(endereco);
		setTelefone(telefone);
		setCelular(celular);
		setEmail(email);
		setCargo(cargo);
		setDataAdimicao(dataAdimicao);
		setSalario(salario);
		setObservacoes(observacoes);
		
		
	}
	
	public String getEmail() {
		return email;
	}
	public String getCargo() {
		return cargo;
	}
	public String getDataAdimicao() {
		return dataAdimicao;
	}
	public Double getSalario() {
		return salario;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public Integer getCelular() {
		return celular;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public void setDataAdimicao(String dataAdimicao) {
		this.dataAdimicao = dataAdimicao;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public void setCelular(Integer celular) {
		this.celular = celular;
	}


}
