package enemies;

import inventory.HealthPotion;
import rpg.Hero;

public class Spider extends Enemy{
	
	//FIELDS\\
	private final static int StartHealth=20;
	private final static int spiderAttackDamage=18;
	private final static int spiderPotionDropChance=0;
	private final static int spiderLifeDropChance=0;
	private final static int spiderWeaponDropChance=0;
	private static String name="Spider";
	
	//CONSTRUCTOR\\
	public Spider() {
		super(StartHealth, spiderAttackDamage, spiderPotionDropChance, spiderLifeDropChance, spiderWeaponDropChance,name);
	}
	
	//METHODS\\
	public void attack(Hero hero){
		int damage =2+rand.nextInt(spiderAttackDamage);
		hero.setHealth(hero.getHealth()-damage);
		System.out.println("\t>> You recieve "+ damage+"in retaliation !");
	}

	public void droppedPotion(Hero hero)
	{
		if(rand.nextInt(100)< spiderPotionDropChance){
			HealthPotion potion=new HealthPotion();
			hero.setNumberHealthPotions(hero.getNumberHealthPotions()+1);
			hero.getInventory().add(potion);
			System.out.println(" # The "+this.getName()+" dropped a health potion !! # ");
			System.out.println(" # You have "+hero.getNumberHealthPotions()+" Heamth potion(s). # ");
		}
	}
}
