package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Log;

/*
 * Type of accounts
 *  1 - Gerente
 *  2 - Sub-Gerente
 *  3 - Atendente
 */


public class LoginDao {


	public void insereLog(Log userLog) throws SQLException {
		try {
			Connection con = Banco.getConexao();
			Statement stmt = con.createStatement();
			String comandoSQL = "INSERT INTO tableLogin(User, Password, Usuario, Cargo, Type)" +
			" VALUES ('"+ userLog.getUser() + "','"+ userLog.getPassword() + "','"+ userLog.getUsuario() + "','"+ userLog.getCargo() + "'," + userLog.getType() + ")";                             
			stmt.executeUpdate(comandoSQL);

			stmt.close();
			//			con.commit();
			con.close();
		} catch (SQLException e){
			throw new SQLException("Problemas ao abrir a conexão com o BD. erro = "+ e.getMessage());
		}
	}

	public Log consultaUmLog(int id) throws SQLException {
		Log log = null;
		try {
			Connection con = Banco.getConexao();
			Statement stat = con.createStatement();
			String query = "SELECT * FROM tableLogin where id = "+id+" ;";

			ResultSet res = stat.executeQuery(query);

			if(res.next()) {
				log = new Log(res.getString("User"), res.getString("Password"), res.getString("Usuario"), res.getString("Cargo"), res.getInt("Type"));
			}
			stat.close();
			con.close();
		} catch (SQLException e){
			throw new SQLException("Problemas ao abrir a conexão com o BD. erro = "+ e.getMessage());
		}

		return log;
	}


}//fim//













