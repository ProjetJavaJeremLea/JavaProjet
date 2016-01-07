package polytech.dc.gameCharacters;

import java.util.Random;

import polytech.dc.accessory.TypeAccessory;
import polytech.dc.accessory.Weapon;

public class Pharaoh extends Enemy {
    //CONSTRUCTEUR
    public Pharaoh() {
        super("Pharaoh", 100, 80, 60, 20, 90, 80);
    }

    // WHEN PHARAOH IS DEAD:
    @Override
    public void giveWeapon(Hero heroPlayer) {
        Random rand = new Random();
        int numBetween0and100 = rand.nextInt(100);
        if (numBetween0and100 <= this.getProbabilityDropWeapon()) {
            System.out.println("\tYes, a weapon in diamonds!");
            System.out.println("\tYou are stronger with this one now.\n");
            Weapon weapon = new Weapon(TypeAccessory.diamondSword);
            heroPlayer.addinInventory(weapon);
        }
    }
}