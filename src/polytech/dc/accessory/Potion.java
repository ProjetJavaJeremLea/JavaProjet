package polytech.dc.accessory;

public abstract class Potion extends Accessory {

    public Potion(TypeAccessory type) {
        super(type);
        super.setDurability(1);
    }
}
