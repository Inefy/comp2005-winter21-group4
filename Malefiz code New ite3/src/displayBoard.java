//group 4

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class displayBoard implements ActionListener{ 
	
    public JFrame UIframe;
	public JPanel boardPanel;
    public JPanel backPanel;
    public JPanel buttonPanel;
    public JLabel inputNameLabel;
    public JButton[][] step;
    public JButton rollDice, saveGame, mainui, exit;
   
    public displayBoard(JFrame frame, JPanel p) {
    	UIframe = frame;
    	backPanel = p;
    	backPanel.removeAll();
    	backPanel.revalidate();
    	backPanel.repaint();
        
    	rollDice = new JButton("Roll Dice");
    	saveGame = new JButton("Save Game");
    	mainui = new JButton("Main Menu");
    	exit = new JButton("Exit Game");
    	mainui.addActionListener(this);
    	exit.addActionListener(this);
    	backPanel.setLayout(new BorderLayout());
    	
    	buttonPanel = new JPanel();
    	buttonPanel.add(rollDice);
    	buttonPanel.add(saveGame);
    	buttonPanel.add(mainui);
    	buttonPanel.add(exit);
    	
    	backPanel.add(buttonPanel, BorderLayout.SOUTH);
    	
    	int row = 16;
        int col = 17;
        boardPanel = new JPanel(new GridLayout(row, col));
        
        step = new JButton[row][col];
        
        
        for (int i = 0; i < row; i++){
        	for (int j = 0; j < col; j++){
        		step[i][j] = new JButton("");
        		step[i][j].setBackground(Color.WHITE);
        		step[i][j].setBorderPainted(false);
        		step[i][j].setSize(10,10);
        		step[i][j].setEnabled(false);
        		boardPanel.add(step[i][j]);
        	}
        }
        
        new setBoard(boardPanel, step);	//sets the empty pieces
        new boardPieces(boardPanel, step);	//sets pawns to starting position and barricade to its original position
        
        
        backPanel.add(boardPanel, BorderLayout.CENTER);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object selected = e.getSource();
		if(selected.equals(mainui)) {
			int reply = JOptionPane.showConfirmDialog(
					UIframe,
				    "Are you sure you want to go the Main Menu?",
				    "An Insane Question",
				    JOptionPane.YES_NO_OPTION);
		  if (reply == JOptionPane.YES_OPTION)
	      {
			  //direct to mainUI()
	      }
		}
		
		if(selected.equals(exit)) {
			new exitGame(UIframe);
		}
		
	}
}
