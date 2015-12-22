package enemies;

import inventory.HealthPotion;
import rpg.Hero;

public class Pharaoh extends Enemy{

	//FIELDS\\
	private final static int StartHealth=110;
	private final static int pharaohAttackDamage=30;
	private final static int pharaohPotionDropChance=70;
	private final static int pharaohLifeDropChance=20;
	private final static int pharaohWeaponDropChance=5;
	private static String name="Pharaoh";
	
	//CONSTRUCTOR\\
	public Pharaoh() {
		super(StartHealth, pharaohAttackDamage, pharaohPotionDropChance, pharaohLifeDropChance, pharaohWeaponDropChance,name);
	}

	//METHODS\\
	public void attack(Hero hero){
		int damage =30+rand.nextInt(pharaohAttackDamage);
		hero.setHealth(hero.getHealth()-damage);
		System.out.println("\t>> You recieve "+ damage+"in retaliation !");
	}
	
	public void droppedPotion(Hero hero)
	{
		if(rand.nextInt(100)< pharaohPotionDropChance){
			HealthPotion potion=new HealthPotion();
			hero.setNumberHealthPotions(hero.getNumberHealthPotions()+1);
			hero.getInventory().add(potion);
			System.out.println(" # The "+this.getName()+" dropped a health potion !! # ");
			System.out.println(" # You have "+hero.getNumberHealthPotions()+" Heamth potion(s). # ");
		}
	}

}
