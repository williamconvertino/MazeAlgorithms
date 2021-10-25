package solvers;

import java.util.ArrayList;
import java.util.List;
import maze.Cell;
import maze.Cell.State;
import maze.Maze;


/**
 * This class represents a random maze search algorithm.
 *
 * @author Will Convertino
 */
/*
public class RandomWalk extends SearchAlgorithm <ArrayList<Cell>> {

	//Constants
	public static final String TITLE = "Random Walk";
	public final double EXPLORE_BIAS = 0.999;

	//RW Variables
	protected Cell nextCell;
	protected List<Cell> empties;
	protected List<Cell> possibles;

	//Constructors
	public RandomWalk(Maze myMaze, String myDescription) {
		super(myMaze, myDescription);
	}

	public RandomWalk(Maze myMaze) {
		this(myMaze,"");
	}

	@Override
	protected void initializeFrontier() {
		empties = new ArrayList<>();
		possibles = new ArrayList<>();
	}

	@Override
	protected Cell getNextSpot() {

		empties.clear();
		possibles.clear();

		for (Cell s: myMaze.getNeighbors(myCurrent)) {
			if (s.getState() == State.EMPTY) {empties.add(s);}
			if (s.getState() != State.WALL) {possibles.add(s);};
		}
		if (! empties.isEmpty() && Randomness.isRandomEnough(EXPLORE_BIAS)) {
			return(Randomness.getRandomElement(empties));
		}
		return(null);
	}

	@Override
	protected Cell getNextCurrentSpot() {
		return nextCell;
	}

	@Override
	protected void addSpot(Cell s) {
		nextCell = s;
	}

	@Override
	protected void removeSpot() {
		nextCell = Randomness.getRandomElement(possibles);
	}

	@Override
	protected boolean isSearchOver() {return(myCurrent != null && myCurrent.equals(myMaze.getGoal()));}

}

 */