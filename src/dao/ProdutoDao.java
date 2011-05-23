package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import entity.Cliente;
import entity.Fornecedor;
import entity.Produto;

public class ProdutoDao {
	public ProdutoDao(){
		Banco banco = new Banco();
	}
	public void insereProduto (Produto produto){
		try {
			Connection con = Banco.getConexao();
			Statement stmt = con.createStatement();
			String comandoSQL = "INSERT INTO tableProduto(NomeCompleto, NomeAbreviado, UnidadeDeMedida, Quantidade, ValorDeCusto, ValorCobrado, NomeFornecedor, DescricaoProduto)" +
			" VALUES ('"+ produto.getNomeCompleto() + "','"+ produto.getNomeAbreviado() + "','"+ produto.getUnindadeDeMedida() + "','"+ produto.getQuantidade() + "','"+ produto.getValorCusto() + "','"+ produto.getValorCobrado() + "','"+ produto.getNomeFornecedor() + "','"+ produto.getDescricao() + "') ";
			stmt.executeUpdate(comandoSQL );

			stmt.close();
			//			con.commit();
			con.close();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Problemas ao abrir a conexão com o BD. erro = "+ e.getMessage());
		}
	}


	//	Pesquisar UM cliente Expecifico
	public Vector<Produto> consultaUmProduto(int id){
		Vector<Produto> listaProduto = new Vector<Produto>();
		Produto produto = new Produto();
		try{
			Connection con = Banco.getConexao();
			Statement stat = con.createStatement();
			String query = "SELECT * FROM tableProduto where id = "+id+" ;";
			ResultSet res = stat.executeQuery(query);
			if(res.next()) {
				produto = new Produto(res.getInt("ID"), res.getString("NomeCompleto"), res.getString("NomeAbreviado"),res.getString("UnidadeDeMedida"), res.getInt("Quantidade") , res.getDouble("ValorDeCusto"), res.getDouble("ValorCobrado"), res.getString("NomeFornecedor"), res.getString("DescricaoProduto"));
				listaProduto.add(produto);
			}
			stat.close();
			con.close();
		} catch(SQLException e) {
			System.out.println("Erro = "+e.getMessage());
		} 
		return listaProduto;
	}


	//  Pesquisa UM Por NOME ou ENDERECO 
	public Vector<Produto> consultaUmProduto(String stgColuna, String stgValor){
		Vector listaProduto = new Vector();
		Produto produto = null;
		try{
			Connection con = Banco.getConexao();
			Statement stat = con.createStatement();
			String query = "SELECT * FROM tableProduto where "+ stgColuna +" like '%"+stgValor+"%' ;";
			ResultSet res = stat.executeQuery(query);
			while(res.next()) {
				produto = new Produto(res.getInt("ID"), res.getString("NomeCompleto"), res.getString("NomeAbreviado"),res.getString("UnidadeDeMedida"), res.getInt("Quantidade") , res.getDouble("ValorDeCusto"), res.getDouble("ValorCobrado"), res.getString("NomeFornecedor"), res.getString("DescricaoProduto"));
				listaProduto.add(produto);
			}
			stat.close();
			con.close();
		} catch(SQLException e) {
			System.out.println("Erro = "+e.getMessage());
		} 
		return listaProduto;
	}

	//  Pesquisa todos os Clientes
	public Vector consultaTodosProduto(){
		Vector listaProduto = new Vector();
		Produto produto = null;
		try {
			Connection con = Banco.getConexao();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM tableProduto" ;
			ResultSet res = stmt.executeQuery(query);
			while (res.next() ){
				produto = new Produto(res.getInt("ID"), res.getString("NomeCompleto"), res.getString("NomeAbreviado"),res.getString("UnidadeDeMedida"), res.getInt("Quantidade") , res.getDouble("ValorDeCusto"), res.getDouble("ValorCobrado"), res.getString("NomeFornecedor"), res.getString("DescricaoProduto"));
				listaProduto.add(produto);
			}
			stmt.close();
			con.close();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Problemas ao consultar no BD. erro = "+ e.getMessage()); 
		}
		return listaProduto; 
	}


	public int deleteProdutos(int id)
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
