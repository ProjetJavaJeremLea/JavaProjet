package gameCharacters;

import java.util.Random;

import accessory.TypeAccessory;
import accessory.Weapon;

public class Snake extends Enemy{

	Random rand = new Random();
	
	public Snake() {
		super("Snake",40, 30, 10, 20, 20, 20);
	}

	public void enemyAttack(Hero heroPlayer){
		int damage = super.randInt(this.getMinAttackDamage(), this.getMaxAttackDamage());
		heroPlayer.reduceHP(damage);
		System.out.println("\t>> and you lose "+damage+" HP.");	}
	
	// WHEN SNAKE IS DEAD:

		
		public void giveWeapon(Hero heroPlayer){
			Random rand= new Random();
			int numBetween0and100 = rand.nextInt(100);
				if (numBetween0and100<=this.getProbabilityDropWeapon()){
					//heroPlayer.changeSword(TypeWeapon.steelSword);
					System.out.println("\tYes, a weapon in steel!");
					System.out.println("\tYou are stronger with this one now.\n");
					Weapon weapon= new Weapon(TypeAccessory.steelSword);
					heroPlayer.addinInventory(weapon);
			}
		}
}
