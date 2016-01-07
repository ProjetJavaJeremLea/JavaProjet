package polytech.dc.gameCharacters;
import java.util.Random;

import polytech.dc.accessory.TypeAccessory;
import polytech.dc.accessory.Weapon;

public class Anubis extends Enemy {
    //CONSTRUCTOR
    public Anubis() {
        super("Anubis", 300, 120, 80, 90, 50, 200);
    }

    // WHEN ANUBIS IS DEAD:
    public void giveWeapon(Hero heroPlayer) {
        Random rand = new Random();
        int numBetween0and100 = rand.nextInt(100);
        if (numBetween0and100 <= this.getProbabilityDropWeapon()) {
            System.out.println("\tYes, a magic weapon !");
            System.out.println("\tYou are stronger with this one now.\n");
            Weapon weapon = new Weapon(TypeAccessory.magicSword);
            heroPlayer.addinInventory(weapon);
        }
    }
}