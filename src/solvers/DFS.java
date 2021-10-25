package solvers;

import java.util.Stack;
import maze.Cell;
import maze.Maze;


/**
 * This class represents a Depth-First maze search algorithm.
 *
 * @author Will Convertino
 */
public class DFS extends SearchAlgorithm<Stack<Cell>> {

	//Constants
	public static final String TITLE = "Depth-First";

	//Constructors
	public DFS(Maze myMaze, String myDescription) {
		super(myMaze, myDescription);
	}

	public DFS(Maze myMaze) {
		super(myMaze);
	}

	//Methods
	@Override
	protected void initializeFrontier() {
		this.myFrontier = new Stack<>();
		this.myFrontier.push(myCurrent);
	}

	@Override
	protected Cell getNextCurrentSpot() {
		return myFrontier.peek();
	}

	@Override
	protected void addSpot(Cell s) {
		myFrontier.push(s);
	}

	@Override
	protected void removeSpot() {
		myFrontier.pop();
	}
}
