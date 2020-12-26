package myTarot;
import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class MyWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3195675131456561211L;
	
	
	public MyWindow() {
		super("Mystic Tarot");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		Deck deckTest = new Deck();
		deckTest.fillTest();
		/* page is a JPanel representing our page, all the data will be display on it
		 * In Box Layout to allow us to display data successively*/
		JPanel page = new JPanel();
		BoxLayout manPage = new BoxLayout(page, BoxLayout.Y_AXIS);
		page.setLayout(manPage);
		
		/* gameTable represent the divination table on it there will be several cardPan */
		JPanel gameTable = new JPanel();
		
		/*Select the manager
		 * FlowLayout permit display the several cards align*/
		FlowLayout manTable = new FlowLayout();
		gameTable.setLayout(manTable);

		/*Loop permitting display all the card*/
		for(Card card : deckTest.getCards()) {
			JPanel cardPan = new JPanel();
			/*Choose a Layout manager
			 * Here we choose a BoxLayout because we want to display
			 * the card picture and it name with the axis Y to organize 
			 * horizontally 
			 */
			BoxLayout manCard = new BoxLayout(cardPan, BoxLayout.Y_AXIS);
			/*Attach the layout to the panel*/
			cardPan.setLayout(manCard);
			/*We create a label containing the card's Name*/
			System.out.println(card);
			JLabel nameCard =new JLabel(card.getName());
			
			
			/*ICON*/
			ImageIcon icon = new ImageIcon(card.getImgPath());
			Image iconData = icon.getImage();
			
			/*Icon resizing*/
			Image resizedIcon=iconData.getScaledInstance(87,162,java.awt.Image.SCALE_SMOOTH);			
			icon=new ImageIcon(resizedIcon);
			/*We create a label containing the card's resized Icon*/
			JLabel iconLabel=new JLabel(icon);
			
			/**/
			JLabel descCard =new JLabel(card.getDescription());
			JScrollPane scrollRight= new JScrollPane(descCard);
				
			/*We stock the labels into the panel*/
			cardPan.add(nameCard);
			cardPan.add(iconLabel);
			//cardPan.add(scrollRight);
			
			/*We insert cardPans (containing picture card and name card) in the gameTable
			 * as if we were setting the Deck on a table*/
			
			gameTable.add(cardPan);
		}
		/*add a toolbar to the page*/
		JToolBar toolBar = toolBar();
		toolBar.setMaximumSize(new Dimension(1000,30));
		page.add(toolBar);
		/*add the gameTable to the page*/
		page.add(gameTable);
		setContentPane(page);
		

	}
	private JToolBar toolBar() {
		JToolBar toolbar = new JToolBar();
		
		JTextArea searchArea = new JTextArea("Inserer la carte à rechercher");
		toolbar.add(searchArea);
		
		JButton searchBtn = new JButton("OK");
		toolbar.add(searchBtn);
		return toolbar;
	}
	public static void main(String[] args) {
		MyWindow window = new MyWindow();
		window.setVisible(true);
	}

}
