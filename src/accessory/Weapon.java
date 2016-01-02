package accessory;

public class Weapon extends Accessory {




	public Weapon(TypeAccessory type) {
		super(type);
		iniWeapon(type);
	}
	
	//INITIALIZE WEAPON STRENGTH
		public void iniWeapon(TypeAccessory type){
			if (type==TypeAccessory.woodenSword) {
				super.setStrength(5);
				super.setDurability(10000);
			}
			else if (type==TypeAccessory.stoneSword) {
				super.setStrength(15);
				super.setDurability(40);

			}
			else if (type==TypeAccessory.steelSword) {
				super.setStrength(30);
				super.setDurability(60);

			}
			else if (type==TypeAccessory.goldSword) {
				super.setStrength(50);
				super.setDurability(2);

			}
			else if (type==TypeAccessory.diamondSword) {
				super.setStrength(70);
				super.setDurability(100);
			}
			else if (type==TypeAccessory.magicSword){
				super.setStrength(90);
				super.setDurability(1000);
			}
			
		}
	
	
}
