package enemies;

import java.util.Random;

import rpg.Hero;

public abstract class Enemy {
	
	//FIELDS\\
	private int enemyHealth;
	private int enemyAttackDamage;
	private int potionDropChance;
	private int lifeDropChance;
	private int weaponDropChance;
	private String name;
	Random rand = new Random();

	//CONSTRUCTOR\\
	public Enemy(int maxEnemyHealth, int enemyAttackDamage, int potionDropChance, int lifeDropChance,
			int weaponDropChance, String name) {
		this.enemyHealth = maxEnemyHealth;
		this.enemyAttackDamage = enemyAttackDamage;
		this.potionDropChance = potionDropChance;
		this.lifeDropChance = lifeDropChance;
		this.weaponDropChance = weaponDropChance;
		this.name=name;
	}

	//GETTERS & SETTERS\\
	public int getEnemyHealth() {
		return enemyHealth;
	}
	public void setEnemyHealth(int maxEnemyHealth) {
		this.enemyHealth = maxEnemyHealth;
	}
	public int getEnemyAttackDamage() {
		return enemyAttackDamage;
	}
	public void setEnemyAttackDamage(int enemyAttackDamage) {
		this.enemyAttackDamage = enemyAttackDamage;
	}
	public int getPotionDropChance() {
		return potionDropChance;
	}
	public void setPotionDropChance(int potionDropChance) {
		this.potionDropChance = potionDropChance;
	}
	public int getLifeDropChance() {
		return lifeDropChance;
	}
	public void setLifeDropChance(int lifeDropChance) {
		this.lifeDropChance = lifeDropChance;
	}
	public int getWeaponDropChance() {
		return weaponDropChance;
	}
	public void setWeaponDropChance(int weaponDropChance) {
		this.weaponDropChance = weaponDropChance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	//METHODS\\
	public abstract void droppedPotion(Hero hero);
	public abstract void attack(Hero hero);
	
	public void dead(Hero hero){
		System.out.println("______________________________________________");
		System.out.println(" # "+this.getName()+" was defeated !! # ");
		System.out.println(" # You have "+hero.getHealth()+" HP left. # ");
		System.out.println("______________________________________________");
		this.droppedPotion(hero);	
	};

}
