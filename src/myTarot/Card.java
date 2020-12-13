package myTarot;

import java.util.ArrayList;

public class Card {
	/*
	 * This class permit creates divinatory card among the existing one and add new type,
	 *  a card has a name*/
	
	/*Attributes*/
	private String name;
	
	/*Constructor*/
	public Card(String n) {
		this.name=n;
	}
	
	/*Assessors*/
	public String getName() {
		return name;
	}
	
	/*Methods*/
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}
