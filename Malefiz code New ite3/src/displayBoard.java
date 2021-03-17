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
    public JButton rollDice, saveGame, quit, exit;
   
    public displayBoard(JFrame frame, JPanel p) {
    	UIframe = frame;
    	backPanel = p;
    	backPanel.removeAll();
    	backPanel.revalidate();
    	backPanel.repaint();
    	
    	//frame = new JFrame("board_test");
        //frame.setSize(700, 700);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);
        
    	rollDice = new JButton("Roll Dice");
    	saveGame = new JButton("Save Game");
    	quit = new JButton("Quit Game");
    	exit = new JButton("Exit Game");
    	quit.addActionListener(this);
    	exit.addActionListener(this);
    	backPanel.setLayout(new BorderLayout());
    	
    	buttonPanel = new JPanel();
    	buttonPanel.add(rollDice);
    	buttonPanel.add(saveGame);
    	buttonPanel.add(quit);
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
        
        for (int i = 0; i < row; i++){
        	for (int j = 0; j < col; j++){
        		if (i==0) {
        			if(j==8) { 
                    step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png")));
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==1) {
        			if(j ==0||j ==1||j ==2||j ==3||j ==4||j ==5||j ==6||j ==7||j ==8||j ==9||j ==10||j ==11||j ==12||
        					j ==13||j ==14||j ==15||j ==16) {
                    step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png")));
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==2) {
        			if(j ==0||j ==16) {
                    step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png")));
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==3) {
        			if(j ==0||j ==1||j ==2||j ==3||j ==4||j ==5||j ==6||j ==7||j ==8||j ==9||j ==10||j ==11||j ==12||
        					j ==13||j ==14||j ==15||j ==16) {
                    step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png")));
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==4) {
        			if(j ==8) {
        		    step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png")));
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==5) {
        			if(j ==6||j ==7||j ==8||j ==9||j ==10) {
        			step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png")));
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==6) {
        			if(j ==6||j ==10) {
        			step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png")));
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==7) {
        			if(j ==4||j ==5||j ==6||j ==7||j ==8||j ==9||j ==10||j ==11||j ==12) {
        			step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png")));
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==8) {
        			if(j ==4||j ==12) {
        			step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png")));
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==9) {
        			if(j ==2||j ==3||j ==4||j ==5||j ==6||j ==7||j ==8||j ==9||j ==10||j ==11||j ==12||
        					j ==13||j ==14) {
        			step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png")));
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==10) {
        			if(j ==2|j ==6|j ==10|j ==14) {
        			step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png")));
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==11) {
        			if(j ==0||j ==1||j ==2||j ==3||j ==4||j ==5||j ==6||j ==7||j ==8||j ==9||j ==10||j ==11||j ==12||
        					j ==13||j ==14||j ==15||j ==16) {
        			step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png")));
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==12) {
        			if(j ==0|j ==4|j ==8|j ==12||j ==16) {
        			step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png")));
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==13) {
        			if(j ==0||j ==1||j ==2||j ==3||j ==4||j ==5||j ==6||j ==7||j ==8||j ==9||j ==10||j ==11||j ==12||
        					j ==13||j ==14||j ==15||j ==16) {
        			step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png")));
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==14) {
        			if(j ==1||j ==2||j ==3||j ==5||j ==6||j ==7||j ==9||j ==10||j ==11||
        					j ==13||j ==14||j ==15) {
        			step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png")));
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        		if (i==15) {
        			if(j ==1||j ==3||j ==5||j ==7||j ==9||j ==11||
        					j ==13||j ==15) {
        			step[i][j].setIcon(new ImageIcon(displayBoard.class.getResource("/images/emptyspace.png")));
        			step[i][j].setBorderPainted(false);
        			step[i][j].setText(null);
        			step[i][j].setEnabled(true);}
        			}
        	}
        }
        
        backPanel.add(boardPanel, BorderLayout.CENTER);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object selected = e.getSource();
		if(selected.equals(quit)) {
			int reply = JOptionPane.showConfirmDialog(
					UIframe,
				    "Are you sure you want to Quit the game?",
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
