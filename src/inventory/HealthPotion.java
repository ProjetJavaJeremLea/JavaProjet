package inventory;
import java.util.Random;


public class HealthPotion extends Accessory{
	
	//FIELDS\\
	Random rand = new Random();
	private int healthBonus;

	//CONSTRUCTOR\\
	public HealthPotion() {
		this.healthBonus = 15+rand.nextInt(15);
	}

	//GETTERS & SETTERS\\
	public int getHealthBonus() {
		return healthBonus;
	}	
}
