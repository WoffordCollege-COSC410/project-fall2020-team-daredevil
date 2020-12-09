package edu.wofford.machiwoco;

/**
 * @author Jacob Vannoy, Kristinn Sigurjonsson, Jaylen Muhammad, Evan Suggs
 */

public class Card {
	//A single Establishment card
	
	private String name;
	private int cost;
	private String color;
	private String icon;
	private int activation;
	
	/**
	 * Creates new instance of Card
	 * @param name name of card
	 * @param cost cost of card
	 * @param color color of card
	 * @param icon icon of card
	 */
	public Card(String name, int cost, String color, String icon) {
		this.name = name;
		this.cost = cost;
		this.color = color;
		this.icon = icon;
		activation = 0;
	}

	/**
	 * Sets the name of the card
	 * @param name new name of card
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the name of the card
	 * @return name of card
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the cost of the card
	 * @param cost new cost of card
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	/**
	 * Gets the cost of the card
	 * @return cost of card
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * Sets the color of the card
	 * @param color new color of card
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * Gets the color of the card
	 * @return color of card
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Gets the icon of the card
	 * @return icon of card
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * Gets the card activation
	 * @return card activation
	 */
	public int getActivation() {
		return activation;
	}
	
	/**
	 * Sets the activation of the card
	 * @param a new activation of card
	 */
	public void setActivation(int a) {
		this.activation = a;
	}

}

//		effectType = 0;
//		effectTarget = 0;
//		effectAmount = 0;
//		effectModifierType = 0;
//		effectModifier = 'N';

//public int getEffectType() {
//	return effectType;
//}
//
//public int getEffectTarget() {
//	return effectTarget;
//}
//
//public int getEffectAmount() {
//	return effectAmount;
//}
//
//public int getEffectModType() {
//	return effectModifierType;
//}
//
//public char getEffectModifier() {
//	return effectModifier;
//}
//
//public void setEffect(int type, int target, int amount, int modType, char mod) {
//	if (type == 0 || type == 1) {
//		effectType = type;
//	}
//	
//	if (target >= 0 && target < 4) {
//		effectTarget = target;
//	}
//	
//	if (amount > 0 && amount <= 5) {
//		effectAmount = amount;
//	}
//	
//	if (modType == 0 || modType == 1) {
//		effectModifierType = modType;
//	}
//	
//	if (mod == 'C') {
//		effectModifier = mod;
//	} else if (mod == 'G') {
//		effectModifier = mod;
//	} else if (mod == 'W') {
//		effectModifier = mod;
//	} else {
//		effectModifier = 'N';
//	}
//}