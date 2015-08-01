package ba.bitcamp.homeworkBasicComponents.task01;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Napisati program koji ima jedan slider koji predstavlja veliccinu fonta.
 * Vecca vrijednost na slider-u odgovaracca veccem fontu. Da bi se predstavio
 * taj font neka su na programu ispisana neka slova koja su predstavljena u tom
 * fontu.
 * 
 * @author amra.sabic
 *
 */
public class AdjustableFontSize extends JPanel {

	private static final long serialVersionUID = -832931565461889537L;
	// declaration of parameters
	private JLabel label;
	private int size;

	/**
	 * Constructor
	 * 
	 * @param width
	 * @param height
	 */
	public AdjustableFontSize(int width, int height) {
		// declaration of new label, font and alignments
		label = new JLabel("Example");
		label.setFont(new Font("Sans Serif", Font.PLAIN, 18));
		label.setHorizontalAlignment(JLabel.CENTER);

		// setting layout and adding label to it
		setLayout(new GridLayout(2, 1, 5, 5));
		add(label);
		// declaration of slider, setting name, value, tick spacing 
		// and painting the spacing 
		JSlider slider = new JSlider(10, 72);
		slider.setName("Font size");
		slider.setValue(0);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(10);
		slider.setPaintTicks(true);
		// adding the listener and method
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// if slider value is changed, get value and change font
				JSlider changed = (JSlider) e.getSource();
				size = slider.getValue();
				label.setFont(new Font("Sans Serif", Font.PLAIN, size));

			}
		});
		// adding slider to panel
		add(slider);

	}

	public static void main(String[] args) {
		// declaration of new frame
		JFrame window = new JFrame();
		// instance of our class
		AdjustableFontSize afs = new AdjustableFontSize(200, 100);
		// adding it to frame = window
		window.add(afs);
		// setting title, size, location, default close operation and visibility
		window.setTitle("Adjustable Font Size!");
		window.setSize(200, 150);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

}