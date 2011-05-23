package service;

import java.util.Vector;

import javax.swing.JOptionPane;

import dao.FornecedorDao;
import entity.Fornecedor;

public class FornecedorService {

	public void salvaFornecedor(String nome, String nomeFantasia, String CNPJ, String endereco, String tel1, String tel2, String email, String descricao){
		Fornecedor fornecedor = new Fornecedor();
		FornecedorDao fornecedorDao = new FornecedorDao();
		Integer intTel1 = Integer.parseInt(tel1);
		Integer intTel2 = Integer.parseInt(tel2);

		fornecedor.setNomeCompleto(nome);
		fornecedor.setNomeFantasia(nomeFantasia);
		fornecedor.setCNPJ(CNPJ);
		fornecedor.setEndereco(endereco);
		fornecedor.setTel1(intTel1);
		fornecedor.setTel2(intTel2);
		fornecedor.setEmail(email);
		fornecedor.setDescricao(descricao);

		fornecedorDao.insereFornecedor(fornecedor);
	}

	public Vector<Fornecedor> PesquisaTodosFornecedores(){
		FornecedorDao fornecedorDao = new FornecedorDao();
		Vector<Fornecedor> valor = new Vector<Fornecedor>();
		valor = fornecedorDao.consultaTodosFornecedores();
		return valor;
	}

	public Vector<Fornecedor> PesquisaUmFornecedo(String stgColuna, String stgValor){
		FornecedorDao fornecedorDao = new FornecedorDao();
		Vector<Fornecedor> fornecedor = new Vector<Fornecedor>();
		fornecedor = fornecedorDao.consultaUmFornecedor(stgColuna, stgValor);
		return fornecedor;
	}

	public Vector<Fornecedor> PesquisaUmFornecedor(int id){
		FornecedorDao fornecedorDao = new FornecedorDao();
		Vector<Fornecedor> fornecedor = new Vector<Fornecedor>();
		fornecedor = fornecedorDao.consultaUmFornecedor(id);
		return fornecedor;
	}

	/*
	 * Metodos
	 */

	public boolean isValidaCNPJ(String txtCNPJ){
		Integer intCNPJ;
		try {
			if(txtCNPJ.length() > 15){
				JOptionPane.showMessageDialog(null, "Numero de CNPJ invalido, o numero deve conter 14 digitos!");
				return false;
			}else{
				intCNPJ = Integer.parseInt(txtCNPJ);
				System.out.println("String= " + txtCNPJ + " int= "+ intCNPJ);
				return true;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Numero de CNPJ invalido, digite apenas numeros!");
			return false;
		}
	}

	public boolean isValidaTelefone(String telefone){
		try {
			if((telefone.length() != 8)){
				JOptionPane.showMessageDialog(null, "Telefone Invalido, os numeros devem conter 8 digitos!");
				return false;
			}else{
				Integer intTelefone = Integer.parseInt(telefone);
				return true;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Telefone Invalido, Digite apenas numeros!");
			return false;
		}
	}

}
