package entity;

public class Produto {

	private int id;
	private String nomeCompleto;
	private String nomeAbreviado;
	private String unindadeDeMedida;
	private Integer quantidade;
	private Double valorCusto;
	private Double valorCobrado;
	private String nomeFornecedor;
	private String descricao;
	
	public Produto(){
		super();
	}
	
	public Produto(int id, String nomeCompleto, String nomeAbreviado, String unidadeDeMedida,Integer quantidade, Double valorCusto, Double valorCobrado,String nomeFornecedor, String descricao){
		setId(id);
		setNomeCompleto(nomeCompleto);
		setNomeAbreviado(nomeAbreviado);
		setUnindadeDeMedida(unidadeDeMedida);
		setQuantidade(quantidade);
		setValorCusto(valorCusto);
		setValorCobrado(valorCobrado);
		setNomeFornecedor(nomeFornecedor);
		setDescricao(descricao);
	}
	
	public int getId() {
		return id;
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	public String getNomeAbreviado() {
		return nomeAbreviado;
	}
	
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	
	public String getUnindadeDeMedida() {
		return unindadeDeMedida;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public Double getValorCusto() {
		return valorCusto;
	}
	
	public Double getValorCobrado() {
		return valorCobrado;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	
	public void setNomeAbreviado(String nomeAbreviado) {
		this.nomeAbreviado = nomeAbreviado;
	}
	
	public void setUnindadeDeMedida(String unindadeDeMedida) {
		this.unindadeDeMedida = unindadeDeMedida;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setValorCusto(Double valorCusto) {
		this.valorCusto = valorCusto;
	}
	
	public void setValorCobrado(Double valorCobrado) {
		this.valorCobrado = valorCobrado;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
