package solvers;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import maze.Cell;
import maze.Cell.State;
import maze.Maze;


/**
 * This class represents a SearchAlgorithmQueue parent class.
 *
 * @author Will Convertino
 */
public abstract class SearchAlgorithmQueue<T extends Queue<Cell>> extends SearchAlgorithm <T> {

	//BFS Variables
	protected Map<Cell, Cell> myPaths;

	//Constructors
	public SearchAlgorithmQueue(Maze myMaze, String myDescription) {
		super(myMaze, myDescription);
	}

	public SearchAlgorithmQueue(Maze myMaze) {
		super(myMaze);
	}

	//Methods
	@Override
	protected void initializeFrontier() {
		this.myPaths = new HashMap();
		myFrontier.add(myCurrent);
	}

	@Override
	protected Cell getNextCurrentSpot() {
		return(myFrontier.peek());
	}

	@Override
	protected void addSpot(Cell s) {
		myFrontier.add(s);
		myPaths.put(s, myCurrent);
	}

	@Override
	protected void removeSpot() {
		myFrontier.remove();
	}

	protected boolean isSearchOver() {
		if(myFrontier.isEmpty() || (myCurrent != null && myCurrent.equals(myMaze.getEnd()))) {
			markPath();
			return true;
		}
		return false;
	}

	protected void markPath () {
		Cell step = myMaze.getEnd();
		while (step != null) {
			step.markState(State.PATH);
			step = myPaths.get(step);
		}
	}


}
