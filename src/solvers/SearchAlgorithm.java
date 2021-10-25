package solvers;


import java.util.Collection;
import java.util.List;
import maze.Cell;
import maze.Cell.State;
import maze.Maze;

/**
 * This class represents the abstraction of a maze search algorithm.
 *
 * @author Will Convertino
 */
public abstract class SearchAlgorithm<T extends Collection<Cell>> {

	//SA Variables
	protected Maze myMaze;
	protected String myDescription;
	protected Cell myCurrent;
	protected T myFrontier;

	//Stat Variables
	protected int totalSteps;
	protected int numberOfBacktracks;

	//Constructors
	public SearchAlgorithm(Maze myMaze, String myDescription) {

		this.myMaze = myMaze;
		this.myDescription = myDescription;
		this.myCurrent = myMaze.getStart();
		this.myCurrent.markState(State.PATH);
		this.totalSteps = 0;
		this.numberOfBacktracks = 0;
		initializeFrontier();

	}

	public SearchAlgorithm(Maze myMaze) {
		this(myMaze, "");
	}

	//Initialization
	protected abstract void initializeFrontier();

	//Cell Methods
	protected List<Cell> getNeighbors() {
		return myMaze.getNeighbors(myCurrent);
	}
	protected Cell getNextSpot() {
		for (Cell s: getNeighbors()) {
			if (s.getState() == State.EMPTY) {
				return(s);
			}
		}
		return null;
	}

	protected abstract Cell getNextCurrentSpot();
	protected abstract void addSpot(Cell s);
	protected abstract void removeSpot();

	public boolean step() {
		//System.out.println( totalSteps+ " " + numberOfBacktracks);
		totalSteps += 1;
		if (isSearchOver()) {return true;}

		Cell next = getNextSpot();
		if (next != null) {
			next.markState(State.PATH);
			addSpot(next);
		} else {
			numberOfBacktracks += 1;
			myCurrent.markState(State.VISITED);
			removeSpot();
		}
		myCurrent = getNextCurrentSpot();
		return false;
	}

	protected boolean isSearchOver() {
		return(myFrontier.isEmpty() || (myCurrent != null && myCurrent.equals(myMaze.getEnd())));
	}

	@Override
	public String toString () {
		return myDescription;
	}

	public int getTotalSteps() {
		return totalSteps;
	}

	public int getNumberOfBacktracks () {
		return numberOfBacktracks;
	}

	public T getMyFrontier() {
		return myFrontier;
	}

}
