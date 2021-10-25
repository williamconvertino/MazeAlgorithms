package maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import maze.Cell.State;

public abstract class Maze {


  protected int rows, columns;
  protected Cell[][] myCells;

  protected Cell myStart;
  protected Cell myEnd;

  public Maze(int rows, int columns) throws IllegalArgumentException {
    if (rows <= 0 || columns <= 0) {
      throw new IllegalArgumentException("Invalid dimensions: received invalid size for either rows or columns.");
    }
    //We enforce the dimensions of the grid to ensure it has an odd number of rows/columns.
    //This will be necessary for us to use the Sidewinder algorithm later on.
    this.rows = rows - (rows+1)%2;
    this.columns = columns - (columns+1)%2;
    generateMaze();
    this.myStart = myCells[0][0];
    this.myEnd = myCells[rows-1][columns-1];
  }

  public Cell getStart() {
    return myStart;
  }

  public Cell getEnd() {
    return myEnd;
  }

  public List<Cell> getNeighbors(Cell cell) {
    List<Cell> ret = new ArrayList<>();
    int row = cell.getRow();
    int column = cell.getColumn();
    if (row > 0) {
      ret.add(myCells[row-1][column]);
    }
    if (row < rows-1) {
      ret.add(myCells[row+1][column]);
    }
    if (column > 0) {
      ret.add(myCells[row][column-1]);
    }
    if (column < columns-1) {
      ret.add(myCells[row][column+1]);
    }
    return ret;
  }

  /**
   * @see Object#toString()
   */
  @Override
  public String toString() {
    String ret = "";
    String symbol;
    for (int r = 0; r < rows; r++) {
      for (int c =0; c < columns; c++) {
        switch (myCells[r][c].getState()) {
          case WALL -> symbol = "X";
          case PATH -> symbol = ">";
          default -> symbol = "0";
        }
        ret = String.format("%s %s", ret, symbol);
      }
      ret = String.format("%s %s", ret, "\n");
    }
    return ret;
  }

  public Cell[][] getCellArray() {
    return myCells;
  }

  //Initializes the myCells 2d array and sets all its starting states to the specified state.
  protected void initCells(State startingState) {
    this.myCells = new Cell[rows][columns];
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < columns; c++) {
        myCells[r][c] = new Cell(r, c, startingState);
      }
    }
  }

  protected abstract void generateMaze();
}
