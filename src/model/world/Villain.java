package model.world;

import java.util.ArrayList;

public class Villain extends Champion {

	public Villain(String name, int maxHP, int maxMana, int actions, int speed, int attackRange, int attackDamage) {
		super(name, maxHP, maxMana, actions, speed, attackRange, attackDamage);

	}

	@Override
	public void useLeaderAbility(ArrayList<Champion> targets) {
		for (Champion c : targets) {

			c.setCurrentHP(0);

		}

	}
	public String toString() {
		return "Type:"+ "Villain" + "\n" + super.toString();
	}
	public String currentToString() {
		return "Type: Villain" +"\n"+ super.currentToString();
	}
	public String notToString()
	{
		return "\n" +"Type: Villain" +"\n"+ super.notToString();
	}


}
