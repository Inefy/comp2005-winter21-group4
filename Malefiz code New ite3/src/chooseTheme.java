import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
//import java.awt.Cursor;

public class chooseTheme implements ActionListener
{
    JFrame frame = new JFrame("CHOOSE THEME");
    JPanel info;
    JButton light,dark;
    JFrame fra;
    public chooseTheme(JPanel panel)
    {
       JPanel subPanel = panel;
       info = new JPanel();
       
       light = new JButton("LIGHT");
       info.add(light);
       light.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent aActionEvent)
           {
               if (aActionEvent.getSource() == light)
               {
                 subPanel.setBackground(Color.WHITE); 
                 
               }
           }
           });
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
    
}
