package view.cadastro;

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

import service.FornecedorService;
import view.Principal.TelaPrincipal;
import view.Principal.TelasAbstract;

public class CadastraFornecedor extends TelasAbstract implements ActionListener{

	JTextField txtNomeFornecedor = new JTextField();
	JTextField txtNomeFantasia = new JTextField();
	JTextField txtCNPJ = new JTextField();
	JTextField txtEndereco = new JTextField();
	JTextField txtTel1 = new JTextField();
	JTextField txtTel2	= new JTextField();
	JTextField txtEmail = new JTextField();
	JTextPane txtDescricao = new JTextPane();
	JScrollPane txtScroll = new JScrollPane(txtDescricao);
	JButton botEnviar = new JButton("Enviar");
	JButton botVoltar = new JButton("Voltar");

	public CadastraFornecedor(){
		super("Cadastro de Fornecedores");
		this.addWindowListener (new WindowAdapter() 
		{		   
			public void windowClosing(WindowEvent e) {
				TelaPrincipal janelap = new TelaPrincipal();
				janelap.setVisible(true);
				setVisible(false);
			}
		});
		this.getContentPane().setLayout(new GridBagLayout());

		this.add("Nome: * ", txtNomeFornecedor);
		this.add("Fantasia:: * ",txtNomeFantasia);
		this.add("CNPJ: * ", txtCNPJ);
		this.add("Endereco: * ", txtEndereco);
		this.add("Telefone 1: * ", txtTel1, "Telefone 2: * ", txtTel2);
		this.add("Email: * ", txtEmail);
		this.add("Descricao: ", txtScroll);
		this.add("", botEnviar, "", botVoltar);

		botEnviar.addActionListener(this);
		botVoltar.addActionListener(this);

		this.setResizable(false);
		this.setBounds(350, 140, 550, 550);
	}

	public void limpaTxt(){
		txtNomeFornecedor.setText("");
		txtNomeFantasia.setText("");
		txtCNPJ.setText("");
		txtEndereco.setText("");
		txtTel1.setText("");
		txtTel2.setText("");
		txtEmail.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botEnviar){
			txtDescricao.setText("");
			if((txtNomeFornecedor.getText().equalsIgnoreCase("")) || (txtNomeFantasia.getText().equalsIgnoreCase("")) || (txtCNPJ.getText().equalsIgnoreCase("")) ||
					(txtEndereco.getText().equalsIgnoreCase("")) || (txtTel1.getText().equalsIgnoreCase("")) || (txtTel2.getText().equalsIgnoreCase("")) ||
					(txtEmail.getText().equalsIgnoreCase(""))){
				JOptionPane.showMessageDialog(null, "Todos os campos * devem ser preenchidos!");
			}else{
				FornecedorService fornecedorService = new FornecedorService();
				if((fornecedorService.isValidaCNPJ(txtCNPJ.getText())) && (fornecedorService.isValidaTelefone(txtTel1.getText())) && (fornecedorService.isValidaTelefone(txtTel2.getText()))){
					fornecedorService.salvaFornecedor(txtNomeFornecedor.getText(), txtNomeFantasia.getText(), txtCNPJ.getText(), txtEndereco.getText(),
							txtTel1.getText(), txtTel2.getText(), txtEmail.getText(), txtDescricao.getText());
				}
			}
			limpaTxt();
		}else if(e.getSource() == botVoltar){
			this.setVisible(false);
			TelaPrincipal janelaPrincipal = new TelaPrincipal();
			janelaPrincipal.setVisible(true);
		}
	}
}
