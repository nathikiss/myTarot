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
		
		/*JPanel Creation,*/
		/*First panel creations
		 * gameTable represent the divination table on it there will be several cardPan */
		JPanel gameTable = new JPanel();
		/*Select the manager*/
		FlowLayout manTable = new FlowLayout();
		gameTable.setLayout(manTable);
		
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
		Card idOneCard=deckTest.getCards().get(0);
		System.out.println(idOneCard);
		JLabel nameCard =new JLabel(idOneCard.getName());
		
		
		/*ICON*/
		ImageIcon icon = new ImageIcon(idOneCard.getImgPath());
		Image iconData = icon.getImage();
		
		/*Icon resizing*/
		Image resizedIcon=iconData.getScaledInstance(87,162,java.awt.Image.SCALE_SMOOTH);			
		icon=new ImageIcon(resizedIcon);
		/*We create a label containing the card's resized Icon*/
		JLabel iconLabel=new JLabel(icon);
		
		/**/
		JLabel descCard =new JLabel(idOneCard.getDescription());
		JScrollPane scrollRight= new JScrollPane(descCard);
			
		/*We stock the labels into the panel*/
		cardPan.add(nameCard);
		cardPan.add(iconLabel);
		//cardPan.add(scrollRight);
		setContentPane(cardPan);
		

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
