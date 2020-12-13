package myTarot;

import java.util.ArrayList;

public class Deck {
	/*
	 * This class contains a card package, a name, methods which allow to add card, 
	 * to remove card, to search a card among the deck */
	
	/*Attributes*/
	private ArrayList<Card>cards;
	
	/*Constructors*/
	public Deck (ArrayList<Card> c) {
		this.cards=c;
	}
	/*Assessors*/
	public ArrayList<Card> getCards() {
		return cards;
	}
	/*Methods*/
	/*This method allows add a card*/
	public void addCard(Card theCard) {
		cards.add(theCard);
		System.out.println("Vous avez ajouté la carte "+theCard.getName());
	}
	/*This method allows remove a card, thanks to it name*/
	public void removeCard(String nameCard) {
		String cardName="";
		Card theCard=null;
		int foundCard=0;
		for (Card card :cards) {
			cardName = card.getName();//we retrieve the name
			if(cardName.contains(nameCard)) {//if the card contains the user's String 
				theCard=card;
				foundCard=1;
			}
		}
		if(foundCard==1) {
			cards.remove(theCard);
			System.out.println("Vous avez supprimé la carte"+" "+nameCard);
		}
		else {
			System.out.println("La carte que vous souhaitez supprimer n'existe pas");
		}
	}
	
	public void fillWithDeckMarseille() {
		String[] namesMarseille = { "Le Bateleur", "La Papesse", "L'Impératrice", "L'Empereur", "Le Pape", "L'Amoureux",
	            "Le Chariot", "La Justice", "L'Hermite", "La Roue de la fortune", "La Force", "Le Pendu", "L'Arcane sans nom", "Tempérance",
	            "Le Diable", "La Maison-Dieu", "L'Étoile", "La Lune", "Le Soleil", "Le Jugement", "Le Monde", "Le Mat" };
		for(int i=0; i<namesMarseille.length;i++) {
			cards.add(new Card(namesMarseille[i]));
			
		}
	
	}
	public Card displayOneCard(String n) {
		Card theCard=null;
		for (Card card :cards) { 
			if(card.getName()==n) {
				theCard=card;
			}
		}
		return theCard;
	 
	}
	public void searchCard(String n) {
		String cardName="";
		Card theCard=null;
		int foundCard=0;
		for (Card card :cards) {
			cardName = card.getName();//we retrieve the name
			if(cardName.contains(n)) {//if the card contains the user's String 
				foundCard+=1;
				theCard=card;
			}
		}
		if (foundCard==1) {
			System.out.println("Vous avez entrez la chaine de caractère "+n+"\n"+"Recherchez vous la carte "+theCard.getName()+" ?");
			
		}
		else if(foundCard>1){
			System.out.println("Votre chaine de caractère('"+n+"')a été retrouvé dans plusieurs cartes");
			for (Card card :cards) {
				cardName = card.getName();
				if(cardName.contains(n)) {//if the card contains the user's String 
					System.out.println(cardName+"\n");
					//foundCard=1;
					//theCard=card;
				}}
			System.out.println("Veuillez réecrire la carte recherchée");
		}
		else {
			System.out.println("La chaine de caractère "+n+" n'a pas été trouvé dans votre paquet");
		}
	
	}
	
	@Override
	public String toString() {
		
		return "Voici votre deck : "+getCards();
	}
	
}
