package rpg.ProjetJava_COLLIN_DOLLE.jeu;
import java.util.Scanner;

public class RPG {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--Menu--");
        System.out.println("Choisir votre personnage");
        String choice = sc.nextLine();
        characterChoice(choice);        
    }
    
}
