import javax.swing.*;

public class movePawn {
	
	public int row = 16;
    public int col = 17;
	public JButton[][] step;
	public JButton rollDice;
	public int diceValue, playerTurn;
	
	public movePawn(JButton[][] buttons, JButton rolldice, int dicevalue, int playerturn) {
		step = buttons;
		rollDice = rolldice;
		diceValue = dicevalue;
		playerTurn = playerturn;
		
	}

}
