package rpg;

import gameCharacters.Enemy;
import gameCharacters.Hero;

public class Game { // 1 game = 1 player
	
	private Boolean endGame;
		
	public Game(){
		this.endGame=false;
	}
	
	//GETTERS AND SETTERS
	public Boolean getEndGame() {
		return endGame;
	}
	public void setEndGame(Boolean endGame) {
		this.endGame = endGame;
	}
	
	public void beginGame(){
		
		System.out.println("    ##                              ##");
		System.out.println("   ####   Welcome To The Pyramid   ####");
		System.out.println("  ######       Of The Death !     ######");
		System.out.println("___________________________________________\n");
		System.out.println("Add Your NAME to enter in The Pyramid:");
		
		Hero heroPlayer = new Hero(); // Ask for the name and create the hero with
		
		System.out.println("\nDear "+heroPlayer.getHeroName()+",");
		System.out.println("You have "+heroPlayer.gethP()+" HP to begin the game.");
		System.out.println("The pyramid offers you 3 health potions.");
		System.out.println("Good luck! \n");
		// RAJOUTER PRESS ENTER TO CONTINUE
				
		while (!this.getEndGame()){
		
			Round round = new Round();

			while(!round.getEndRound()){
				Enemy theEnemy = round.beginRound(heroPlayer);
				round.choicesAndActions(heroPlayer,theEnemy);
			}
			System.out.println("\tEnd of the round"); //faire un compteur de round?	
			this.setEndGame(round.getEndGame());
		}
		System.out.println("\tEnd of the game");

	}

	// end quand mort ou courage=0 ou exit faire un truc un peu mieux
	// end quand xp = 3600 environ A FAIRE
	
	

}
