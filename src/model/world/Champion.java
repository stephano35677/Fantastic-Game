package model.world;

import java.awt.Point;
import java.util.ArrayList;


import model.abilities.Ability;
import model.effects.Effect;

@SuppressWarnings("rawtypes")
public abstract class Champion implements Damageable,Comparable {
	private String name;
	private int maxHP;
	private int currentHP;
	private int mana;
	private int maxActionPointsPerTurn;
	private int currentActionPoints;
	private int attackRange;
	private int attackDamage;
	private int speed;
	private ArrayList<Ability> abilities;
	private ArrayList<Effect> appliedEffects;
	private Condition condition;
	private Point location;
	

	public Champion(String name, int maxHP, int mana, int actions, int speed, int attackRange, int attackDamage) {
		this.name = name;
		this.maxHP = maxHP;
		this.mana = mana;
		this.currentHP = this.maxHP;
		this.maxActionPointsPerTurn = actions;
		this.speed = speed;
		this.attackRange = attackRange;
		this.attackDamage = attackDamage;
		this.condition = Condition.ACTIVE;
		this.abilities = new ArrayList<Ability>();
		this.appliedEffects = new ArrayList<Effect>();
		this.currentActionPoints=maxActionPointsPerTurn;
	}
	
	public String toString() {
		return "Name:"+ name + "\n"+
				"Health Points:" + maxHP + "\n" +
				"Mana:" + mana + "\n"+
				"Action Points per Turn:" + maxActionPointsPerTurn + "\n"+
				"Speed:"+ speed + "\n"+
				"Attack Damage:" + attackDamage+"\n"+
				"Attack Range:" + attackRange +"\n"+ "\n"+
				"Ability 1:" +"\n"+ (this.getAbilities().get(0)).toString() +"\n"+
				"Ability 2:" +"\n"+ (this.getAbilities().get(1)).toString() +"\n" +
				"Ability 3:" +"\n"+ (this.getAbilities().get(2)).toString() +"\n";
	}
	
	public String currentToString() {
		String n= "";
		String s= "";
		for(int i=1; i<=this.getAppliedEffects().size();i++) {
			n+= "Effect"+i+": " +this.getAppliedEffects().get(i-1).currentToString()+"\n";
		}
		if(this.getAbilities().size()==4) 
		{
			s="Ability 4:" +"\n"+ (this.getAbilities().get(3)).currentToString() +"\n";
		}
		
		return "Name:"+ name + "\n"+
				"Health Points:" + currentHP + "\n" +
				"Mana:" + mana + "\n"+
				"Action Points:" + currentActionPoints + "\n"+
				"Attack Damage:" + attackDamage+"\n"+
				"Attack Range:" + attackRange +"\n"+ "\n"+
				"Ability 1:" +"\n"+ (this.getAbilities().get(0)).currentToString() +"\n"+
				"Ability 2:" +"\n"+ (this.getAbilities().get(1)).currentToString() +"\n" +
				"Ability 3:" +"\n"+ (this.getAbilities().get(2)).currentToString() +"\n"+
				s+
				n;
	}
	public String notToString()
	{
		String n= "";
		for(int i=1; i<=this.getAppliedEffects().size();i++) {
			n+= "Effect"+i+":" +"\n"+this.getAppliedEffects().get(i-1).toString()+"\n";
		}
		
		return "\n"+"Name:"+ name + "\n"+"\n"+
				"Health Points:" + currentHP +"\n"+ "\n" +
				"Mana:" + mana + "\n"+"\n"+
				"Action Points:" + currentActionPoints +"\n"+ "\n"+
				"Attack Damage:" + attackDamage+"\n"+"\n"+
				"Attack Range:" + attackRange +"\n"+"\n"+
				"Speed:"+ speed +"\n"+"\n"+
				"Action Points per Turn:"+ maxActionPointsPerTurn +"\n"+"\n"+
				n;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public String getName() {
		return name;
	}

	public void setCurrentHP(int hp) {

		if (hp <= 0) {
			currentHP = 0;
			condition=Condition.KNOCKEDOUT;
			
		} 
		else if (hp > maxHP)
			currentHP = maxHP;
		else
			currentHP = hp;

	}

	
	public int getCurrentHP() {

		return currentHP;
	}

	public ArrayList<Effect> getAppliedEffects() {
		return appliedEffects;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int currentSpeed) {
		if (currentSpeed < 0)
			this.speed = 0;
		else
			this.speed = currentSpeed;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point currentLocation) {
		this.location = currentLocation;
	}

	public int getAttackRange() {
		return attackRange;
	}

	public ArrayList<Ability> getAbilities() {
		return abilities;
	}

	public int getCurrentActionPoints() {
		return currentActionPoints;
	}

	public void setCurrentActionPoints(int currentActionPoints) {
		if(currentActionPoints>maxActionPointsPerTurn)
			currentActionPoints=maxActionPointsPerTurn;
		else 
			if(currentActionPoints<0)
			currentActionPoints=0;
		this.currentActionPoints = currentActionPoints;
	}

	public int getMaxActionPointsPerTurn() {
		return maxActionPointsPerTurn;
	}

	public void setMaxActionPointsPerTurn(int maxActionPointsPerTurn) {
		this.maxActionPointsPerTurn = maxActionPointsPerTurn;
	}

	public int compareTo(Object o)
	{
		Champion c = (Champion)o;
		if(speed==c.speed)
			return name.compareTo(c.name);
		return -1 * (speed-c.speed);
	}
	
public abstract void useLeaderAbility(ArrayList<Champion> targets);
}
