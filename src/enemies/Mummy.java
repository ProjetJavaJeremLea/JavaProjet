package enemies;

import inventory.HealthPotion;
import rpg.Hero;

public class Mummy extends Enemy{
	
	//FIELDS\\
	private final static int StartHealth=80;
	private final static int mummyAttackDamage=30;
	private final static int mummyPotionDropChance=50;
	private final static int mummyLifeDropChance=10;
	private final static int mummyWeaponDropChance=20;
	private static String name="Mummy";

	//CONSTRUCTOR\\
	public Mummy() {
		super(StartHealth, mummyAttackDamage, mummyPotionDropChance,mummyLifeDropChance,mummyWeaponDropChance,name);
		
	}
	
	//METHODS\\
	public void attack(Hero hero){
		int damage =20+rand.nextInt(mummyAttackDamage);
		hero.setHealth(hero.getHealth()-damage);
		System.out.println("\t>> You recieve "+ damage+"in retaliation !");
	}
	
	public void droppedPotion(Hero hero)
	{
		if(rand.nextInt(100)< mummyPotionDropChance){
			HealthPotion potion=new HealthPotion();
			hero.setNumberHealthPotions(hero.getNumberHealthPotions()+1);
			hero.getInventory().add(potion);
			System.out.println(" # The "+this.getName()+" dropped a health potion !! # ");
			System.out.println(" # You have "+hero.getNumberHealthPotions()+" Heamth potion(s). # ");
		}
	}

}
