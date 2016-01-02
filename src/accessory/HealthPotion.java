package accessory;

import java.util.Random;

public class HealthPotion extends Potion{

	
	 private static Random rand = new Random();
	//GETTERS AND SETTERS

	public HealthPotion() {
		super(TypeAccessory.healthPotion);
		super.setStrength(rand.nextInt(100));
	}
	
	

	
}
