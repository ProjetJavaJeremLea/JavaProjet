package polytech.dc.event;
import java.util.Random;
import polytech.dc.accessory.Accessory;
import polytech.dc.accessory.Armor;
import polytech.dc.accessory.DamagePotion;
import polytech.dc.gameCharacters.Enemy;
import polytech.dc.gameCharacters.Hero;
import polytech.dc.rpg.Round;

public class Action {

    public void fight(Round round,Hero heroPlayer,Enemy enemy) {
        this.heroActivateArmor(heroPlayer);//test if u want to use an armor
        this.heroAttack(enemy, heroPlayer);//Hero attack
        this.enemyAttack(heroPlayer,enemy);//Enemy attack if hero haven't armor
        round.displayResultAttack(heroPlayer, enemy,this);
        if (heroPlayer.dead()) {
            System.out.println("\t>> You limp out of the Pyramid, weak from battle !\n");
            round.setEndRound(true);
            round.setEndGame(true);
        }
        if (enemy.gethP() <= 0) {
            round.enemyDeath(heroPlayer, enemy,this); // THE ENEMY IS DEAD
            round.setEndRound(true);
            heroPlayer.heroLevel();
        }
    }
    public void runAway(Round round,Hero heroPlayer, Enemy enemy) {
        round.displayRunAway(heroPlayer, enemy);
            round.setEndRound(true);
        if (heroPlayer.coward()) {
            System.out.println("\t>> You are a coward, Go away ! \n");
            round.setEndGame(true);
        }
    }
    public void continueAdventure(Round round) {
        System.out.println("\tYou continue the adventure !!");
        round.setEndRound(true);
    }
    
    //Hero actions
    public void heroAttack(Enemy enemy, Hero heroPlayer) {
        System.out.println("\t What kind of weapon do you want to use? \n");
        heroPlayer.setWeapon(heroPlayer.accessoryChoice());
        enemy.sethP(enemy.gethP() - heroPlayer.getStrength());
        heroPlayer.getWeapon().decreaseDurability();
        if (heroPlayer.getWeapon().brokenAccessory()) {
            System.out.println("\t OMG! Your weapon can't be use again!");
            heroPlayer.removeinInventory(heroPlayer.getWeapon());
        }
    }
    public void heroActivateArmor(Hero heroPlayer) {
        if (heroPlayer.getNbArmors() > 0) {
            int choice = Controler.displayUseArmor();
            if (choice == 1) {
                heroPlayer.reduceArmors();
                for (Accessory armor : heroPlayer.getInventory()) {
                    ((Armor) armor).activateArmor(); //is activate vaut true
                    heroPlayer.getInventory().remove(armor);
                    break;
                }
            }
        }
    }
    public void heroDrinkPotion(Hero heroPlayer){
        if (heroPlayer.getNbHealthPotions()> 0) {
            for (Accessory potion : heroPlayer.getInventory()) {
                heroPlayer.reduceHealthPotions();
                heroPlayer.increaseHP(potion.getStrength()); //Drink potion if you can
                System.out.println("\t-------------------------------------");
                System.out.println("\t>> You drink a health potion, healting yourself for " + potion.getStrength() + ".");
                System.out.println("\t>> You now have " + heroPlayer.gethP() + " Hp.");
                System.out.println("\t>> You have " + heroPlayer.getNbHealthPotions() + " health potions left.");
                System.out.println("\t-------------------------------------\n");
                break;
            }  
        } 
        else {
            System.out.println("\tSorry, you don't have any potion.\n");
        }
    }
    
    public int enemyAttack(Hero heroPlayer,Enemy enemy) {
        int damage = 0;
        if (heroPlayer.getNbArmors() == 0) {
            damage = randInt(enemy.getMinAttackDamage(), enemy.getMaxAttackDamage());
            heroPlayer.reduceHP(damage);
        } else {
            for (Accessory accessory : heroPlayer.getInventory()) {
                if (accessory instanceof Armor) {
                    if (!((Armor)accessory).getIsActivate() && enemy.gethP() > 0){
                        damage = randInt(enemy.getMinAttackDamage(), enemy.getMaxAttackDamage());
                        heroPlayer.reduceHP(damage);
                        break;
                    }
                }
            }
        }
        return damage;
    }

    public boolean enemyGivePotion(Hero heroPlayer,Enemy enemy) {
        Random rand = new Random();
        int numBetween0and100 = rand.nextInt(100);
        int fiftypercent = rand.nextInt(100);
        if (numBetween0and100 <= enemy.getProbabilityDropPotion()) {
            if (fiftypercent <= 50) {
                System.out.println("\tYes, a new Health Potion !!");
                heroPlayer.increaseHealthPotions();
            } else {
                System.out.println("\tYes, a new Damage Potion !!");
                heroPlayer.getInventory().add(new DamagePotion());
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