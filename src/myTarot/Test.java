package myTarot;

public class Test {
	public static void main(String[] args) {
	
		
		Deck testDeck  = new Deck ();
		
		testDeck.fillWithDeckMarseille();
		System.out.println(testDeck.toString());
		testDeck.searchCard("La Papesse");
		testDeck.searchCardByNumber(2);

	}
	
}
