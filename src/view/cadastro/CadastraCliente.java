package view.cadastro;

import gerencia.Principal;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import service.ClienteService;
import view.Principal.TelaPrincipal;
import view.Principal.TelasAbstract;




public class CadastraCliente extends TelasAbstract implements ActionListener {

	Principal principal = new Principal();
	JTextField txtNome = new JTextField("");
	JTextField txtDia = new JTextField(2);
	JTextField txtMes = new JTextField(2);
	JTextField txtAno = new JTextField(4);
	String nascimento = new String("");
	JTextField txtEndereco = new JTextField("");
	JTextField txtTelefone = new JTextField("");
	JTextField txtEmail = new JTextField("");
	JTextPane txtArea = new JTextPane();
	JScrollPane scroll = new JScrollPane(txtArea);
	JButton botaoEnviar = new JButton("Enviar.");
	JButton botaoVoltar = new JButton("Voltar.");

	
	public CadastraCliente(){
		super("Cadastro de Clientes");
		this.addWindowListener (new WindowAdapter() 
		{		   
			public void windowClosing(WindowEvent e) {
				TelaPrincipal janelap = new TelaPrincipal();
				janelap.setVisible(true);
				setVisible(false);
			}
		});
		this.getContentPane().setLayout(new GridBagLayout());

		this.add("Nome: * ", txtNome);
		this.add("Nascimento: * " , txtDia, txtMes, txtAno);
		this.add("Endereço: * ", txtEndereco);
		this.add("Telefone: * ", txtTelefone);
		this.add("Email: ", txtEmail);
		this.add("Descrição: ", scroll);
		this.add("", botaoEnviar, "", botaoVoltar);


		botaoVoltar.addActionListener(this);

		botaoEnviar.addActionListener(this);

		this.setBounds(350, 140, 550, 550);
		this.setResizable(false);
	}

	public void limpaCampos(){
		txtNome.setText("");
		txtDia.setText("");
		txtMes.setText("");
		txtAno.setText("");
		txtEndereco.setText("");
		txtTelefone.setText("");
		txtEmail.setText("");
		txtArea.setText("");
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botaoEnviar){
			if((txtNome.getText().equalsIgnoreCase("")) || txtDia.getText().equalsIgnoreCase("") || (txtMes.getText().equalsIgnoreCase("")) || (txtAno.getText().equalsIgnoreCase("")) || 
					txtEndereco.getText().equalsIgnoreCase("") ){
				JOptionPane.showMessageDialog(null, "Os campos Nome, Nascimento e Endereço devem ser preenxidos.");
			}else{
				ClienteService clienteServer = new ClienteService();
				if((clienteServer.isValidaNascimento(txtDia.getText(), txtMes.getText(), txtAno.getText())) && (clienteServer.isValidaTelefone(txtTelefone.getText()))){
					nascimento = txtDia.getText() + "-" + txtMes.getText() + "-" + txtAno.getText();
					clienteServer.salvaCliente(txtNome.getText(), nascimento, txtEndereco.getText(), txtTelefone.getText(), txtEmail.getText(), txtArea.getText());
				}
			}
			limpaCampos();
		}else if (e.getSource() == botaoVoltar){
			this.setVisible(false);
			TelaPrincipal janelaPrincipal = new TelaPrincipal();
			janelaPrincipal.setVisible(true);
		}
	}
}




