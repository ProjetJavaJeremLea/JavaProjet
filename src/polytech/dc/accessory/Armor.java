package polytech.dc.accessory;

public class Armor extends Accessory { // CREATE AN ARMOR = ACTIVATE IT

    private Boolean isActivate;

    public Armor() {
        super(TypeAccessory.armor);
        this.isActivate = false;
    }
    //GETTERS AND SETTERS
    public Boolean getIsActivate() {
        return isActivate;
    }
   
    public void activateArmor(){
        this.isActivate = true;
        System.out.println("\t You are invicible for this round ! ");
    }
}
