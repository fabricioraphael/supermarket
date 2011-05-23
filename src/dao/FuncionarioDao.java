package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import entity.Cliente;
import entity.Funcionario;

public class FuncionarioDao {

	public FuncionarioDao(){
		Banco banco = new Banco();
	}
	public void insereFuncionario (Funcionario usu){
		try {
			Connection con = Banco.getConexao();
			Statement stmt = con.createStatement();
			String comandoSQL = "INSERT INTO tableFuncionario(Nome, Nascimento, Endereco, Telefone, Celular, Email, Cargo, DataAdmisao, Salario, Observacoes)" +
			" VALUES ('"+ usu.getNome() + "','"+ usu.getNascimento() + "','"+ usu.getEndereco() + "','"+ usu.getTelefone() + "','"+ usu.getCelular() + "','"+ usu.getEmail() + "','"+ usu.getCargo() + "','"+ usu.getDataAdimicao() + "','"+ usu.getSalario() + "','"+ usu.getObservacoes() + "') ";
			stmt.executeUpdate(comandoSQL);
			System.out.println("\n\nComando SQL=  " + comandoSQL+"\n\n");

			stmt.close();
			//			con.commit();
			con.close();
		} catch (SQLException e){
			System.out.println("\nA merda foi aqui\n");
			JOptionPane.showMessageDialog(null,"Problemas ao abrir a conexão com o BD. erro = "+ e.getMessage());
		}

	}

	//	Pesquisar UM cliente Expecifico
	public Vector<Funcionario> consultaUmFuncionario(int id){
		Vector<Funcionario> listaCliente = new Vector<Funcionario>();
		Funcionario funcionario = new Funcionario();
		try{
			Connection con = Banco.getConexao();
			Statement stat = con.createStatement();
			String query = "SELECT * FROM tableFuncionario where id = "+id+" ;";
			ResultSet res = stat.executeQuery(query);
			if(res.next()) {
				funcionario = new Funcionario(res.getInt("ID"), res.getString("Nome"), res.getString("Nascimento") , res.getString("Endereco"), res.getInt("Telefone"), res.getInt("Celular"), res.getString("Email"), res.getString("Cargo"), res.getString("DataAdmisao"), res.getDouble("Salario"), res.getString("Observacoes"));
				listaCliente.add(funcionario);
			}
			stat.close();
			con.close();
		} catch(SQLException e) {
			System.out.println("Erro = "+e.getMessage());
		} 
		return listaCliente;
	}

	//  Pesquisa UM Por NOME ou ENDERECO 
	public Vector<Funcionario> consultaUmFuncionario(String stgColuna, String stgValor){
		Vector<Funcionario> listaFuncionario = new Vector<Funcionario>();
		Funcionario funcionario = null;
		try{
			Connection con = Banco.getConexao();
			Statement stat = con.createStatement();
			String query = "SELECT * FROM tableFuncionario where "+ stgColuna +" like '%"+stgValor+"%' ;";
			ResultSet res = stat.executeQuery(query);
			while(res.next()) {
				funcionario = new Funcionario(res.getInt("ID"), res.getString("Nome"), res.getString("Nascimento") ,res.getString("Endereco"), res.getInt("Telefone"),res.getInt("Celular"), res.getString("Email"), res.getString("Cargo"), res.getString("DataAdmisao"), res.getDouble("Salario"), res.getString("Observacoes"));
				listaFuncionario.add(funcionario);
			}
			stat.close();
			con.close();
		} catch(SQLException e) {
			System.out.println("Erro = "+e.getMessage());
		} 
		return listaFuncionario;
	}

	//  Pesquisa todos os Clientes
	public Vector consultaTodosFuncionarios(){
		Vector listaFuncionario = new Vector();
		Funcionario usu = null;
		try {
			Connection con = Banco.getConexao();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM tableFuncionario" ;
			ResultSet res = stmt.executeQuery(query);
			while (res.next() ){
				usu = new Funcionario(res.getInt("ID"), res.getString("Nome"), res.getString("Nascimento") ,res.getString("Endereco"), res.getInt("Telefone"), res.getInt("Celular"),res.getString("Email"), res.getString("Cargo"), res.getString("DataAdmisao"), res.getDouble("Salario"), res.getString("Observacoes"));
				listaFuncionario.add(usu);
			}
			stmt.close();
			con.close();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Problemas ao consultar no BD. erro = "+ e.getMessage()); 
		}
		return listaFuncionario; 
	}

	public int deleteFuncionario(int id)
	{
		try{
			Connection con = Banco.getConexao();
			Statement stat;
			stat = con.createStatement();
			stat.executeUpdate("Delete FROM tableFuncionario WHERE id = "+id);
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
