import java.awt.event.*;

import javax.swing.*;

public class movePawn implements ActionListener, MouseListener {
	
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
		
		for (int i = 0; i < row; i++){
        	for (int j = 0; j < col; j++){
        		step[i][j].addActionListener(this);
        		
        	}
        }
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object selected = e.getSource();
		for (int i = 0; i < row; i++){
        	for (int j = 0; j < col; j++){
        		if(selected.equals(step[i][j])) {
                    System.out.println(i+","+j);
        		}
        		
        	}
        }
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		/*Object selected = e.getSource();
		
		if (selected instanceof JButton)
		{
            JButton step = (JButton) selected;
            System.out.println(x+","+y);
            
		}*/
	}
	
	// not used but must be present to fulfill MouseListener contract
	public void mouseEntered(MouseEvent arg0){}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}

}
