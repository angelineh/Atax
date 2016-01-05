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
		panneau = new Interface(plateau,0);
		panneau.setPreferredSize(new Dimension(plateau.hauteur * 50 , plateau.largeur * 50));
		setTitle("Attax Game");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panneau);
		addMouseListener(panneau);
		pack();
		setPanneauPosition();
		setLocationByPlatform(true);
		setVisible(true);
	}
	public void setPanneauPosition(){
		panneau.positionY = getHeight() - plateau.hauteur * 50;
	}
}