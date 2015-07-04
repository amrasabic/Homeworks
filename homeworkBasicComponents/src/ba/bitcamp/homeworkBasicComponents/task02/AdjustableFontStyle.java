package ba.bitcamp.homeworkBasicComponents.task02;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Napisati program koji ima dva check boxa koji predstavljaju da li je font
 * boldiran i da li je font italic. Pored toga, neka program sadrzzi i dugme
 * koje update-a (osvjezi) selektirane opcije na nekom tekstu prikazanom iznad
 * check boxova.
 * 
 * @author amra.sabic
 *
 */
public class AdjustableFontStyle extends JFrame {

	private static final long serialVersionUID = 4747937099340691984L;
	// declaration of parameters
	private JCheckBox box1 = new JCheckBox("Bold");
	private JCheckBox box2 = new JCheckBox("Italic");
	private JButton button = new JButton("Apply");
	private JLabel label;
	
	/*
	 * Constructor
	 */
	public AdjustableFontStyle() {
		// setting layout for frame
		setLayout(new GridLayout(4, 1, 5, 5));
		// declaration of label, label font  and alignment
		label = new JLabel("Example");
		Font f = new Font("Sans Serif", Font.PLAIN, 18);
		label.setFont(f);
		label.setHorizontalAlignment(JLabel.CENTER);
		// adding label to frame
		add(label);
		// adding both boxes to frame
		add(box1);
		add(box2);
		// button action listener 
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() != null){
					// if first check box is selected - bold on apply button
					if(box1.isSelected()){
						label.setFont(new Font("Sans Serif", Font.BOLD, 18));
					}
					// if second check box is selected - italic on apply button
					if(box2.isSelected()){
						label.setFont(new Font("Sans Serif", Font.ITALIC, 18));
					}
					// if both check boxes are selected - bold and italic on apply button
					if(box1.isSelected() && box2.isSelected()){
						label.setFont(new Font("Sans Serif", Font.BOLD + Font.ITALIC, 18));
					} else if (!box1.isSelected() && !box2.isSelected()){
						label.setFont(f);
					}
				}
				
			}
		});
		// adding button to frame
		add(button);
		// setting title, size, location, default close operation and visibility
		setTitle("Adjustable Font Style!");
		setSize(200, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {

		new AdjustableFontStyle();

	}

}