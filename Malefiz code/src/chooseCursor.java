import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Cursor;

public class chooseCursor implements ActionListener
{
    JFrame frame = new JFrame("CURSOR OPTIONS");
    JButton original, hand;
    JPanel display_panel;
    JFrame UI_frame;
    
    public chooseCursor(JFrame main_frame)
    {
    	 UI_frame = main_frame;
         JButton original = new JButton("Default");
         JButton hand = new JButton("Hand Shape");
         
         
         display_panel = new JPanel();
         display_panel.add(original);
         display_panel.add(hand);
         
         hand.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent aevt)
             {
               if(aevt.getSource() == hand)
               {
                   Cursor mycursor =  new Cursor(Cursor.HAND_CURSOR);
                   UI_frame.setCursor(mycursor);
               }  
             }
          });
         original.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent aevt)
             {
               if(aevt.getSource() == original)
               {
                   Cursor mycursor =  new Cursor(Cursor.DEFAULT_CURSOR);
                   UI_frame.setCursor(mycursor);
               }  
             }
          });
         
         frame.getContentPane().setLayout( new BorderLayout());
      
         frame.getContentPane().add( display_panel, BorderLayout.NORTH);
         
         frame.pack();
         frame.setVisible(true);
         
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    /*public void actionPerformed(ActionEvent aevt)
    {
    	Object selected = aevt.getSource();
    	
    	if(selected.equals(hand))
        {
    		Cursor mycursor =  new Cursor(Cursor.HAND_CURSOR);
    		UI_frame.setCursor(mycursor);
        }
    	if(selected.equals(original))
        {
    		Cursor mycursor =  new Cursor(Cursor.DEFAULT_CURSOR);
    		UI_frame.setCursor(mycursor);
        }
     
    }*/
    
}
