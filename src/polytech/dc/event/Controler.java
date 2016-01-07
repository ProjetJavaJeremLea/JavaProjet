package polytech.dc.event;
import java.util.ArrayList;
import java.util.Scanner;
import polytech.dc.accessory.Accessory;
import polytech.dc.accessory.DamagePotion;
import polytech.dc.accessory.Weapon;
import polytech.dc.gameCharacters.Enemy;
import polytech.dc.gameCharacters.Hero;

public final class Controler {
    
    static Scanner sc=new Scanner(System.in);
    
    public static String DisplayNewHero(){
        System.out.println("    ##                              ##");
        System.out.println("   ####   Welcome To The Pyramid   ####");
        System.out.println("  ######       Of The Death !     ######");
        System.out.println("___________________________________________\n");
        System.out.println("Add Your NAME to enter in The Pyramid:");
        String name = sc.nextLine();
        return name;
    }
    
    public static void DisplayWelcome(Hero heroPlayer){
        System.out.println("\nDear " + heroPlayer.getHeroName() + ",");
        System.out.println("You have " + heroPlayer.gethP() + " HP to begin the game.");
        System.out.println("The pyramid offers you 3 health potions.");
        /*NARRATION*/   
        System.out.println("Good luck! \n");
        System.out.println(">>Press ENTER to Continue...\n");
        sc.nextLine();
    }
    
    public static int displayAfterFight() {
        System.out.println("______________________________________________\n");
        System.out.println("\tWhat would you like to do ?!");
        System.out.println("\t1. Fight again");
        System.out.println("\t2. Exit the Pyramid");
        int choice = sc.nextInt();

        while (choice != 1 && choice != 2) {
            System.out.println("\tInvalid command... Press a valid one !");
            choice = sc.nextInt();
        }
        return choice;
    }
    
    public static int displayChoices(Hero heroPlayer, Enemy enemy) {
        System.out.println("\tYour Health:" + heroPlayer.gethP());
        System.out.println("\tYour Brave points:" + heroPlayer.getBrave());
        System.out.println("\t" + enemy.getType() + "'s Health :" + enemy.gethP() + "\n");
        System.out.println("\tWhat do you want to do ?!");
        System.out.println("\t1. Attack this enemy");
        System.out.println("\t2. Run far far away !");
        if (heroPlayer.getNbHealthPotions() > 0) {
            System.out.println("\t3. Drink health potion");
        }
        int choice = sc.nextInt();
        return choice;
    }
    
    public static int displayFullInventory() {
        System.out.println("\t Your inventory is full. ");
        System.out.println("\t Do you want to swap it for an other?");
        System.out.println("\t 1. Yes");
        System.out.println("\t 2. No");
        int choice = sc.nextInt();
        return choice;
    }

    public static int displaySawpAccessory(ArrayList<Accessory> inventory) {
        int i = 0;
        int choice;
        for (Accessory accessory : inventory) {
            i++;
            if (accessory instanceof Weapon || accessory instanceof DamagePotion) {
                System.out.println("\t" + i + ". " + accessory.getType() + " available for " + accessory.getDurability() + " round(s)");
            }
        }
        choice = sc.nextInt();
        return choice;
    }

    public static int displayUseArmor() {
        System.out.println("\tYou have an Armor, what do you want to do ?");
        System.out.println("\t1. Use it!");
        System.out.println("\t2. Continue without armor.");
        int choiceArmor = sc.nextInt();
        return choiceArmor;
    }
}
