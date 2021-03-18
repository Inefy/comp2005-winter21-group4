//contributor: zac, Nima, Aman, Fysal

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainUI implements ActionListener
 {
    public JMenuItem cursor, theme;
    public JFrame frame;
    public JPanel mainPanel;
    public JButton newGame;
    public JLabel name = new JLabel("Malefiz");
    public JPanel centerPanel = new JPanel();
    public JPanel northPanel = new JPanel();
    
    public mainUI(JFrame UIframe, JPanel UIpanel) 
    {
        //Creating the Frame
    	frame = UIframe;
    	mainPanel = UIpanel;
    	mainPanel.removeAll();
    	mainPanel.revalidate();
    	mainPanel.repaint();
        frame.setTitle("Malefiz");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);

        //Creating the MenuBar and adding components
        JMenuBar menubar = new JMenuBar();
        JMenu menubar_display = new JMenu("Display Options");
        //menubar_display.addActionListener(this);
        menubar.add(menubar_display);
        cursor = new JMenuItem("Choose cursor");
        theme = new JMenuItem("Choose theme");
        
        //creating buttons
        JButton newGame = new JButton("New Game");
        JButton exitGame = new JButton("Exit Game");
        JButton loadGame = new JButton("Load Game");
        newGame.setFont(new Font("Tahoma", Font.PLAIN, 40));
        exitGame.setFont(new Font("Tahoma", Font.PLAIN, 40));
        loadGame.setFont(new Font("Tahoma", Font.PLAIN, 40));
        newGame.setSize(40, 40);
        exitGame.setSize(40, 40);
        exitGame.setSize(40, 40);
        exitGame.addActionListener(this);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        
        northPanel.setLayout(new FlowLayout());
        northPanel.setOpaque(false);
        name.setFont(new Font("Tahoma", Font.PLAIN, 80));
        northPanel.add(name);
        mainPanel.add(northPanel, BorderLayout.NORTH);
        
        centerPanel.setLayout(new GridLayout(3, 1));
        centerPanel.setOpaque(false);
        centerPanel.add(newGame).setLocation(1, 1);
        newGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == newGame)
              {
                  
            	  new newGame(frame, mainPanel);
               
              }  
            }
        });
        
        centerPanel.add(loadGame).setLocation(2, 1);
        centerPanel.add(exitGame).setLocation(3, 1);
        exitGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
            	Object selected = aActionEvent.getSource();
              if(selected.equals(exitGame)) //pop up box prompting user to confirm quitting
              {
            	  
            	  new exitGame(frame);
            	  
              }  
            }
        });
        
        newGame.setOpaque(false);
        newGame.setContentAreaFilled(false);
        newGame.setBorderPainted(false);
        loadGame.setOpaque(false);
        loadGame.setContentAreaFilled(false);
        loadGame.setBorderPainted(false);
        exitGame.setOpaque(false);
        exitGame.setContentAreaFilled(false);
        exitGame.setBorderPainted(false);
        
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        menubar_display.add(cursor);
        cursor.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == cursor)
              {
            	  new chooseCursor(frame);
               
              }  
            }
        });
        
        menubar_display.add(theme);
        theme.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == theme)
              {
            	  new chooseTheme(frame,mainPanel);
              } 
              
            }
        });


        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, menubar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        
    }
    
    public void actionPerformed(ActionEvent aevt)
    {
    	
    }
}