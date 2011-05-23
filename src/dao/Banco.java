package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import view.login.Login;

public class Banco {
	// Access
	Login log = new Login("");
	private static String DRIVER_BD = "com.mysql.jdbc.Driver";
	private static String URL_BD = "jdbc:mysql://localhost:3306/baseMercado";
	private static String usuario = "root";
	private static String senha = "asdasd";
	
	private static Connection con;

	public Banco(){
		try{
			Class.forName(DRIVER_BD);
		} catch (ClassNotFoundException e){
			System.out.println("Problemas ao carregar o driver");
		}
	}

	public static Connection getConexao(){
		ArrayList<String> query = new ArrayList<String>(createTables());
		try {
//			senha = JOptionPane.showInputDialog("Senha:");			
			con = DriverManager.getConnection(URL_BD, usuario, senha);
			System.out.println("Conected!");
			
			try {
				Statement st = con.createStatement();
				st.executeUpdate("CREATE DATABASE if not exists DBMercado");

				try {
					
					st.executeUpdate("use DBMercado");
					//Cria as tabelas
					for(int i=0; i < query.size(); i++){
						st.executeUpdate(query.get(i));
					}

				} catch (Exception e) {
					System.out.println("Err ao tentar criar a tabela." + e.getMessage());
				}
				
			} catch (SQLException e) {
				System.out.println("Err ao criar o banco de dados." + e.getMessage());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Err ao abrir conexao com o BD" + e.getMessage());
			e.printStackTrace();
		}
		return con;
	}
	
	public void fecharConexao(Connection con){
		try {
			con.close();
			System.out.println("Closed!");
		} catch (SQLException e) {
			System.out.println("Err ao fechar a conexao" + e.getMessage());
		}
	}

	public static ArrayList<String> createTables(){
		ArrayList<String> query = new ArrayList<String>();
		// 0 - Cria talbe Cliente
		query.add("CREATE table if not exists tableCliente(" +
				" ID int(7) not null primary key auto_increment, " +
				" Nome varchar(55) not null, Nascimento varchar(25) not null, " +
				" Endereco varchar(55) not null, " +
				" Telefone int(11) not null, " +
		        " Email varchar(50), Descricao varchar(150))");

		// 1 - Cria table Fornecedor
		query.add("CREATE TABLE if not exists tableFornecedor(" +
				" ID int not null primary key auto_increment," +
				" NomeCompleto varchar(100) not null," +
				" NomeFantasia varchar(50) not null," +
				" CNPJ int(16) not null," +
				" Endereco varchar(50) not null," +
				" Telefone1 int(11) not null," +
				" Telefone2 int(11) not null," +
		 		" Email varchar(50) not null," +
		        " Descricao varchar(150))");

		// 2 - Cria table Funcionário
		query.add("CREATE TABLE if not exists tableFuncionario(" +
				" ID int not null primary key auto_increment, Nome varchar(50) not null," +
				" Nascimento varchar(50) not null, Endereco varchar(50) not null," +
				" Telefone int(11) not null, Celular int(11), Email varchar(50)," +
				" Cargo varchar(15) not null, DataAdmisao varchar(11) not null," +
		        " Salario double not null, Observacoes varchar(150))");

		// 3 - Cria table Produto
		query.add("CREATE TABLE if not exists tableProduto(" +
				" ID int not null primary key auto_increment, NomeCompleto varchar(70) not null," +
				" NomeAbreviado varchar(50) not null, UnidadeDeMedida varchar(5) not null," +
				" Quantidade int not null, ValorDeCusto double not null, ValorCobrado double not null," +
		        " NomeFornecedor varchar(70) not null, DescricaoProduto varchar(150))");
		// 3 - Cria table Login
		query.add("CREATE TABLE if not exists tableLogin( ID int not null primary key auto_increment," +
				" User varchar(32) not null, Password varchar(32) not null," +
				" Usuario varchar(50) not null, Cargo varchar(20) not null, Type int not null)");
		
		return query;
	}
}

















