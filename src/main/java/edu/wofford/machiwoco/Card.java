package edu.wofford.machiwoco;

public class Card {
	//A single Establishment card
	
	private String name;
	private int cost;
	private String color;
	private String icon;
	private int activation;
	
	public Card(String name, int cost, String color, String icon) {
		this.name = name;
		this.cost = cost;
		this.color = color;
		this.icon = icon;
		activation = 0;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}

	public String getIcon() {
		return icon;
	}

	public int getActivation() {
		return activation;
	}
	
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