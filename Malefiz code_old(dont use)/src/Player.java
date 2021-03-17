import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Cursor;

public class Player extends JPanel implements ActionListener
{
    
    public JPanel info, player_panel, colour_panel, pawn_panel;
    public JOptionPane colour, pawn;
    public JButton start ;
    public JButton player1, player2, player3, player4;
    public JButton pawn1, pawn2, pawn3, pawn4;
    public JButton color1,color2,color3,color4;
    public JLabel change_name = new JLabel("                                                           Change Name");
    public JLabel change_colour = new JLabel("  Pick Colour");
    public JLabel change_pawn = new JLabel("Change Shape  ");
    
    public Player(JPanel p)
    {
        
        info = p;
        info.setLayout( new BorderLayout());
        info.setBackground(Color.WHITE);
        
        JButton start = new JButton("START");
        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == start)
              {
            	  new displayBoard(info);
              } 
              
            }
        });
        
        
        JPanel player_panel = new JPanel();
        player_panel.setPreferredSize(new Dimension(400,400));
        JPanel colour_panel = new JPanel();
        JPanel pawn_panel = new JPanel();
        
        player_panel.setLayout(new GridLayout(5,1));
        player_panel.setOpaque(false);
        
        colour_panel.setLayout(new GridLayout(5,1));
        colour_panel.setOpaque(false);
        
        pawn_panel.setLayout(new GridLayout(5,1));
        pawn_panel.setOpaque(false);
        
        player_panel.add(change_name).setLocation(1,1);
        colour_panel.add(change_colour).setLocation(1,1);
        pawn_panel.add(change_pawn).setLocation(1,1);
        
        
        // information for player1
        player1 = new JButton("PLAYER 1");
        player_panel.add(player1).setLocation(2,1);
        player1.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == player1)
              {
            	  String input = JOptionPane.showInputDialog(null, "Enter your player Name please");
            	  player1.setText(input);
              }  
            }
        });
        
        pawn1 = new JButton("-");
        pawn1.setSize(50,50);
        pawn_panel.add(pawn1).setLocation(2,1);
        pawn1.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == pawn1)
              {
            	  String[] pawn_shapes = {"*","&","$","%"};
            	  String input = (String)pawn.showInputDialog(info,null,"Pawn shape", JOptionPane.QUESTION_MESSAGE,null,pawn_shapes,pawn_shapes[1]);
            	  switch(input)
            	  {
            	      case "*":
            	      pawn1.setText("*");
            	      break;
            	      case "&":
            	      pawn1.setText("&");
            	      break;
            	      case "$":
            	      pawn1.setText("$");
            	      break;
            	      case "%":
            	      pawn1.setText("%");
            	      break;
            	   }
              }  
            }
        });
        color1 = new JButton("-");
        color1.setSize(50,50);
        colour_panel.add(color1).setLocation(2,1);
        color1.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == color1)
              {
            	  String[] colour_codes = {"RED","GREEN","BLUE","YELLOW"};
            	  String input = (String)colour.showInputDialog(info,null,"Pawn Color", JOptionPane.QUESTION_MESSAGE,null,colour_codes,colour_codes[1]);
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
        player2 = new JButton("PLAYER 2");
        player_panel.add(player2).setLocation(3,1);
        player2.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == player2)
              {
            	  String input = JOptionPane.showInputDialog(null, "Enter your player Name please");
            	  player2.setText(input);
              }  
            }
        });
        
        pawn2 = new JButton("-");
        pawn2.setSize(50,50);
        pawn_panel.add(pawn2).setLocation(3,1);
        pawn2.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == pawn2)
              {
            	  String[] pawn_shapes = {"*","&","$","%"};
            	  String input = (String)pawn.showInputDialog(info,null,"Pawn shape", JOptionPane.QUESTION_MESSAGE,null,pawn_shapes,pawn_shapes[1]);
            	  switch(input)
            	  {
            	      case "*":
            	      pawn2.setText("*");
            	      break;
            	      case "&":
            	      pawn2.setText("&");
            	      break;
            	      case "$":
            	      pawn2.setText("$");
            	      break;
            	      case "%":
            	      pawn2.setText("%");
            	      break;
            	   }
              }  
            }
        });
        color2 = new JButton("-");
        color2.setSize(50,50);
        colour_panel.add(color2).setLocation(3,1);
        color2.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == color2)
              {
            	  String[] colour_codes = {"RED","GREEN","BLUE","YELLOW"};
            	  String input = (String)colour.showInputDialog(info,null,"Pawn Color", JOptionPane.QUESTION_MESSAGE,null,colour_codes,colour_codes[1]);
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
        
        
        
        //information
        
        // information for player3
        player3 = new JButton("PLAYER 3");
        player_panel.add(player3).setLocation(4,1);
        player3.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == player3)
              {
            	  String input = JOptionPane.showInputDialog(null, "Enter your player Name please");
            	  player3.setText(input);
              }  
            }
        });
        
        pawn3 = new JButton("-");
        
        pawn_panel.add(pawn3).setLocation(4,1);
        pawn3.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == pawn3)
              {
            	  String[] pawn_shapes = {"*","&","$","%"};
            	  String input = (String)pawn.showInputDialog(info,null,"Pawn shape", JOptionPane.QUESTION_MESSAGE,null,pawn_shapes,pawn_shapes[1]);
            	  switch(input)
            	  {
            	      case "*":
            	      pawn3.setText("*");
            	      break;
            	      case "&":
            	      pawn3.setText("&");
            	      break;
            	      case "$":
            	      pawn3.setText("$");
            	      break;
            	      case "%":
            	      pawn3.setText("%");
            	      break;
            	   }
              }  
            }
        });
        color3 = new JButton("-");
        colour_panel.add(color3).setLocation(4,1);
        color3.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == color3)
              {
            	  String[] colour_codes = {"RED","GREEN","BLUE","YELLOW"};
            	  String input = (String)colour.showInputDialog(info,null,"Pawn Color", JOptionPane.QUESTION_MESSAGE,null,colour_codes,colour_codes[1]);
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
        player4 = new JButton("PLAYER 4");
        player_panel.add(player4).setLocation(5,1);
        player4.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == player4)
              {
            	  String input = JOptionPane.showInputDialog(null, "Enter your player Name please");
            	  player4.setText(input);
              }  
            }
        });
        
        pawn4 = new JButton("-");
        pawn_panel.add(pawn4).setLocation(5,1);
        pawn4.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == pawn4)
              {
            	  String[] pawn_shapes = {"*","&","$","%"};
            	  String input = (String)pawn.showInputDialog(info,null,"Pawn shape", JOptionPane.QUESTION_MESSAGE,null,pawn_shapes,pawn_shapes[1]);
            	  switch(input)
            	  {
            	      case "*":
            	      pawn4.setText("*");
            	      break;
            	      case "&":
            	      pawn4.setText("&");
            	      break;
            	      case "$":
            	      pawn4.setText("$");
            	      break;
            	      case "%":
            	      pawn4.setText("%");
            	      break;
            	   }
              }  
            }
        });
        color4 = new JButton("-");
        colour_panel.add(color4).setLocation(5,1);
        color4.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == color4)
              {
            	  String[] colour_codes = {"RED","GREEN","BLUE","YELLOW"};
            	  String input = (String)colour.showInputDialog(info,null,"Pawn Color", JOptionPane.QUESTION_MESSAGE,null,colour_codes,colour_codes[1]);
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
        
        info.add(colour_panel, BorderLayout.WEST);
        info.add(player_panel, BorderLayout.CENTER);
        info.add(pawn_panel, BorderLayout.EAST);
        info.add(start, BorderLayout.SOUTH);
        
        
        //frame.getContentPane().add(BorderLayout.CENTER, info);
        //frame.pack();
        //frame.setVisible(true);
        
    }
    public void actionPerformed (ActionEvent aevt){

    }

}