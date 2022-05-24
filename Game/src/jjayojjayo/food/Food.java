package jjayojjayo.food;

import java.util.List;

public abstract class Food{
	private String name;
	private int cookingTime;
	private int exp;
	public static List<Food> foodlist;
	private int j;
	
	public Food(){};
	public Food(String name,int cookingTime, int exp){
		this.name = name;
		this.cookingTime = cookingTime;
		this.exp = exp;
	};
	
//	public abstract void levelup();
	
	public String getName() {
		return name;
	}
	
	public void setJ(int j) {
		this.j = j;
	}
	
	public int getJ() {
		return j;
	}
	
	public int getExp() {
		return exp;
	}
	
	
	
}
