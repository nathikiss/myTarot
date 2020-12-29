package myTarot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


public class Deck implements Serializable {
	/**
	 * @author Nathivel Kissita
	 * This class contains a card package entitled Deck
	 * @see class Card
	 * Each Deck has a card package, here represented
	 * with an ArrayList 
	 * /
	
	/*Attributes*/
	private ArrayList<Card>cards;
	
	/*Constructors*/
	public Deck () {
		this.cards = new ArrayList<Card>();
	}
	public Deck (ArrayList<Card> c) {
		this.cards=c;
	}
	/*Assessors*/
	public ArrayList<Card> getCards() {
		return cards;
	}
	/*Methods*/
	/**
	 * This method allows us to add a card to the Deck
	 * @param theCard corresponds to the card we want to add to the deck
	 * */
	public void addCard(Card theCard) {
		cards.add(theCard);
		System.out.println("Vous avez ajouté la carte "+theCard.getName());
	}
	/**
	 * This method allows to remove a card, thanks to it name
	 * to do so we go through the ArrayList cards and for each card
	 * in cards if the cardName contains the String nameCard, 
	 * we remove the card , if the card is not found we just display a String
	 * meaning that the card doesn't exist
	 * @param nameCard corresponds to the name of the card
	 * */
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
	
	/**
	 * This method filled the deck with Tarot cards
	 * Permitting us doing test
	 * We implement three arrays representing cards attributes names,
	 * descriptions, images, we put data in its  and thanks to a loop we take 
	 * one data from each array to create a new Card
	 * */
	public void fillTest() {
		String[] names= { "Le Bateleur", "La Papesse", "L'Impératrice", "L'Empereur"};
		String [] descs = {"C’est le début de tout. Je montre mes capacités"+"\n"+"Je manque de confiance en moi. J’ai peur de m’affirmer.",
							"Je prends le temps de bien préparer mon projet"+"\n"+"Je me bloque et j’attends. Je me renferme sur moi-même.",
							"Je m’exprime. Je communique "+"\n"+"Je parle trop. Je m’exprime trop brutalement.",
							"J’agis. Je réalise. Je dirige."+"\n"+"Je suis trop autoritaire"};
		/*Just to Avoid repetition*/
		String srcPath="src/myTarot/images/";
		String [] imgs= {srcPath+"lebateleur.jpg",srcPath+"lapapesse.jpg",srcPath+"limperatrice.jpg",srcPath+"lempereur.jpg"};
		String desc= "Pas de Description insérée";
		String img ="No Image";
  		for(int i=0; i<names.length;i++) {
  			if (descs.length==names.length && imgs.length==names.length) {
  				desc = descs[i];
  				img=imgs[i];
  				
			}
			cards.add(new Card(names[i],desc,img));
			}
	
	}
	
	/*This method filled the deck with the Marseille Tarot cards
	 * */
	public void fillWithDeckMarseille() {
		String[] namesMarseille = { "Le Bateleur", "La Papesse", "L'Impératrice", "L'Empereur", "Le Pape", "L'Amoureux",
	            "Le Chariot", "La Justice", "L'Hermite", "La Roue de la fortune", "La Force", "Le Pendu", "L'Arcane sans nom", "Tempérance",
	            "Le Diable", "La Maison-Dieu", "L'Étoile", "La Lune", "Le Soleil", "Le Jugement", "Le Monde", "Le Mat" };
		String [] descsMarseille = {""};
		String desc= "Pas de Description insérée";
  		for(int i=0; i<namesMarseille.length;i++) {
  			if (descsMarseille.length==namesMarseille.length) {
  				desc = descsMarseille[i];
			}
			cards.add(new Card(namesMarseille[i],desc));
			}
	
	}
	
	/**
	 * leverDeVoile is a cards drawing method, we shuffle the deck, draw three cards 
	 * to set on the table and we give the prediction of the three card :
	 * the first one symbolize how the situation is perceive the situation
	 * the second one represent what prevent the user from seeing the truth
	 * the last one is the truth the real situation 
	 * @return divinationCards a ArrayList of containing the three cards
	 * */
	public ArrayList<Card> leverDeVoile(){
		Collections.shuffle(cards);
		ArrayList<Card> divinationCards = new ArrayList<Card>();
		System.out.println("le paquet est mélangé \n");
		if (cards.size()>0) {
			Card perceiveCard = this.cards.get(cards.size()-1);
			Card troubleCard = this.cards.get(cards.size()-2);
			Card truthCard = this.cards.get(cards.size()-3);
			divinationCards.add(perceiveCard);
			divinationCards.add(troubleCard);
			divinationCards.add(truthCard);
			}
		return divinationCards;
	}
	
	
	/**
	 * @param n a String representing the name of the card
	 * Thanks to a loop we search the parameter in the Deck
	 * if we found it we display a String saying that we found it
	 * else we display an other String saying that the card doesn't exist
	 * */
	public void searchCard(String n) {
		String cardName="";
		Card theCard=null;
		int foundCard=0;
		for (Card card :cards) {
			cardName = card.getName();
			if(cardName == n ) { 
				foundCard += 1;
				theCard = card;
				break;
			}
		}
		if (foundCard==1) {
			System.out.println("La carte "+cardName+" a été trouvé");
		}
		else {
			System.out.println("La carte n'existe pas ou son nom n'est pas exacte");
		}
		
		
	}
	
	/**
	 * This method allows searching a card by is position in the Deck
	 * thanks to a number.
	 * We get through the deck to get the card which the position corresponding
	 * to the number given in parameter.
	 * @param nb int representing the number of the card we want to display
	 * @return theCard we wanted
	 * */
	public Card searchCardByNumber(int nb) {
		int i;
		Card theCard=null;
		for( i = 0; i<=nb ; i++) {
			theCard=cards.get(nb);
		}
		System.out.println("La carte ayant l'indice "+nb+" est "+theCard.getName());
		return theCard;
	}
	
	/**
	 * This method allows us to search a card thanks to an approximative String
	 * we search in our ArrayList Deck if the String given in parameter can
	 * corresponds to a card name.   
	 * @param n a String representing a String that the Card name contains
	 * @return theCard we found or nothing if the card was never found
	 * */
	public Card searchCardByStringIn(String n) {
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
			System.out.println("Vous avez entrez la chaine de caractère "+n+
					"\n"+"Recherchez vous la carte "+theCard.getName()+" ?");
			return theCard;
		}
		else if (foundCard>1){
			System.out.println("Votre chaine de caractère('"+n+"')a été retrouvé dans plusieurs cartes");
			for (Card card :cards) {
				cardName = card.getName();
				if(cardName.contains(n)) {//if the card contains the user's String 
					System.out.println(cardName+"\n");
				}}
			System.out.println("Veuillez réecrire la carte recherchée");
			return theCard;
		}
		else {
			System.out.println("La chaine de caractère "+n+" n'a pas été trouvé dans votre paquet");
			return theCard;
		}
	
	}
	/**
	 * The method toString() is a String representation of this Object
	 * @return a String meaning that our Deck is empty if the size of
	 * ArrayList is lower than 1,otherwise it returns a String
	 * associated with the array of Card containing cards names 
	 * */
	@Override
	public String toString() {
		if (getCards().size()<1) {
			return "Votre deck est vide";
		}
		else {
			return "Voici votre deck : "+getCards();
		}
	}
	
}
