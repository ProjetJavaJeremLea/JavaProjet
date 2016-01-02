package gameCharacters;

import java.util.Random;

public abstract class Enemy extends GameCharacter{ //en abstract ou pas ? parce que ca serait bien de mettre les methodes direct ici

	private String type;
	private int maxAttackDamage;
	private int minAttackDamage;
	private int probabilityDropPotion;
	private int probabilityDropWeapon;
	private int xpGiven;
	
	public Enemy(String type, int hP, int maxAttackDamage, int minAttackDamage, int probabilityDropPotion,
			int probabilityDropWeapon, int xpGiven) {
		super(hP);
		this.type=type;
		this.maxAttackDamage = maxAttackDamage;
		this.minAttackDamage = minAttackDamage;
		this.probabilityDropPotion = probabilityDropPotion;
		this.probabilityDropWeapon = probabilityDropWeapon;
		this.xpGiven = xpGiven;
	}
	
	// GETTERS AND SETTERS
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMaxAttackDamage() {
		return maxAttackDamage;
	}
	public void setMaxAttackDamage(int maxAttackDamage) {
		this.maxAttackDamage = maxAttackDamage;
	}
	public int getMinAttackDamage() {
		return minAttackDamage;
	}
	public void setMinAttackDamage(int minAttackDamage) {
		this.minAttackDamage = minAttackDamage;
	}
	public int getProbabilityDropPotion() {
		return probabilityDropPotion;
	}
	public void setProbabilityDropPotion(int probabilityDropPotion) {
		this.probabilityDropPotion = probabilityDropPotion;
	}
	public int getProbabilityDropWeapon() {
		return probabilityDropWeapon;
	}
	public void setProbabilityDropWeapon(int probabilityDropWeapon) {
		this.probabilityDropWeapon = probabilityDropWeapon;
	}
	public int getXpGiven() {
		return xpGiven;
	}
	public void setXpGiven(int xpGiven) {
		this.xpGiven = xpGiven;
	}
	
	// ABSTRACT METHODS
	public abstract void enemyAttack(Hero heroPlayer);
	public abstract void giveWeapon(Hero heroPlayer);
	
	// GLOBAL METHODS DEMANDER AU PROF
	public boolean givePotion(Hero heroPlayer){
		Random rand= new Random();
		int numBetween0and100 = rand.nextInt(100);
		int fiftypercent = rand.nextInt(100);
		if (numBetween0and100<=this.getProbabilityDropPotion()){

			if(fiftypercent<=50){
				System.out.println("\tYes, a new Health Potion !!");
			} else {
				System.out.println("\tYes, a new Damage Potion !!");

			}
		return true;
		}
		else return false;
	}
	
	
}
