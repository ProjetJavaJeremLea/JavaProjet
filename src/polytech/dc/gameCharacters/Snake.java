package polytech.dc.gameCharacters;
import java.util.Random;
import polytech.dc.accessory.TypeAccessory;
import polytech.dc.accessory.Weapon;

public class Snake extends Enemy {

    //CONSTRUCTOR
    public Snake() {
        super("Snake", 40, 30, 10, 20, 20, 20);
    }
    
    // WHEN SNAKE IS DEAD:
    @Override
    public void giveWeapon(Hero heroPlayer) {
        Random rand = new Random();
        int numBetween0and100 = rand.nextInt(100);
        if (numBetween0and100 <= this.getProbabilityDropWeapon()) {
            //heroPlayer.changeSword(TypeWeapon.steelSword);
            System.out.println("\tYes, a weapon in steel!");
            System.out.println("\tYou are stronger with this one now.\n");
            Weapon weapon = new Weapon(TypeAccessory.steelSword);
            heroPlayer.addinInventory(weapon);
        }
    }
}