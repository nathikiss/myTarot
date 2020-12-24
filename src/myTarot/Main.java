package myTarot;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Card>cardsTest =new ArrayList<Card>();
		Deck deckTest = new Deck(cardsTest);
		deckTest.fillWithDeckMarseille();
		//System.out.println(deckTest);
		//deckTest.searchCardByStringIn("Le");
		System.out.println(deckTest.searchCardByNumber(1));
		//deckTest.removeCard("Le Pape");
		//System.out.println(deckTest);
		Card CardTest=new Card("ZA WARUDO");
		//deckTest.addCard(CardTest);
		System.out.println(deckTest);
	}

}
