package gerencia;

import java.util.ArrayList;

public class Controller {

	
	public ArrayList<String> criaTables(){
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
				" CNPJ int(16) not nulll," +
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
				"ID int not null primary key auto_increment, NomeCompleto varchar(70) not null," +
				" NomeAbreviado varchar(50) not null, UnidadeDeMedida varchar(5) not null," +
				" Quantidade int not null, ValorDeCusto double not null, ValorCobrado double not null," +
				" NomeFornecedor varchar(70) not null, DescricaoProduto varchar(150))");
		
		
//		System.out.println(query);
		
		return query;
	}
}
