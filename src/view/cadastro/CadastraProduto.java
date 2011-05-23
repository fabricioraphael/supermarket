package view.cadastro;

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

import service.FornecedorService;
import service.ProdutoService;
import view.Principal.TelaPrincipal;
import view.Principal.TelasAbstract;
import entity.Fornecedor;

public class CadastraProduto extends TelasAbstract implements ActionListener{

	JTextField txtNomeCompleto = new JTextField();
	JTextField txtNomeAbreviado = new JTextField();
	String [] txtOpcoes = {"Null", "UNI ", "Kg", "L"};
	JComboBox comboBox = new JComboBox(txtOpcoes);
	JTextField txtQuantidade = new JTextField("1",5);
	JTextField txtValorCusto = new JTextField(5);
	JTextField txtValorCobrado = new JTextField(5);
	JButton botCalcularPorcentagem = new JButton("Calcular %");
	JTextField txtNomeFornecedor = new JTextField();
	JTextField txtEnderecoFornecedor = new JTextField();
	JTextField txtTelefoneFornecedos1 = new JTextField(6);
	JTextField txtTelefoneFornecedos2 = new JTextField(6);
	JButton botBuscaFornecedor = new JButton("Pesquisa Fornecedores");
	JTextField txtEmail = new JTextField();
	JTextPane txtPainel = new JTextPane();
	JScrollPane txtScroll = new JScrollPane(txtPainel);
	JButton botEnviar = new JButton("Enviar");
	JButton botVoltar = new JButton("Voltar");
	FornecedorService fornecedorService = new FornecedorService();
	ProdutoService produtoS = new ProdutoService();


	public CadastraProduto(){
		super("Cadastro de Produtos");
		this.addWindowListener (new WindowAdapter() 
		{		   
			public void windowClosing(WindowEvent e) {
				TelaPrincipal janelap = new TelaPrincipal();
				janelap.setVisible(true);
				setVisible(false);
			}
		});
		this.getContentPane().setLayout(new GridBagLayout());

		this.add("Nome completo:* ", txtNomeCompleto);
		this.add("Nome abreviacao:*", txtNomeAbreviado);
		this.add("Unidade de medida:*", comboBox, "    Quantidade:* ", txtQuantidade);
		this.add("Valor de custo:*", txtValorCusto, "Valor Cobrado:* ",txtValorCobrado, botCalcularPorcentagem);
		this.add("Nome Fornecedor*: ", txtNomeFornecedor);
		this.add("Pesquisar: ", botBuscaFornecedor);
		this.add("Endereco: ", txtEnderecoFornecedor);
		this.add("Telefone: ", txtTelefoneFornecedos1, "             Celular: ", txtTelefoneFornecedos2);
		this.add("Email:", txtEmail);
		this.add("Descricao produto:", txtScroll);
		this.add("", botEnviar, "", botVoltar);

		botCalcularPorcentagem.addActionListener(this);
		botBuscaFornecedor.addActionListener(this);
		botEnviar.addActionListener(this);
		botVoltar.addActionListener(this);

		this.setBounds(350, 140, 550, 550);
		this.setResizable(false);
	}

	public void limpaTxt(){
		txtNomeCompleto.setText("");
		txtNomeAbreviado.setText("");
		txtValorCusto.setText("");
		txtValorCobrado.setText("");
		txtNomeFornecedor.setText("");
		txtEnderecoFornecedor.setText("");
		txtTelefoneFornecedos1.setText("");
		txtTelefoneFornecedos2.setText("");
		txtEmail.setText("");
		txtPainel.setText("");
		txtQuantidade.setText("1");
		comboBox.setSelectedIndex(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botCalcularPorcentagem){
			txtValorCobrado.setText(produtoS.calculaPorcentagem(txtValorCusto.getText()));
		}
		if(e.getSource() == botEnviar){
			if((txtNomeCompleto.getText().equalsIgnoreCase("")) || (txtNomeAbreviado.getText().equalsIgnoreCase("")) ||
					(txtQuantidade.getText().equalsIgnoreCase("")) || (txtValorCusto.getText().equalsIgnoreCase("")) ||
					(txtValorCobrado.getText().equalsIgnoreCase("")) || (txtNomeFornecedor.getText().equalsIgnoreCase(""))){
				JOptionPane.showMessageDialog(null, "Todos os campos * devem ser preenchidos!");
			}else{
				if(produtoS.isValidaValorCusto(txtValorCusto.getText())){
					String UNI = produtoS.checaComboBox(comboBox);
					if(UNI != null){
						produtoS.salvaProduto(txtNomeCompleto.getText(), txtNomeAbreviado.getText(), UNI, txtQuantidade.getText(), txtValorCusto.getText(), txtValorCobrado.getText(),txtNomeFornecedor.getText(), txtPainel.getText());
					}
					limpaTxt();
				}
			}
		}
		if(e.getSource() == botBuscaFornecedor){
			String stgColuna = "NomeCompleto";
			String stgValor = txtNomeFornecedor.getText();

			Vector<Fornecedor> fornecedor = new Vector<Fornecedor>();
			fornecedor = fornecedorService.PesquisaUmFornecedo(stgColuna, stgValor);
			if(fornecedor.size() > 1){
				JOptionPane.showMessageDialog(null, "Existe mais de um fornecedor com esse nome, consulte o cadastro de fornecedores.");
			}else{
				System.out.println("Entrou aqui");
				String tel1 = String.valueOf(fornecedor.get(0).getTel1());
				String tel2 = String.valueOf(fornecedor.get(0).getTel2());
				txtNomeFornecedor.setText(fornecedor.get(0).getNomeCompleto());
				txtEnderecoFornecedor.setText(fornecedor.get(0).getEndereco());
				txtTelefoneFornecedos1.setText(tel1);
				txtTelefoneFornecedos2.setText(tel2);
				txtEmail.setText(fornecedor.get(0).getEmail());
			}
		}
		if(e.getSource() == botVoltar){
			this.setVisible(false);
			TelaPrincipal janelaPrincipal = new TelaPrincipal();
			janelaPrincipal.setVisible(true);
		}
	}
}
