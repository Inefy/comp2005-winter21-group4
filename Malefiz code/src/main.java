//Usually you will require both swing and awt packages
// even if you are working with just swings.
import java.awt.*;
//import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
//import java.awt.Cursor;

public class main implements ActionListener, MouseListener 
 {
    JMenuItem m22, m33, m44;
    JFrame frame;
    JPanel mainPanel = new JPanel();
    public main() 
    {

        //Creating the Frame
        JFrame frame = new JFrame("Malefiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);

        //Creating the MenuBar and adding components
        JMenuBar menubar = new JMenuBar();
        JMenu menubar_display = new JMenu("Display Options");
        menubar_display.addActionListener(this);
        menubar.add(menubar_display);
        JMenuItem brightness = new JMenuItem("Choose brightness");
        JMenuItem cursor = new JMenuItem("Choose cursor");
        JMenuItem theme = new JMenuItem("Choose theme");
        
      //creating buttons
        JButton newGame = new JButton("New Game");
        newGame.setSize(50, 50);
        
        JButton exitGame = new JButton("Exit Game");
        exitGame.setSize(50, 50);
        
        JButton loadGame = new JButton("Load Game");
        exitGame.setSize(50, 50);
        
        mainPanel.add(loadGame);
        mainPanel.add(newGame);
        mainPanel.add(exitGame);
        
        
        brightness.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == brightness)
              {
                  //chooseBrightness bright = new chooseBrightness(frame);
              }  
            }
        });
        menubar_display.add(brightness);
        cursor.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == cursor)
              {
            	  new chooseCursor(frame);
               
              }  
            }
        });
        menubar_display.add(cursor);
        theme.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == theme)
              {
            	  new chooseTheme(frame, mainPanel);
              }  
            }
        });
        menubar_display.add(theme);
       

        


        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, menubar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) 
    {
		// TODO Auto-generated method stub
    	new main();
    }
	
    public void actionPerformed(ActionEvent aevt)
    {
    	
    }
    
    public void mouseClicked(MouseEvent mevt)
    {
        //mevt.getSource();
    	
    }
    public void mouseEntered(MouseEvent arg0){}
    public void mouseExited(MouseEvent arg0) {}
    public void mousePressed(MouseEvent arg0) {}
    public void mouseReleased(MouseEvent arg0) {}

}