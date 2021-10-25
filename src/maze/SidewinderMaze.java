package maze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import maze.Cell.State;

public class SidewinderMaze extends Maze {

  public SidewinderMaze(int rows, int columns) throws IllegalArgumentException {
    super(rows, columns);
  }

  /**
   * see Maze#generateMaze
   */
  @Override
  protected void generateMaze() {

    initCells(State.WALL);

    Random rd = new Random();
    List<Cell> runSet = new ArrayList<>();

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < columns; c++) {
        if (r%2 == 0 && c%2==0) {
          myCells[r][c].setState(State.EMPTY);

          boolean goEast = rd.nextBoolean();
          if (r == 0) {
            carveEast(r,c);
          }else if (goEast && c < columns -1) {
            carveEast(r,c);
            runSet.add(myCells[r][c]);
          } else {
            runSet.add(myCells[r][c]);
            carveNorth(runSet);
          }

        }
      }
    }

  }

  private void carveEast(int r, int c) {
    if (c < columns-1) {
      myCells[r][c+1].setState(State.EMPTY);
    }
  }

  private void carveNorth(List<Cell> runSet) {
    Collections.shuffle(runSet);
    Cell chosenCell = runSet.get(0);
    myCells[chosenCell.getRow()-1][chosenCell.getColumn()].setState(State.EMPTY);
    runSet.clear();
  }

}
