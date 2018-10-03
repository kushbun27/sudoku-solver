package sudoku_solver1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//import Sudoku.Cell;

//import Sudoku.Cell;

//import Sudoku.Cell;



public class sudokuSolver extends JFrame implements ActionListener
{
	
	static int gb[][];
	 static int N = 9;
	 
	 
	 static class Cell {

		  int row, col;

		  public Cell(int row, int col) {
		   super();
		   this.row = row;
		   this.col = col;
		  }

		  @Override
		  public String toString() {
		   return "Cell [row=" + row + ", col=" + col + "]";
		  }
		 };
		 
		 
		 public static void asli_main()
		 
		 
		 {
			 
			 
			 {
				  boolean solved = solve(new Cell(0, 0));
				  if (!solved) {
				   System.out.println("SUDOKU cannot be solved.");
				   return;
				  }
				  System.out.println("SOLUTION\n");
				 }

				
		 }
		 
		 
		 
		 static boolean isValid(Cell cell, int value) {

			  if (gb[cell.row][cell.col] != 0) {
			   throw new RuntimeException(
			     "Cannot call for cell which already has a value");
			  }

			  // if v present row, return false
			  for (int c = 0; c < 9; c++) {
			   if (gb[cell.row][c] == value)
			    return false;
			  }

			  // if v present in col, return false
			  for (int r = 0; r < 9; r++) {
			   if (gb[r][cell.col] == value)
			    return false;
			  }

			  // if v present in grid, return false

			  // to get the grid we should calculate (x1,y1) (x2,y2)
			  int x1 = 3 * (cell.row / 3);
			  int y1 = 3 * (cell.col / 3);
			  int x2 = x1 + 2;
			  int y2 = y1 + 2;

			  for (int x = x1; x <= x2; x++)
			   for (int y = y1; y <= y2; y++)
			    if (gb[x][y] == value)
			     return false;

			  // if value not present in row, col and bounding box, return true
			  return true;
			 }

		 
		 
		 static Cell getNextCell(Cell cur) {

			  int row = cur.row;
			  int col = cur.col;

			  // next cell => col++
			  col++;

			  // if col > 8, then col = 0, row++
			  // reached end of row, got to next row
			  if (col > 8) {
			   // goto next line
			   col = 0;
			   row++;
			  }

			  // reached end of matrix, return null
			  if (row > 8)
			   return null; // reached end

			  Cell next = new Cell(row, col);
			  return next;
			 }
	
		 
		 
		 
		 static boolean solve(Cell cur) {

			  // if the cell is null, we have reached the end
			  if (cur == null)
			   return true;

			  // if grid[cur] already has a value, there is nothing to solve here,
			  // continue on to next cell
			  if (gb[cur.row][cur.col] != 0) {
			   // return whatever is being returned by solve(next)
			   // i.e the state of soduku's solution is not being determined by
			   // this cell, but by other cells
			   return solve(getNextCell(cur));
			  }

			  // this is where each possible value is being assigned to the cell, and
			  // checked if a solutions could be arrived at.
			  
			  // if grid[cur] doesn't have a value
			  // try each possible value
			  for (int i = 1; i <= 9; i++) {
			   // check if valid, if valid, then update
			   boolean valid = isValid(cur, i);

			   if (!valid) // i not valid for this cell, try other values
			    continue;

			   // assign here
			   gb[cur.row][cur.col] = i;

			   // continue with next cell
			   boolean solved = solve(getNextCell(cur));
			   // if solved, return, else try other values
			   if (solved)
			    return true;
			   else
			    gb[cur.row][cur.col] = 0; // reset
			   // continue with other possible values
			  }

			  // if you reach here, then no value from 1 - 9 for this cell can solve
			  // return false
			  return false;
			 }

		 
		 
		 
		 
	
	sudokuSolver(){
		gb=new int[9][9];		
	//	for(int i = 0;i<9;i++) {
		//	for(int j = 0;j<9;j++) {
			//	gb[i][j] = 70;
		//	}
	//	}
	}
	
	
	JButton button[][] = new JButton[9][9],b1;
	
	void gui() {
		setLayout(new GridLayout(10,9));
		for (int i = 0; i<9;i++)
		{
			for(int j=0;j<9;j++)
			
			{
				button[i][j] = new JButton();
				button[i][j].addActionListener(this);
				add(button[i][j]);
			}		
		}
		b1= new JButton("solve");
		b1.addActionListener(this);
		add(b1);
	
	}
	public void actionPerformed(ActionEvent e)
	
	{
		String st =JOptionPane.showInputDialog(this,"proceed");
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				if(e.getSource()==button[i][j]&&e.getSource()!=b1)
				{	
					System.out.println(st + "------------"+i+" , "+j);
					button[i][j].setText(st);
					button[i][j].setEnabled(true);
					gb[i][j]=Integer.parseInt(button[i][j].getText().toString());
					System.out.println("value of sudoku matrix at"+i+" "+ j + " is "+gb[i][j]);
					
				}
		// we have asked for filling the values inside the box by clicking on the block.

		
		if(e.getSource()==b1)
		
		
			{
			//ab yahan par solve karna hai sudoku.
				
	//	b1.setText("chal gye");
		asli_main();
		
		
		for(int p=0;p<9;p++)
			for(int q=0;q<9;q++)
				button[p][q].setText(gb[p][q]+"");
					
				
				}
		
					
	}
	
	

}



	
