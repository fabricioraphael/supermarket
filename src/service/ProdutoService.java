package service;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import dao.ClienteDao;
import dao.ProdutoDao;
import entity.Cliente;
import entity.Produto;

public class ProdutoService {

	public void salvaProduto(String nomeC, String nomeA, String UNI, String quantidade, String valorCusto, String valorCobrado, String nomeFornecedor, String descricao){
		Produto produto = new Produto();
		ProdutoDao produtoServise = new ProdutoDao();
		
		Integer intQuantidade = Integer.parseInt(quantidade);
		Double doubleValorCusto = Double.parseDouble(valorCusto);
		Double doubleValorCobrado = Double.parseDouble(valorCobrado);

		produto.setNomeCompleto(nomeC);
		produto.setNomeAbreviado(nomeA);
		produto.setUnindadeDeMedida(UNI);
		produto.setQuantidade(intQuantidade);
		produto.setValorCusto(doubleValorCusto);
		produto.setValorCobrado(doubleValorCobrado);
		produto.setNomeFornecedor(nomeFornecedor);
		produto.setDescricao(descricao);

		produtoServise.insereProduto(produto);
	}
	
	public Vector<Produto> PesquisaTodosProduto(){
		ProdutoDao produtoDao = new ProdutoDao();
		Vector<Produto> valor = new Vector<Produto>();
		valor = produtoDao.consultaTodosProduto();
		return valor;
	}
	public Vector<Produto> PesquisaUmProduto(String stgColuna, String stgValor){
		ProdutoDao produtoDao = new ProdutoDao();
		Vector<Produto> valores = new Vector<Produto>();
		valores = produtoDao.consultaUmProduto(stgColuna, stgValor);
		return valores;
	}
	public Vector<Produto> PesquisaUmProduto(int id){
		ProdutoDao produtoDao = new ProdutoDao();
		Vector<Produto>  produto = new Vector<Produto>();
		produto = produtoDao.consultaUmProduto(id);
		return produto;
	}
	
	
	/*
	 * Metodos
	 */


	public boolean isValidaValorCusto(String valorCusto){
		try {
			Double doubleValorCusto = Double.parseDouble(valorCusto);
			if(doubleValorCusto <= 0){
				JOptionPane.showMessageDialog(null, "Valor de Custo invalido!");
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Valor de custo invalido, digite apenas numeros!");
			return false;
		}
	}
	
	
	public String checaComboBox(JComboBox comboBox){
		
		String valorDeMedida = null;
		if(comboBox.getSelectedIndex() == 0){
			JOptionPane.showMessageDialog(null, "Selecione uma unidade de medida!");
			valorDeMedida = null;
		}else if(comboBox.getSelectedIndex() == 1){
			valorDeMedida = "UNI";
		}else if(comboBox.getSelectedIndex() == 2){
			valorDeMedida = "Kg";
		}else if(comboBox.getSelectedIndex() == 2){
			valorDeMedida = "L";
		}
		return valorDeMedida;
	}
	
	
	public String calculaPorcentagem(String txtValorCusto){
		String stgValorTotal = null;
		try {
			Double doubleValorDeCusto = Double.parseDouble(txtValorCusto);
			String stgPorcentagem = JOptionPane.showInputDialog("Digite a porcentagem!");
			Double doubPorcentagem = Double.parseDouble(stgPorcentagem);
			Double doubleValorTotal = (doubleValorDeCusto * doubPorcentagem) / 100 + doubleValorDeCusto;
			stgValorTotal = String.valueOf(doubleValorTotal);
			return stgValorTotal;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Preenxa o campo Valor De Custo!");
			return stgValorTotal;
		}
	}
}
