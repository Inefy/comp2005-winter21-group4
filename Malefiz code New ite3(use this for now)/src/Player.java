
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Player extends JPanel implements ActionListener
{
    
    public JFrame UIframe;
	public JPanel info, player_panel, colour_panel, pawn_panel;
    public JOptionPane colour, pawn;
    public JButton start ;
    public JButton back;
    public JButton player1, player2, player3, player4;
    public JButton pawn1, pawn2, pawn3, pawn4;
    public JButton color1,color2,color3,color4;
    public JButton preview1,preview2,preview3,preview4;
    public JButton change_name = new JButton("Change Name");
    public JButton change_colour = new JButton("Pick Colour");
    public JButton change_pawn = new JButton("Change Shape");
    public JButton preview = new JButton("Preview");
    public static String player1Name;
	public static String player2Name;
	public static String player3Name;
	public static String player4Name;
    
    public Player(JFrame frame, JPanel p)
    {
    	UIframe = frame;
        info = p;
        
        info.setLayout( new GridLayout(2,4));
        
        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == start)
              {
            	  new displayBoard(UIframe, info);
              } 
              
            }
        });
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == back)
              {
            	  int reply = JOptionPane.showConfirmDialog(
      					UIframe,
      				    "Are you sure you want to go the back?",
      				    "An Insane Question",
      				    JOptionPane.YES_NO_OPTION);
      		  if (reply == JOptionPane.YES_OPTION)
      	      {
      			  //direct to mainUI()
      			  new mainUI(UIframe, info);
      	      }
              } 
              
            }
        });
        
        
        JPanel player_panel = new JPanel();
        JPanel colour_panel = new JPanel();
        JPanel pawn_panel = new JPanel();
        JPanel preview_panel = new JPanel();
        
        player_panel.setLayout(new GridLayout(5,1));
        player_panel.setOpaque(false);
        
        colour_panel.setLayout(new GridLayout(5,1));
        colour_panel.setOpaque(false);
        
        pawn_panel.setLayout(new GridLayout(5,1));
        pawn_panel.setOpaque(false);
        
        preview_panel.setLayout(new GridLayout(5,1));
        preview_panel.setOpaque(false);
        
        
        change_name.setSize(50,50);
        change_name.setBorderPainted(false);
        change_name.setOpaque(false);
        change_name.setContentAreaFilled(false);
        change_name.removeActionListener(this);
        change_name.setFocusable(false);
        player_panel.add(change_name).setLocation(1,1);
        
        change_colour.setSize(50,50);
        change_colour.setBorderPainted(false);
        change_colour.setOpaque(false);
        change_colour.setContentAreaFilled(false);
        change_colour.removeActionListener(this);
        change_colour.setFocusable(false);
        colour_panel.add(change_colour).setLocation(1,1);
        
        change_pawn.setSize(50,50);
        change_pawn.setBorderPainted(false);
        change_pawn.setOpaque(false);
        change_pawn.setContentAreaFilled(false);
        change_pawn.removeActionListener(this);
        change_pawn.setFocusable(false);
        pawn_panel.add(change_pawn).setLocation(1,1);
        
        preview.setSize(50,50);
        preview.setBorderPainted(false);
        preview.setOpaque(false);
        preview.setContentAreaFilled(false);
        preview.removeActionListener(this);
        preview.setFocusable(false);
        preview_panel.add(preview).setLocation(1,1);
        
        // information for player1
        player1 = new JButton("Player 1");
        player_panel.add(player1).setLocation(2,1);
        player1.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == player1)
              {
            	  String input = JOptionPane.showInputDialog(null, "Enter your player Name please");
            	  if (!input.isBlank()) {
            		  player1.setText(input);
            		  player1Name = input; //for displayboard
            	  }
              }  
            }
        });
        
        preview1 = new JButton("");
        preview1.setBorderPainted(false);
        preview1.setOpaque(false);
        preview1.setContentAreaFilled(false);
        preview1.removeActionListener(this);
        preview1.setFocusable(false);
        preview1.setIcon(new ImageIcon(Player.class.getResource("/images/player1.png")));
        preview_panel.add(preview1).setLocation(2,1);
        
        pawn1 = new JButton("King");
        pawn_panel.add(pawn1).setLocation(2,1);
        pawn1.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == pawn1)
              {
            	  String[] pawn_shapes = {"King","Knight","Rook","Bishop"};
            	  String input = (String)JOptionPane.showInputDialog(info,null,"Pawn shape", JOptionPane.QUESTION_MESSAGE,null,pawn_shapes,pawn_shapes[1]);
            	  switch(input)
            	  {
            	      case "King":
            	      pawn1.setText("King");
            	      break;
            	      case "Knight":
            	      pawn1.setText("Knight");
            	      break;
            	      case "Rook":
            	      pawn1.setText("Rook");
            	      break;
            	      case "Bishop":
            	      pawn1.setText("Bishop");
            	      break;
            	   }
              }  
            }
        });
        color1 = new JButton("BLUE");
        colour_panel.add(color1).setLocation(2,1);
        color1.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == color1)
              {
            	  String[] colour_codes = {"BLUE","RED","GREEN","YELLOW"};
            	  String input = (String)JOptionPane.showInputDialog(info,null,"Pawn Color", JOptionPane.QUESTION_MESSAGE,null,colour_codes,colour_codes[1]);
            	  switch(input)
            	  {
            	      case "RED":
            	      color1.setBackground(Color.RED);
            	      break;
            	      case "GREEN":
            	      color1.setBackground(Color.GREEN);
            	      break;
            	      case "BLUE":
            	      color1.setBackground(Color.BLUE);
            	      break;
            	      case "YELLOW":
            	      color1.setBackground(Color.YELLOW);
            	      break;
            	   }
              }  
            }
        });
        
        
        
        //info player 2
        player2 = new JButton("Player 2");
        player_panel.add(player2).setLocation(3,1);
        player2.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == player2)
              {
            	  String input = JOptionPane.showInputDialog(null, "Enter your player Name please");
            	  if (!input.isBlank()) {
            		  player2.setText(input);
            		  player2Name = input; //for displayboard
            	  }
              }  
            }
        });
        
        preview2 = new JButton("");
        preview2.setBorderPainted(false);
        preview2.setOpaque(false);
        preview2.setContentAreaFilled(false);
        preview2.removeActionListener(this);
        preview2.setFocusable(false);
        preview2.setIcon(new ImageIcon(Player.class.getResource("/images/player2.png")));
        preview_panel.add(preview2).setLocation(3,1);
        
        pawn2 = new JButton("Knight");
        pawn_panel.add(pawn2).setLocation(3,1);
        pawn2.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == pawn2)
              {
            	  String[] pawn_shapes = {"King","Knight","Rook","Bishop"};
            	  String input = (String)JOptionPane.showInputDialog(info,null,"Pawn shape", JOptionPane.QUESTION_MESSAGE,null,pawn_shapes,pawn_shapes[1]);
            	  switch(input)
            	  {
            	      case "King":
            	      pawn2.setText("King");
            	      break;
            	      case "Knight":
            	      pawn2.setText("Knight");
            	      break;
            	      case "Rook":
            	      pawn2.setText("Rook");
            	      break;
            	      case "Bishop":
            	      pawn2.setText("Bishop");
            	      break;
            	   }
              }  
            }
        });
        color2 = new JButton("RED");
        colour_panel.add(color2).setLocation(3,1);
        color2.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == color2)
              {
            	  String[] colour_codes = {"BLUE","RED","GREEN","YELLOW"};
            	  String input = (String)JOptionPane.showInputDialog(info,null,"Pawn Color", JOptionPane.QUESTION_MESSAGE,null,colour_codes,colour_codes[1]);
            	  switch(input)
            	  {
            	      case "RED":
            	      color2.setBackground(Color.RED);
            	      break;
            	      case "GREEN":
            	      color2.setBackground(Color.GREEN);
            	      break;
            	      case "BLUE":
            	      color2.setBackground(Color.BLUE);
            	      break;
            	      case "YELLOW":
            	      color2 .setBackground(Color.YELLOW);
            	      break;
            	   }
              }  
            }
        });
        
        
        
        
        // information for player3
        player3 = new JButton("Player 3");
        player_panel.add(player3).setLocation(4,1);
        player3.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == player3)
              {
            	  String input = JOptionPane.showInputDialog(null, "Enter your player Name please");
            	  if (!input.isBlank()) {
            		  player3.setText(input);
            		  player3Name = input; //for displayboard
            	  }
              }  
            }
        });
        
        preview3 = new JButton("");
        preview3.setBorderPainted(false);
        preview3.setOpaque(false);
        preview3.setContentAreaFilled(false);
        preview3.removeActionListener(this);
        preview3.setFocusable(false);
        preview3.setIcon(new ImageIcon(Player.class.getResource("/images/player3.png")));
        preview_panel.add(preview3).setLocation(4,1);
        
        pawn3 = new JButton("Rook");
        pawn_panel.add(pawn3).setLocation(4,1);
        pawn3.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == pawn3)
              {
            	  String[] pawn_shapes = {"King","Knight","Rook","Bishop"};
            	  String input = (String)JOptionPane.showInputDialog(info,null,"Pawn shape", JOptionPane.QUESTION_MESSAGE,null,pawn_shapes,pawn_shapes[1]);
            	  switch(input)
            	  {
            	      case "King":
            	      pawn3.setText("King");
            	      break;
            	      case "Knight":
            	      pawn3.setText("Knight");
            	      break;
            	      case "Rook":
            	      pawn3.setText("Rook");
            	      break;
            	      case "Bishop":
            	      pawn3.setText("Bishop");
            	      break;
            	   }
              }  
            }
        });
        color3 = new JButton("GREEN");
        colour_panel.add(color3).setLocation(4,1);
        color3.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == color3)
              {
            	  String[] colour_codes = {"BLUE","RED","GREEN","YELLOW"};
            	  String input = (String)JOptionPane.showInputDialog(info,null,"Pawn Color", JOptionPane.QUESTION_MESSAGE,null,colour_codes,colour_codes[1]);
            	  switch(input)
            	  {
            	      case "RED":
            	      color3.setBackground(Color.RED);
            	      break;
            	      case "GREEN":
            	      color3.setBackground(Color.GREEN);
            	      break;
            	      case "BLUE":
            	      color3.setBackground(Color.BLUE);
            	      break;
            	      case "YELLOW":
            	      color3.setBackground(Color.YELLOW);
            	      break;
            	   }
              }  
            }
        });
        
        
        
        //info player 4
        player4 = new JButton("Player 4");
        player_panel.add(player4).setLocation(5,1);
        player4.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == player4)
              {
            	  String input = JOptionPane.showInputDialog(null, "Enter your player Name please");
            	  if (!input.isBlank()) {
            		  player4.setText(input);
            		  player4Name = input; //for displayboard
            	  }
              }  
            }
        });
        
        preview4 = new JButton("");
        preview4.setBorderPainted(false);
        preview4.setOpaque(false);
        preview4.setContentAreaFilled(false);
        preview4.removeActionListener(this);
        preview4.setFocusable(false);
        preview4.setIcon(new ImageIcon(Player.class.getResource("/images/player4.png")));
        preview_panel.add(preview4).setLocation(5,1);
        
        pawn4 = new JButton("Bishop");
        pawn_panel.add(pawn4).setLocation(5,1);
        pawn4.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == pawn4)
              {
            	  String[] pawn_shapes = {"King","Knight","Rook","Bishop"};
            	  String input = (String)JOptionPane.showInputDialog(info,null,"Pawn shape", JOptionPane.QUESTION_MESSAGE,null,pawn_shapes,pawn_shapes[1]);
            	  switch(input)
            	  {
            	      case "King":
            	      pawn4.setText("King");
            	      break;
            	      case "Knight":
            	      pawn4.setText("Knight");
            	      break;
            	      case "Rook":
            	      pawn4.setText("Rook");
            	      break;
            	      case "Bishop":
            	      pawn4.setText("Bishop");
            	      break;
            	   }
              }  
            }
        });
        color4 = new JButton("YELLOW");
        colour_panel.add(color4).setLocation(5,1);
        color4.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == color4)
              {
            	  String[] colour_codes = {"BLUE","RED","GREEN","YELLOW"};
            	  String input = (String)JOptionPane.showInputDialog(info,null,"Pawn Color", JOptionPane.QUESTION_MESSAGE,null,colour_codes,colour_codes[1]);
            	  switch(input)
            	  {
            	      case "RED":
            	      color4.setBackground(Color.RED);
            	      break;
            	      case "GREEN":
            	      color4.setBackground(Color.GREEN);
            	      break;
            	      case "BLUE":
            	      color4.setBackground(Color.BLUE);
            	      break;
            	      case "YELLOW":
            	      color4 .setBackground(Color.YELLOW);
            	      break;
            	   }
              }  
            }
        });
        
        info.add(player_panel).setLocation(1, 1);
        info.add(colour_panel).setLocation(1, 2);
        info.add(pawn_panel).setLocation(1, 3);
        info.add(preview_panel).setLocation(1, 4);
        
        
        
        
        
        JPanel bottomButtons = new JPanel();
        bottomButtons.setOpaque(false);
        bottomButtons.setLayout(new FlowLayout());
        bottomButtons.add(start);
        bottomButtons.add(back);
        
        //info.add(bottomButtons).setLocation(2, 2);
        JLabel empty = new JLabel(" ");
        empty.setSize(50, 50);
        
        info.add(empty).setLocation(2, 3);
        info.add(empty).setLocation(2, 2);
        info.add(bottomButtons).setLocation(2, 1);
        info.add(empty).setLocation(2, 4);
        
    }
    public void actionPerformed (ActionEvent aevt){

    }

}