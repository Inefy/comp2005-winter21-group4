import java.awt.event.*;

import javax.swing.*;

public class movePawn implements ActionListener
{
    
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
        int flag;
        int x1, x2;
        int y1, y2;
    
    
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
        /*for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if(playerTurn == 1)
                {
                	if(step[i][j].getIcon().equals(player1)) {
                		step[i][j].setEnabled(false);
                	}
                  }
                if(playerTurn == 2)
                {
                	if(step[i][j].getIcon().equals(player2)) {
                		step[i][j].setEnabled(false);
                	}
                  }
                if(playerTurn == 3)
                {
                	if(step[i][j].getIcon().equals(player3)) {
                		step[i][j].setEnabled(false);
                	}
                  }
                 if(playerTurn == 4)
                {
                	 if(step[i][j].getIcon().equals(player4)) {
                 		step[i][j].setEnabled(false);
                 	}
                  }
            }
        }*/
        
        
    }


    @Override
     public void actionPerformed(ActionEvent e) 
     {
        Object selected = e.getSource();
        flag++;
        for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++){
                if(selected.equals(step[i][j])) 
                {
                	if (flag == 1)
                    {
                    x1 = i;
                    y1 = j;
                    }
                	if (flag == 2)
                    {
                		x2 =i;
                        y2 =j;
                        if(x2 == 14 || x2==15) {
                        	flag = 1;
                        }
                        if(playerTurn ==1)
                        {
                            step[x2][y2].setIcon(player1);
                            step[x1][y1].setIcon(emptySpace);
                          }
                        if(playerTurn ==2)
                        {
                            step[x2][y2].setIcon(player2);
                            step[x1][y1].setIcon(emptySpace);
                          }
                        if(playerTurn ==3)
                        {
                            step[x2][y2].setIcon(player3);
                            step[x1][y1].setIcon(emptySpace);
                          }
                         if(playerTurn ==4)
                        {
                            step[x2][y2].setIcon(player4);
                            step[x1][y1].setIcon(emptySpace);
                          }
                    }
                }
                
            }
          }

        }    

}