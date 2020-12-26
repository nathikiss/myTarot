package myTarot;

import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Main {
	
	public static void main(String[] args) {
		//ArrayList<Card>cardsTest =new ArrayList<Card>();
		Deck deckTest = new Deck();
		deckTest.fillTest();
		//System.out.println(deckTest);
		//deckTest.searchCardByStringIn("Le");
		System.out.println(deckTest.searchCardByNumber(1));
		//deckTest.removeCard("Le Pape");
		//System.out.println(deckTest);
		Card CardTest=new Card("ZA WARUDO","The World est le stand de Dio Brando","src/myTarot/images/zawarudo.png");
		//deckTest.addCard(CardTest);
		System.out.println(CardTest.getImgPath());
		System.out.println(deckTest);
		for(Card card : deckTest.getCards()) {
			System.out.println("LE PATH "+card.getImgPath());	
		}
		
		/*
		 *INTERFACE Graphique */
		JFrame window = new JFrame("MYSTIC TAROT");
		window.setSize(600,400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		
		/*TEST DES IMAGES*/
		/*
		window.add(new JLabel(CardTest.getName()));
		window.add(new JLabel(CardTest.getDescription()));
		
		ImageIcon icon = new ImageIcon(CardTest.getImgPath());
		
		JLabel label=new JLabel(icon,JLabel.CENTER);

		window.add(label);
		*/
		for(Card card : deckTest.getCards()) {
			window.setLayout(new FlowLayout());
			window.add(new JLabel(card.getName()));
			//window.add(new JLabel(card.getDescription()));
			
			
			
			/*dszfe*/
			ImageIcon icon = new ImageIcon(card.getImgPath());
			Image iconData = icon.getImage();
			/*Icon resizing*/
			Image resizedIcon=iconData.getScaledInstance(87,162,java.awt.Image.SCALE_SMOOTH);			
			icon=new ImageIcon(resizedIcon);
			JLabel label=new JLabel(icon);
			
			window.add(label);
		}
		
		window.setVisible(true);
		
		/*Serialization*/
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
