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

import service.ProdutoService;
import view.Principal.TelaPrincipal;
import view.Principal.TelasAbstract;
import entity.Produto;

public class PesquisaProdutos extends TelasAbstract implements ActionListener{

	String [] txtOpcoesCombo = {"Todos", "Nome Completo", "Nome Abreviado", "Unidade De Medida"};
	JComboBox comboBox = new JComboBox(txtOpcoesCombo);
	JTextField txtNomeCompleto = new JTextField();
	JTextField txtNomeAbreviado = new JTextField();
	String [] txtOpcaoCombo2 = {"Null", "UNI ", "Kg", "L"};
	JComboBox comboBox2 = new JComboBox(txtOpcaoCombo2);
	JTextPane txtPane = new JTextPane();
	JScrollPane txtScroll = new JScrollPane(txtPane);
	JButton botListar = new JButton("Listar");
	JButton botVoltar = new JButton("Voltar");

	public PesquisaProdutos(){
		super("Pesquisa Produtos");
		this.addWindowListener (new WindowAdapter() 
		{		   
			public void windowClosing(WindowEvent e) {
				TelaPrincipal janelap = new TelaPrincipal();
				janelap.setVisible(true);
				setVisible(false);
			}
		});
		this.getContentPane().setLayout(new GridBagLayout());

		this.add("Pesquisar por: ", comboBox);
		this.add("Nome Completo: ", txtNomeCompleto);
		this.add("Nome Abreviado:", txtNomeAbreviado);
		this.add("UNI De Medida:", comboBox2);
		this.add("Valores: ", txtScroll);
		this.add("", botListar, "", botVoltar);

		botListar.addActionListener(this);
		botVoltar.addActionListener(this);

		this.setResizable(false);
		this.setBounds(350, 140, 550, 550);
		this.setVisible(true);
	}


	/*
	 * 
	 * 
	 *         M E T O D O S
	 * 
	 * 
	 */

	public String checaComboBox(){
		String valorDeMedida = new String("");
		if(comboBox2.getSelectedIndex() == 0){
			JOptionPane.showMessageDialog(null, "Selecione uma Unidade De Medida!");
			valorDeMedida = null;
		}else if(comboBox2.getSelectedIndex() == 1){
			valorDeMedida = "UNI";
		}else if(comboBox2.getSelectedIndex() == 2){
			valorDeMedida = "Kg";
		}else if(comboBox2.getSelectedIndex() == 3){
			valorDeMedida = "L";
		}
		return valorDeMedida;
	}
	
	public void limpaCampos(){
		txtNomeCompleto.setText("");
		txtNomeAbreviado.setText("");
		comboBox2.setSelectedIndex(0);
	}

	public String mostraProduto(Vector<Produto> produto){
		String stgValores = new String();
		stgValores = "                                   Pesquisa de Produtos\n\n";
		for(int i=0; i < produto.size(); i++){
			stgValores += "ID:  " + produto.get(i).getId() + "\n";
			stgValores += "Nome completo:  " + produto.get(i).getNomeCompleto() + "\n";
			stgValores += "Nome abreviado:  " + produto.get(i).getNomeAbreviado() + "\n";
			stgValores += "Unidade de medida:  " + produto.get(i).getUnindadeDeMedida() + "\n";
			stgValores += "Quantidade:  " + produto.get(i).getQuantidade() + "\n";
			stgValores += "Valor de custo:  " + produto.get(i).getValorCusto() + "\n";
			stgValores += "Valor cobrado:  " + produto.get(i).getValorCobrado() + "\n";
			stgValores += "Nome do Fornecedor:  " + produto.get(i).getNomeFornecedor() + "\n";
			stgValores += "Valor Descricao:  " + produto.get(i).getDescricao() + "\n";
			stgValores += "________________________________________________________________\n\n\n";
		}
		return stgValores;
	}

	/*
	 * 
	 * Opcão do ComboBox 
	 * 
	 */


	//	IF tipo de busca == Todos
	public void ifOpcao0(){
		if(comboBox.getSelectedIndex() == 0){
			Vector<Produto> txtValores = new Vector<Produto>();
			ProdutoService pesquisa = new ProdutoService();
			txtValores = pesquisa.PesquisaTodosProduto();
			txtPane.setText(mostraProduto(txtValores));
		}
	}

	//	IF tipo de busca == Nome Completo
	public void ifOpcao1(){
		if(comboBox.getSelectedIndex() == 1){
			if(txtNomeCompleto.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Preencha o campo Nome Completo!");
			}else{
				String stgColuna = "NomeCompleto";
				String stgValor = txtNomeCompleto.getText();
				Vector<Produto> txtValores = new Vector<Produto>();
				ProdutoService pesquisa = new ProdutoService();
				txtValores = pesquisa.PesquisaUmProduto(stgColuna, stgValor);
				txtPane.setText(mostraProduto(txtValores));
			}
		}
	}
	//	IF tipo de busca == Nome Abreviado
	public void ifOpcao2(){
		if(comboBox.getSelectedIndex() == 2){
			if(txtNomeAbreviado.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Preencha o campo Nome Abreviado!");
			}else{
				String stgColuna = "NomeAbreviado";
				String stgValor = txtNomeAbreviado.getText();
				Vector<Produto> txtValores = new Vector<Produto>();
				ProdutoService pesquisa = new ProdutoService();
				txtValores = pesquisa.PesquisaUmProduto(stgColuna, stgValor);
				txtPane.setText(mostraProduto(txtValores));
			}
		}
	}

	//	IF tipo de busca == Unidade de medida
	public void ifOpcao3(){
		if(comboBox.getSelectedIndex() == 3){
			String valor = checaComboBox();
			if(valor != null){
				String stgColuna = "UnidadeDeMedida";
				String stgValor = valor;
				Vector<Produto> txtValores = new Vector<Produto>();
				ProdutoService pesquisa = new ProdutoService();
				txtValores = pesquisa.PesquisaUmProduto(stgColuna, stgValor);
				txtPane.setText(mostraProduto(txtValores));
			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botListar){
			txtPane.setText("");
			if(comboBox.getSelectedIndex() == 0){
				ifOpcao0();
			}else if(comboBox.getSelectedIndex() == 1){
				ifOpcao1();
			}else if(comboBox.getSelectedIndex() == 2){
				ifOpcao2();
			}else if (comboBox.getSelectedIndex() == 3){
				ifOpcao3();
			}
			limpaCampos();
		}else if(e.getSource() == botVoltar){
			this.setVisible(false);
			TelaPrincipal janelaPrincipal = new TelaPrincipal();
			janelaPrincipal.setVisible(true);
		}
	}
}
