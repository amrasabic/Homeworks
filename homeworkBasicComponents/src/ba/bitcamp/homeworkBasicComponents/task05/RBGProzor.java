package ba.bitcamp.homeworkBasicComponents.task05;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Napraviti program koji posjeduje tri slider-a. Svaki slider je zasluzan za
 * jednu od tri RGB boje. Tokom mijenjanja vrijednosti na slider-ima potrebno 
 * je obojiti dati prozor (panel) u izabranu boju.
 * 
 * @author amra.sabic
 *
 */
public class RBGProzor extends JFrame {

	private static final long serialVersionUID = 5877822045491920864L;
	// declaration of parameters
	private int red;
	private int blue;
	private int green;

	private JPanel panel;
	private JPanel sliders;
	/*
	 * Constructor
	 */
	public RBGProzor(int width, int height) {
		// setting layout of frame
		setLayout(new GridLayout(2, 1));

		initPanel(width, height);
		panel = new JPanel();
		// adding panel to frame
		add(panel);
		// slider dimensions
		int sliderHeight = height / 7;
		Dimension sliderDimension = new Dimension(width - 50, sliderHeight);
		// declaration of red slider and initializing red slider
		JSlider redSlider = new JSlider(0, 255);
		initSlider(redSlider, "RED", sliderDimension);
		// declaration of blue slider and initializing blue slider
		JSlider blueSlider = new JSlider(0, 255);
		initSlider(blueSlider, "BLUE", sliderDimension);
		// declaration of green slider and initializing green slider
		JSlider greenSlider = new JSlider(0, 255);
		initSlider(greenSlider, "GREEN", sliderDimension);

		// red, green, blue label and color
		JLabel redLabel = new JLabel("Red");
		redLabel.setForeground(Color.RED);
		JLabel blueLabel = new JLabel("Blue");
		blueLabel.setForeground(Color.BLUE);
		JLabel greenLabel = new JLabel("Green");
		greenLabel.setForeground(Color.GREEN);
		// adding labels and sliders to panel - sliders
		sliders = new JPanel();
		add(sliders);
		sliders.add(redLabel);
		sliders.add(redSlider);
		sliders.add(blueLabel);
		sliders.add(blueSlider);
		sliders.add(greenLabel);
		sliders.add(greenSlider);
		
		// setting title, size, default close operation and visibility
		setTitle("RBG Prozor");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void initSlider(JSlider slider, String name, Dimension d) {
		// slider name, size, value
		slider.setName(name);
		slider.setPreferredSize(d);
		slider.setValue(0);
		// tick spacing and painting it so it would be visible
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(25);
		slider.setPaintTicks(true);
		// adding listener to slider
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider changed = (JSlider) e.getSource();
				// depending on which slider is moved get value
				switch (name) {
				case "RED":
					red = changed.getValue();
					// don't u ever forget break again
					break;
				case "BLUE":
					blue = changed.getValue();
					break;
				case "GREEN":
					green = changed.getValue();
					break;
				}
				// and update panel
				updatePanel();
			}
		});
	}

	private void updatePanel() {
		// panel background and foreground color
		panel.setBackground(new Color(red, green, blue, 255));
		panel.setForeground(new Color(255 - red, 255 - green, 255 - blue));
		repaint();
	}
	
	private void initPanel(int width, int height) {
		// Initialize new panel, size and opaque
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height / 2));
		panel.setOpaque(true);
		// update 
		updatePanel();
	}

	public static void main(String[] args) {
		
		new RBGProzor(490, 490);
		
	}

}