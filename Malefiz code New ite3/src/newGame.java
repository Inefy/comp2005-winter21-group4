import javax.swing.*;


public class newGame extends JPanel
{
    
    public JFrame UIframe;
    public JPanel newGamePanel;
    public JTextField userNameText;
    public JLabel inputNameLabel;


    public newGame(JFrame frame, JPanel mainPanel) {
    	UIframe = frame;
    	newGamePanel = mainPanel;
    	newGamePanel.removeAll();
    	newGamePanel.revalidate();
    	newGamePanel.repaint();
    	new Player(UIframe, newGamePanel);
    	
    }
}
