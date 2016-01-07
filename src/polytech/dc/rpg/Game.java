package polytech.dc.rpg;
import polytech.dc.event.Controler;
import polytech.dc.gameCharacters.Enemy;
import polytech.dc.gameCharacters.Hero;

public class Game { // 1 game = 1 player

    private Boolean endGame;

    //CONSTRUCTOR
    public Game() {
        this.endGame = false;
    }

    //GAME
    public void beginGame() {
        
        String name = Controler.DisplayNewHero();
        Hero heroPlayer = new Hero(name);
        Controler.DisplayWelcome(heroPlayer);

        while (!this.endGame) {
            Round round = new Round();
            while (!round.getEndRound()) {
                Enemy theEnemy = round.beginRound(heroPlayer);
                round.action(heroPlayer, theEnemy);
            }
            System.out.println("\tEnd of the round");
            this.endGame=round.getEndGame();
        }
        System.out.println("\tEnd of the game");
    }
    // end quand mort ou courage=0 ou exit faire un truc un peu mieux
    // end quand xp = 3600 environ A FAIRE
}