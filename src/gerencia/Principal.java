package gerencia;

import javax.swing.JOptionPane;

import service.LoginService;
import view.login.Login;

public class Principal {


	public static void main(String[] args) {
		Login log = new Login("Loggin");
		log.setVisible(true);

	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	@SuppressWarnings({ "unused", "static-access" })
	private void criaPrimeiraConta(){
		LoginService loginServer = new LoginService();
		String user, password, usuario, cargo,    userC, passwordC;
		Integer type = 1, id;

		user = JOptionPane.showInputDialog("user");
		password = JOptionPane.showInputDialog("password: ");
		usuario = JOptionPane.showInputDialog("usuario: ");
		cargo = JOptionPane.showInputDialog("cargo: ");

		userC = loginServer.isCriptografa(user);
		passwordC = loginServer.isCriptografa(password);
		
		try {
			id = loginServer.isSeparaID(user);
			loginServer.armazenaUsuario(userC, passwordC, usuario, cargo, type);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		System.out.println("user: " + user + " \npassword: " + password + " \nusuario: " + usuario + " \ncargo: " + cargo + " \ntype: " + type);
	}

}
















