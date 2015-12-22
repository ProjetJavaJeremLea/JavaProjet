package rpg;

import java.util.Scanner;
import enemies.Enemy;

public class Main {
	public static void main(String[] args) {
		
		// System objects
		Scanner sc = new Scanner(System.in);		
		
		Game game = new Game();			//Creation of the game	
		Hero heroPlayer = game.start(); //Creation of the player character to start the game
		
		boolean running =true;

		GAME:
		while(running){
			
			Enemy[] enemies = game.createEnemies(); //Creation of the list of different enemies you can have.
			
			Enemy enemy=game.enemyAppear(enemies);	//Enemy apparition
								
			while(enemy.getEnemyHealth()> 0){		//Battle loop...maybe do a class for it
				
				String choice = heroPlayer.makeChoice(enemy);	//hero make a choice
				
				if(choice.equals("1"))				//Choice 1 --> Attack
				{
					heroPlayer.attack(enemy);//Hero attack
					enemy.attack(heroPlayer);//Enemy attack									
					if(heroPlayer.getHealth()<1)//Check if hero is dead
					{
						System.out.println("______________________________________________");
						System.out.println("\t>> You have taken too much damage, your are too weak to go on... <<");
						break;//exit the loop
					}
				}
				else if(choice.equals("2"))			//Choice 2 --> Drink a health potion
				{
					heroPlayer.drinkPotion(heroPlayer.getInventory());//Drink potion if he can
				}
				else if(choice.equals("3")){
					System.out.println("\t>> You run away from the "+enemy.getName()+"!! <<");
					continue GAME;//Return to the loop called "GAME"
				}
				else{
					System.out.println("\t>> Invalid command... <<");
				}
			}
			
			//////The enemy is dead now or you're dead\\\\\\\\
			
			if(heroPlayer.getHealth()<1)//You're dead
			{
				System.out.println("\t>> You limp out of the dungeon, weak from battle ! <<");
				break; //Exit the loop end of the game
			}
			enemy.dead(heroPlayer);
			String choice=heroPlayer.afterFightChoice();
			
			while(!choice.equals("1") && !choice.equals("2")){
				System.out.println("\tInvalid command...");
				choice=sc.nextLine();
			}

			if (choice.equals("1")){
				System.out.println("\tYou continu the adventure !!");
			}
			else if(choice.equals("2")){
				System.out.println("\tYou left the Dungeon !");
				break;
			}
		}
		
		game.gameEnd();
	
	}

}

