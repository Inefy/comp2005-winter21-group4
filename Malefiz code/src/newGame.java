
/**
 * 
 */
import java.util.concurrent.Flow.Publisher;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * @author Nima Pishva
 *
 */
public class newGame extends JFrame implements ActionListener 
{
     
     /**
        * 
     */
    
    public JFrame frame;
    public JPanel userNamePanel;
    public JTextField userNameText;
    public JLabel inputNameLabel;


    public newGame() {
        
        frame = new JFrame("User Info");
        frame.setSize(350, 200);
        userNamePanel = new JPanel();
        frame.add(userNamePanel);
        
        userNamePanel.setLayout(null);
        
        inputNameLabel = new JLabel("Input PlayerName");
        inputNameLabel.setBounds(10, 20, 80,25);
        userNamePanel.add(inputNameLabel);
        
        userNameText = new JTextField(20);
        userNameText.setBounds(100, 20, 165, 25);
        userNamePanel.add(userNameText);
        frame.setVisible(true);
    }
    public void actionPerformed (ActionEvent event){
        
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        new newGame();

    }

}
