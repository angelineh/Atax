import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JFrame;
public class Windows extends JFrame{
	JFrame fenetre ;
	Plateau plateau;
	Interface panneau;
	public Windows(Plateau plateau){
		//Cette classe permet de faire des changements sur les fenêtres.
		this.plateau = plateau;
		this.panneau = new Interface(plateau,0);
		this.panneau.setPreferredSize(new Dimension(this.plateau.hauteur * 50 , this.plateau.largeur * 50));
		this.setTitle("Attax Game");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(this.panneau);
		this.addMouseListener(this.panneau);
		this.pack();
		this.setPanneauPosition();
		this.setVisible(true);
	}
	public void setPanneauPosition(){
		this.panneau.positionY = this.getHeight() - this.plateau.hauteur * 50;
	}
}