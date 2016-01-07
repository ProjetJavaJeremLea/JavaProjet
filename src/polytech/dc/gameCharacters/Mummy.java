package polytech.dc.gameCharacters;
import java.util.Random;
import polytech.dc.accessory.TypeAccessory;
import polytech.dc.accessory.Weapon;

public class Mummy extends Enemy {
    //CONSTRUCTOR
    public Mummy() {
        super("Mummy", 80, 60, 30, 60, 10, 40);
    }

    // WHEN MUMMY IS DEAD:
    @Override
    public void giveWeapon(Hero heroPlayer) {
        Random rand = new Random();
        int numBetween0and100 = rand.nextInt(100);
        if (numBetween0and100 <= this.getProbabilityDropWeapon()) {
            System.out.println("\tYes, a weapon in gold!");
            System.out.println("\tYou are stronger with this one now.\n");
            Weapon weapon = new Weapon(TypeAccessory.goldSword);
            heroPlayer.addinInventory(weapon);
        }
    }
}