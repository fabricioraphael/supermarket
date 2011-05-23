package view.Principal;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public abstract class TelasAbstract extends JFrame{

	
	public TelasAbstract(String string) {
		super(string);
	}
	
	
	/*
	 * Add uma Label e um Jcomponente.
	 */
	public void add(String stg, JComponent componente){
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
	
	
	/*
	 * Add Label e um JScrollPane();
	 */
	public void add(String stg, JScrollPane scroll){
		GridBagConstraints cons = new GridBagConstraints();

		cons.fill = GridBagConstraints.NONE;
		cons.anchor = GridBagConstraints.NORTHWEST;
		cons.insets = new Insets(4, 4, 4, 4);
		cons.weighty = 1;
		cons.gridheight = GridBagConstraints.RELATIVE;

		cons.weightx = 0;
		cons.gridwidth = 1;
		this.getContentPane().add(new JLabel(stg), cons);

		cons.fill = GridBagConstraints.BOTH;
		cons.weightx = 1;
		cons.gridwidth = GridBagConstraints.REMAINDER;
		this.getContentPane().add(scroll, cons);
	}
	
	
	/*
	 * Add 2 JLabel e 2 Jcomponents 
	 */
	public void add(String stg1, JComponent componente1, String stg2, JComponent componente2){
		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.BOTH;  
		cons.insets = new Insets(4,4,4,4);  

		cons.fill = GridBagConstraints.NONE;  
		cons.anchor = GridBagConstraints.NORTHWEST;  
		cons.weightx = 0;  
		cons.gridwidth = 1;  
		this.getContentPane().add(new JLabel(stg1), cons);  

		cons.weightx = 1;  
		cons.gridwidth = 1;  
		cons.fill = GridBagConstraints.BOTH;  
		this.getContentPane().add(componente1, cons);  

		cons.fill = GridBagConstraints.NONE;  
		cons.weightx = 0;  
		cons.gridwidth = 1;  
		this.getContentPane().add(new JLabel(stg2), cons);  

		cons.weightx = 1;  
		cons.fill = GridBagConstraints.BOTH;  
		cons.gridwidth = GridBagConstraints.REMAINDER;  
		this.getContentPane().add(componente2, cons); 
	}
	
	
	/*
	 * Add 1 JLabel e 3 JTextField
	 */
	public void add(String label, JTextField txt1, JTextField txt2, JTextField txt3){
		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.NORTHEAST;  
		cons.insets = new Insets(4,4,4,4);  

		cons.fill = GridBagConstraints.NONE;  
		cons.anchor = GridBagConstraints.NORTHWEST;  
		cons.weightx = 0;  
		cons.gridwidth = 1;  
		this.getContentPane().add(new JLabel(label), cons);  

		cons.weightx = 1;  
		cons.gridwidth = 1;  
		cons.fill = GridBagConstraints.NONE;  
		this.getContentPane().add(txt1, cons);  

		cons.fill = GridBagConstraints.NONE;  
		cons.weightx = 0;  
		cons.gridwidth = 1;  
		this.getContentPane().add(txt2, cons);  

		cons.weightx = 1;  
		cons.fill = GridBagConstraints.NONE;  
		cons.gridwidth = GridBagConstraints.REMAINDER;  
		this.getContentPane().add(txt3, cons); 
	}
	
	/*
	 * Add 2 String, 3 JComponent
	 */
	public void add(String stg1, JComponent componente1, String stg2, JComponent componente2, JComponent componente3){
		GridBagConstraints cons = new GridBagConstraints();
		cons.fill = GridBagConstraints.BOTH;  
		cons.insets = new Insets(4,4,4,4);  

		cons.fill = GridBagConstraints.NONE;
		cons.anchor = GridBagConstraints.NORTHWEST;
		cons.weightx = 0;  
		cons.gridwidth = 1;  
		this.getContentPane().add(new JLabel(stg1), cons);  

		cons.weightx = 1;  
		cons.gridwidth = 1;  
		cons.fill = GridBagConstraints.BOTH;  
		this.getContentPane().add(componente1, cons); 

		cons.fill = GridBagConstraints.NONE;  
		cons.weightx = 0;  
		cons.gridwidth = 1;  
		this.getContentPane().add(new JLabel(stg2), cons); 

		cons.weightx = 1;  
		cons.gridwidth = 1;  
		cons.fill = GridBagConstraints.BOTH;  
		this.getContentPane().add(componente2, cons); 

		cons.weightx = 0;  
		cons.fill = GridBagConstraints.BOTH;  
		cons.gridwidth = GridBagConstraints.REMAINDER;  
		this.getContentPane().add(componente3, cons); 
	}
	
}
