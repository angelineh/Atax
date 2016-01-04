import java.util.Vector;

import org.omg.CosNaming.IstringHelper;

public class Joueur {

  public Boolean JoueurHumain;
  public Joueur(Boolean IsAHumain){
	  this.JoueurHumain =  IsAHumain;
  }
    /*public Vector  myJeu;
    public Vector  myJeu;*/
  public Boolean hasRightToPlay(){
	  return true;
  }
    
}