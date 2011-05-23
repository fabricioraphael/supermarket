package view.pesquisa;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import service.ClienteService;
import service.FornecedorService;
import service.FuncionarioService;
import view.Principal.TelaPrincipal;
import view.Principal.TelasAbstract;
import entity.Cliente;
import entity.Fornecedor;
import entity.Funcionario;

public class PesquisaPessoa extends TelasAbstract implements ActionListener{

	String [] opcoesTxt = {"Todos", "Cliente", "Fornecedor", "Funcionario"};
	JComboBox opcoesBox = new JComboBox(opcoesTxt);
	String [] opcoesTxt2 = {"Todos", "ID", "Nome", "Endereco"};
	JComboBox opcoesBox2 = new JComboBox(opcoesTxt2);
	JTextField txtID = new JTextField();
	JTextField txtNome = new JTextField();
	JTextField txtEndereco = new JTextField();
	JButton lista = new JButton();
	JTextPane txtArea = new JTextPane();
	JScrollPane txtScroll = new JScrollPane(txtArea);
	JButton botListar = new JButton("        Listar.         ");
	JButton botVoltar = new JButton("        Voltar.         ");

	public PesquisaPessoa(){
		super("Mostra Cadastros");
		this.addWindowListener (new WindowAdapter() 
		{		   
			public void windowClosing(WindowEvent e) {
				TelaPrincipal janelap = new TelaPrincipal();
				janelap.setVisible(true);
				setVisible(false);
			}
		});
		this.getContentPane().setLayout(new GridBagLayout());

		//		this.add("Pesquisar por: ",opcTodos , opcCliente, opcVendedor, opcGerente);
		this.add("Listar: ", opcoesBox, "Pesquisar por: ", opcoesBox2);

		this.add("ID: ", txtID);
		this.add("Nome: ", txtNome);
		this.add("Endereco:", txtEndereco);
		this.add("Valores: ", txtScroll);
		this.add("", botListar, "", botVoltar);

		botListar.addActionListener(this);
		botVoltar.addActionListener(this);


		this.setResizable(false);
		this.setVisible(true);
		this.setBounds(350, 140, 550, 550);
	}

	public String mostraClientes(Vector<Cliente> cliente){
		String stgValores = new String();
		stgValores = "                                   Todos os Clientes\n\n";
		for(int i=0; i < cliente.size(); i++){
			stgValores += "ID: " + cliente.get(i).getId() + "\n";
			stgValores += "Nome: " + cliente.get(i).getNome() + "\n";
			stgValores += "Nascimento: " + cliente.get(i).getNascimento() + "\n";
			stgValores += "Endereço: " + cliente.get(i).getEndereco() + "\n";
			stgValores += "Telefone: " + cliente.get(i).getTelefone() + "\n";
			stgValores += "E-mail: " + cliente.get(i).getEmail() + "\n";
			stgValores += "Descrição: " + cliente.get(i).getDescricao()+ "\n";
			stgValores += "________________________________________________________________________\n\n\n";
		}
		return stgValores;
	}

	public String mostraFuncionario(Vector<Funcionario> funcionario){
		String stgValores = new String();
		stgValores = "                                   Todos os Funcionarios\n\n";
		for(int i=0; i < funcionario.size(); i++){
			stgValores += "ID: " + funcionario.get(i).getId() + "\n";
			stgValores += "Nome: " + funcionario.get(i).getNome() + "\n";
			stgValores += "Nascimento: " + funcionario.get(i).getNascimento() + "\n";
			stgValores += "Endereço: " + funcionario.get(i).getEndereco() + "\n";
			stgValores += "Telefone: " + funcionario.get(i).getTelefone() + " Celular: " + funcionario.get(i).getCelular() + "\n";
			stgValores += "E-mail: " + funcionario.get(i).getEmail() + "\n";
			stgValores += "Cargo: " + funcionario.get(i).getCargo() + "\n";
			stgValores += "Data Adimição: " + funcionario.get(i).getDataAdimicao() + "\n";
			stgValores += "Salário: " + funcionario.get(i).getSalario() + "\n";
			stgValores += "Descrição: " + funcionario.get(i).getObservacoes()+ "\n";
			stgValores += "________________________________________________________________________\n\n\n";
		}
		return stgValores;
	}

	public String mostraFornecedor(Vector<Fornecedor> fornecedor){
		String stgValores = new String();
		stgValores = "                                   Todos os Fornecedores\n\n";
		for(int i=0; i < fornecedor.size(); i++){
			stgValores += "ID: " + fornecedor.get(i).getId() + "\n";
			stgValores += "Nome Completo: " + fornecedor.get(i).getNomeCompleto() + "\n";
			stgValores += "Nome Fantasia: " + fornecedor.get(i).getNomeFantasia() + "\n";
			stgValores += "CNPJ: " + fornecedor.get(i).getCNPJ() + "\n";
			stgValores += "Endereço: " + fornecedor.get(i).getEndereco() + "\n";
			stgValores += "Telefone 1: " + fornecedor.get(i).getTel1() + " Telefone 2: " + fornecedor.get(i).getTel2() + "\n";
			stgValores += "E-mail: " + fornecedor.get(i).getEmail() + "\n";
			stgValores += "Descrição: " + fornecedor.get(i).getDescricao()+ "\n";
			stgValores += "________________________________________________________________________\n\n\n";
		}
		return stgValores;
	}
	public void ifOpcao0(){
		//		Le os Clientes
		Vector<Cliente> listaCliente = new Vector<Cliente>();
		ClienteService pesquisaCliente = new ClienteService();
		listaCliente = pesquisaCliente.PesquisaTodosClientes();
		//		Le os Funcionarios
		Vector<Funcionario> listaFuncionario = new Vector<Funcionario>();
		FuncionarioService pesquisaFuncionario = new FuncionarioService();
		listaFuncionario = pesquisaFuncionario.PesquisaTodosFuncionario();
		String separador = "\n\n===========================================";
		//		Le os Fornecedores
		Vector<Fornecedor> listaFornecedor = new Vector<Fornecedor>();
		FornecedorService pesquisaFornecedor = new FornecedorService();
		listaFornecedor = pesquisaFornecedor.PesquisaTodosFornecedores();
		
		txtArea.setText((mostraClientes(listaCliente)) + separador + (mostraFuncionario(listaFuncionario)) + separador + (mostraFornecedor(listaFornecedor)));
	}


	/*
	 * Opcoes do ComboBox (opcoesBox) IF Listar == Cliente
	 */
	public void ifOpcao1(){
		//		IF tipo de busca == Todos
		if(opcoesBox2.getSelectedIndex() == 0){
			Vector<Cliente> txtValores = new Vector<Cliente>();
			ClienteService pesquisa = new ClienteService();
			txtValores = pesquisa.PesquisaTodosClientes();
			txtArea.setText(mostraClientes(txtValores));
		}
		//		IF tipo de busca == ID
		else if(opcoesBox2.getSelectedIndex() == 1){
			Integer ID = new Integer(0);
			if(txtID.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Preencha o campo ID!");
			}else{
				ClienteService pesquisa = new ClienteService();
				Vector<Cliente> cliente = new Vector<Cliente>();
				try {
					ID = Integer.parseInt(txtID.getText());
					cliente = pesquisa.PesquisaUmCliente(ID);
					txtArea.setText(mostraClientes(cliente));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "O campo ID deve ser preenchido somente com Numeros!");
				}
			}
		}
		//		IF tipo de busca == Nome
		else if(opcoesBox2.getSelectedIndex() == 2){
			if(txtNome.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Preencha o campo Nome!");
			}else{
				String stgColuna = "Nome";
				String stgValor = txtNome.getText();
				Vector<Cliente> txtValores = new Vector<Cliente>();
				ClienteService pesquisa = new ClienteService();
				txtValores = pesquisa.PesquisaUmCliente(stgColuna, stgValor);
				txtArea.setText(mostraClientes(txtValores));
			}
		}
		//		IF tipo de busca == Endereco
		else if(opcoesBox2.getSelectedIndex() == 3){
			if(txtEndereco.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Preencha o campo Endereço!");
			}else{
				String stgColuna = "Endereco";
				String stgValor = txtEndereco.getText();
				Vector<Cliente> txtValores = new Vector<Cliente>();
				ClienteService pesquisa = new ClienteService();
				txtValores = pesquisa.PesquisaUmCliente(stgColuna, stgValor);
				txtArea.setText(mostraClientes(txtValores));
			}
		}
	}


	/*
	 * Opcoes do ComboBox (opcoesBox) IF Listar == Fornecedor
	 */
	public void ifOpcao2(){

		if(opcoesBox2.getSelectedIndex() == 0){
			Vector<Fornecedor> txtValores = new Vector<Fornecedor>();
			FornecedorService pesquisa = new FornecedorService();
			txtValores = pesquisa.PesquisaTodosFornecedores();
			txtArea.setText(mostraFornecedor(txtValores));
			//			IF tipo de busca == ID
		}else if(opcoesBox2.getSelectedIndex() == 1){
			Integer ID = new Integer(9);
			if(txtID.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Preencha o campo ID!");
			}else{
				FornecedorService fornecedorService = new FornecedorService();
				Vector<Fornecedor> fornecedor = new Vector<Fornecedor>();
				try {
					ID = Integer.parseInt(txtID.getText());
					fornecedor = fornecedorService.PesquisaUmFornecedor(ID);
					txtArea.setText(mostraFornecedor(fornecedor));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "O campo ID deve ser preenchido somente com Numeros!");
				}
			}

			//			IF tipo de busca == Nome
		}else if(opcoesBox2.getSelectedIndex() == 2){
			if(txtNome.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Preencha o campo Nome!");
			}else{
				String stgColuna = "NomeCompleto";
				String stgValor = txtNome.getText();
				Vector<Fornecedor> txtValores = new Vector<Fornecedor>();
				FornecedorService pesquisa = new FornecedorService();
				txtValores = pesquisa.PesquisaUmFornecedo(stgColuna, stgValor);
				txtArea.setText(mostraFornecedor(txtValores));
			}

			//			IF tipo de busca == Endereco
		}else if(opcoesBox2.getSelectedIndex() == 3){
			if(txtEndereco.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Preencha o campo Endereço!");
			}else{
				String stgColuna = "Endereco";
				String stgValor = txtEndereco.getText();
				Vector<Fornecedor> txtValores = new Vector<Fornecedor>();
				FornecedorService pesquisa = new FornecedorService();
				txtValores = pesquisa.PesquisaUmFornecedo(stgColuna, stgValor);
				txtArea.setText(mostraFornecedor(txtValores));
			}
		}
	}


	/*
	 * Opcoes do ComboBox (opcoesBox) IF Listar == Funcionario
	 */
	public void ifOpcao3(){
		if(opcoesBox2.getSelectedIndex() == 0){
			Vector<Funcionario> txtValores = new Vector<Funcionario>();
			FuncionarioService pesquisa = new FuncionarioService();
			txtValores = pesquisa.PesquisaTodosFuncionario();
			txtArea.setText(mostraFuncionario(txtValores));
			//			IF tipo de busca == ID
		}else if(opcoesBox2.getSelectedIndex() == 1){
			Integer ID = new Integer(0);
			if(txtID.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Preencha o campo ID!");
			}else{
				FuncionarioService funcionarioService = new FuncionarioService();
				Vector<Funcionario> funcionario = new Vector<Funcionario>();
				try {
					ID = Integer.parseInt(txtID.getText());
					funcionario = funcionarioService.PesquisaUmFuncionario(ID);
					txtArea.setText(mostraFuncionario(funcionario));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "O campo ID deve ser preenchido somente com Numeros!");
				}
			}

			//			IF tipo de busca == Nome
		}else if(opcoesBox2.getSelectedIndex() == 2){
			if(txtNome.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Preencha o campo Nome!");
			}else{
				String stgColuna = "Nome";
				String stgValor = txtNome.getText();
				Vector<Funcionario> txtValores = new Vector<Funcionario>();
				FuncionarioService pesquisa = new FuncionarioService();
				txtValores = pesquisa.PesquisaUmFuncionario(stgColuna, stgValor);
				txtArea.setText(mostraFuncionario(txtValores));
			}

			//			IF tipo de busca == Endereco
		}else if(opcoesBox2.getSelectedIndex() == 3){
			if(txtEndereco.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Preencha o campo Endereço!");
			}else{
				String stgColuna = "Endereco";
				String stgValor = txtEndereco.getText();
				Vector<Funcionario> txtValores = new Vector<Funcionario>();
				FuncionarioService pesquisa = new FuncionarioService();
				txtValores = pesquisa.PesquisaUmFuncionario(stgColuna, stgValor);
				txtArea.setText(mostraFuncionario(txtValores));
			}
		}
	}
	public void limpaTxt(){
		txtNome.setText("");
		txtID.setText("");
		txtEndereco.setText("");
		opcoesBox.setSelectedIndex(0);
		opcoesBox2.setSelectedIndex(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botListar){
			txtArea.setText("");
			if(opcoesBox.getSelectedIndex() == 0){
				ifOpcao0();
			}else if(opcoesBox.getSelectedIndex() == 1){
				ifOpcao1();
			}else if(opcoesBox.getSelectedIndex() == 2){
				ifOpcao2();
			}else if(opcoesBox.getSelectedIndex() == 3){
				ifOpcao3();
			}
			limpaTxt();
		}else if(e.getSource() == botVoltar){
			this.setVisible(false);
			TelaPrincipal janelaPrincipal = new TelaPrincipal();
			janelaPrincipal.setVisible(true);
		}
	}
}

















