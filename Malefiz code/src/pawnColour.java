import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Fysal Mahmud Rabbe
 *
 */
public class pawnColour extends JPanel {

	private ColorPicker picker = new ColorPicker();

	JFrame frame = new JFrame();

	/**
	 * 
	 */
	public pawnColour(final JPanel panel) {
		// TODO Auto-generated constructor stub
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		picker.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName() == ColorPicker.SELECTEDCOLORCHANGE) {
					panel.setBackground(picker.getSelectedColor());
				}
			}
		});
		frame.add(picker);
	}

}

class ColorPicker extends JComponent {

	public static final String SELECTEDCOLORCHANGE = "selectedcolorchange";
	public static final String OVERCOLORCHANGE = "overcolorchange";

	private ColorPanel colorPanel = new ColorPanel();
	private Color selectedColor = null;

	public ColorPicker() {
		initGUI();
		installListener();
	}

	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}

	public Insets getInsets() {
		return new Insets(1, 1, 1, 1);
	}

	private void installListener() {

		colorPanel.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName() == SELECTEDCOLORCHANGE) {
					Object newValue = evt.getNewValue();
					if (newValue == null) {
						setSelectedColor(null);
					} else {
						setSelectedColor((Color) newValue);
					}
				}
			}
		});
	}

	private void initGUI() {
		this.setLayout(new BorderLayout());
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setOpaque(false);

		this.add(colorPanel, BorderLayout.CENTER);
	}

	public Color getSelectedColor() {
		return selectedColor;
	}

	public void setSelectedColor(Color selectedColor) {
		Color old = this.selectedColor;
		this.selectedColor = selectedColor;
		this.firePropertyChange(SELECTEDCOLORCHANGE, old, selectedColor);
	}

}

class ColorButton extends JButton {
	public ColorButton(String text) {
		super(text);
		this.setContentAreaFilled(false);
	}

	protected void paintComponent(Graphics g) {
		if (this.getModel().isRollover()) {
			Graphics2D g2 = (Graphics2D) g;
			GradientPaint p = new GradientPaint(0, 0, new Color(0xFFFFFF), 0, getHeight(), new Color(0xC8D2DE));
			Paint oldPaint = g2.getPaint();
			g2.setPaint(p);
			g2.fillRect(0, 0, getWidth(), getHeight());
			g2.setPaint(oldPaint);
		}
		super.paintComponent(g);

	}

}

class ColorPanel extends JComponent {

	private List colorList = new ArrayList();
	private Map colorMap = new HashMap();

	private Color overColor = null;
	private Color selectedColor = new Color(71, 50, 127);

	private Color overFillColor = new Color(255, 200, 0, 100);
	private Color borderColor = Color.BLACK;

	public ColorPanel() {
		int count = 4;
		int gap = 255 / (count - 1);
		for (int r = count - 1; r >= 0; r--) {
			int red = Math.round(gap * r);
			for (int b = count - 1; b >= 0; b--) {
				int blue = Math.round(gap * b);
				for (int g = count - 1; g >= 0; g--) {
					int green = Math.round(gap * g);
					colorList.add(new Color(red, blue, green));
				}
			}
		}
		installListener();
	}

	private void installListener() {
		this.addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent e) {
				setOverColor(getColorByPoint(e.getPoint()));
			}

			public void mouseDragged(MouseEvent e) {
				setOverColor(getColorByPoint(e.getPoint()));
			}
		});
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setSelectedColor(overColor);
			}

			public void mouseExited(MouseEvent e) {
				setOverColor(null);
			}
		});
	}

	private Color getColorByPoint(Point point) {
		int size = colorList.size();
		for (int i = 0; i < size; i++) {
			Color color = (Color) colorList.get(i);
			Rectangle2D rect = (Rectangle2D) colorMap.get(color);
			if (rect.contains(point)) {
				return color;
			}
		}
		return null;
	}

	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		calcluteColorBounds();
	}

	private void calcluteColorBounds() {
		colorMap.clear();
		int size = colorList.size();
		double width = this.getWidth();
		double height = this.getHeight();
		double perWidth = width / 8.2;
		double perHeight = height / 8.2;
		for (int i = 0; i < size; i++) {
			int row = i / 8;
			int col = i % 8;
			double x = perWidth * 0.1 + col * perWidth;
			double y = perHeight * 0.1 + row * perHeight;
			Rectangle2D rect = new Rectangle2D.Double(x, y, perWidth, perHeight);
			colorMap.put(colorList.get(i), rect);
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		int size = colorList.size();
		for (int i = 0; i < size; i++) {
			Color color = (Color) colorList.get(i);
			Rectangle2D rect = (Rectangle2D) colorMap.get(color);

			if (color == overColor) {
				g2d.setColor(overFillColor);
				g2d.fill(rect);
				g2d.setColor(borderColor);
				g2d.draw(rect);
			}
			g2d.setColor(color);
			double rw = rect.getWidth();
			double rh = rect.getHeight();
			Rectangle2D colorRect = new Rectangle2D.Double(rect.getX() + 2, rect.getY() + 2, rw - 4, rh - 4);
			g2d.fill(colorRect);
			g2d.setColor(borderColor);
			g2d.draw(colorRect);
		}
	}

	private void setOverColor(Color overColor) {
		if (this.overColor != overColor) {
			Color old = this.overColor;
			this.overColor = overColor;
			this.firePropertyChange(ColorPicker.OVERCOLORCHANGE, old, overColor);
			this.repaint();
		}
	}

	public void setSelectedColor(Color selectedColor) {
		if (this.selectedColor != selectedColor) {
			Color old = this.selectedColor;
			this.selectedColor = selectedColor;
			this.firePropertyChange(ColorPicker.SELECTEDCOLORCHANGE, old, selectedColor);
		}
	}

	public Color getSelectedColor() {
		return selectedColor;
	}

	public void setOverFillColor(Color overFillColor) {
		this.overFillColor = overFillColor;
		this.repaint();
	}

	public Color getOverFillColor() {
		return overFillColor;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
		this.repaint();
	}

	public Color getOverColor() {
		return overColor;
	}
}
