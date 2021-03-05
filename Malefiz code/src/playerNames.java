import java.util.concurrent.Flow.Publisher;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * Write a description of class playerNames here.
 *
 * @author Nima Pishva
 * @version (a version number or a date)
 */


public class playerNames extends JFrame implements ActionListener
{
   private JFrame frame;
   private JPanel buttonPanel;
   private JPanel mainPanel;
   private JPanel namePanel;
   private JButton player1Button;
   private JButton player2Button;
   private JButton player3Button;
   private JButton player4Button;
   public String player1;
   public String player2;
   public String player3;
   public String player4;
   private JLabel player1Name;
   private JLabel player2Name;
   private JLabel player3Name;
   private JLabel player4Name;
   
   
    public playerNames()
    {
        frame = new JFrame("Player Names");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setResizable(false);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        frame.add(mainPanel);
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        
        player1Name = new JLabel("Player1: " + player1);
        player2Name = new JLabel("Player2: " + player2);
        player3Name = new JLabel("Player3: " + player3);
        player4Name = new JLabel("Player4: " + player4);
        
        namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel,BoxLayout.PAGE_AXIS));
        namePanel.add(player1Name);
        namePanel.add(player2Name);
        namePanel.add(player3Name);
        namePanel.add(player4Name);
        mainPanel.add(namePanel, BorderLayout.CENTER);
        
        
        player1Button = new JButton("Player1");
        player2Button = new JButton("Player2");
        player3Button = new JButton("Player3");
        player4Button = new JButton("Player4");
        
        buttonPanel.add(player1Button);
        buttonPanel.add(player2Button);
        buttonPanel.add(player3Button);
        buttonPanel.add(player4Button);
        
        player1Button.addActionListener(this);
        player2Button.addActionListener(this);
        player3Button.addActionListener(this);
        player4Button.addActionListener(this);
        
        frame.pack();
        frame.setVisible(true);
    }

    
    public void actionPerformed (ActionEvent event){ 
    	/**
    	 * Button click prompt a dialogue box where the user inputs their player name
    	 * the player names will be updated on screen
    	 * user can change their names infinite amount of times during this process
    	 */
        Object selected = event.getSource();
        
        if (selected.equals(player1Button)){
            String player1 = JOptionPane.showInputDialog(null, "Enter your player Name please");
            player1Name.setText("Player1: " + player1);
        }
        
         if (selected.equals(player2Button)){
            String player2 = JOptionPane.showInputDialog(null, "Enter your player Name please");
            
            player2Name.setText("Player2: " + player2);
        }
        
         if (selected.equals(player3Button)){
            String player3 = JOptionPane.showInputDialog(null, "Enter your player Name please");
            
            player3Name.setText("Player3: " + player3);
        }
        
         if (selected.equals(player4Button)){
            String player4 = JOptionPane.showInputDialog(null, "Enter your player Name please");
            
            player4Name.setText("Player4: " + player4);
        }
    }
   
    
    public static void main(String[] args) {
       new playerNames();

       
    }
    
    
}
