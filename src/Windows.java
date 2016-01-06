import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JFrame;
public class Windows extends JFrame{
	JFrame fenetre ;
	Plateau plateau;
	Interface panneau;
	
	private JMenuBar menuBar = new JMenuBar();
        private JMenu test1 = new JMenu("Fichier");
        private JMenu test2 = new JMenu("Affichage");
        private JMenuItem item1 = new JMenuItem("Commencer partie");
        private JMenuItem item2 = new JMenuItem("Finir partie");
        private JMenuItem item3 = new JMenuItem("Selectionner joueur");
        this.test1.add(item1);
        this.test1.add(item2);
        this.test2.add(item3);
        this.menuBar.add(test1);
        this.menuBar.add(test2);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
        
        item3.addActionListener(new ActionListener(){
        
                public void actionPerformed(ActionEvent arg0) {
                JOptionPane jop = new JOptionPane();
                }
        }
        
        public static void main(String[] args) {
        JOptionPane jop = new JOptionPane();
        String nom = jop.showInputDialog(null, "Nom du joueur", "Selectionner joueur", JOptionPane.QUESTION_MESSAGE);
        }
        
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
