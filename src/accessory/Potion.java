package accessory;

import java.util.Random;

public abstract class Potion extends Accessory{

	public Potion(TypeAccessory type) {
		super(type);
		super.setDurability(1);
	}
	
	//TEST CAPACITY ?

	
}
