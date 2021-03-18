import javax.swing.*;

public class movePawn {
	
	public int row = 16;
    public int col = 17;
	public JButton[][] step;
	public JButton rollDice;
	public int diceValue, playerTurn;
	public Icon emptySpace = new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png"));
	public Icon barricade = new ImageIcon(displayBoard.class.getResource("/images/barricade.png"));
	public Icon endgoal = new ImageIcon(displayBoard.class.getResource("/images/endgoal.png"));
	public Icon player1 = new ImageIcon(displayBoard.class.getResource("/images/player1.png"));
	public Icon player2 = new ImageIcon(displayBoard.class.getResource("/images/player2.png"));
	public Icon player3 = new ImageIcon(displayBoard.class.getResource("/images/player3.png"));
	public Icon player4 = new ImageIcon(displayBoard.class.getResource("/images/player4.png"));
	
	
	public movePawn(JButton[][] buttons, JButton rolldice, int dicevalue, int playerturn) {
		step = buttons;
		rollDice = rolldice;
		diceValue = dicevalue;
		playerTurn = playerturn;
		
	}

}
