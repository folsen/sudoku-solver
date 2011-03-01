package sudoku;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
public class SolveButton extends JButton implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SudokuGUI gui;
	public SolveButton(SudokuGUI gui) {
		super("Solve");
		this.gui = gui;
		addActionListener(this);
	}
	
	/**
	 * This method is performed when you click the solve button
	 * it creates a Sudoku object with the values from the GUI as
	 * a parameter. It then proceeds to solve it and return an alert
	 * if it is not solvable or show the results if it is.
	 */
	 public void actionPerformed(ActionEvent e) {
		 Sudoku su = new Sudoku(gui.getValues());
		 if(su.solve(0,0)) {
			 gui.setValues(su.getResults());
		 } else {
			 JOptionPane.showMessageDialog(this, "Sudoku is not solvable.");
		 }
	 }
}