import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.util.*;


import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
/**
	Server that handles all the commands of Memory game
*/
public class ServerFrame extends JFrame
{
	//Default frame dimensions
	private static final int FRAME_WIDTH = 450;
	private static final int FRAME_HEIGHT = 100;
	
	//GUI objects of the window
	private JTextField leftField;
	private JTextField rightField;
	private JButton commandButton;
	private JComboBox commandCombo;
	
	private HumanFrame player;
	
	
	public ServerFrame()
	{
		createButton();
		createTextField();
		createComboBox();
		createPanel();
		
		player = new HumanFrame();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		player.setVisible(true);
		player.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Creates a button for user to click to execute the desired command
	 */
	private void createButton()
	{
		commandButton = new JButton("Execute Command");
		commandButton.addActionListener(e -> this.command((String)commandCombo.getSelectedItem()));
	}
	
	/**
	Creates the combo box with the command choices.
	*/
	private void createComboBox()
	{
		commandCombo = new JComboBox();
		commandCombo.addItem("SET PLAYER");
		commandCombo.addItem("PLAYING");
		commandCombo.addItem("TRY");
		commandCombo.addItem("SHOW");
		commandCombo.addItem("COVER");
		commandCombo.addItem("PAIRS");
		commandCombo.addItem("DISABLE");
		commandCombo.addItem("WINNER");
		commandCombo.addItem("LOSER");
		commandCombo.setEditable(true);
	}
	
	/**
	* Creates the field for paramters for the various commands
	*/
	private void createTextField()
	{
		final int FIELD_WIDTH = 5;
		leftField = new JTextField(FIELD_WIDTH);
		rightField = new JTextField(FIELD_WIDTH);
		leftField.setText("0");
	}
	
	 /**
	 * Creates the window with GUI objects
	 */
	private void createPanel()
	{
		JPanel panel = new JPanel();

		panel.add(commandCombo);
		panel.add(leftField);
		panel.add(rightField);
		panel.add(commandButton);
		add(panel);
	}
	
	/**
	 * Gets the various commands from the JComboBox and executes the corresponding command.
	* @param command from JComboBox
	*/
	public void command(String command)
	{
		if(command == "SET PLAYER")
		{
			//Sets player to 0 or 1. If 0 then this.player will begin the game.
			setPlayer(Integer.parseInt(leftField.getText()));
			System.out.println("server -> player" + player.getPlayer() + " -> SETPLAYER " + player.getPlayer());
			player.setTitle("PLAYER " + player.getPlayer());
		}
		
		else if(command == "PLAYING")
		{
			//If leftField has 0 then it's this.player's turn
			if(Integer.parseInt(leftField.getText()) == 0)
			{
				player.setTurn(true);
				System.out.println("server -> player" + player.getPlayer() + " -> PLAYING " + player.getPlayer());
			}
			//Not this.player's turn
			else if(Integer.parseInt(leftField.getText()) == 1)
			{
				player.setTurn(false);
			}
		}
		
		//Player chooses a card
		else if(command == "TRY")
		{
			if(player.getTurn())
			{
				player.pickCard(Integer.parseInt(leftField.getText()));
			}
		}
		
		//Show the chosen cards
		else if(command == "SHOW")
		{
			player.showCard(Integer.parseInt(leftField.getText()), rightField.getText());
			System.out.println("server -> player" + player.getPlayer() + " -> SHOW " + leftField.getText() + " " + rightField.getText());
		}
		
		else if(command == "COVER")
		{
			player.coverCard(Integer.parseInt(leftField.getText()), Integer.parseInt(rightField.getText()));
			System.out.println("server -> player" + player.getPlayer() + " -> COVER " + leftField.getText() + " " + rightField.getText());
		}
		
		//Increase the number of pairs by 1
		else if(command == "PAIRS")
		{
			if(player.getTurn())
			{
				System.out.println("server -> player" + player.getPlayer() + " -> PAIRS " + leftField.getText());
				player.increaseMatches();
			}
		}
		
		else if(command == "DISABLE")
		{
			System.out.println("server -> player" + player.getPlayer() + " -> DISABLE " + leftField.getText() + " " + rightField.getText());
			player.disableCards(Integer.parseInt(leftField.getText()), Integer.parseInt(rightField.getText()));
		}
		
		else if(command == "WINNER")
		{
			System.out.println("server -> player" + player.getPlayer() + " -> WINNER " + leftField.getText());
			player.win();
		}
		else if(command == "LOSER")
		{
			System.out.println("server -> player" + player.getPlayer() + " -> LOSER " + leftField.getText());
			player.lose();
		}
	}
	
	/**
	 * Sets the player to 0 or 1 in the leftField textfield. If player is set to 0, the player should begin the game.
	* @param number the text in the leftField textfield converted to an integer.
	*/
	public void setPlayer(int number)
	{
		if(number == 0)
		{
			player.setPlayer(0);
		}
		else if(number == 1)
		{
			player.setPlayer(1);
		}
	}
	
}