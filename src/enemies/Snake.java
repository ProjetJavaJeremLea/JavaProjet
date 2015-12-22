package enemies;

import inventory.HealthPotion;
import rpg.Hero;

public class Snake extends Enemy {
	
	//FIELDS\\
	private final static int StartHealth=30;
	private final static int snakeAttackDamage=24;
	private final static int snakePotionDropChance=20;
	private final static int snakeLifeDropChance=5;
	private final static int snakeWeaponDropChance=0;
	private static String name="Snake";

	//CONSTRUCTOR\\
	public Snake() {
		super(StartHealth, snakeAttackDamage, snakePotionDropChance, snakeLifeDropChance, snakeWeaponDropChance,name);
	}
	
	//METHODS\\
	public void attack(Hero hero){
		int damage =6+rand.nextInt(snakeAttackDamage);
		hero.setHealth(hero.getHealth()-damage);
		System.out.println("\t>> You recieve "+ damage+"in retaliation !");
	}
	
	public void droppedPotion(Hero hero)
	{
		if(rand.nextInt(100)< snakePotionDropChance){
			HealthPotion potion=new HealthPotion();
			hero.setNumberHealthPotions(hero.getNumberHealthPotions()+1);
			hero.getInventory().add(potion);
			System.out.println(" # The "+this.getName()+" dropped a health potion !! # ");
			System.out.println(" # You have "+hero.getNumberHealthPotions()+" Heamth potion(s). # ");
		}
	}

}
