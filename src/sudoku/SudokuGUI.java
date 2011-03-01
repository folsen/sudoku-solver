package sudoku;

import javax.swing.*;

import sudoku.SolveButton;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.*;
import java.io.*;
/**
 * The graphical user interface.
 */
public class SudokuGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField[][] fields = new JTextField[9][9];

	/**
	 * The constructor creates object of the buttons
	 * and draws the textfields for input.
	 */
	public SudokuGUI() {
		super("Sudoku solver");
		setLayout(new BorderLayout());
		
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(9,9));
		for(int i = 0;i<9;i++) {
			for(int k = 0;k<9;k++) {
				fields[i][k] = new JTextField();
				fields[i][k].setColumns(1);
				fields[i][k].setHorizontalAlignment(JTextField.CENTER);
				if(((i == 0 || i == 1 || i == 2 || i == 6 || i == 7 || i == 8) 
				   && (k == 0 || k == 1 || k == 2 || k == 6 || k == 7 || k == 8))
				   || ((i == 3 || i == 4 || i == 5) && (k == 3 || k == 4 || k == 5))){
					fields[i][k].setBackground(Color.ORANGE);
				}
				fields[i][k].setFont(new Font("Arial", Font.BOLD, 15));
				mainPanel.add(fields[i][k]);
			}
		}
		add(mainPanel,BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(new SolveButton(this));
		buttonPanel.add(new ClearButton(this));
		add(buttonPanel, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}
	/**
	 * This method gets all the values from the GUI
	 * and stores them in a 9x9 matrix. It parses all the input
	 * and creates a 0 where there were wrong input-types.
	 * @return Returns an int-matrix with the values given by the user.
	 */
	public int[][] getValues() {
		int[][] values = new int[9][9];
		for(int i = 0;i<9;i++) {
			for(int k = 0;k<9;k++) {
				String fieldContent = fields[i][k].getText();
				try {
					values[i][k] = Integer.parseInt(fieldContent);
					if(values[i][k] > 9) {
						values[i][k] = (int) (values[i][k]/Math.pow(10,
									(new Integer(values[i][k])).toString().length()));
					}
				} catch (NumberFormatException e) {
					values[i][k] = 0;
				}
			}
		}
		return values;
	}
	/**
	 * This method sets all the values in the GUI from a given 9x9 matrix.
	 * @param values A 9x9 matrix of integer values
	 */
	public void setValues(int[][] values) {
		for(int i = 0;i<9;i++) {
			for(int k = 0;k<9;k++) {
				fields[i][k].setText((new Integer(values[i][k])).toString());
			}
		}
	}
	
	/**
	 * This method clears all the GUI text-fields of data.
	 */
	public void clearValues() {
		for(int i = 0;i<9;i++) {
			for(int k = 0;k<9;k++) {
				fields[i][k].setText("");
			}
		}
	}
}
