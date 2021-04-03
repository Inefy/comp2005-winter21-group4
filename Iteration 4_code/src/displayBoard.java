//group 4

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;



public class displayBoard implements ActionListener{ 
	
    public JFrame UIframe;
	public JPanel boardPanel;
    public JPanel backPanel;
    public JPanel buttonPanel;
    public JLabel inputNameLabel;
    public int row = 16;
    public int col = 17;
    public JButton[][] step;
    public JButton rollDice, saveGame, mainui, exit;
    public JLabel valueLabel = new JLabel("Dice Value: -  ");
    public JLabel turnOrder = new JLabel();
    public int diceValue, playerTurn;
    public Icon endgoal = new ImageIcon(displayBoard.class.getResource("/images/endgoal.png"));
    //public String[] names;
   
    public displayBoard(JFrame frame, JPanel p) {
    	//TODO modify display current player on the left bottom corner
		playerTurn = gameData.currentPlayer;
		turnOrder.setText("Turn: Player "+playerTurn);

    	UIframe = frame;
    	backPanel = p;
    	backPanel.removeAll();
    	backPanel.revalidate();
    	backPanel.repaint();
    	String[] names = {"Player 1","Player 2","Player 3","Player 4"};
        
    	rollDice = new JButton("Roll Dice");
    	saveGame = new JButton("Save Game");
    	mainui = new JButton("Main Menu");
    	exit = new JButton("Exit Game");
    	
    	
    	backPanel.setLayout(new BorderLayout());
    	
    	buttonPanel = new JPanel();
    	
    	buttonPanel.add(turnOrder);
    	
    	buttonPanel.add(valueLabel);
    	
    	buttonPanel.add(rollDice);
    	rollDice.setEnabled(true);
		rollDice.addActionListener(this);
		
    	buttonPanel.add(saveGame);
    	saveGame.addActionListener(this);
    	
    	buttonPanel.add(mainui);
    	mainui.addActionListener(this);
    	
    	buttonPanel.add(exit);
    	exit.addActionListener(this);
    	
    	backPanel.add(buttonPanel, BorderLayout.SOUTH);
    	
    	
        boardPanel = new JPanel(new GridLayout(row, col));
        
        step = new JButton[row][col];
        
        
        //this nested for loop sets the board don't mess with it please
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
        
        
        /*while(String.valueOf(step[0][8].getIcon())==String.valueOf(endgoal))
        {
        	//this loop goes on till someone wins the game/reaches the endgoal point
        	for(int i = 0; i < names.length; i++) 
        	{
        		turnOrder.setText("turn: "+names[i]+"  ");
        		rollDice.setEnabled(true);
        		rollDice.addActionListener(this);
        	}
        }*/
        
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
			  new mainUI(UIframe, backPanel);
	      }
		}
		
		if(selected.equals(exit)) {
			//Direct to exit game
			new exitGame(UIframe);
		}
		
		if(selected.equals(rollDice)) {

			Random x = new Random();
			diceValue = x.nextInt(6) + 1;
			valueLabel.setText("Dice Value: "+String.valueOf(diceValue)+"  ");
			//valueLabel.setText("Dice Value: "+String.valueOf(endgoal)+"  ");
			//rollDice.setEnabled(false);
			turnOrder.setText("Turn: Player "+playerTurn);
			new movePawn(UIframe,step,rollDice,diceValue,playerTurn,valueLabel,turnOrder);

			//TODO changing player when move has made
			playerTurn++;
			if(playerTurn > 4) {
				playerTurn = 1;
			}
		}
		
		if(selected.equals(saveGame)) {

			for (int i = 0; i < step.length; i++) {
				for (int j = 0; j < step[0].length; j++) {
					Icon icon = step[i][j].getIcon();
					if(icon!=null){
						ImageIcon imageIcon = (ImageIcon)icon;
						String desc = imageIcon.getDescription();
						if(desc.contains("emptyspace")){
							gameData.map[i][j] = '0';
						}else if(desc.contains("endgoal")){
							gameData.map[i][j] = '9';
						}else if(desc.contains("barricade")){
							gameData.map[i][j] = '5';
						}else if(desc.contains("player1")){
							gameData.map[i][j] = '1';
						}else if(desc.contains("player2")){
							gameData.map[i][j] = '2';
						}else if(desc.contains("player3")){
							gameData.map[i][j] = '3';
						}else if(desc.contains("player4")){
							gameData.map[i][j] = '4';
						}
					}else{
						gameData.map[i][j] = ' ';
					}
				}
			}
			//TODO add  color gameData.playerColor and shape gameData.playerShape
			gameData.currentPlayer = playerTurn;
			boolean save = gameData.saveGameData();
			if(save){
				JOptionPane.showMessageDialog(UIframe, "Save game successfully.",
						"Info", JOptionPane.WARNING_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(UIframe, "Save game failed.",
						"Info", JOptionPane.WARNING_MESSAGE);
			}

		}
		
	}
}
