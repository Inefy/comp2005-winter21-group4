import java.awt.event.*;

import javax.swing.*;

public class movePawn implements ActionListener, MouseListener 
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
                if(playerTurn == 1)
                {
                	Icon p1 = step[i][j].getIcon();
                	if(p1 == player1) {
                		step[i][j].setEnabled(false);
                	}
                  }
                if(playerTurn == 2)
                {
                	Icon p2 = step[i][j].getIcon();
                	if(p2 == player2) {
                		step[i][j].setEnabled(false);
                	}
                  }
                if(playerTurn == 3)
                {
                	Icon p3 = step[i][j].getIcon();
                	if(p3 == player3) {
                		step[i][j].setEnabled(false);
                	}
                  }
                 if(playerTurn == 4)
                {
                	 Icon p4 = step[i][j].getIcon();
                	 if(p4 == player4) {
                 		step[i][j].setEnabled(false);
                 	}
                  }
            }
        }
        
        
    }


    @Override
     public void actionPerformed(ActionEvent e) 
     {
        Object selected = e.getSource();
        flag++;
        if (flag == 1)
        {
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++){
                if(selected.equals(step[i][j])) 
                {
                    x1 = i;
                    y1 = j;
                }
                
            }
          }
        }
        if (flag == 2)
        {
          for (int i = 0; i < row; i++){
             for (int j = 0; j < col; j++){
                if(selected.equals(step[i][j])) {
                    x2 =i;
                    y2 =j;
        		}
            }
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
	@Override
    public void mouseClicked(MouseEvent e)
    {
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