package polytech.dc.event;
import java.util.ArrayList;
import java.util.Scanner;
import polytech.dc.accessory.Accessory;
import polytech.dc.gameCharacters.Enemy;
import polytech.dc.gameCharacters.Hero;

public final class Controler {
    
    static Scanner sc=new Scanner(System.in);
    static boolean continueInput = true;
    
    public static String displayNewHero(){
        DisplayStory.pyramid();
        DisplayStory.welcome();
        DisplayStory.introduction();
        System.out.println("__________________________________________________________________\n");
        System.out.println("\t\tAdd Your NAME to enter in The Pyramid:");
        String name = sc.nextLine();
        System.out.println("__________________________________________________________________\n");
        return name;
    }
    
    public static void displayWelcome(Hero heroPlayer){
        System.out.println("\n\t\tDear " + heroPlayer.getHeroName() + ",\n");
        DisplayStory.beginning();
        System.out.println("\t\tYou have " + heroPlayer.gethP() + " HP to begin the game.");
        System.out.println("\t\tThe pyramid offers you 3 health potions.");
        System.out.println("\t\tGood luck! \n");
        System.out.println("\t\t\t>>Press ENTER to Continue...\n");
        sc.nextLine();
    }
    
    public static int displayAfterFight() {
        System.out.println("__________________________________________________________________\n");
        System.out.println("\t\tWhat would you like to do ?!");
        System.out.println("\t\t1. Fight again");
        System.out.println("\t\t2. Exit the Pyramid");
        int choice = 0;
        do {
            try {
                choice = sc.nextInt();
                continueInput = false;
            } catch (Exception ex) {
                System.out.println("\t\tInvalid command... Press a valid one !");
                sc.nextLine();
            }
        } while (continueInput);
        while (choice != 1 && choice != 2) {
            System.out.println("\t\tInvalid command... Press a valid one !");
            choice = sc.nextInt();
        }
        continueInput=true;
        return choice;
    }
    
    public static int displayChoices(Hero heroPlayer, Enemy enemy) {
        System.out.println("\t\t\tYour Health:" + heroPlayer.gethP());
        System.out.println("\t\t\tYour Brave points:" + heroPlayer.getBrave());
        System.out.println("\t\t\t" + enemy.getType() + "'s Health :" + enemy.gethP() + "\n");
        System.out.println("\t\t\tWhat do you want to do ?!");
        System.out.println("\t\t\t1. Attack this enemy");
        System.out.println("\t\t\t2. Run far far away !");
        if (heroPlayer.getNbHealthPotions() > 0) {
            System.out.println("\t\t\t3. Drink health potion");
        }
        int choice = 0;
        do {
            try {
                choice = sc.nextInt();
                continueInput = false;
            } catch (Exception ex) {
                System.out.println("\t\tInvalid command... Press a valid one !");
                sc.nextLine();
            }
        } while (continueInput);
        while (choice >= 3 && heroPlayer.getNbHealthPotions() < 0) {
            System.out.println("\t\tInvalid command... Press a valid one !");
            choice = sc.nextInt();
        }
        continueInput = true;
        return choice;
    }
    
    public static int displayFullInventory() {
        System.out.println("\t\tYour inventory is full. ");
        System.out.println("\t\tDo you want to swap it for an other?");
        System.out.println("\t\t1. Yes");
        System.out.println("\t\t2. No");
        int choice = 0;
        do {
            try {
                choice = sc.nextInt();
                continueInput = false;
            } catch (Exception ex) {
                System.out.println("\t\tInvalid command... Press a valid one !");
                sc.nextLine();
            }
        } while (continueInput);
        while (choice != 1 && choice != 2) {
            System.out.println("\t\tInvalid command... Press a valid one !");
            choice = sc.nextInt();
        }
        continueInput=true;
        return choice;
    }

    public static int displaySawpAccessory(ArrayList<Accessory> inventory) {
        int i = 0;
        int choice=0;
        for (Accessory accessory : inventory) {
            i++;
                System.out.println("\t" + i + ". " + accessory.getType() + " available for " + accessory.getDurability() + " round(s) " + "and strenght value is :"+accessory.getStrength() );
        }
        do {
            try {
                choice = sc.nextInt();
                continueInput = false;
            } catch (Exception ex) {
                System.out.println("\t\tInvalid command... Press a valid one !");
                sc.nextLine();
            }
        } while (continueInput);
        while (choice > inventory.size()) {
            System.out.println("\t\tInvalid command... Press a valid one !");
            choice = sc.nextInt();
        }
        continueInput=true;
        return choice;
    }

    public static int displayUseArmor() {
        System.out.println("\t\tYou have an Armor, what do you want to do ?");
        System.out.println("\t\t1. Use it!");
        System.out.println("\t\t2. Continue without armor.");
        int choiceArmor = 0;

        do {
            try {
                choiceArmor = sc.nextInt();
                continueInput = false;
            } catch (Exception ex) {
                System.out.println("\t\tInvalid command... Press a valid one !");
                sc.nextLine();
            }
        } while (continueInput);
        while (choiceArmor != 1 && choiceArmor != 2) {
            System.out.println("\t\tInvalid command... Press a valid one !");
            choiceArmor = sc.nextInt();
        }
        continueInput = true;
        return choiceArmor;
    }
}
