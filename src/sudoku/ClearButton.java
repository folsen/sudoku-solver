package sudoku;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
public class ClearButton extends JButton implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SudokuGUI gui;
	public ClearButton(SudokuGUI gui) {
		super("Clear");
		this.gui = gui;
		addActionListener(this);
	}
	
	/**
	 * Clear all the values from the GUI.
	 */
	 public void actionPerformed(ActionEvent e) {
		gui.clearValues();
	 }
}