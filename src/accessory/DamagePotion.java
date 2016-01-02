package accessory;

import java.util.Random;

public class DamagePotion extends Potion {

	
	private static Random rand = new Random();
	//GETTERS AND SETTERS
	
	public DamagePotion() {
		super(TypeAccessory.damagePotion);
		super.setStrength(rand.nextInt(100));
	}

}
