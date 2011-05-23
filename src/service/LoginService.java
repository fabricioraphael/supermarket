package service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import dao.LoginDao;
import entity.Log;

public class LoginService {

	public LoginService() {
	}
	// Metodo para armazenar (criar logins) no Banco de Dados.
	public void armazenaUsuario(String user, String password, String usuario, String cargo, Integer type) throws Exception{
		Log userLog = new Log();
		LoginDao loginDao = new LoginDao();

		userLog.setUser(user);
		userLog.setPassword(password);
		userLog.setUsuario(usuario);
		userLog.setCargo(cargo);
		userLog.setType(type);
		loginDao.insereLog(userLog);
	}
	// Metodo para consulta/busca um Login no Banco de Dados.
	public Log pesquisaUmUsuario(int id) throws Exception{
		LoginDao loginDao = new LoginDao();

		Log log = loginDao.consultaUmLog(id);

		if (log == null)
			throw new Exception("Usuario ou senha invalidos!");

		return log;
	}


	// Função para criar hash do valor informado. 
	public static String isCriptografa(String valor){  
		String sen = "";  
		StringBuffer stg = new StringBuffer();
		try {
			stg.append(valor);
			stg.reverse();
			sen = stg.toString();
		} catch (Exception e) {
			System.out.println("DEU MERDA! n rolo de separa as paradas. =/");
		}

		MessageDigest md = null;  
		try {  
			md = MessageDigest.getInstance("MD5");  
		} catch (NoSuchAlgorithmException e) {  
			e.printStackTrace();  
		}  
		BigInteger hash = new BigInteger(1, md.digest(sen.getBytes()));  
		sen = hash.toString(16);   
		System.out.println("Valor Recebido: " + valor + "     Valor reverse(); " + stg + " \nValor criptografado: " + sen + "\n");
		return sen;  
	}  

	public Integer isSeparaID(String user){
		String idSeparado[];
		Integer id = null;

		try{
			idSeparado = user.split("\\.");
			id = Integer.parseInt(idSeparado[1]);
			System.out.println("\n\nLogin[0]: " + idSeparado[0] + "        Login[1]: " + idSeparado[1] + " \nID: " + id + " \n");
		}catch (Exception e) {
			throw new IllegalArgumentException("Usuario informado inválido!");
		}
		return id;
	}

	/*
	 * 
	 * User: fabricio.001
	 * Password: asdasd
	 * 
	 */

	@SuppressWarnings("static-access")
	public boolean isValidaLoggin(String usuario, String senha) throws Exception{
		Log log = new Log();
		String user, password;
		Integer id;

		user = this.isCriptografa(usuario);
		password = this.isCriptografa(senha);
		id = this.isSeparaID(usuario);

		log = this.pesquisaUmUsuario(id);

		if(!log.getUser().equalsIgnoreCase(user) && !log.getPassword().equalsIgnoreCase(password)){
			return false;
		}

		return true;
	}

}//fim//







