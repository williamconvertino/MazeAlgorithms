package solvers;


import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import maze.Maze;
import maze.Cell;


/**
 * This class represents a Greedy maze search algorithm.
 *
 * @author Will Convertino
 */
public class Greedy extends SearchAlgorithmQueue<PriorityQueue<Cell>> {

	//Constants
	public static final String TITLE = "Greedy";

	//Constructors
	public Greedy(Maze myMaze, String myDescription) {
		super(myMaze, myDescription);
	}

	public Greedy(Maze myMaze) {
		super(myMaze);
	}

	//Methods
	@Override
	protected void initializeFrontier() {
		this.myFrontier = new PriorityQueue();
		super.initializeFrontier();
	}

	@Override
	protected List<Cell> getNeighbors() {
		List<Cell> neighbors = super.getNeighbors();
		Collections.sort(neighbors);
		return neighbors;
	}

}
