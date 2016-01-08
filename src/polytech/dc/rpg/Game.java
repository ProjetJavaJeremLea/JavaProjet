package polytech.dc.rpg;
import polytech.dc.event.Controler;
import polytech.dc.gameCharacters.Enemy;
import polytech.dc.gameCharacters.Hero;

public class Game { // 1 game = 1 player

    private Boolean endGame;
    private final int LEVEL_BOSS=10;
    
    //CONSTRUCTOR
    public Game() {
        this.endGame = false;
    }

    //GAME
    public void beginGame() {
        
        String name = Controler.displayNewHero();
        Hero heroPlayer = new Hero(name);
        Controler.displayWelcome(heroPlayer);

        while (!this.endGame) {
            Round round = new Round();
            while (!round.getEndRound()) {
                if (heroPlayer.getLevel() < LEVEL_BOSS) {
                    Enemy enemy = round.enemyAppear(heroPlayer, round.createEnemies(heroPlayer.getLevel()));
                    round.action(heroPlayer, enemy);
                }
                else{
                    round.bossFight(heroPlayer);
                }
            }
            this.endGame=round.getEndGame();
        }
        
    }
    // end quand mort ou courage=0 ou exit faire un truc un peu mieux
    // end quand xp = 3600 environ A FAIRE
}