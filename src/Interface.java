import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class Interface extends JPanel implements MouseListener{
	Plateau plateau;
	int positionY;
	public Interface(Plateau plateau,int positionY){
		this.plateau = plateau;
		this.positionY = positionY;

	}
	public void paintComponent(Graphics g){
		for(int i = 0; i < plateau.largeur ; i++){
			for(int j=0;j<plateau.largeur;j++){
				g.drawImage(this.plateau.base_material, i*50, j*50, this);
				if(plateau.wait){
					g.drawImage(this.plateau.selected_image, plateau.selected[0]*50,plateau.selected[1]*50, this);
				}
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
		int absoluteY = (e.getY()-positionY) / 50, absoluteX = e.getX()/50;
		if(plateau.nextMove(absoluteX, absoluteY)){
			this.repaint();
		}else{
			System.out.println("your move is not correct, please chose an other direction");
			this.repaint();
		}
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
