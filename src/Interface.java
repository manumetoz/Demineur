import java.awt.Color;

import javax.swing.*;

public class Interface extends JFrame{
	private static final long serialVersionUID = 1L;

	private JMenuBar MenuBar;
	private JMenu Reprendre,Nouveau,Quitter;
	private JMenuItem Facile,Normal,Difficile;
	private JButton Mineur[][];
	public Interface(){             
	    this.setTitle("Demineur");
	    this.setSize(400, 400);
	    this.setLocationRelativeTo(null);               
	    JPanel pan = new JPanel();
	    
	    Facile= new JMenuItem("Facile");
	    Normal= new JMenuItem("Normal");
	    Difficile= new JMenuItem("Difficile");
	   
	    
	    Nouveau= new JMenu("Nouvelle Partie");
	    Nouveau.add(Facile);
	    Nouveau.add(Normal);
	    Nouveau.add(Difficile);
	    
	    Reprendre= new JMenu("Reprendre Partie");

	    Quitter= new JMenu("Quitter");

	    MenuBar = new JMenuBar();
	    MenuBar.add(Reprendre);
	    MenuBar.add(Nouveau);
	    MenuBar.add(Quitter);
	    
	    Mineur[1][1]= new JButton();
	    
	    pan.add(MenuBar);
	    pan.add(Mineur[1][1]);
	    
	    pan.setBackground(Color.LIGHT_GRAY);        
	    this.setContentPane(pan);               
	    this.setVisible(true);
	    
	  }
}
