package rpg;

import java.util.Random;
import java.util.Scanner;

import accessory.Armor;
import accessory.HealthPotion;
import accessory.Potion;
import gameCharacters.Anubis;
import gameCharacters.Enemy;
import gameCharacters.Hero;
import gameCharacters.Mummy;
import gameCharacters.Pharaoh;
import gameCharacters.Snake;
import gameCharacters.Spider;

public class Round { //1 round  = 1 enemy
	
	private Boolean endRound;
	private Boolean endGame;
	Random rand = new Random();
	Scanner sc = new Scanner(System.in);
	
	
	// CONSTRUCTEUR D UN TOUR
	public Round(){	
		this.endRound=false;
		this.endGame=false;
	}
	//GETTERS AND SETTERS
	public Boolean getEndRound() {
		return endRound;
	}
	public void setEndRound(Boolean endRound) {
		this.endRound = endRound;
	}
	public Boolean getEndGame() {
		return endGame;
	}
	public void setEndGame(Boolean endGame) {
		this.endGame = endGame;
	}
	//CREATION OF ENEMIES
	public Enemy[] createEnemies(int level){ 
		Enemy spider = new Spider();
		Enemy snake = new Snake();
		Enemy mummy = new Mummy();
		Enemy pharaoh = new Pharaoh();
		Enemy anubis = new Anubis();
	
		if ((level==0)||(level==1)){ 
			Enemy[] enemies={spider};
			return enemies;
		} else if ((level==2)||(level==3)){
			Enemy[] enemies={spider,snake};
			return enemies;
		} else if (level==4){
			Enemy[] enemies={spider,snake,mummy};
			return enemies;
		} else if(level==5)	{
			Enemy[] enemies={snake,mummy};
			return enemies;
		} else if ((level==6)||(level==7)){
			Enemy[] enemies={snake,mummy,pharaoh};
			return enemies;
		} else if (level==8){
			Enemy[] enemies={mummy,pharaoh};
			return enemies;
		} else if (level==9){
			Enemy[] enemies={pharaoh,anubis};
			return enemies;
		} else {
			Enemy[] enemies={anubis};
			return enemies;
		}
	}

	// AN ENEMY APPEARS
	public Enemy enemyAppear(Hero heroPlayer, Enemy[] enemies){
		System.out.println("_____________________________________________\n");
		Enemy enemy= enemies[rand.nextInt(enemies.length)];// est-ce que c'est pas length - 1
		System.out.println("Level "+heroPlayer.getLevel());
		System.out.println("\t>>A(n) " + enemy.getType() + " is on your way !!<< \n");
		return enemy;
	}

	// THE PLAYER HAVE TO DO AN ACTION CHOICE
	public int makeChoice(Hero heroPlayer, Enemy enemy){
		System.out.println("\tYour Health:"+heroPlayer.gethP());
		System.out.println("\tYour Brave points:"+heroPlayer.getBrave());
		System.out.println("\t"+enemy.getType()+"'s Health :"+enemy.gethP()+"\n");
		System.out.println("\tWhat do you want to do ?!");
		System.out.println("\t1. Attack this enemy");
		System.out.println("\t2. Run far far away !");
		
		if (heroPlayer.getNbPotions()>0){
			System.out.println("\t3. Drink health potion");
		} 
		
		int choice = sc.nextInt();
		return choice;
	}
	
	// ACTION CHOICE WHEN THE ENEMY IS DEAD
	public int afterFightChoice(){
		System.out.println("______________________________________________\n");
		System.out.println("\tWhat would you like to do ?!");
		System.out.println("\t1. Fight again");
		System.out.println("\t2. Exit the Pyramid");
		
		int input = sc.nextInt();
		return input;
	}
	
	// DEATH OF THE ENEMY
	public void enemyDeath(Hero heroPlayer, Enemy enemy){
		heroPlayer.increaseXP(enemy.getXpGiven());
		System.out.println("______________________________________________\n");
		System.out.println("\t# "+enemy.getType()+" was defeated !! # ");
		System.out.println("\t# You have "+heroPlayer.gethP()+" HP left.   # ");
		System.out.println("\t# You have "+heroPlayer.getxP()+" XP now.    # ");
		System.out.println("______________________________________________\n");
		//Potions, weapon, armor
		if (enemy.givePotion(heroPlayer)){
			
		}
		System.out.println(" \tYou have "+heroPlayer.getNbPotions()+" potions left. ");
		enemy.giveWeapon(heroPlayer);	
	}
	
	// FONCTIONS CALLED BY THE GAME !!!!!!
	public Enemy beginRound(Hero heroPlayer){
		Enemy[] enemies = this.createEnemies(heroPlayer.getLevel());
		Enemy myEnemy = this.enemyAppear(heroPlayer,enemies);
		return myEnemy;
	}
	
	public void choicesAndActions(Hero heroPlayer, Enemy enemy){
		
			while((enemy.gethP()> 0)&&(!this.getEndRound())){		//Battle loop...
				
				int choice = this.makeChoice(heroPlayer,enemy);		//hero make a choice
				
				if(choice==1)				//Choice 1 --> Attack
				{
					Armor armor = new Armor(); //Armor activation
					
					if (heroPlayer.getNbArmors()>0){
						System.out.println("\tYou have an Armor, what do you want to do ?");
						System.out.println("\t1. Use it!");
						System.out.println("\t2. Continue without armor.");
						int choiceArmor = sc.nextInt();
						
						if (choiceArmor==1){
							heroPlayer.reduceArmors();
							armor.activateArmor(); //is activate vaut true
						} 									
					}
					
					heroPlayer.heroAttack(enemy); //Hero attack
					System.out.println("\t-------------------------------------");
					System.out.println("\t>> You strike the "+enemy.getType()+" for "+heroPlayer.getStrength()+" damage !");
					System.out.println("\t>> with "+heroPlayer.getWeapon().getType());
					
					if (!armor.getIsActivate()&&enemy.gethP()>0){
						enemy.enemyAttack(heroPlayer);//Enemy attack if hero haven't armor									
					}
					System.out.println("\t-------------------------------------\n");


					if (heroPlayer.dead()) {
						System.out.println("\t>> You limp out of the Pyramid, weak from battle !\n");
						this.setEndRound(true);
						this.setEndGame(true);
						//ne sort pas de la boucle va sur makechoice
					}
					
				}
				
				else if(choice==2){
						System.out.println("\t-------------------------------------");
						System.out.println("\t>> You run away from the "+enemy.getType()+"!! ");
						heroPlayer.reduceBrave();
						System.out.println("\t>> You lose 5 points of brave... ");
						System.out.println("\t-------------------------------------\n");

					
						if (heroPlayer.coward()) {
							System.out.println("\t>> You are a coward, Go away ! \n");
							this.setEndRound(true);
							this.setEndGame(true);	
						//attention ne sort pas de la boucle
						}
					
						this.setEndRound(true);
					}
				
					else if(choice==3)			//Choice 3 --> Drink a health potion
						{
							if (heroPlayer.getNbPotions()>0){
								
							Potion healthPotion = new HealthPotion();
							heroPlayer.reducePotions();
							heroPlayer.increaseHP(healthPotion.getStrength()); //Drink potion if you can
							System.out.println("\t-------------------------------------");
							System.out.println("\t>> You drink a health potion, healting yourself for "+healthPotion.getStrength()+".");
							System.out.println("\t>> You now have "+heroPlayer.gethP()+" Hp.");
							System.out.println("\t>> You have "+heroPlayer.getNbPotions()+ " health potions left.");
							System.out.println("\t-------------------------------------\n");
							}
							else System.out.println("\tSorry, you don't have any potion.\n");
						} 
				
						else {
								System.out.println("\t>>Invalid command... ");
								//return to the choice
						}
			} //end loop
			
			if (enemy.gethP()<=0){
				this.enemyDeath(heroPlayer,enemy); // THE ENEMY IS DEAD
				
				heroPlayer.heroLevel();
			}
			
			if (!this.getEndGame()){
				
				int choiceTwo = this.afterFightChoice(); // CONTINUE OR EXIT if continue, boucle la m�thode choicesandactions
				
				while(choiceTwo!=1 && choiceTwo!=2){
					System.out.println("\tInvalid command...");
					choiceTwo=sc.nextInt();
				}
				if (choiceTwo==1){
					System.out.println("\tYou continue the adventure !!");
					this.setEndRound(true); 
				}
				else {
					System.out.println("\tYou left the Pyramid !"); 
					this.setEndRound(true);
					this.setEndGame(true);
					// fin du jeu 
				}
			}
		}
}