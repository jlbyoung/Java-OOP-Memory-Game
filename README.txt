James Young
100273383
CPSC 1181
Gladys Monagan
Assignment 9
Readme.txt

1.) Open two editors and run MemoryGame.java on both.

2.) Select 'SETPLAYER' command on the Server window. Press execute command button.
- In the left text field, input either 0 or 1 to determine which player is player 0 or player 1. 
- 0 should be the player to begin the game.

3.) Select 'PLAYING' command on the Server window. Press execute command button.
- In the left text field, input either 0 or 1 to determine which player's turn it is. 

4.) Now either select 'TRY' command on the Server window or click the desired card to reveal.
- If using the 'TRY' command, input a number from 0 to 5 in the left text field to reveal desired card.
	- The cards follow this layout :
		0 1 2
		3 4 5
- Can only select 2 cards.

5.) Select 'SHOW' command. Repeat this command twice. 
- In the left text field, input a number from 0 to 5 in the left text field to reveal desired card.
	- The cards follow this layout :
		0 1 2
		3 4 5
	- The left text field on the second time should have a different number than the first time.
	 executing the 'SHOW' command.
- In the right text field, input any valid string. 
	- For an honorable game, a matching pair should have the same string.

6.) Select 'COVER' command. 
- In both text fields, input the numbers of the cards that were revealed.

*IF PLAYER HAS MATCHING PAIR*
7.) Select 'PAIRS' command. No parameters in either text field needed. Press execute command.

8.) Select 'DISABLE' command.
- In both text fields, input the numbers of the cards that were a matching pair.

*WHEN THE GAME IS OVER*
9.) Select 'WINNER' and 'LOSER' commands on the respective players that won or lost, no parameters required.

*****OTHER FUNCTIONS*****
New Game - starts a new game during the current player's game. Resets all parameters and GUI.
Forfeit Game - current player loses game. Disables all cards.