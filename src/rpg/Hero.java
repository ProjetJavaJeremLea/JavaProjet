package rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import enemies.Enemy;
import inventory.Accessory;
import inventory.HealthPotion;

public class Hero {
	
	//FIELDS\\
	private String playerName;
	private int health;
	private int maxAttackDamage;
	private int numberHealthPotions;
	private int level;
	Random rand = new Random();
	Scanner sc = new Scanner(System.in);
	private ArrayList<Accessory> inventory = new ArrayList<Accessory>();
	HealthPotion potion1 = new HealthPotion();
	HealthPotion potion2 = new HealthPotion();
	HealthPotion potion3 = new HealthPotion();
	
	//CONSTRUCTOR\\
	public Hero(String playerName) {
		this.playerName = playerName;
		inventory.add(potion1);
		inventory.add(potion2);
		inventory.add(potion3);
		health= 100;
		maxAttackDamage=30;
		numberHealthPotions=3;
		level = 0;
	}
	
	//GETTERS & SETTERS\\
	public int getHealth() {
		return health;
	}
	public int getMaxAttackDamage() {
		return maxAttackDamage;
	}
	public int getNumberHealthPotions() {
		return numberHealthPotions;
	}
	public int getLevel() {
		return level;
	}
	public String getPlayerName() {
		return playerName;
	}
	public ArrayList<Accessory> getInventory() {
		return inventory;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void setNumberHealthPotions(int numberHealthPotions) {
		this.numberHealthPotions = numberHealthPotions;
	}
	
	//METHODS\\
	public void attack(Enemy enemy){
		int damage =20+rand.nextInt(maxAttackDamage);
		enemy.setEnemyHealth(enemy.getEnemyHealth()-damage);
		System.out.println("\t>> You strique the "+enemy.getName()+" for "+damage+" damage !");
	}
	
	public void drinkPotion(List<Accessory> inventory)
	{
		if(this.getNumberHealthPotions() >0)
		{
			HealthPotion potion = (HealthPotion) inventory.get(inventory.size()-1);
			this.setHealth(this.getHealth() + potion.getHealthBonus());
			inventory.remove(inventory.get(inventory.size()-1));
			numberHealthPotions--;
			System.out.println("\t>> You drink a health potion, healting yourself for"+potion.getHealthBonus() + "\n\t>> You now have "+health+" Hp. +\n\t>> You have "+this.getNumberHealthPotions()+ "health potions left.\n");
		}
		else{
			System.out.println("\t>> You have no health potions left !! Defeat enemies for a chance to get one !");
		}
	}
	
	public String makeChoice(Enemy enemy){
		System.out.println("\tYour Health:"+this.getHealth());
		System.out.println("\t"+enemy.getName()+"'s Health :"+enemy.getEnemyHealth());
		System.out.println("\tWhat do you want to do ?!");
		System.out.println("\t1. Attack");
		System.out.println("\t2. Drink health potion");
		System.out.println("\t3. Run away !");

		String input = sc.nextLine();
		return input;
	}

	public String afterFightChoice(){
		System.out.println("______________________________________________");
		System.out.println("What would you like to do ?!");
		System.out.println("\t1. Continue fighting");
		System.out.println("\t2. Exit the Dungeon");
		
		String input = sc.nextLine();
		return input;
	}



	
	
}
