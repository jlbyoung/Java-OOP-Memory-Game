import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.WindowConstants.*;
import java.awt.*;
import java.awt.GridLayout.*;
import java.util.*;


import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
/**
	Player that plays the Memory game
*/
public class HumanFrame extends JFrame
{
	//Default frame dimensions
	private static final int FRAME_WIDTH = 700;
	private static final int FRAME_HEIGHT = 375;
	
	private static final int CARD_WIDTH = 100;
	private static final int CARD_HEIGHT = 100;
	
	private final String DEFAULT_TEXT = "1181";
	
	//GUI objects of the window
	private JButton forfeitGameButton;
	private JButton newGameButton;
	private JLabel matchesField;
	private JLabel playerNumberField;
	private JTextArea gameStatusField;
	private JScrollPane scrollPane;
	
	//The number the player is assigned to. 0 means the player should begin the game.
	private int playerNumber;
	
	//True if it's the player's turn, false otherwise.
	private boolean isYourTurn;
	
	//Number of pairs the player has matched
	private int matches;
	
	//Card buttons
	private Card[] cards;
	private Card card0;
	private Card card1;
	private Card card2;
	private Card card3;
	private Card card4;
	private Card card5;
	
	//Number of pickedCards the user has selected. If greater or equal to 2, the user cannot select any more cards.
	private int pickedCards;

	public HumanFrame()
	{
		pickedCards = 0;
		createButton();
		createFields();
		initComponents();
		setResizable(false);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	/**
	 * Creates the window with GUI objects
	*/
	private void createFields()
	{
		gameStatusField = new JTextArea("Welcome to Memory \n", 7, 30);
		gameStatusField.setEditable(false);
		matchesField = new JLabel("Number of Matches : ");
		playerNumberField = new JLabel("You are Player ");
	}
	
	/**
	 * Creates the newGame and quitGame buttons
	*/
	private void createButton()
	{
		forfeitGameButton = new JButton();
		newGameButton = new JButton();
		
		newGameButton.addActionListener(e -> newGame());
		forfeitGameButton.addActionListener(e -> forfeitGame());
	}
	
	/**
	 * Creates the window with GUI objects
	*/
	private void initComponents() 
	{
		ActionListener listener = new CardListener();
		card0 = new Card(DEFAULT_TEXT);
		card0.addActionListener(listener);
		card1 = new Card(DEFAULT_TEXT);
		card1.addActionListener(listener);
		card2 = new Card(DEFAULT_TEXT);
		card2.addActionListener(listener);
		card3 = new Card(DEFAULT_TEXT);
		card3.addActionListener(listener);
		card4 = new Card(DEFAULT_TEXT);
		card4.addActionListener(listener);
		card5 = new Card(DEFAULT_TEXT);
		card5.addActionListener(listener);
		
		cards = new Card[] {card0, card1, card2, card3, card4, card5};
		
		scrollPane = new JScrollPane();
		newGameButton = new JButton();
		forfeitGameButton = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		card0.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));

		card1.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));

		card2.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));

		card3.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));

		card4.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));

		card5.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));

		scrollPane.setViewportView(gameStatusField);
		newGameButton.setText("New Game");
		forfeitGameButton.setText("Forfeit Game");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
		    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup()
			.addContainerGap()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
			    .addGroup(layout.createSequentialGroup()
				.addComponent(forfeitGameButton)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(newGameButton))
			    .addGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(playerNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(matchesField, GroupLayout.Alignment.LEADING))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				    .addGroup(layout.createSequentialGroup()
					.addComponent(card3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(card4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(card5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				    .addGroup(layout.createSequentialGroup()
					.addComponent(card0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(card1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(card2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
		    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup()
			.addContainerGap()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			    .addGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(card0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(card1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(card2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(card3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(card4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(card5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
			    .addGroup(layout.createSequentialGroup()
				.addComponent(playerNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(matchesField)))
			.addGap(33, 33, 33)
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			    .addComponent(newGameButton)
			    .addComponent(forfeitGameButton))
			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
	}//initComponents()
	
	/**
	 * Server gets the playerNumber
	* @return playerNumber
	*/
	public int getPlayer()
	{
		return playerNumber;
	}
	
	/**
	 * Server sets the player to either 0 or 1 with the *SETPLAYER* command. If player is set to 0, then that player will begin the game.
	* @param n , 0 or 1
	*/
	public void setPlayer(int n)
	{
		if(n == 0)
		{
			playerNumber = 0;
			playerNumberField.setText("You are Player 0");
			gameStatusField.append("You are Player 0 \n");
		}
		else if(n == 1)
		{
			playerNumber = 1;
			playerNumberField.setText("You are Player 1");
			gameStatusField.append("You are Player 1 \n");
		}
	}
	
	/**
	 * The server requests whether or not it is the player's turn. 
	* @return isYourTurn returns true if it's the players turn, false otherwise.
	*/
	public boolean getTurn()
	{
		return isYourTurn;
	}
	
	/**
	 * The server sets if it's the player's turn with the *PLAYING* command. When this command is executed, then the number of picked cards is also reset.
	* @param b true if it's the player's turn, false otherwise
	*/
	public void setTurn(boolean b)
	{
		isYourTurn = b;
		if(isYourTurn)
		{
			gameStatusField.append("Your turn. \n");
			pickedCards = 0;
		}
		else
		{
			gameStatusField.append("It's not your turn. \n");
		}
	}
	
	/**
	 * Either the server or player can initiate this command with the *TRY* command. The player can activates this when clicking on a card during their turn. 
	* @param buttonNumber the index of the card
	*/
	public void pickCard(int buttonNumber)
	{
		if(!cards[buttonNumber].getDisabledStatus())
		{
			if(pickedCards < 2)
			{
				gameStatusField.append("Picked card in slot " + buttonNumber + "\n");
				System.out.println("player" + playerNumber + " -> server -> TRY card " + buttonNumber);
				pickedCards++;
			}
		}
	}
	
	/**
	 * The server displays the chosen card with the *SHOW* command.
	* @param leftNumber the index of the card specified on the leftField on the server frame. 
	* @param string the rightField's text
	*/
	public void showCard(int leftNumber, String string) 
	{
		cards[leftNumber].setText(string);
	}
	
	/**
	 * The server covers the two cards that have been picked with the *COVER* command.
	* @param leftNumber the index of the card specified on the leftField on the server frame. 
	* @param rightNumber the index of the card specified on the leftField on the server frame. 
	*/
	public void coverCard(int leftNumber, int rightNumber) 
	{
		cards[leftNumber].setText(DEFAULT_TEXT);
		cards[rightNumber].setText(DEFAULT_TEXT);
	}
	
	/**
	 * The server requests the amount of matches the player currently has.
	* @return matches the number of pairs the player has.
	*/
	public int getMatches()
	{
		return matches;
	}
	
	/**
	 * The server increases the number of matches the player has with the *PAIRS* command.
	*/
	public void increaseMatches()
	{
		matches++;
		matchesField.setText("Number of Matches : " + matches);
	}
	
	/**
	 * The server disables specified cards when the player has matched a pair with the *DISABLE* command.
	* @param leftField the text on the leftField, converted into an integer
	* @param rightField the text on the rightField, converted into an integer
	*/
	public void disableCards(int leftField, int rightField)
	{
		cards[leftField].disable();
		cards[rightField].disable();
	}
	
	/**
	 * The player forfeits the game during their turn, ends the game and disables buttons.
	*/
	private void forfeitGame()
	{
		if(isYourTurn)
		{
			lose();
		}
	}
	
	/**
	 * The player requests a new game and sets all of the GUI objects and parameters to original state.
	*/
	private void newGame()
	{
		if(isYourTurn)
		{
			matches = 0;
			for(int i = 0; i < cards.length; i++)
			{
				cards[i].setDisable(false);
			}
			gameStatusField.setText("");
			playerNumberField.setText("You are Player");
		}
	}
	
	/**
	 * The server sets the player to lose state. Cards are disabled.
	*/
	public void lose()
	{
		gameStatusField.append("You lost. \n");
		for(int i = 0; i < cards.length; i++)
		{
			cards[i].setDisable(true);
		}
	}
	
	/**
	 * The server sets the player to win state. Cards are disabled.
	*/
	public void win()
	{
		gameStatusField.append("You won! \n");
		for(int i = 0; i < cards.length; i++)
		{
			cards[i].setDisable(true);
		}
	}
	
	/**
	 * Displays an error message
	* @param string An error message.
	*/
	public void showError(String string)
	{
		gameStatusField.append("**ERROR : " + string + "** \n");
	}
	
	/**
	 * Listens to mouse clicks on the cards
	*/
	private class CardListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(isYourTurn && pickedCards < 2)
			{
				//Gets the button that was clicked on
				Object obj = e.getSource();
				Card card = (Card)obj;
				String string = card.getText();
				for(int i = 0; i < cards.length; i++)
				{
					if(cards[i].equals(card))
					{
						pickCard(i);
					}
				}
			}
			else if(pickedCards >= 2)
			{
				showError("You already picked 2 cards.");
			}
			else
			{
				showError("It's not your turn.");
			}
		}
	}
}