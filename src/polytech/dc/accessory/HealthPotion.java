package polytech.dc.accessory;
import java.util.Random;

public class HealthPotion extends Potion {
    
    public HealthPotion() {
        super(TypeAccessory.healthPotion);
        Random rand = new Random();
        super.setStrength(rand.nextInt(100));
    }

}
