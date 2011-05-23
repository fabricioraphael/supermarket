package service;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import dao.FuncionarioDao;
import entity.Funcionario;

public class FuncionarioService {
	
	public void salvaFuncionario(String nome, String nascimento, String endereco, String telefone, String celular, String email, String cargo, String dataAdimicao, String salario, String observacoes){
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = new Funcionario();
		
		Integer intTelefone = Integer.parseInt(telefone);
		Integer intCelular = Integer.parseInt(celular);
		Double doubleSalario = Double.parseDouble(salario);
		
		funcionario.setNome(nome);
		funcionario.setNascimento(nascimento);
		funcionario.setEndereco(endereco);
		funcionario.setTelefone(intTelefone);
		funcionario.setCelular(intCelular);
		funcionario.setEmail(email);
		funcionario.setCargo(cargo);
		funcionario.setDataAdimicao(dataAdimicao);
		funcionario.setSalario(doubleSalario);
		funcionario.setObservacoes(observacoes);

		funcionarioDao.insereFuncionario(funcionario);
	}
	
	public Vector<Funcionario> PesquisaTodosFuncionario(){
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Vector<Funcionario> valor = new Vector<Funcionario>();
		valor = funcionarioDao.consultaTodosFuncionarios();
		return valor;
	}
	public Vector<Funcionario> PesquisaUmFuncionario(String stgColuna, String stgValor){
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Vector<Funcionario> valores = new Vector<Funcionario>();
		valores = funcionarioDao.consultaUmFuncionario(stgColuna, stgValor);
		return valores;
	}
	public Vector<Funcionario> PesquisaUmFuncionario(int id){
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Vector<Funcionario> funcionario = new Vector<Funcionario>();
		funcionario = funcionarioDao.consultaUmFuncionario(id);
		return funcionario;
	}
	
	/*
	 * Metodos
	 */
	public boolean isValidaNascimento(String dia, String mes, String ano){
		try {
			Integer intDia = Integer.parseInt(dia);
			Integer intMes = Integer.parseInt(mes);
			Integer intAno = Integer.parseInt(ano);

			if ((intDia <= 0) || (intDia > 31) || (dia.length() != 2)){
				JOptionPane.showMessageDialog(null, "Nascimento Invalido, data dia invalido!");
				return false;
			}if((intMes <= 0) || (intMes >12) || (mes.length() != 2)){
				JOptionPane.showMessageDialog(null, "Nascimento Invalido, data mes invalido!");
				return false;
			}if((intAno <= 0) || (intAno > 2010) || (ano.length() != 4)){
				JOptionPane.showMessageDialog(null, "Nascimento Invalido, data ano invalido!");
				return false;
			}
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nascimento Invalido, digite apenas numeros!");
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
	
	
	public String checaComboBox(JComboBox boxCargo){
		String txtCargo = "";
		if(boxCargo.getSelectedIndex() == 0){
			JOptionPane.showMessageDialog(null, "Selecione um cargo!");
			txtCargo = null;
		}else if(boxCargo.getSelectedIndex() == 1){
			txtCargo = "Empacotador";
		}else if(boxCargo.getSelectedIndex() == 2){
			txtCargo = "Limpesa";
		}else if(boxCargo.getSelectedIndex() == 3){
			txtCargo = "Caixa";
		}else if(boxCargo.getSelectedIndex() == 4){
			txtCargo = "Gerente";
		}
		return txtCargo;
	}
	
}
