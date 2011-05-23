package service;

import java.util.Vector;

import javax.swing.JOptionPane;

import dao.ClienteDao;
import entity.Cliente;


public class ClienteService {

	public void salvaCliente(String nome, String nascimento, String endereco, String telefone, String email, String descricao){
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = new Cliente();
		Integer intTelefone = Integer.parseInt(telefone);
		
		cliente.setNome(nome);
		cliente.setNascimento(nascimento);
		cliente.setEndereco(endereco);
		cliente.setTelefone(intTelefone);
		cliente.setEmail(email);
		cliente.setDescricao(descricao);
		clienteDao.insereUsuario(cliente);
	}
	
	@SuppressWarnings("unchecked")
	public Vector<Cliente> PesquisaTodosClientes(){
		ClienteDao clienteDao = new ClienteDao();
		Vector<Cliente> valor = new Vector<Cliente>();
		valor = clienteDao.consultaTodosClientes();
		return valor;
	}
	public Vector<Cliente> PesquisaUmCliente(String stgColuna, String stgValor){
		ClienteDao clienteDao = new ClienteDao();
		Vector<Cliente> valores = new Vector<Cliente>();
		valores = clienteDao.consultaUmCliente(stgColuna, stgValor);
		return valores;
	}
	public Vector<Cliente> PesquisaUmCliente(int id){
		ClienteDao clienteDao = new ClienteDao();
		Vector<Cliente> cliente = new Vector<Cliente>();
		cliente = clienteDao.consultaUmCliente(id);
		return cliente;
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
}
