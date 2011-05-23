package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import entity.Cliente;
import entity.Fornecedor;

public class FornecedorDao {

	public FornecedorDao(){
		Banco banco = new Banco();
	}
	public void insereFornecedor(Fornecedor fornecedor){
		try {
			Connection con = Banco.getConexao();
			Statement stmt = con.createStatement();
			String comandoSQL = "INSERT INTO tableFornecedor(NomeCompleto, NomeFantasia, CNPJ, Endereco, Telefone1, Telefone2, Email, Descricao)" +
			" VALUES ('"+ fornecedor.getNomeCompleto() + "','"+ fornecedor.getNomeFantasia() + "','"+fornecedor.getCNPJ()+"','"+ fornecedor.getEndereco() + "','"+ fornecedor.getTel1() + "','"+ fornecedor.getTel2() + "','"+ fornecedor.getEmail() + "','"+ fornecedor.getDescricao() + "') ";
			stmt.executeUpdate(comandoSQL );

			stmt.close();
			con.close();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Problemas ao abrir a conexão com o BD. erro = "+ e.getMessage());
		}

	}
	//	Pesquisar UM cliente Expecifico
	public Vector<Fornecedor> consultaUmFornecedor(int id){
		Vector<Fornecedor> listaFornecedor= new Vector<Fornecedor>();
		Fornecedor fornecedor = new Fornecedor();
		try{
			Connection con = Banco.getConexao();
			Statement stat = con.createStatement();
			String query = "SELECT * FROM tableFornecedor where id = "+id+" ;";
			ResultSet res = stat.executeQuery(query);
			if(res.next()) {
				fornecedor = new Fornecedor (res.getInt("ID"), res.getString("NomeCompleto"), res.getString("NomeFantasia"), res.getString("CNPJ") ,res.getString("Endereco"), res.getInt("Telefone1"), res.getInt("Telefone2"),res.getString("Email"), res.getString("Descricao"));
				listaFornecedor.add(fornecedor);
			}
			stat.close();
			con.close();
		} catch(SQLException e) {
			System.out.println("Erro = "+e.getMessage());
		} 
		return listaFornecedor;
	}

	//  Pesquisa UM Por NOME ou ENDERECO 
	public Vector<Fornecedor> consultaUmFornecedor(String stgColuna, String stgValor){
		Vector listaFornecedor = new Vector();
		Fornecedor fornecedor = null;
		try{
			Connection con = Banco.getConexao();
			Statement stat = con.createStatement();
			String query = "SELECT * FROM tableFornecedor where "+ stgColuna +" like '%"+stgValor+"%' ;";
			ResultSet res = stat.executeQuery(query);
			while(res.next()) {
				fornecedor = new Fornecedor(res.getInt("ID"), res.getString("NomeCompleto"), res.getString("NomeFantasia"), res.getString("CNPJ") ,res.getString("Endereco"), res.getInt("Telefone1"), res.getInt("Telefone2"),res.getString("Email"), res.getString("Descricao"));
				listaFornecedor.add(fornecedor);
			}
			stat.close();
			con.close();
		} catch(SQLException e) {
			System.out.println("Erro = "+e.getMessage());
		} 
		return listaFornecedor;
	}
	
//  Pesquisa todos os Clientes
	public Vector consultaTodosFornecedores(){
		Vector listaFornecedor = new Vector();
		Fornecedor fornecedor = null;
		try {
			Connection con = Banco.getConexao();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM tableFornecedor" ;
			ResultSet res = stmt.executeQuery(query);
			while (res.next() ){
				fornecedor = new Fornecedor(res.getInt("ID"), res.getString("NomeCompleto"), res.getString("NomeFantasia") ,res.getString("CNPJ"), res.getString("Endereco"),res.getInt("Telefone1"), res.getInt("Telefone2"), res.getString("Email"), res.getString("Descricao"));
				listaFornecedor.add(fornecedor);
			}
			stmt.close();
			con.close();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Problemas ao consultar no BD. erro = "+ e.getMessage()); 
		}
		return listaFornecedor; 
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
