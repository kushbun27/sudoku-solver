package sudoku_solver1;

import javax.swing.JFrame;



public class Driver {

	public static void main(String[] args) {
		sudokuSolver ss = new sudokuSolver();
		ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ss.setSize(850,700);
		ss.setVisible(true);
		ss.setTitle("SUDOKU GAME");
		
		ss.gui();
	}

}
