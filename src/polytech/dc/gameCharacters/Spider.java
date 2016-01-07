package polytech.dc.gameCharacters;
import java.util.Random;
import polytech.dc.accessory.TypeAccessory;
import polytech.dc.accessory.Weapon;

public class Spider extends Enemy {
    
    //CONSTRUCTOR
    public Spider() {
        super("Spider", 20, 10, 0, 100, 50, 15);
    }

    // WHEN SPIDER IS DEAD:
    @Override
    public void giveWeapon(Hero heroPlayer) {
        Random rand = new Random();
        int numBetween0and100 = rand.nextInt(100);
        if (numBetween0and100 <= this.getProbabilityDropWeapon()) {
            System.out.println("\tYes, a weapon in stone!");
            System.out.println("\tYou are stronger with this one now.\n");
            Weapon weapon = new Weapon(TypeAccessory.stoneSword);
            heroPlayer.addinInventory(weapon);
        }
    }
}