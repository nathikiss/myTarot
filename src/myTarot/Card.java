package myTarot;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * @author Nathivel Kissita
 * This class represents a Divinatory Card.
 * Each Cards have a Name, a Description and
 * an Image(which will be found thanks to a image path)
 * We implement the class Serializable to allow us to serialize
 * data in MyWindow
 * */

public class Card implements Serializable{
	
	/*Attributes*/
	private String name;
	private String description="";
	private String imgPath="";
	
	/*Constructors*/
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
	
	/**
	 * This method modifies an existing description or add a description to a card
	 * @param description corresponds to the new description
	 * */
	public void addDescription(String description) {
		this.description = description;
	}
	
	/**
	 * This method modifies an existing image or add an image to a card
	 * @param img corresponds to the new image path given in argument
	 * */
	public void addImg(String img) {
		this.imgPath = img;
	}
	
	/**
	 * This method updates card's data
	 * @param name corresponds to the new name
	 * @param description corresponds to the new description
	 * @param imgPath corresponds to the new imgPath
	 * */
	public void updateCard(String name,String description,String imgPath) {
		this.name = name;
		this.description=description;
		this.imgPath=imgPath;
	}
	
	/**
	 * The method toString() is a String representation of this Object
	 * @return name containing the name of the card*/
	@Override
	public String toString() {
		return name;
	}
}
