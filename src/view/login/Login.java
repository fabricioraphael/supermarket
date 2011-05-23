package view.login;


import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import service.LoginService;
import view.Principal.TelaPrincipal;
import view.Principal.TelasAbstract;

public class Login extends TelasAbstract implements ActionListener{

	private JTextField user = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JButton enter = new JButton("enter");


	public Login(String string) {
		super(string);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridBagLayout());

		this.add("Usuário: *", user);
		this.add("Senha: *", password);
		this.add("", enter);

		enter.addActionListener(this);

		setBounds(600, 270, 200, 120);
		setResizable(false);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		LoginService logServer = new LoginService();
		Boolean valida = false;
		if(e.getSource() == enter){
			String usuario, senha;

			usuario = this.user.getText();
			senha = this.password.getText();
			if(!usuario.equalsIgnoreCase("") || !senha.equalsIgnoreCase("")){
				try{
					valida = logServer.isValidaLoggin(usuario, senha);
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				
				if(valida){
					this.setVisible(false);
					TelaPrincipal janelaPrincipal = new TelaPrincipal();
					janelaPrincipal.setVisible(true);
				}else{
					this.password.setText("");
				}
			}else{
				JOptionPane.showMessageDialog(null, "* Campos obrigatorios!");
			}
		}
	}
}



















