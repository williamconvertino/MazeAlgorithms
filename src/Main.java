import java.util.Collection;
import maze.Cell;
import maze.Cell.State;
import maze.Maze;
import maze.SidewinderMaze;
import solvers.DFS;
import solvers.SearchAlgorithm;

public class Main {

  public static void main(String[] args) {

    Maze myMaze = new SidewinderMaze(19,19);
    System.out.println(myMaze);

    SearchAlgorithm myAlgorithm = new DFS(myMaze);

    while (myAlgorithm.step() == false) {}

    Cell[][] myGrid = myMaze.getCellArray();

    for (Cell c: (Collection<Cell>)myAlgorithm.getMyFrontier()) {
      myMaze.getCellArray()[c.getColumn()][c.getRow()].setState(State.PATH);
    }

    System.out.println(myMaze);
  }

}
