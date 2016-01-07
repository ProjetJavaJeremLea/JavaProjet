package polytech.dc.gameCharacters;

import polytech.dc.accessory.Accessory;
import polytech.dc.accessory.Armor;
import java.util.Random;
import polytech.dc.accessory.DamagePotion;

public abstract class Enemy extends GameCharacter { //en abstract ou pas ? parce que ca serait bien de mettre les methodes direct ici

    //FIELDS
    private String type;
    private int maxAttackDamage;
    private int minAttackDamage;
    private int probabilityDropPotion;
    private int probabilityDropWeapon;
    private int xpGiven;

    //CONSTRUTOR
    public Enemy(String type, int hP, int maxAttackDamage, int minAttackDamage, int probabilityDropPotion,
            int probabilityDropWeapon, int xpGiven) {
        super(hP);
        this.type = type;
        this.maxAttackDamage = maxAttackDamage;
        this.minAttackDamage = minAttackDamage;
        this.probabilityDropPotion = probabilityDropPotion;
        this.probabilityDropWeapon = probabilityDropWeapon;
        this.xpGiven = xpGiven;
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

    // ABSTRACT METHODS
    public abstract void giveWeapon(Hero heroPlayer);

    //METHODS
    
}