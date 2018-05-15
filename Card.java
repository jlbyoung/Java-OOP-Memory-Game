import javax.swing.*;
import java.awt.*;

/**
 * A card button that user clicks on to match pairs
*/
public class Card extends JButton
{
	//True if the button is disabled, false otherwise
	private boolean isDisabled;
	
	public Card(String string)
	{
		super(string);
		isDisabled = false;
	}
	
	/**
	 * Sets wheter or not the button is disabled or not.
	*/
	public void setDisable(boolean b)
	{
		isDisabled = b;
		setVisible(!b);
	}
	
	public boolean getDisabledStatus()
	{
		return isDisabled;
	}
}