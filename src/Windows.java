import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JFrame;
public class Windows {
	JFrame fenetre ;
	Plateau plateau;
	Interface panneau;
	public Windows(Plateau plateau){
		this.plateau = plateau;
		this.panneau = new Interface(plateau);
		this.fenetre = new JFrame(); 
		this.fenetre.setResizable(false);
		this.fenetre.setTitle("Attax Game");
		this.fenetre.setSize(this.plateau.hauteur * 50 , this.plateau.largeur * 50);
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.fenetre.add(this.panneau);
		this.fenetre.addMouseListener(this.panneau);
		this.fenetre.setVisible(true);
	}
}