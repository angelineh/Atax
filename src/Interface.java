import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class Interface extends JPanel implements MouseListener{
	Plateau plateau;
	public Interface(Plateau plateau){
		this.plateau = plateau;
	}
	public void paintComponent(Graphics g){
		for(int i = 0; i < plateau.hauteur ; i++){
			for(int j=0;j<plateau.largeur;j++){
				g.drawImage(this.plateau.base_material, i*50, j*50, this);
				if(plateau.positions[i][j]== 1){
					g.drawImage(this.plateau.white_side, i*50, j*50, this);
				}
				if(plateau.positions[i][j]== 2){
					g.drawImage(this.plateau.black_side, i*50, j*50, this);
				}
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.plateau.positions[(int) (e.getX()/50)][(int) (e.getY()/50)]=(this.plateau.positions[(int) (e.getX()/50)][(int) (e.getY()/50)]+1)%3 ;
		this.repaint();
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub


	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
