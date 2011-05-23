package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import entity.Cliente;




public class ClienteDao {

	public ClienteDao(){
		Banco banco = new Banco();
	}
	
	public void insereUsuario (Cliente usu){
		try {
			Connection con = Banco.getConexao();
			Statement stmt = con.createStatement();
			String comandoSQL = "INSERT INTO tableCliente(Nome, Nascimento, Endereco, Telefone, Email, Descricao)" +
			" VALUES ('"+ usu.getNome() + "','"+ usu.getNascimento() + "','"+ usu.getEndereco() + "','"+ usu.getTelefone() + "','"+ usu.getEmail() + "','"+ usu.getDescricao() + "') ";
			stmt.executeUpdate(comandoSQL );

			stmt.close();
			//			con.commit();
			con.close();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Problemas ao abrir a conexão com o BD. erro = "+ e.getMessage());
		}

	}
	//	Pesquisar UM cliente Expecifico
	public Vector<Cliente> consultaUmCliente(int id){
		Vector<Cliente> listaCliente = new Vector<Cliente>();
		Cliente cliente = new Cliente();
		try{
			Connection con = Banco.getConexao();
			Statement stat = con.createStatement();
			String query = "SELECT * FROM tableCliente where id = "+id+" ;";
			ResultSet res = stat.executeQuery(query);
			if(res.next()) {
				cliente = new Cliente(res.getInt("ID"), res.getString("Nome"), res.getString("Nascimento") ,res.getString("Endereco"), res.getInt("Telefone"),res.getString("Email"), res.getString("Descricao"));
				listaCliente.add(cliente);
			}
			stat.close();
			con.close();
		} catch(SQLException e) {
			System.out.println("Erro = "+e.getMessage());
		} 
		return listaCliente;
	}

	//  Pesquisa UM Por NOME ou ENDERECO 
	public Vector<Cliente> consultaUmCliente(String stgColuna, String stgValor){
		Vector listaClientes = new Vector();
		Cliente usu = null;
		try{
			Connection con = Banco.getConexao();
			Statement stat = con.createStatement();
			String query = "SELECT * FROM tableCliente where "+ stgColuna +" like '%"+stgValor+"%' ;";
			ResultSet res = stat.executeQuery(query);
			while(res.next()) {
				usu = new Cliente(res.getInt("ID"), res.getString("Nome"), res.getString("Nascimento") ,res.getString("Endereco"), res.getInt("Telefone"),res.getString("Email"), res.getString("Descricao"));
				listaClientes.add(usu);
			}
			stat.close();
			con.close();
		} catch(SQLException e) {
			System.out.println("Erro = "+e.getMessage());
		} 
		return listaClientes;
	}
	//  Pesquisa todos os Clientes
	public Vector consultaTodosClientes(){
		Vector listaClientes = new Vector();
		Cliente usu = null;
		try {
			Connection con = Banco.getConexao();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM tableCliente" ;
			ResultSet res = stmt.executeQuery(query);
			while (res.next() ){
				usu = new Cliente(res.getInt("ID"), res.getString("Nome"), res.getString("Nascimento") ,res.getString("Endereco"), res.getInt("Telefone"),res.getString("Email"), res.getString("Descricao"));
				listaClientes.add(usu);
			}
			stmt.close();
			con.close();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Problemas ao consultar no BD. erro = "+ e.getMessage()); 
		}
		return listaClientes; 
	}

	public int deleteUsuario(int id)
	{
		try{
			Connection con = Banco.getConexao();
			Statement stat;
			stat = con.createStatement();
			stat.executeUpdate("Delete FROM tableCliente WHERE id = "+id);
			stat.close();
			return(0);
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,"Problemas ao deletar no BD. erro = "+ e.getMessage());
			return(1);
		}
	}
	

}
