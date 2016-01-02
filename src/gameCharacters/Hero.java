package gameCharacters;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

import accessory.Accessory;
import accessory.Armor;
import accessory.DamagePotion;
import accessory.HealthPotion;
import accessory.TypeAccessory;
import accessory.Weapon;

public class Hero extends GameCharacter{

	private String heroName;
	private int level;
	private int xP;
	private int brave;
	private int strength;
	private int nbHealthPotions; 
	private int nbArmors;
	private int conditionToChangeLevel;
	private ArrayList<Accessory> inventory;
	private static int MAX_SIZE_INVENTORY=20;
	private Accessory weapon;
	
	Scanner sc = new Scanner(System.in);
	
	public Hero() {
		super(30);
		this.level=0;
		this.xP=0;
		this.brave=30;
		this.nbHealthPotions=3;
		this.nbArmors=0;
		this.weapon=new Weapon(TypeAccessory.woodenSword);
		// "Enter the name" then create the hero
		this.heroName=sc.nextLine();
		this.conditionToChangeLevel=this.level*this.level*this.level+50; // recalculer
		this.inventory = new ArrayList<Accessory>();
		inventory.add(weapon);
		inventory.add(new DamagePotion());
	}
	
	// GETTERS AND SETTERS
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	public int getLevel(){
		return level;
	}
	public void setLevel(int level){
		this.level=level;
	}
	public int getxP() {
		return xP;
	}
	public void setxP(int xP) {
		this.xP = xP;
	}
	public int getBrave() {
		return brave;
	}
	public void setBrave(int brave) {
		this.brave = brave;
	}
	public int getStrength() {
		return strengthCalculation(weapon);
	}
	public void setStrength(int strength) {
		this.strength = this.strengthCalculation(weapon);
	}
	public int getNbPotions() {
		return nbHealthPotions;
	}
	public void setNbPotions(int nbPotions) {
		this.nbHealthPotions = nbPotions;
	}
	public int getNbArmors() {
		return nbArmors;
	}
	public void setNbArmors(int nbArmors) {
		this.nbArmors = nbArmors;
	}
	public Scanner getSc() {
		return sc;
	}
	public void setSc(Scanner sc) {
		this.sc = sc;
	}	
	public int getConditionToChangeLevel() {
		return conditionToChangeLevel;
	}
	public void setConditionToChangeLevel(int conditionToChangeLevel) {
		this.conditionToChangeLevel = conditionToChangeLevel;
	}
	public ArrayList<Accessory> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Accessory> inventory) {
		this.inventory = inventory;
	}
	public Accessory getWeapon() {
		return weapon;
	}

	public void setWeapon(Accessory weapon) {
		this.weapon = weapon;
	}

	//INCREASE OR REDUCE LIFE
	public void increaseHP(int addHp){
		this.sethP(this.gethP()+addHp);
	}
	public void reduceHP(int removHp) {
		this.sethP(this.gethP()-removHp);
	}
	// STRENGTH = LEVEL + WEAPON STRENGTH
	public int strengthCalculation(Accessory weapon){ // weapon chosen
		int strengthBase=5; 
		return strengthBase+strengthBase*this.getLevel()+this.weapon.getStrength(); // 5 + 5 * Level + weapon's Strength
	}

	// BRAVE IS REDUCING BY 5 POINTS WHEN HERO RUN AWAY
	public void reduceBrave(){
		this.setBrave(this.getBrave() - 5);
		}
	
	// TRUE IF HERO IS DEAD OR IF HE RUNS AWAY 6 TIMES
	public Boolean dead(){
		if (this.gethP()<=0) return true;
		else return false;		
	}
	public Boolean coward(){
		if (this.getBrave()==0) return true;
		else return false;
	}
	
	//INCREASE EXPERIENCE
	public void increaseXP(int wonXp){
		this.setxP(this.getxP()+wonXp);
	}
	
	//REDUCE OR INCREASE nbPOTIONS
	public void increasePotions(){
		this.setNbPotions(this.getNbPotions()+1);
	}
	public void reducePotions(){
		this.setNbPotions(this.getNbPotions()-1);
	}
	
	//REDUCE OR INCREASE nbArmor
	public void increaseArmors(){
		this.setNbArmors(this.getNbArmors()+1);
	}
	public void reduceArmors(){
		this.setNbArmors(this.getNbArmors()-1);
	}
	// ADD IN THE INVENTORY
	public void addinInventory(Accessory accessory){
		if (this.inventory.size()<=MAX_SIZE_INVENTORY){
			this.inventory.add(accessory);
		} else {
			System.out.println("\t Your inventory is full. ");
			System.out.println("\t Do you want to swap it for an other?");
			System.out.println("\t 1. Yes");
			System.out.println("\t 2. No");
			
			int choice = sc.nextInt();
			if (choice==1){
				System.out.println("\t What accessory do you want to exchange for? \n");
				swapAccessory(accessoryChoice(),accessory);
			}
		}
	}
	
	//EXCHANGE SWORD
	public void swapAccessory(Accessory removeAccess,Accessory addAccess){
		this.removeinInventory(removeAccess);
		this.addinInventory(addAccess);
	}
	
	//REMOVE IN THE INVENTORY
	public void removeinInventory(Accessory accessory){
		this.inventory.remove(accessory);
	}
	
		
	//ACCESSORY CHOICE
	public Accessory accessoryChoice(){
		int i=0;
		int choice;
			for(Accessory accessory : inventory){
				i++;
				if(accessory instanceof Weapon|| accessory instanceof DamagePotion){
					System.out.println("\t"+i+". "+accessory.getType()+" available for "+accessory.getDurability()+" round(s)");
				}				
		}
		choice=sc.nextInt();
		return inventory.get(choice-1);
	}
		
	//ATTACK OF THE ENEMY
	public void heroAttack(Enemy enemy){
			System.out.println("\t What kind of weapon do you want to use? \n");
			weapon=this.accessoryChoice();
			enemy.sethP(enemy.gethP()-this.getStrength()); // attention faire avec get
			weapon.decreaseDurability();
			
			if (weapon.brokenAccessory()){
				System.out.println("\t OMG! Your weapon can't be use again!");
				this.removeinInventory(weapon);
			}
	}
	
	
	// INCREMENTATION OF THE LEVEL DEPENDING THE XP
	public void heroLevel(){
		if(this.getxP()>=this.getConditionToChangeLevel()){
			this.setLevel(this.getLevel()+1);
			this.increaseArmors();
			this.increaseHP(this.getLevel()*10);
			this.setConditionToChangeLevel(this.getConditionToChangeLevel()+this.getLevel()*this.getLevel()*this.getLevel()+50);
			System.out.println("\n\tCongratulation, you successed Level "+(this.getLevel()-1)+"!");
			System.out.println("\tYou win an Armor to be invicible for one round.");
			System.out.println("\tYou have "+this.gethP()+" HP.");
			System.out.println("\tYou are stronger.\n");
			System.out.println("\tWelcome to Level "+this.getLevel()+".");
			System.out.println("\tGet to "+(this.getConditionToChangeLevel())+" XP to pass next level.");
		//mettre les sop ailleurs 
		}
	}

}
