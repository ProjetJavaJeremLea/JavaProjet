package enemies;

import inventory.HealthPotion;
import rpg.Hero;

public class Anubis extends Enemy{
	
	//FIELDS\\
	private final static int StartHealth=150;
	private final static int anubisAttackDamage=40;
	private final static int anubisPotionDropChance=80;
	private final static int anubisLifeDropChance=50;
	private final static int anubisWeaponDropChance=30;
	private static String name="Anubis";
	
	//CONSTRUCTOR\\
	public Anubis() {
		super(StartHealth, anubisAttackDamage, anubisPotionDropChance, anubisLifeDropChance, anubisWeaponDropChance,name);
	}

	//METHODS\\
	public void attack(Hero hero){
		int damage =40+rand.nextInt(anubisAttackDamage);
		hero.setHealth(hero.getHealth()-damage);
		System.out.println("\t>> You recieve "+ damage+"in retaliation !");
	}
	
	public void droppedPotion(Hero hero)
	{
		if(rand.nextInt(100)< anubisPotionDropChance){
			HealthPotion potion=new HealthPotion();
			hero.setNumberHealthPotions(hero.getNumberHealthPotions()+1);
			hero.getInventory().add(potion);
			System.out.println(" # The "+this.getName()+" dropped a health potion !! # ");
			System.out.println(" # You have "+hero.getNumberHealthPotions()+" Heamth potion(s). # ");
		}
	}
	
}
