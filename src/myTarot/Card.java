package myTarot;

import java.util.ArrayList;

public class Card {
	/*
	 * This class permit creates divinatory card among the existing one and add new type,
	 *  a card has a name*/
	
	/*Attributes*/
	private String name;
	private String description="";
	private String imgName="";
	
	/*Constructor*/
	public Card(String n) {
		this.name=n;
	}
	public Card(String n, String desc) {
		this.name=n;
		this.description=desc;
	}
	public Card(String n, String desc,String img) {
		this.name=n;
		this.description=desc;
		this.imgName=img;
	}
	
	/*Assessors*/
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getImgName() {
		return imgName;
	}
	
	
	/*Methods*/
	/*This method modify an existing description or add a description to a card*/
	public void addDescription(String description) {
		this.description = description;
	}
	public void addImg(String img) {
		this.imgName = img;
	}
	public void updateCard(String name,String description,String imgName) {
		this.name = name;
		this.description=description;
		this.imgName=imgName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}
