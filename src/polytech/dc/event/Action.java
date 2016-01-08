package polytech.dc.event;
import java.util.Random;
import polytech.dc.accessory.Armor;
import polytech.dc.accessory.DamagePotion;
import polytech.dc.accessory.HealthPotion;
import polytech.dc.gameCharacters.Enemy;
import polytech.dc.gameCharacters.Hero;
import polytech.dc.rpg.Round;

public class Action {

    //Choices 1 2 and 3
    public void fight(Round round,Hero heroPlayer,Enemy enemy) {
        int damage=0;
        boolean armorActivate = heroActivateArmor(heroPlayer);//test if u want to use an armor
        this.heroAttack(enemy, heroPlayer);//Hero attack
        if (enemy.gethP() > 0) {
            damage = this.enemyAttack(heroPlayer, enemy, armorActivate);//Enemy attack if hero haven't armor
        }
        round.displayResultAttack(heroPlayer, enemy, damage,this);
        
    }
    public void runAway(Round round, Hero heroPlayer, Enemy enemy) {
        round.displayRunAway(heroPlayer, enemy);
        round.setEndRound(true);
        if (heroPlayer.coward()) {
            System.out.println("\t\t >> You are a coward, Go away ! \n");
            round.setEndGame(true);
        }
    }
    public void heroDrinkPotion(Hero heroPlayer, HealthPotion potion) {
        if (heroPlayer.getNbHealthPotions() > 0) {
            heroPlayer.reduceHealthPotions();
            heroPlayer.increaseHP(potion.getStrength()); //Drink potion if you can
            System.out.println("--------------------------------------------------------------------");
            System.out.println("\t\t>> You drink a health potion, healting yourself for " + potion.getStrength() + ".");
            System.out.println("\t\t>> You now have " + heroPlayer.gethP() + " Hp.");
            System.out.println("\t\t>> You have " + heroPlayer.getNbHealthPotions() + " health potions left.");
            System.out.println("--------------------------------------------------------------------");
        }
        else {
            System.out.println("\t\t Sorry, you don't have any potion.\n");
        }
    }
    
    //After fight choice
    public void continueAdventure(Round round) {
        System.out.println("\t\t You continue the adventure !!");
        round.setEndRound(true);
    }
    
    //Hero actions
    public void heroAttack(Enemy enemy, Hero heroPlayer) {
        if (heroPlayer.getInventory().size() != 0) {

            System.out.println("\t\t What kind of weapon do you want to use? \n");
            heroPlayer.setWeapon(heroPlayer.accessoryChoice());

        } else {
            System.out.println("\t\tYou don't have any weapon, fight with your naked hands.\n");
        }
        enemy.reduceHP(heroPlayer.getStrength());
        heroPlayer.getWeapon().decreaseDurability();
        if (heroPlayer.getWeapon().brokenAccessory()) {
            System.out.println("--------------------------------------------------------------------");
            System.out.println("\t\tOMG! Your weapon can't be use again!");
            System.out.println("--------------------------------------------------------------------");
            heroPlayer.removeinInventory(heroPlayer.getWeapon());
        }
    }
    public boolean heroActivateArmor(Hero heroPlayer) {
        boolean result=false;
        if (heroPlayer.getNbArmors() > 0) {
            int choice = Controler.displayUseArmor();
            if (choice == 1) {
                Armor armor = new Armor();
                armor.activateArmor();
                result=armor.getIsActivate();
                heroPlayer.setNbArmors(heroPlayer.getNbArmors()-1);
            }
        }
        return result;
    }
    
    //Enemy actions
    public int enemyAttack(Hero heroPlayer,Enemy enemy,boolean armorActivate) {
        int damage = 0;
        if (!armorActivate){
            damage = randInt(enemy.getMinAttackDamage(), enemy.getMaxAttackDamage());
            heroPlayer.reduceHP(damage);
        } 
        return damage;
    }
    public boolean enemyGivePotion(Hero heroPlayer,Enemy enemy) {
        Random rand = new Random();
        int numBetween0and100 = rand.nextInt(100);
        int fiftypercent = rand.nextInt(100);
        if (numBetween0and100 <= enemy.getProbabilityDropPotion()) {
            if (fiftypercent <= 50) {
                System.out.println("\t\t Yes, a new Health Potion !!");
                heroPlayer.increaseHealthPotions();
            } else {
                DamagePotion potion = new DamagePotion();
                System.out.println("\t\t Yes, a new Damage Potion with a strenght value at "+potion.getStrength()+" !!");
                heroPlayer.addinInventory(potion);
            }
            return true;
        } else {
            return false;
        }
 
    }
        
    //FONCTION RANDOM BETWEEN 2 INT
    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min) + min;
    }
}