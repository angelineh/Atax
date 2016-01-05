
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
	public BufferedImage selected_image;
	public BufferedImage wrong_image;
	public Boolean role = false;
	public Integer hauteur;
	public Integer largeur;
	public Boolean wait = false;// ce boolean veut dire que l'utilisateur à choisi le point qu'il veut bouger et qu'il attend à ce qu'il le bouge
	public int[][] positions;
	public int[] selected = new int[2];


	public Plateau(int hauteur,int largeur){
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.positions = new int[hauteur][largeur];
		try {
			this.black_side = ImageIO.read(new File("src/media/black.png"));
			this.white_side = ImageIO.read(new File("src/media/white.png"));
			this.base_material = ImageIO.read(new File("src/media/baseMetal.png"));
			this.selected_image = ImageIO.read(new File("src/media/selected.png"));
			this.wrong_image = ImageIO.read(new File("src/media/wrong.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.print("Some images file are missings, please check "
					+ "there existing before reloading the game");
		}
		this.initiateTheGame();
	}

	public int getHauteur() {
		return hauteur;
	}

	public int getLargeur() {
		return largeur;
	}
	public void initiateTheGame(){
		positions[0][0]=1;
		positions[hauteur-1][largeur-1]=1;
		positions[0][largeur-1]=2;
		positions[hauteur-1][0]=2;
	}
	public Boolean nextMove(int positionX,int positionY){
		if(wait){
			if(this.updateTheVue(positionX, positionY)){
				this.role = !this.role;
				this.wait =! this.wait;
				return true;
			}else{

				return false;
			}
		}else{
			if(this.setSelected(positionX, positionY)){
				this.wait =! this.wait;
				return true;
			}else{
				return false;
			}
		}
	}
	public Boolean updateTheVue(int x, int y ){
		// c'est ce vue qui doit s'occuper de l'update des vues,
		if(Math.max(Math.abs(selected[0]-x), Math.abs(selected[1]-y))==1 && positions[x][y]==0){
			this.setVoisin(role?1:2,x,y);
			return true;
		}else if(Math.abs(selected[0]-x)==2 && Math.abs(selected[1]-y)==2  && positions[x][y]==0){
			this.setVoisin(role?1:2,x,y);
			positions[selected[0]][selected[1]]=0;
			return true;
		}else{
			return false;
		}
	}
	// Permet d'identifier le point choisis
	public Boolean setSelected(int x, int y){
		if(this.hasPermissionToPlay(x, y)){
			this.selected[0]=x;this.selected[1]=y;
			return true;
		}
		return false;
	}
	public Boolean hasPermissionToPlay(int x,int y){
		return role && positions[x][y]==1 || !role && positions[x][y]== 2;
	}
	public void setVoisin(int value, int x, int y){
		int X = x-1, Y=y-1;
		positions[x][y]=value;
		for(int i = 0; i < 3; i++){
			for(int j=0; j<3;j++){
				if(this.inPlateau(X+i, Y+j)){
					if(positions[X+i][Y+j]>0){
						positions[X+i][Y+j]=value;
					}
				}
			}
		}
	}
	public Boolean inPlateau(int x, int y){
		return x >=0 && x < largeur && y >=0 && y < hauteur;
	}
	public Boolean isOver(){
		for(int i = 0; i < largeur; i++){
			for(int j=0; j<hauteur;j++){
				if(positions[i][j]==0 && this.hasNeighberHoudWithValue(role?1:2, i, j)){
					return true;
				}
			}
		}
		return false;
	}
	public Boolean hasNeighberHoudWithValue(int value, int x,int y){
		int X = x-1, Y=y-1;
		for(int i = 0; i < 3; i++){
			for(int j=0; j<3;j++){
				if(this.inPlateau(X+i, Y+j)){
					if(positions[X+i][Y+j] == value && i != 1 && j!=1){
						return true;
					}
				}
			}
		}
		return false;
	}
}

