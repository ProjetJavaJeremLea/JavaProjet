package polytech.dc.gameCharacters;
import java.util.ArrayList;
import polytech.dc.accessory.Accessory;
import polytech.dc.accessory.Armor;
import polytech.dc.accessory.DamagePotion;
import polytech.dc.accessory.TypeAccessory;
import polytech.dc.accessory.Weapon;
import polytech.dc.event.DisplayStory;
import polytech.dc.event.Controler;

public class Hero extends GameCharacter {

    //FIELDS
    private String heroName;
    private int level;
    private int xP;
    private int brave;
    private int strength;
    private int nbHealthPotions;
    private int nbArmors;
    private int conditionToChangeLevel;
    private ArrayList<Accessory> inventory;
    private final int MAX_SIZE_INVENTORY = 2;
    private Accessory weapon;

    //CONSTRUCTOR
    public Hero(String name) {
        super(30);
        this.level = 0;
        this.xP = 0;
        this.brave = 30;
        this.nbHealthPotions = 3;
        this.nbArmors = 0;
        this.weapon = new Weapon(TypeAccessory.woodenSword);
        this.heroName =name;
        
        this.conditionToChangeLevel = (this.level)^3 + 50;
        
        this.inventory = new ArrayList<Accessory>();
        this.addinInventory(weapon);
        this.addinInventory(new DamagePotion());
    }

    // GETTERS AND SETTERS
    public ArrayList<Accessory> getInventory(){
        return inventory;
    }
    public String getHeroName() {
        return heroName;
    }
    public int getLevel() {
        return level;
    }
    public int getxP() {
        return xP;
    }
    public int getNbHealthPotions() {
        return nbHealthPotions;
    }
    public Accessory getWeapon() {
        return weapon;
    }
    public int getStrength() {
        return strength= this.strengthCalculation(weapon);
    }
    public int getBrave() {
        return brave;
    }
    public void setWeapon(Accessory weapon) {
        this.weapon = weapon;
    }
    public int getNbArmors() {
        nbArmors=0;
        for(Accessory armor : inventory){
            if(armor instanceof Armor){
            nbArmors++;
            }
        }
        return nbArmors;
    }
    public int getConditionToChangeLevel() {
        return conditionToChangeLevel;
    }
    public void setNbArmors(int nbArmors) {
        this.nbArmors = nbArmors;
    }
    public void setNbHealthPotions(int nbHealthPotions) {
        this.nbHealthPotions = nbHealthPotions;
    }
   
    //INCREASE OR REDUCE
    public void increaseHP(int addHp) {
        this.sethP(this.gethP() + addHp);
    }    
    public void increaseXP(int wonXp) {
        this.xP+= wonXp;
    }
    public void reduceBrave() {
        this.brave-= 5;
    }
    public void increaseHealthPotions() {
        this.nbHealthPotions+= 1;
    }
    public void reduceHealthPotions() {
        this.nbHealthPotions-= 1;
    }

    // STRENGTH = LEVEL + WEAPON STRENGTH
    public int strengthCalculation(Accessory weapon) { // weapon chosen
        int strengthBase = 5;
        return strengthBase + strengthBase * this.level+ this.weapon.getStrength(); // 5 + 5 * Level + weapon's Strength
    }
  
    // TRUE IF HERO IS DEAD OR IF HE RUNS AWAY 6 TIMES
    public Boolean dead() {
        return this.gethP() <= 0;
    }
    public Boolean coward() {
        return this.brave== 0;
    }

    // ADD IN THE INVENTORY
    public void addinInventory(Accessory accessory) {
        if (this.inventory.size() <= MAX_SIZE_INVENTORY) {
            this.inventory.add(accessory);
        } else {
            int choice = Controler.displayFullInventory();
            if (choice == 1) {
                System.out.println("\t What accessory do you want to exchange for? \n");
                Accessory accessoryToExchange = accessoryChoice();
                swapAccessory(accessoryToExchange, accessory);
            }
        }
    }
    
    //REMOVE IN THE INVENTORY
    public void removeinInventory(Accessory accessory) {
        this.inventory.remove(accessory);
    }
    //EXCHANGE SWORD
    public void swapAccessory(Accessory removeAccess, Accessory addAccess) {
        this.removeinInventory(removeAccess);
        this.addinInventory(addAccess);
    }

    //ACCESSORY CHOICE
    public Accessory accessoryChoice(){
        int choice=Controler.displaySawpAccessory(inventory);
        return inventory.get(choice - 1);
    }

    // INCREMENTATION OF THE LEVEL DEPENDING THE XP
    public void heroChangeLevel() {
        if (this.xP>= this.conditionToChangeLevel) {
            this.level++;
            nbArmors++;
            this.increaseHP(this.level * 10);
            this.conditionToChangeLevel+=(this.level)^3+ 50;
            DisplayStory.level(this);
        }
    }
    
}