package polytech.dc.accessory;
import java.util.Random;

public class DamagePotion extends Potion {

    public DamagePotion() {
        super(TypeAccessory.damagePotion);
        Random rand = new Random();
        super.setStrength(rand.nextInt(50));
    }

}
