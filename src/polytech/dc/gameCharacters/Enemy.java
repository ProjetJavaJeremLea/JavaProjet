package polytech.dc.gameCharacters;
import java.util.Random;
import polytech.dc.accessory.TypeAccessory;
import polytech.dc.accessory.Weapon;

public class Enemy extends GameCharacter { //en abstract ou pas ? parce que ca serait bien de mettre les methodes direct ici

    //FIELDS
    private String type;
    private int maxAttackDamage;
    private int minAttackDamage;
    private int probabilityDropPotion;
    private int probabilityDropWeapon;
    private int xpGiven;
    private TypeAccessory weaponType;

    //CONSTRUTOR
    public Enemy(String type, int hP, int maxAttackDamage, int minAttackDamage, int probabilityDropPotion,
            int probabilityDropWeapon, int xpGiven,TypeAccessory weaponType) {
        super(hP);
        this.type = type;
        this.maxAttackDamage = maxAttackDamage;
        this.minAttackDamage = minAttackDamage;
        this.probabilityDropPotion = probabilityDropPotion;
        this.probabilityDropWeapon = probabilityDropWeapon;
        this.xpGiven = xpGiven;
        this.weaponType=weaponType;
    }

    // GETTERS AND SETTERS
    public int getProbabilityDropWeapon() {
        return probabilityDropWeapon;
    }
    public String getType() {
        return type;
    }
    public int getXpGiven() {
        return xpGiven;
    }
    public int getMaxAttackDamage() {
        return maxAttackDamage;
    }
    public int getMinAttackDamage() {
        return minAttackDamage;
    }
    public int getProbabilityDropPotion() {
        return probabilityDropPotion;
    }
    public TypeAccessory getWeaponType() {
        return weaponType;
    }

    public void giveWeapon(Hero heroPlayer) {
        Random rand = new Random();
        int numBetween0and100 = rand.nextInt(100);
        if (numBetween0and100 <= this.getProbabilityDropWeapon()) {
            Weapon weapon = new Weapon(weaponType);
            System.out.println("\t\tYes, a weapon in "+weaponType+" with a strength value at "+weapon.getStrength()+" !");
            System.out.println("\t\tYou could be stronger with this one.\n");
            heroPlayer.addinInventory(weapon);
        }
    }
}