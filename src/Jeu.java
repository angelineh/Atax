
public class Jeu {

	public Joueur firstPlayer;
	public Joueur secondPlayer;
	public Plateau plateau;
	public Boolean GameOver = false;
	public Windows vue;

	public Jeu(Joueur firstPlayer,Joueur secondePlayer, Windows vue){
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		this.plateau = plateau;
		this.vue = vue;
	}

	public void CommencerPartie(){
	}

	public void FinirPartie() {
	}

	public void CommencerTour(int i, int j) {
		//To complete
	}

}