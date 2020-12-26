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
		JPanel contentPane= (JPanel) this.getContentPane();
		
		int maxCardPerLine = deckTest.getCards().size();
		GridLayout gridCard=new GridLayout(3,maxCardPerLine,20,20);
		contentPane.setLayout(gridCard);
		

		contentPane.add(toolBar());
		
		for(Card card : deckTest.getCards()) {
			JLabel nameCard =new JLabel(card.getName());
			contentPane.add(nameCard);
		}
	
		for(Card card : deckTest.getCards()) {
			/*ICON*/
			ImageIcon icon = new ImageIcon(card.getImgPath());
			Image iconData = icon.getImage();
			/*Icon resizing*/
			Image resizedIcon=iconData.getScaledInstance(87,162,java.awt.Image.SCALE_SMOOTH);			
			icon=new ImageIcon(resizedIcon);
			JLabel label=new JLabel(icon);
			contentPane.add(label);	
		}
		
		for(Card card : deckTest.getCards()) {
			JTextField descCard =new JTextField(card.getDescription());
			descCard.setEditable(false);
			JScrollPane scrollRight= new JScrollPane(descCard);
			contentPane.add(scrollRight,BorderLayout.CENTER);
			//contentPane.add(descCard);
		}
		
		
	
		

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
