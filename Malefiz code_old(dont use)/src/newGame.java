
import javax.swing.*;


public class newGame extends JPanel
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
    	new Player(newGamePanel);
    	
    }
}
