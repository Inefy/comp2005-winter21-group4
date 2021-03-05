import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * 
 */

/**
 * @author Fysal Mahmud Rabbe
 *
 */
public class pawnShape extends JPanel {

	private static final int BUTTONWIDTH = 140;
	private static final int BUTTONHEIGHT = 140;

	/**
	 * 
	 */
	public pawnShape() {
		// TODO Auto-generated constructor stub
		JFrame jf = new JFrame("Choose Shape");
		jf.setSize(420, 420);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);

		// 创建 2行 3 列 的网格布局
		GridLayout layout = new GridLayout(2, 3);

		JPanel panel = new JPanel(layout);

		JButton btn01 = new JButton();
		btn01 = changeIconSize(btn01, "img/zfx.jpg", BUTTONWIDTH, BUTTONHEIGHT, "");
		btn01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// TODO Auto-generated
				System.out.println("square");
			}
		});
		JButton btn02 = new JButton();
		btn02 = changeIconSize(btn02, "img/yx.jpg", BUTTONWIDTH, BUTTONHEIGHT, "");
		btn02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// TODO Auto-generated
				System.out.println("circle");
			}
		});
		JButton btn03 = new JButton();
		btn03 = changeIconSize(btn03, "img/sjx.jpg", BUTTONWIDTH, BUTTONHEIGHT, "");
		btn03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// TODO Auto-generated
				System.out.println("triangle");
			}
		});
		JButton btn04 = new JButton();
		btn04 = changeIconSize(btn04, "img/wbx.jpg", BUTTONWIDTH, BUTTONHEIGHT, "");
		btn04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// TODO Auto-generated
				System.out.println("pentagon");
			}
		});
		JButton btn05 = new JButton();
		btn05 = changeIconSize(btn05, "img/wjx.jpg", BUTTONWIDTH, BUTTONHEIGHT, "");
		btn05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// TODO Auto-generated
				System.out.println("five-pointed star");
			}
		});
		JButton btn06 = new JButton();
		btn06 = changeIconSize(btn06, "img/ljx.jpg", BUTTONWIDTH, BUTTONHEIGHT, "");
		btn06.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// TODO Auto-generated
				System.out.println("hexagon");
			}
		});

		panel.add(btn01);
		panel.add(btn02);
		panel.add(btn03);
		panel.add(btn04);
		panel.add(btn05);
		panel.add(btn06);

		jf.setContentPane(panel);
		jf.setVisible(true);
	}

	public static JButton changeIconSize(JButton button, String url, int width, int height, String tip) {
		button.setBounds(0, 0, width, height);
		ImageIcon buttonImg = new ImageIcon(url);
		Image temp = buttonImg.getImage().getScaledInstance(button.getWidth(), button.getHeight(),
				buttonImg.getImage().SCALE_DEFAULT);
		button = new JButton(new ImageIcon(temp));
		button.setToolTipText(tip);
		return button;
	}

}
