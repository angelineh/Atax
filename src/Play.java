
public class Play {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Joueur player1 = new Joueur(false);
		Joueur player2 = new Joueur(false);
		Plateau plateau = new Plateau(10,10);
		Windows windows = new Windows(plateau);
		Jeu partie = new Jeu(player1, player2, windows);
	}

}
