package entity;

public class Fornecedor extends Pessoa{

	private String nomeCompleto;
	private String nomeFantasia;
	private String CNPJ;
	private Integer tel1;
	private Integer tel2;
	private String email;
	private String descricao;
	
	public Fornecedor(){
		super();
	}
	
	public Fornecedor(int id, String nomeCompleto, String nomeFantasia, String CNPJ, String endereco, Integer tel1, Integer tel2, String email, String descricao){
		setId(id);
		setNomeCompleto(nomeCompleto);
		setNomeFantasia(nomeFantasia);
		setCNPJ(CNPJ);
		setEndereco(endereco);
		setTel1(tel1);
		setTel2(tel2);
		setEmail(email);
		setDescricao(descricao);
	}
	
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public String getCNPJ() {
		return CNPJ;
	}

	public Integer getTel1() {
		return tel1;
	}
	
	public Integer getTel2() {
		return tel2;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	
	public void setTel1(Integer tel1) {
		this.tel1 = tel1;
	}	
	
	public void setTel2(Integer tel2) {
		this.tel2 = tel2;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
