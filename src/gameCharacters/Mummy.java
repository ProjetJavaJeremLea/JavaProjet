package gameCharacters;

import java.util.Random;

import accessory.TypeAccessory;
import accessory.Weapon;

public class Mummy extends Enemy{

	Random rand = new Random();
	
	public Mummy() {
		super("Mummy",80, 60, 30, 60, 10,40);
	}

	public void enemyAttack(Hero heroPlayer){
		int damage = super.randInt(this.getMinAttackDamage(), this.getMaxAttackDamage());
		heroPlayer.reduceHP(damage);
		System.out.println("\t>> and you lose "+damage+" HP.");	}
	
	// WHEN MUMMY IS DEAD:
		
		public void giveWeapon(Hero heroPlayer){
			Random rand= new Random();
			int numBetween0and100 = rand.nextInt(100);

				if (numBetween0and100<=this.getProbabilityDropWeapon()){
					System.out.println("\tYes, a weapon in gold!");
					System.out.println("\tYou are stronger with this one now.\n");
					Weapon weapon= new Weapon(TypeAccessory.goldSword);
					heroPlayer.addinInventory(weapon);
		
			}

		}
}
