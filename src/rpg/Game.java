package rpg;

import java.util.Random;
import java.util.Scanner;

import enemies.Anubis;
import enemies.Enemy;
import enemies.Mummy;
import enemies.Pharaoh;
import enemies.Snake;
import enemies.Spider;

public class Game {

	//FIELDS\\
	private Enemy Spider;
	private	Enemy Snake;
	private	Enemy Mummy;
	private	Enemy Pharaoh;
	private	Enemy Anubis;
	private Hero heroPlayer;
	Random rand = new Random();	
	Scanner sc = new Scanner(System.in);

	//METHODS
	public Hero start(){
		System.out.println("    ##                              ##");
		System.out.println("   ####   Welcome To The Pyramid   ####");
		System.out.println("  ######       Of The Dead !      ######");
		System.out.println("______________________________________________");
		System.out.println("Enter Your NAME to enter in The Pyramide:");
		String name = sc.nextLine();
		heroPlayer = new Hero(name);
		return heroPlayer;
	}
	
	public Enemy[] createEnemies(){
		Spider = new Spider();
		Snake = new Snake();
		Mummy = new Mummy();
		Pharaoh = new Pharaoh();
		Anubis = new Anubis();
		Enemy[] enemies={Spider,Snake,Mummy,Pharaoh,Anubis};
		return enemies;
	}
	
	public Enemy enemyAppear(Enemy[] enemies){
		System.out.println("______________________________________________");
		Enemy enemy= enemies[rand.nextInt(enemies.length)];
		System.out.println("\t >>A(n) " + enemy.getName() + " is on your way !!<< \n");
		return enemy;
	}
	
	public void gameEnd(){
		System.out.println("______________________________________________");

		System.out.println("\t#########################");
		System.out.println("\t# THANK YOU FOR PLAYING #");
		System.out.println("\t#########################");	
	}

}
