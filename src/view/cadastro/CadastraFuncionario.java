package view.cadastro;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import entity.Funcionario;

import service.FuncionarioService;
import view.Principal.TelaPrincipal;
import view.Principal.TelasAbstract;

public class CadastraFuncionario extends TelasAbstract implements ActionListener {
	JTextField txtNome = new JTextField();
	JTextField txtEndereco = new JTextField();
	JTextField nDia = new JTextField(2);
	JTextField nMes = new JTextField(2);
	JTextField nAno = new JTextField(4);
	JTextField txtTelefone = new JTextField(8);
	JTextField txtCelular = new JTextField(8);
	JTextField txtEmail = new JTextField();
	String [] opcoesCargo = {"Null", "Empacotador", "Limpeza", "Caixa", "Gerente"};
	JComboBox boxCargo = new JComboBox(opcoesCargo);
	String txtCargo = null;
	JTextField txtSalario = new JTextField();
	JTextField aDia = new JTextField(2);
	JTextField aMes = new JTextField(2);
	JTextField aAno = new JTextField(4);
	JTextPane txtArea = new JTextPane();
	JScrollPane txtScroll = new JScrollPane(txtArea);
	JButton botCadastrar = new JButton("Cadastrar");
	JButton botVoltar = new JButton("Voltar");
	String nascimento = new String();
	String dataAddimicao = new String();
	FuncionarioService funcionarioS = new FuncionarioService();

	public CadastraFuncionario(){
		super("Cadastro de Funcionários");
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
		this.add("Nascimento: * ", nDia, nMes, nAno);
		this.add("Endereço: * ", txtEndereco);
		this.add("Telefone: * ", txtTelefone, "Celular: " , txtCelular);
		this.add("Email: ", txtEmail);
		this.add("Cargo: * ", boxCargo);
		this.add("Data Adimição: * ", aDia, aMes, aAno);
		this.add("Salario: * ", txtSalario);
		this.add("Observacoes: ", txtScroll);
		this.add("", botCadastrar, "", botVoltar);

		botCadastrar.addActionListener(this);
		botVoltar.addActionListener(this);

		this.setBounds(350, 140, 550, 550);
		this.setResizable(false);
	}

	public void limpaCampo(){
		txtNome.setText("");
		nDia.setText("");
		nMes.setText("");
		nAno.setText("");
		txtEndereco.setText("");
		txtTelefone.setText("");
		txtCelular.setText("");
		txtEmail.setText("");
		aDia.setText("");
		aMes.setText("");
		aAno.setText("");
		txtSalario.setText("");
		txtArea.setText("");
		boxCargo.setSelectedIndex(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botCadastrar){
			if((txtNome.getText().equalsIgnoreCase("")) || (nDia.getText().equalsIgnoreCase("")) || (nMes.getText().equalsIgnoreCase("")) ||
					(nAno.getText().equalsIgnoreCase("")) || (txtEndereco.getText().equalsIgnoreCase("")) || (txtTelefone.getText().equalsIgnoreCase("")) || 
					(txtEmail.getText().equalsIgnoreCase("")) || (aDia.getText().equalsIgnoreCase("")) || (aMes.getText().equalsIgnoreCase("")) ||
					(aAno.getText().equalsIgnoreCase("")) || (txtSalario.getText().equalsIgnoreCase(""))){
				JOptionPane.showMessageDialog(null, "Os campos * devem ser preenxido!");
			}else{
				
				if( (funcionarioS.isValidaNascimento(nDia.getText(), nMes.getText(), nAno.getText())) &&
						(funcionarioS.isValidaNascimento(aDia.getText(), aMes.getText(), aAno.getText())) && (funcionarioS.isValidaTelefone(txtTelefone.getText()))){
					String nascimento = nDia.getText() + "-" + nMes.getText() + "-" + nAno.getText();
					String dataAddimicao = aDia.getText() + "-" + aMes.getText() + "-" + aAno.getText();
					txtCargo = funcionarioS.checaComboBox(boxCargo);
					if(txtCargo != null){
						funcionarioS.salvaFuncionario(txtNome.getText(), nascimento, txtEndereco.getText(), txtTelefone.getText(), txtCelular.getText(),
								txtEmail.getText(), txtCargo, dataAddimicao, txtSalario.getText(), txtArea.getText());
					}
				}
			}
			limpaCampo();
		}if(e.getSource() == botVoltar){
			this.setVisible(false);
			TelaPrincipal janelaPrincipal = new TelaPrincipal();
			janelaPrincipal.setVisible(true);
		}

	}
}
