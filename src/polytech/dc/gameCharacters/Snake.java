package polytech.dc.gameCharacters;
import polytech.dc.accessory.TypeAccessory;

public class Snake extends Enemy {

    //CONSTRUCTOR
    public Snake() {
        super("Snake", 40, 30, 10, 20, 20, 20, TypeAccessory.steelSword);
    }
}