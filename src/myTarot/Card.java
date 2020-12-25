package myTarot;

import java.io.Serializable;
import java.util.ArrayList;

public class Card implements Serializable{
	/*
	 * This class permit creates divinatory card among the existing one and add new type,
	 *  a card has a name*/
	
	/*Attributes*/
	private String name;
	private String description="";
	private String imgPath="";
	
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
		this.imgPath=img;
	}
	
	/*Assessors*/
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getImgPath() {
		return imgPath;
	}
	
	
	/*Methods*/
	/*This method modify an existing description or add a description to a card*/
	public void addDescription(String description) {
		this.description = description;
	}
	public void addImg(String img) {
		this.imgPath = img;
	}
	public void updateCard(String name,String description,String imgPath) {
		this.name = name;
		this.description=description;
		this.imgPath=imgPath;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}
