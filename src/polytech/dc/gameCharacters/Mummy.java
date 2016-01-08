package polytech.dc.gameCharacters;
import polytech.dc.accessory.TypeAccessory;

public class Mummy extends Enemy {
    //CONSTRUCTOR
    public Mummy() {
        super("Mummy", 80, 60, 30, 60, 10, 40, TypeAccessory.goldSword);
    }
}