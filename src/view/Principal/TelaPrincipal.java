package view.Principal;

import gerencia.Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import view.cadastro.CadastraCliente;
import view.cadastro.CadastraFornecedor;
import view.cadastro.CadastraFuncionario;
import view.cadastro.CadastraProduto;
import view.pesquisa.PesquisaPessoa;
import view.pesquisa.PesquisaProdutos;



@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame implements ActionListener {

	Principal principal = new Principal();

	JMenuBar menuBar;
	JMenu menuPrincipal;
	JMenu menuCadastra;
	JMenu menuPesquisa;
	JMenuItem menuCadastraCliente;
	JMenuItem menuCadastraFuncionario;
	JMenuItem menuCadastraProduto;
	JMenuItem menuPesquisaCadastrado;
	JMenuItem menuPesquisaProduto;
	JMenuItem menuCadastraFornecedor;
	JMenuItem menuSair;
	Icon imagem;
	private Container containerPrincipal; 
	private JPanel pImagem,painelInicio= new JPanel();
	
	JTextField txt1 = new JTextField(15);
	JTextField txt2 = new JTextField(10);
	JTextField txt3 = new JTextField(10);
	JTextPane txtPanel = new JTextPane();
	JScrollPane txtScroll = new JScrollPane(txtPanel);

	public TelaPrincipal(){
		
		super("Gerencia Mercado    ##########~~~~~~~~~~##########");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(350, 140, 700, 700);
		this.setResizable(false);
		setLayout(new BorderLayout());
		criaBarraMenu();
		containerPrincipal = getContentPane();

		//		Toolkit kit = Toolkit.getDefaultToolkit();     
		//	    Image imagem = kit.getImage("imagens/logo_cruz_vermelha.jpg");
		//	    setIconImage(imagem);

//		painelInicio = new JPanel();
//		painelInicio.setLayout(new CardLayout());
//		imagemPainel();
//		criaCaixa();
		

		containerPrincipal.add(painelInicio,BorderLayout.CENTER);

		setVisible(true);
	}

	public void criaCaixa(){
		pImagem = new JPanel();
		JTextField txt1 = new JTextField(100);
		JTextField txt2 = new JTextField(10);
		JTextField txt3 = new JTextField(10);
		JTextPane txtPanel = new JTextPane();
		JScrollPane txtScroll = new JScrollPane(txtPanel);
		Container cont = new Container();
		
		pImagem.add("Nome ",txt1);
		pImagem.add("endereco ",txt2);
		pImagem.add("coco ",txt3);
		pImagem.add("descricao ",txtScroll);
		
		cont.add(pImagem);
		cont.setVisible(true);
		
		painelInicio.add(cont, BorderLayout.CENTER);
	}
	
	public void addd(String stg, JComponent componente){
		GridBagConstraints cons = new GridBagConstraints();

		cons.fill = GridBagConstraints.NONE;
		cons.anchor = GridBagConstraints.NORTHWEST;
		cons.insets = new Insets(4, 4, 4, 4);

		cons.weightx = 0;
		cons.gridwidth = 1;
		this.getContentPane().add(new JLabel(stg), cons);

		cons.fill = GridBagConstraints.BOTH;
		cons.weightx = 1;
		cons.gridwidth = GridBagConstraints.REMAINDER;
		this.getContentPane().add(componente, cons);
	}
	
	//----------------------------------

	public void imagemPainel(){
		//imagem
		imagem = new ImageIcon("imagens/imagem.gif");
		JLabel lImag = new JLabel(imagem,JLabel.CENTER);
		pImagem = new JPanel();

		pImagem.setLayout(new BorderLayout());		
		pImagem.add(lImag,BorderLayout.CENTER);			
		pImagem.setBackground(Color.WHITE);
		pImagem.setForeground(Color.BLUE);
		pImagem.setBorder(BorderFactory.createTitledBorder("Bem vindo!"));

		painelInicio.add(pImagem,"pImagem");
	}

	public void criaBarraMenu(){

		menuBar = new JMenuBar();
		//		Cria Menus
		menuPrincipal = new JMenu("Principal");
		menuCadastra = new JMenu("Cadastra");
		menuPesquisa = new JMenu("Pesquisa");
		//		Cria Menus Itens
		menuCadastraCliente = new JMenuItem("Cadastra Cliente");
		menuCadastraFuncionario = new JMenuItem("Cadastra Funcionario");
		menuCadastraProduto  = new  JMenuItem("Cadastra Produto");
		menuPesquisaCadastrado = new JMenuItem("Pesquisar Cadastrados");
		menuPesquisaProduto = new JMenuItem("Pesquisar Produtos");
		menuCadastraFornecedor = new JMenuItem("Cadastra Fornecedor");
		menuSair = new JMenuItem("Sair");
		//		Menu Principal
		menuSair.setMnemonic('s');
		menuSair.addActionListener(this);
		//		Menu Cadastro
		menuCadastraCliente.setMnemonic('c');
		menuCadastraCliente.addActionListener(this);
		menuCadastraFuncionario.setMnemonic('f');
		menuCadastraFuncionario.addActionListener(this);
		menuCadastraProduto.setMnemonic('p');
		menuCadastraProduto.addActionListener(this);
		menuCadastraFornecedor.setMnemonic('o');
		menuCadastraFornecedor.addActionListener(this);
		//		Menu Pesquisa
		menuPesquisaCadastrado.setMnemonic('c');
		menuPesquisaCadastrado.addActionListener(this);
		menuPesquisaProduto.setMnemonic('p');
		menuPesquisaProduto.addActionListener(this);
		//		Atribui ao Menu Cadastra.
		menuCadastra.add(menuCadastraCliente);
		menuCadastra.add(menuCadastraFornecedor);
		menuCadastra.add(menuCadastraFuncionario);
		menuCadastra.add(menuCadastraProduto);
		//		Atribui ao Menu Principal.
		menuPrincipal.add(menuSair);
		//		Atribui ao menu Pesquisa
		menuPesquisa.add(menuPesquisaCadastrado);
		menuPesquisa.add(menuPesquisaProduto);
		//		Atribui os Menus ao MenuBar		
		menuBar.add(menuPrincipal);
		menuBar.add(menuCadastra);
		menuBar.add(menuPesquisa);
		this.getContentPane().add(menuBar, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menuCadastraCliente){
			this.setVisible(false);
			CadastraCliente janelaCadastraCliente = new CadastraCliente();
			janelaCadastraCliente.setVisible(true);
		}
		if(e.getSource() == menuCadastraFornecedor){
			this.setVisible(false);
			CadastraFornecedor janelaCadastraFornecedor = new CadastraFornecedor();
			janelaCadastraFornecedor.setVisible(true);
		}
		if(e.getSource() == menuCadastraProduto){
			this.setVisible(false);
			CadastraProduto janelaCadastraProduto = new CadastraProduto();
			janelaCadastraProduto.setVisible(true);
			
		}
		if(e.getSource() == menuCadastraFuncionario){
			this.setVisible(false);
			CadastraFuncionario janelaCadastraFuncionario = new CadastraFuncionario();
			janelaCadastraFuncionario.setVisible(true);
		}
		if(e.getSource() == menuPesquisaCadastrado){
			this.setVisible(false);
			PesquisaPessoa mostraResultados = new PesquisaPessoa();
			mostraResultados.setVisible(true);
		}
		if(e.getSource() == menuPesquisaProduto){
			this.setVisible(false);
			PesquisaProdutos janelaPesquisaProdutos = new PesquisaProdutos();
			janelaPesquisaProdutos.setVisible(true);
		}

		if(e.getSource() == menuSair){
			System.exit(0);
		}
	}

}
