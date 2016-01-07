package polytech.dc.gameCharacters;

import java.util.Random;

public class GameCharacter { //pas mis en abstract car j'arrivais pas à aller chercher l'attribut hp dans les sous classes

    private int hP;
    //CONSTRUCTEUR
    public GameCharacter(int hP) {
        this.hP = hP;
    }
    
    //GET & SET
    public int gethP() {
        return hP;
    }
    public void sethP(int hP) {
        this.hP = hP;
    }

}
