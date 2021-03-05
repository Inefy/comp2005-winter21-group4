import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class newGame extends JFrame implements ActionListener 
{
    
    public JFrame frame;
    public JPanel newGamePanel;
    public JTextField userNameText;
    public JLabel inputNameLabel;


    public newGame(JPanel mainPanel) {
    	newGamePanel = mainPanel;
    	newGamePanel.removeAll();
    	newGamePanel.revalidate();
    	newGamePanel.repaint();
    	
    	
    }
    public void actionPerformed (ActionEvent aevt){
    	
    }

}
