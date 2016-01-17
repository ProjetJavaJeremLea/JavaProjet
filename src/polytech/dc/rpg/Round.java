package polytech.dc.rpg;
import polytech.dc.event.Controler;
import java.util.Random;
import polytech.dc.accessory.Accessory;
import polytech.dc.accessory.HealthPotion;
import polytech.dc.event.DisplayStory;
import polytech.dc.gameCharacters.Anubis;
import polytech.dc.gameCharacters.Enemy;
import polytech.dc.gameCharacters.Hero;
import polytech.dc.gameCharacters.Mummy;
import polytech.dc.gameCharacters.Pharaoh;
import polytech.dc.gameCharacters.Snake;
import polytech.dc.gameCharacters.Spider;

public class Round { //1 round  = 1 enemy

    private Boolean endRound;
    private Boolean endGame;
    Random rand = new Random();

    // CONSTRUCTOR
    public Round() {
        this.endRound = false;
        this.endGame = false;
    }

    //GETTERS AND SETTERS
    public Boolean getEndRound() {
        return endRound;
    }
    public Boolean getEndGame() {
        return endGame;
    }
    public void setEndRound(Boolean endRound) {
        this.endRound = endRound;
    }
    public void setEndGame(Boolean endGame) {
        this.endGame = endGame;
    }

    //CREATION OF ENEMIES
    public Enemy[] createEnemies(int level) {
        Enemy spider = new Spider();
        Enemy snake = new Snake();
        Enemy mummy = new Mummy();
        Enemy pharaoh = new Pharaoh();
        Enemy anubis = new Anubis();

        if ((level == 0) || (level == 1)) {
            Enemy[] enemies = {spider};
            return enemies;
        } else if ((level == 2) || (level == 3)) {
            Enemy[] enemies = {spider, snake};
            return enemies;
        } else if (level == 4) {
            Enemy[] enemies = {spider, snake, mummy};
            return enemies;
        } else if (level == 5) {
            Enemy[] enemies = {snake, mummy};
            return enemies;
        } else if ((level == 6) || (level == 7)) {
            Enemy[] enemies = {snake, mummy, pharaoh};
            return enemies;
        } else if (level == 8) {
            Enemy[] enemies = {mummy, pharaoh};
            return enemies;
        } else if (level == 9) {
            Enemy[] enemies = {pharaoh};
            return enemies;
        } else {
            Enemy[] enemies = {anubis};
            return enemies;
        }
    }

    // AN ENEMY APPEARS
    public Enemy enemyAppear(Hero heroPlayer, Enemy[] enemies) {
        System.out.println("__________________________________________________________________\n");
        Enemy enemy = enemies[rand.nextInt(enemies.length)];// est-ce que c'est pas length - 1
        System.out.println("Level " + heroPlayer.getLevel());
        System.out.println("\t\t >>A(n) " + enemy.getType() + " is on your way !!<< \n");
        return enemy;
    }

    // DEATH OF THE ENEMY
    public void enemyDeath(Hero heroPlayer, Enemy enemy,Action action) {
        heroPlayer.increaseXP(enemy.getXpGiven());
        System.out.println("__________________________________________________________________\n");
        System.out.println("\t\t# " + enemy.getType() + " was defeated !! # ");
        System.out.println("\t\t# You have " + heroPlayer.gethP() + " HP left.   # ");
        System.out.println("\t\t# You have " + heroPlayer.getxP() + " XP now.    # ");
        System.out.println("__________________________________________________________________\n");
        //Potions, weapon, armor
        System.out.println("\t\t You have " + heroPlayer.getNbHealthPotions() + " Health potions left. ");
        if (!action.enemyGivePotion(heroPlayer, enemy)) {
            enemy.giveWeapon(heroPlayer);
        }
    }

    //RESULT ATTACK DISPLAY
    public void displayResultAttack(Hero heroPlayer, Enemy enemy,int damage,Action action) {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("\t\t >> You strike the " + enemy.getType() + " for " + heroPlayer.getStrength() + " damage !");
        System.out.println("\t\t >> with " + heroPlayer.getWeapon().getType());
        System.out.println("\t\t >> and you lose " + damage + " HP.");
        System.out.println("--------------------------------------------------------------------\n");
        if (heroPlayer.dead()) {
            System.out.println("\t\t >> You limp out of the Pyramid, weak from battle !\n");
            DisplayStory.loose();
            setEndRound(true);
            setEndGame(true);
        }
        if (enemy.gethP() <= 0) {
            if (enemy instanceof Anubis) {
                DisplayStory.winBoss();
                this.endRound=true;
                this.endGame=true;

            } else {
                enemyDeath(heroPlayer, enemy, action); // THE ENEMY IS DEAD
                setEndRound(true);
                heroPlayer.heroChangeLevel();
            }
        }
    }
    public void displayRunAway(Hero heroPlayer, Enemy enemy) {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("\t\t >> You run away from the " + enemy.getType() + "!! ");
        heroPlayer.reduceBrave();
        System.out.println("\t\t >> You lose 5 points of brave... ");
        System.out.println("--------------------------------------------------------------------\n");
    }

    //Round
    public void action(Hero heroPlayer, Enemy enemy) {
        Action action = new Action();
        
        while (!this.endRound) {//Battle loop...
            int choice = Controler.displayChoices(heroPlayer, enemy);
            if (choice == 1) { //Choice 1 --> Attack
                action.fight(this, heroPlayer, enemy);
            } else if (choice == 2) { //run away
                action.runAway(this, heroPlayer, enemy);
            } else if (choice == 3) { //Choice 3 --> Drink a health potion
                action.heroDrinkPotion(heroPlayer,new HealthPotion());
            } else {
                System.out.println("\t\t >>Invalid command... ");
            }
        } //end loop
        
        if (!this.endGame) {
            int choice = Controler.displayAfterFight();
            if (choice == 1) {
                action.continueAdventure(this);
            } 
            else {
                System.out.println("\t\t You left the Pyramid !");
                this.endRound = true;
                this.endGame = true;// fin du jeu 
            }
        }
    }
    
    public void bossFight(Hero heroPlayer){
        Anubis anubis = new Anubis();
        DisplayStory.boss(heroPlayer);
        
        for(int i=0;i<heroPlayer.getNbHealthPotions();i++){
            HealthPotion potion = new HealthPotion();
            heroPlayer.increaseHP(potion.getStrength());
        }
        
        heroPlayer.setNbHealthPotions(0);
        this.action(heroPlayer, anubis);
    }
}