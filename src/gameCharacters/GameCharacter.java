package gameCharacters;

import java.util.Random;

public class GameCharacter { //pas mis en abstract car j'arrivais pas à aller chercher l'attribut hp dans les sous classes

	private int hP;
	
	
	public GameCharacter(int hP) {
		this.hP = hP;
	}

	public int gethP() {
		return hP;
	}
	public void sethP(int hP) {
		this.hP = hP;
	}	
	
	//FONCTION RANDOM BETWEEN 2 INT (ou la mettre)
	public static int randInt(int min, int max) {
		
	    Random rand = new Random();

	    return rand.nextInt(max - min) + min;

	}
}
