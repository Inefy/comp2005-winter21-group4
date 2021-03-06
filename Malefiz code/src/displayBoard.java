import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;



public class displayBoard { 
	
    public JPanel boardPanel;
    public JPanel backPanel;
    public JLabel inputNameLabel;
    public JButton[][] step;
    public JButton rollDice, saveGame, quit;
   
    public displayBoard(JPanel p) {
    	boardPanel = p;
    	boardPanel.removeAll();
    	boardPanel.revalidate();
    	boardPanel.repaint();
    	
    	//frame = new JFrame("board_test");
        //frame.setSize(700, 700);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);
        
    	rollDice = new JButton("Roll Dice");
    	saveGame = new JButton("Save Game");
    	quit = new JButton("Quit");
    	
    	backPanel = new JPanel(new BorderLayout());
    	backPanel.add(boardPanel, BorderLayout.CENTER);
    	backPanel.add(rollDice, BorderLayout.SOUTH);
    	backPanel.add(saveGame, BorderLayout.SOUTH);
    	backPanel.add(quit, BorderLayout.SOUTH);
    	//step.setBorder(BorderFactory.createEmptyBorder());
    	
    	int row = 16;
        int col = 17;
        boardPanel.setLayout(new GridLayout(row, col));
        
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
        
        //frame.getContentPane().add(BorderLayout.CENTER, boardPanel);
        //frame.pack();
        //frame.setVisible(true);
    }
}

        /*int boardArray[][] = {{8},
        {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16},
        {0,16},
        {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16},
        {8},
        {6,7,8,9,10},
        {6,10},
        {4,5,6,7,8,9,10,11,12},
        {4,12},
        {2,3,4,5,6,7,8,9,10,11,12,13,14},
        {2,14},
        {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16},
        {0,16},
        {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16},
        {1,2,3,5.6,7,8,10,11,13,14,15},
        {1,3,5,7,9,11,13,15}};
        */