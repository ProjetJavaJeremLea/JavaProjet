package rpg.ProjetJava_COLLIN_DOLLE.Charactere;

public class Character {

    private String name;

    private int level;

    private int maxWeight;

    private int maxHealth;

    private int maxDexterity;

    public void characterChoice(String choice,String name){
        if(choice=="1"){
            Character myCharacter =new Thor(name);
        }
        else if(choice=="2"){
            Character myCharacter =new CaptainAmerica(name);
        }
        else if(choice=="3"){
            Character myCharacter =new IronMan(name);
        }
        else if(choice=="4"){
            Character myCharacter =new Hulk(name);
        }
    }

    public Character(String name, int level, int maxWeight, int maxHealth, int maxDexterity) {
        this.name = name;
        this.level = level;
        this.maxWeight = maxWeight;
        this.maxHealth = maxHealth;
        this.maxDexterity = maxDexterity;
    }  
    
}
