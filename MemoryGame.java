import javax.swing.JFrame;
import javax.swing.JOptionPane;  //for  dialog boxes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**
 * The memory game. Players try to match two cards and if they are the same then the player increases their match count. Whichever player has the higher amount of matches wins the game.
 * PROTOCOL:
	 * SET PLAYER : Sets the player to 0 or 1. 0 means the player should begin the game.
	 * PLAYING : Sets if it's the player's turn. 
	 * TRY : The server or player can choose a card either through command or by the user clicking the card. A player has maximum 2 cards to pick.
	 * SHOW : The server displays the specified card.
	 * COVER : Covers the specified cards.
	 * PAIRS : Increases the amount of pairs the player has.
	 * DISABLE : Disables the specified cards that were matched.
	 * WINNER : Sets the player to winner.
	 * LOSER : Sets the player to loser.
 */
public class MemoryGame
{
	public static void main(String[] args)
	{
		JFrame fr = new ServerFrame();
		fr.setTitle("Server");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
	}
}
