
import java.util.Vector;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Plateau{
	public BufferedImage black_side;
	public BufferedImage white_side;
	public BufferedImage base_material;
	public Integer hauteur;
	public Integer largeur;
	public int[][] positions;
	
	public Plateau(int hauteur,int largeur){
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.positions = new int[hauteur][largeur];
		try {
		    this.black_side = ImageIO.read(new File("src/media/black.png"));
		    this.white_side = ImageIO.read(new File("src/media/white.png"));
		    this.base_material = ImageIO.read(new File("src/media/baseMetal.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.print("Some images file are missings, please check "
					+ "there existing before reloading the game");
		}
	}

	public int getHauteur() {
		return hauteur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void AfficherCaseDisponible(){

	}

}

