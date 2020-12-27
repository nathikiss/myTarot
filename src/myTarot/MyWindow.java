package myTarot;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class MyWindow extends JFrame {

	/**
	 * @author Nathivel Kissita
	 * This class contains our application, a Graphical User Interface
	 * GUI.
	 * With JFrame we visually display cards, we can remove them
	 * modify them or create new ones with ActionListener
	 * */
	 
	private static final long serialVersionUID = -3195675131456561211L;
	
	
	public MyWindow() {
		super("Mystic Tarot");
		/**
		 *@param JFrame.EXIT_ON_CLOSE give a behavior to the window, 
		 *when we click on the red cross the window will be closed 
		 **/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		final Deck deckTest = new Deck();
		deckTest.fillTest();
		
		/* page is a JPanel representing our page, all the data will be display on it
		 * We choose a BoxLayout to display data successively
		 * */
		final JPanel page = new JPanel();
		BoxLayout manPage = new BoxLayout(page, BoxLayout.Y_AXIS);
		page.setLayout(manPage);
		
		/* gameTable represent the divination table on it there will be several cardPan */
		final JPanel gameTable = new JPanel();
		
		/*
		 * Select the manager
		 * FlowLayout permit display the several cards align
		 * */
		FlowLayout manTable = new FlowLayout();
		gameTable.setLayout(manTable);

		/* Loop permitting display all the card */
		for(final Card card : deckTest.getCards()) {
			final JPanel cardPan = new JPanel();
			
			/* 
			 * Choose a Layout manager
			 * Here we choose a BoxLayout because we want to display
			 * the card picture and it name with the axis Y to organize 
			 * horizontally (permitting display the one under the other)
			 */
			BoxLayout manCard = new BoxLayout(cardPan, BoxLayout.Y_AXIS);
			
			/* Attach the layout to the panel */
			cardPan.setLayout(manCard);
			
			/* We create a label containing the card's Name */
			System.out.println(card);
			JLabel nameCard =new JLabel(card.getName());
			
			
			/* ICON */
			ImageIcon icon = new ImageIcon(card.getImgPath());
			Image iconData = icon.getImage();
			
			/* Icon resizing */
			Image resizedIcon=iconData.getScaledInstance(87,162,java.awt.Image.SCALE_SMOOTH);			
			icon=new ImageIcon(resizedIcon);
			
			/* We create a label containing the card's resized Icon */
			JLabel iconLabel=new JLabel(icon);
			
			/* Description with a scroll bar to display everything */
			JLabel descCard =new JLabel(card.getDescription());
			JScrollPane scrollRight= new JScrollPane(descCard);
			
			/*
			 * Those Buttons permit remove a card, update a card
			 */
			
			JButton suppButton = new JButton("Supprimer");
			suppButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					/* Remove the card in the GUI */
				      gameTable.remove(cardPan);
				    /* Remove the card in the arrayList Deck */
				      deckTest.removeCard(card.getName());
				      pack();
				    }
			});
			
			JButton updateButton = new JButton("Mise à Jour");
			updateButton.addActionListener(new ActionListener() {
				
				/**
				 * This method was supposed to update a Card in the GUI and 
				 * in the Deck
				 */
				@Override
				public void actionPerformed(ActionEvent arg0) {
					JPanel updWindow = new JPanel();
					BorderLayout manUpd = new BorderLayout();
					updWindow.setLayout(manUpd);
					JTextField newName = new JTextField();
					JButton ok = new JButton("OK");
					updWindow.add(newName);
					updWindow.add(ok);
					page.add(updWindow);
					ok.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							
						}
					});
				}
			});
			
			/* We stock the labels into the panel */
			cardPan.add(nameCard);
			cardPan.add(iconLabel);
			//cardPan.add(scrollRight);
			cardPan.add(suppButton);
			cardPan.add(updateButton);
			
			/* We insert cardPans (containing picture card and name card) in the gameTable
			 * as if we were setting the Deck on a table */
			gameTable.add(cardPan);
		}
		
		/* add a toolbar to the page */
		JToolBar toolBar = toolBar();
		toolBar.setMaximumSize(new Dimension(1000,30));
		page.add(toolBar);
		/* add the gameTable to the page */
		page.add(gameTable);
		setContentPane(page);
		
		
		/**
		 * Serialization
		 * This allows us to stock our data in a file
		 * @param "tarotSave.ser" is the name give, to the file in which 
		 * we will save our data
		 * We try to write in the file we catch the exception
		 * @throws FileNotFoundException if the file hasn't been found
		 * @throws IOException Signals that an I/O exception of some sort has occurred 
		 * */
		try {
			FileOutputStream fos = new FileOutputStream("tarotSave.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(deckTest);
			oos.close();
			} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This private method allows to create a ToolBar
	 * Here it will represent a search bar with a TextArea and a Button
	 * @return toolbar 
	 */
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
