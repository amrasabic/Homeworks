package ba.bitcamp.homeworkMiniGUIProject;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Minesweeper extends JFrame {

	private static final long serialVersionUID = -1019010246829572299L;
	// declaration of parameters
	private static int number = 0;
	private static int[][] matrix1;
	private static JButton[][] buttons;

	private ImageIcon mine;
	private ImageIcon flag;

//	private ImageIcon blue;
//	private ImageIcon purple;

	private ImageIcon zero;
	private ImageIcon one;
	private ImageIcon two;
	private ImageIcon three;
	private ImageIcon four;
	private ImageIcon five;
	private ImageIcon six;
	private ImageIcon seven;
	private ImageIcon eight;

	private int size = 40;
	int[][] matrix;
	
	/*
	 * Constructor
	 */
	public Minesweeper() {
		// adding and setting image locations
		flag = new ImageIcon("src/flag.png");
		mine = new ImageIcon("src/mine.png");

//		blue = new ImageIcon("src/blueButton.png");
//		purple = new ImageIcon("src/purpleButton.png");

		zero = new ImageIcon("src/zero.png");
		one = new ImageIcon("src/one.png");
		two = new ImageIcon("src/two.png");
		three = new ImageIcon("src/three.png");
		four = new ImageIcon("src/four.png");
		five = new ImageIcon("src/five.png");
		six = new ImageIcon("src/six.png");
		seven = new ImageIcon("src/seven.png");
		eight = new ImageIcon("src/eight.png");

		try {
			// window to enter number value for size of field
			number = Integer.parseInt(JOptionPane.showInputDialog("Enter a number to set size of field: "));	
			// assigning value to matrix size
			matrix1 = new int[number][number];
			// generating matrix size buttons
			buttons = new JButton[number][number];
		} catch (NumberFormatException e) {
			System.exit(0);
		}
			
		// setting layout for frame
		setLayout(new GridLayout(number, number));
		// generating number of mines equal to number enter 
		for (int i = 0; i < number; i++) {
			matrix1[((int) (Math.random() * number))][((int) (Math.random() * number))] = -1;

		}
		// adding mines (-1) to new matrix and method to increase values near mines
		matrix = matrixWithMines(matrix1);
		
		// solution print on console if needed (for testing)
		for (int i = 0; i < number; i++) {
			System.out.println();
			for (int j = 0; j < number; j++) {
				System.out.printf("%2d", matrix[i][j]);
			}
		}
		// let the game begins
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				// adding buttons setting opaque
				buttons[i][j] = new JButton();
				buttons[i][j].setOpaque(true);
				// add mouse listener
				buttons[i][j].addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						// action on left click
						if (e.getButton() == 1) {
							for (int i = 0; i < buttons.length; i++) {
								for (int j = 0; j < buttons[i].length; j++) {
									// if any of buttons clicked
									if (e.getSource() == buttons[i][j]) {
										// and if value of that button is -1
										if (matrix[i][j] != -1) {
											// open field method
											openField(i, j);
										} else {
											for (int k = 0; k < buttons.length; k++) {
												for (int l = 0; l < buttons[k].length; l++) {
													//  if it's -1 and no icon and there is no flag
													if (matrix[k][l] == -1 && buttons[k][l].getIcon() == null || buttons[k][l].getIcon() == flag) {
														// set icon mine
														buttons[k][l].setIcon(mine);
													}
												}
											}
											// new window when game over
											if (JOptionPane.showConfirmDialog(null,	"GAME OVER!! \nPLAY AGAIN?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
												// closing old minesweeper window
												dispose();
												// opening new one
												new Minesweeper();
											} else {
												// system exit
												System.exit(0);
											}

										}
										// method won if value is true
										if (won()) {
											for (int k = 0; k < buttons.length; k++) {
												for (int l = 0; l < buttons[k].length; l++) {
													// show mines
													if (matrix[k][l] == -1) {
														buttons[k][l].setIcon(mine);
													}
												}
											}
											if (JOptionPane.showConfirmDialog(null,"YOU WON \nPLAY AGAIN?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
												// closing old minesweeper window
												dispose();
												// opening new one
												new Minesweeper();
											} else {
												// system exit
												System.exit(0);
											}
										}

									}
								}
							}
							// action on right click
						} else if (e.getButton() == 3) {
							for (int i = 0; i < buttons.length; i++) {
								for (int j = 0; j < buttons[i].length; j++) {
									// click on any of buttons
									if (e.getSource() == buttons[i][j]) {
										// if there is no icon 
										if (buttons[i][j].getIcon() == null	&& buttons[i][j].getText().equals("")) {
											// set icon flag
											buttons[i][j].setIcon(flag);
											// if the icon is flag
										} else if (buttons[i][j].getIcon() == flag) {
											// set to null
											buttons[i][j].setIcon(null);
										}
									}
								}
							}
						}
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						super.mouseEntered(e);
						for (int i = 0; i < buttons.length; i++) {
							for (int j = 0; j < buttons[i].length; j++) {
								// entered on any of buttons
								if (e.getSource() == buttons[i][j]) {
									// no border and no icon
									if (buttons[i][j].getBorder() == null && buttons[i][j].getIcon() == null) {
										// set border layout lowered
										buttons[i][j].setBorder(BorderFactory.createLoweredBevelBorder());
									}
								}
							}
						}
					}

					@Override
					public void mouseExited(MouseEvent e) {
						super.mouseExited(e);
						for (int i = 0; i < buttons.length; i++) {
							for (int j = 0; j < buttons[i].length; j++) {
								// exited on any of buttons
								if (e.getSource() == buttons[i][j]) {
									// no border and no icon
									if (buttons[i][j].getBorder() == null && buttons[i][j].getIcon() == null) {
										// set border layout raised
										buttons[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
									}
								}
							}
						}
					}

				});
				// add buttons to frame
				add(buttons[i][j]);
			}
		}
		// set frame title, size, resizable, location, close operation and visible
		setTitle("Minesweeper");
		setSize(size * number, size * number);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Minesweeper();
	}

	/**
	 * This method adds 1 to every number around '-1'
	 * 
	 * @param m - matrix
	 * @return matrix with added numbers around '-1'
	 */
	public static int[][] matrixWithMines(int m[][]) {

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == -1) {
					for (int k = i - 1; k <= i + 1; k++) {
						for (int y = j - 1; y <= j + 1; y++) {
							if (k >= 0 && y >= 0 && k < m.length
									&& y < m[i].length) {
								if (m[k][y] != -1)
									m[k][y] += 1;
							}
						}
					}
				}
			}
		}
		return m;
	}
	/**
	 * Open field
	 * <p>
	 * Recursive method, to open all zero fields, and connected 1 and 2 fields.
	 * @param i - coordinate of button
	 * @param j - coordinate of button
	 */
	public void openField(int i, int j) {
		// if not in range of matrix return
		if (i < 0 || i >= number || j < 0 || j >= number) {
			return;
		}
		// if it is zero and no icon on that field
		if (matrix[i][j] == 0 && buttons[i][j].getIcon() == null) {
			// set button opaque, icon and color
			buttons[i][j].setOpaque(true);
			buttons[i][j].setIcon(zero);
			buttons[i][j].setBackground(new Color(229, 204, 255));
			buttons[i][j].setBorder(BorderFactory.createLoweredBevelBorder());
			openField(i + 1, j);
			openField(i - 1, j);
			openField(i, j + 1);
			openField(i, j - 1);
			openField(i - 1, j - 1);
			openField(i + 1, j - 1);
			openField(i - 1, j + 1);
			openField(i + 1, j + 1);
			// if value is > 0 set different icon and background color
		} else if (matrix[i][j] > 0) {
			// set opaque
			buttons[i][j].setOpaque(true);
			buttons[i][j].setBorder(BorderFactory.createLoweredBevelBorder());
			if (matrix[i][j] == 1) {
				buttons[i][j].setIcon(one);
				buttons[i][j].setBackground(new Color(204, 153, 255));
			} else if (matrix[i][j] == 2) {
				buttons[i][j].setIcon(two);
				buttons[i][j].setBackground(new Color(204, 153, 255));
			} else if (matrix[i][j] == 3) {
				buttons[i][j].setIcon(three);
				buttons[i][j].setBackground(new Color(178, 102, 255));
			} else if (matrix[i][j] == 4) {
				buttons[i][j].setIcon(four);
				buttons[i][j].setBackground(new Color(178, 102, 255));
			} else if (matrix[i][j] == 5) {
				buttons[i][j].setIcon(five);
				buttons[i][j].setBackground(new Color(127, 0, 255));
			} else if (matrix[i][j] == 6) {
				buttons[i][j].setIcon(six);
				buttons[i][j].setBackground(new Color(127, 0, 255));
			} else if (matrix[i][j] == 7) {
				buttons[i][j].setIcon(seven);
				buttons[i][j].setBackground(new Color(127, 0, 255));
			} else if (matrix[i][j] == 8) {
				buttons[i][j].setIcon(eight);
				buttons[i][j].setBackground(new Color(127, 0, 255));
			}

		}
		repaint();
		return;
	}
	/**
	 * Won !
	 * <p>
	 * Two counters, for unopened fields and mines.
	 * Count number of unopened fields and mines, compare those numbers
	 * @return - boolean value true if counters are the same
	 */
	public boolean won() {
		// declaration of counters
		int counter1 = 0;
		int counter2 = 0;
		
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				// if there is no icon and icon is flag count
				if (buttons[i][j].getIcon() == null || buttons[i][j].getIcon() == flag) {
					counter1++;
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				// count mines
				if (matrix[i][j] == -1) {
					counter2++;
				}
			}
		}
		// are those counters equal?
		if (counter1 == counter2) {
			return true;
		} else {
			return false;
		}

	}

}
