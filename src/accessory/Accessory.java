package accessory;

public class Accessory {

	private TypeAccessory type;
	private int durability;
	private int strength;	

	
	public Accessory(TypeAccessory type) {
		super();
		this.type = type;
	}

	//GETTERS AND SETTERS
	public TypeAccessory getType() {
		return type;
	}

	public void setType(TypeAccessory type) {
		this.type = type;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	//
	
	//DECREASE DURABILITY
	public void decreaseDurability(){
		this.setDurability(this.durability-1);
	}
	
	// TEST DURABILITY
	public boolean brokenAccessory(){
		if (this.getDurability()==0){
			return true;
		} else return false;
	}


		
	
}
