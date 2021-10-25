package solvers;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import maze.Cell;
import maze.Maze;


/**
 * This class represents a Breadth-First maze search algorithm.
 *
 * @author Will Convertino
 */
public class BFS extends SearchAlgorithmQueue <Queue<Cell>> {

	//Constants
	public static final String TITLE = "Breadth-First";

	//BFS Variables
	protected Map<Cell, Cell> myPaths;

	//Constructors
	public BFS(Maze myMaze, String myDescription) {
		super(myMaze, myDescription);
	}

	public BFS(Maze myMaze) {
		super(myMaze);
	}

	//Methods
	@Override
	protected void initializeFrontier() {
		this.myFrontier = new LinkedList();
		super.initializeFrontier();
	}


}
