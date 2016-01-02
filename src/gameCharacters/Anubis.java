package gameCharacters;

import java.util.Random;

import accessory.TypeAccessory;
import accessory.Weapon;

public class Anubis extends Enemy{

	Random rand = new Random();
	
	public Anubis() {
		super("Anubis",300, 120, 80, 90, 50, 200);
	}
	
	public void enemyAttack(Hero heroPlayer){
		int damage = super.randInt(this.getMinAttackDamage(), this.getMaxAttackDamage());
		heroPlayer.reduceHP(damage);
		System.out.println("\t>> and you lose "+damage+" HP.");
	}

	// WHEN ANUBIS IS DEAD:
	
	public void giveWeapon(Hero heroPlayer){
		Random rand= new Random();
		int numBetween0and100 = rand.nextInt(100);

			if (numBetween0and100<=this.getProbabilityDropWeapon()){
				System.out.println("\tYes, a magic weapon !");
				System.out.println("\tYou are stronger with this one now.\n");
				Weapon weapon= new Weapon(TypeAccessory.magicSword);
				heroPlayer.addinInventory(weapon);
				
		}
	}
}
