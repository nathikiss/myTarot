package myTarot;

import java.util.ArrayList;

public class Card {
	/*
	 * This class permit creates divinatory card among the existing one and add new type,
	 *  a card has a name*/
	
	/*Attributes*/
	private String name;
	private String description="";
	/*Constructor*/
	public Card(String n) {
		this.name=n;
	}
	public Card(String n, String desc) {
		this.name=n;
		this.description=desc;
	}
	/*Assessors*/
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
	/*Methods*/
	/*This method modify an existing description or add a description to a card*/
	public void addDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}
