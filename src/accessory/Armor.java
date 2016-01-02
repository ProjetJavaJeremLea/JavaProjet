package accessory;

public class Armor { // CREATE AN ARMOR = ACTIVATE IT

	private Boolean isActivate;
	
	public Armor(){
		this.isActivate=false;
	}
	
	
	
	/*public void desactivateArmor(){
		this.isActivate=false;
	}*/
	
	//GETTERS AND SETTERS

	public Boolean getIsActivate() {
		return isActivate;
	}

	public void setIsActivate(Boolean isActivate) {
		this.isActivate = isActivate;
	}
	
	public void activateArmor(){
		this.isActivate=true;
		System.out.println("\t You are invicible for this round ! ");
	}
	
}
