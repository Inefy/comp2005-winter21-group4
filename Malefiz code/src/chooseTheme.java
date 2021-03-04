import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
//import java.awt.Cursor;

public class chooseTheme implements ActionListener,MouseListener
{
    JFrame frame = new JFrame("CHOOSE THEME");
    JPanel info;
    JButton light,dark;
    JFrame fra;
    public chooseTheme(JFrame fr, JPanel panel)
    {
       JFrame fra = fr;
       JPanel subPanel = panel;
       info = new JPanel();
       
       light = new JButton("LIGHT");
       info.add(light);
       dark = new JButton("DARK");
       info.add(dark);
       dark.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent aActionEvent)
        {
            if (aActionEvent.getSource() == dark)
            {
              subPanel.setBackground(Color.PINK); 
              
            }
        }
        });
       
       
       
       
       
       
       frame.getContentPane().setLayout( new BorderLayout());
      
       frame.getContentPane().add(info, BorderLayout.NORTH);
         
       frame.pack();
       frame.setVisible(true);
       
       
    }
    
    public void actionPerformed(ActionEvent aevt)
    {
        
    }
    
    public void mouseClicked(MouseEvent mevt)
    {
        
    }
    public void mouseEntered(MouseEvent arg0){}
    public void mouseExited(MouseEvent arg0) {}
    public void mousePressed(MouseEvent arg0) {}
    public void mouseReleased(MouseEvent arg0) {}
    
    
    
    
}
