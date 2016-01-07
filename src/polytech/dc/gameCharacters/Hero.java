package polytech.dc.gameCharacters;
import java.util.ArrayList;
import polytech.dc.accessory.Accessory;
import polytech.dc.accessory.Armor;
import polytech.dc.accessory.DamagePotion;
import polytech.dc.accessory.TypeAccessory;
import polytech.dc.accessory.Weapon;
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
        this.strength= this.strengthCalculation(weapon);

        // "Enter the name" then create the hero
        this.heroName =name;
        
        this.conditionToChangeLevel = this.level * this.level * this.level + 50; // recalculer
        this.inventory = new ArrayList<Accessory>();
        inventory.add(weapon);
        inventory.add(new DamagePotion());
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
        return strength;
    }
    public int getBrave() {
        return brave;
    }
    public void setWeapon(Accessory weapon) {
        this.weapon = weapon;
    }
    public int getNbArmors() {
        return nbArmors;
    }
   
    //INCREASE OR REDUCE
    public void increaseHP(int addHp) {
        this.sethP(this.gethP() + addHp);
    }
    public void reduceHP(int removHp) {
        this.sethP(this.gethP() - removHp);
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
    public void increaseArmors() {
        this.nbArmors+= 1;
    }
    public void reduceArmors() {
        this.nbArmors -= 1;
    }
    
    // STRENGTH = LEVEL + WEAPON STRENGTH
    public int strengthCalculation(Accessory weapon) { // weapon chosen
        int strengthBase = 5;
        return strengthBase + strengthBase * this.level+ this.weapon.getStrength(); // 5 + 5 * Level + weapon's Strength
    }
  
    // TRUE IF HERO IS DEAD OR IF HE RUNS AWAY 6 TIMES
    public Boolean dead() {
        if (this.gethP() <= 0) {
            return true;
        } else {
            return false;
        }
    }
    public Boolean coward() {
        if (this.brave== 0) {
            return true;
        } else {
            return false;
        }
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

    //EXCHANGE SWORD
    public void swapAccessory(Accessory removeAccess, Accessory addAccess) {
        this.removeinInventory(removeAccess);
        this.addinInventory(addAccess);
    }

    //REMOVE IN THE INVENTORY
    public void removeinInventory(Accessory accessory) {
        this.inventory.remove(accessory);
    }

    //ACCESSORY CHOICE
    public Accessory accessoryChoice() {
        int choice=Controler.displaySawpAccessory(inventory);
        return inventory.get(choice - 1);
    }

    // INCREMENTATION OF THE LEVEL DEPENDING THE XP
    public void heroLevel() {
        if (this.xP>= this.conditionToChangeLevel) {
            this.level++;
            this.increaseArmors();
            Armor armor = new Armor();
            inventory.add(armor);
            this.increaseHP(this.level * 10);
            this.conditionToChangeLevel+=(this.level)^3+ 50;
            System.out.println("\n\tCongratulation, you successed Level " + (this.level - 1) + "!");
            System.out.println("\tYou win an Armor to be invicible for one round.");
            System.out.println("\tYou have " + this.gethP() + " HP.");
            System.out.println("\tYou are stronger.\n");
            System.out.println("\tWelcome to Level " + this.level + ".");
            System.out.println("\tGet to " + this.conditionToChangeLevel + " XP to pass next level.");
        }
    }
}