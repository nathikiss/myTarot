package myTarot;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		//ArrayList<Card>cardsTest =new ArrayList<Card>();
		Deck deckTest = new Deck();
		deckTest.fillWithDeckMarseille();
		//System.out.println(deckTest);
		//deckTest.searchCardByStringIn("Le");
		System.out.println(deckTest.searchCardByNumber(1));
		//deckTest.removeCard("Le Pape");
		//System.out.println(deckTest);
		Card CardTest=new Card("ZA WARUDO");
		//deckTest.addCard(CardTest);
		System.out.println(deckTest);
		
		try {
			FileOutputStream fos = new FileOutputStream("tarotSave.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(deckTest);
			oos.close();
			} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
