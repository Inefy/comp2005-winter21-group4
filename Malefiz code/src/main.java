//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.*;
class gui {
    public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("Malefiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m2 = new JMenu("Display Options");
        mb.add(m2);
        JMenuItem m22 = new JMenuItem("Choose bightness");
        JMenuItem m33 = new JMenuItem("Choose cursor");
        JMenuItem m44 = new JMenuItem("Choose theme");
        m2.add(m22);
        m2.add(m33);
        m2.add(m44);
       

        //creating buttons
        JButton newGame = new JButton("New Game");
        newGame.setSize(50, 50);
        JButton exitGame = new JButton("Exit Game");
        exitGame.setSize(50, 50);
        JPanel subPanel = new JPanel();
        JButton loadGame = new JButton("Load Game");
        exitGame.setSize(50, 50);
        subPanel.add(loadGame);
        subPanel.add(newGame);
        subPanel.add(exitGame);


        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, subPanel);
        frame.setVisible(true);
    }
}