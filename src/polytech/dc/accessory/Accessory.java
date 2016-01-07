package polytech.dc.accessory;

public class Accessory {

    //FIELDS

    private TypeAccessory type;
    private int durability;
    private int strength;

    //CONSTRUCTOR
    public Accessory(TypeAccessory type) {
        this.type = type;
    }

    //GETTERS AND SETTERS
    public void setDurability(int durability) {
        this.durability = durability;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getStrength() {
        return strength;
    }
    public TypeAccessory getType() {
        return type;
    }
    public int getDurability() {
        return durability;
    }

    //DECREASE DURABILITY
    public void decreaseDurability() {
        this.durability--;
    }

    // TEST DURABILITY
    public boolean brokenAccessory() {
        if (this.durability == 0) {
            return true;
        } else {
            return false;
        }
    }
}