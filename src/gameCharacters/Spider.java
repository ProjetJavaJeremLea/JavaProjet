package gameCharacters;

import java.util.Random;

import accessory.TypeAccessory;
import accessory.Weapon;

public class Spider extends Enemy{

	Random rand = new Random();
	
	public Spider() {
		super("Spider",20, 10, 0, 15, 50, 15);
	}

	public void enemyAttack(Hero heroPlayer){
		int damage = super.randInt(this.getMinAttackDamage(), this.getMaxAttackDamage());
		heroPlayer.reduceHP(damage);
		System.out.println("\t>> and you lose "+damage+" HP.");
	}
	
	// WHEN SPIDER IS DEAD:

		
		public void giveWeapon(Hero heroPlayer){
			Random rand= new Random();
			int numBetween0and100 = rand.nextInt(100);

				if (numBetween0and100<=this.getProbabilityDropWeapon()){
					System.out.println("\tYes, a weapon in stone!");
					System.out.println("\tYou are stronger with this one now.\n");
					Weapon weapon= new Weapon(TypeAccessory.stoneSword);
					heroPlayer.addinInventory(weapon);
			}
		}
}
