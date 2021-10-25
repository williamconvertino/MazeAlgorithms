package maze;


/**
 * This class keeps track of an individual cell, including its location
 * and state.
 *
 * It is based on the Cell class provided by professors Robert C. Duvall
 * and Shannon Pollard of the Duke University CS Department.
 *
 * @author William Convertino
 */
public class Cell implements Comparable<Cell> {

  /**
   * An enumeration of all the possible states of the cell.
   * WALL represents a cell that cannot be traversed.
   * PATH represents a cell that is either being explored or is in the final path.
   * EMPTY represents a cell that has not yet been explored.
   * VISITED represents a cell that has been explored, but is not in the final path.
   */
  public enum State {
    WALL,
    PATH,
    EMPTY,
    VISITED
  }

  //The position of the cell.
  private int row, column;

  //The state of the cell.
  private State state;

  /**
   * Constructs a Cell with the given position and state.
   *
   * @param row the x position of the cell.
   * @param column the y position of the cell.
   * @param state the state of the cell.
   */
  public Cell(int row, int column, State state) {
    this.row = row;
    this.column = column;
    this.state = state;
  }

  /**
   * Returns the row` position of this cell.
   *
   * @return the row position of this cell.
   */
  public int getRow() {
    return row;
  }

  /**
   * Returns the column of this cell.
   *
   * @return the column of this cell.
   */
  public int getColumn() {
    return column;
  }

  /**
   * Returns the state of this cell.
   *
   * @return the state of this cell.
   */
  public State getState() {
    return state;
  }

  /**
   * Updates the state of the cell to reflect a new state unless the cell is
   * a wall.
   *
   * @param newState the attempted new state of this cell.
   */
  public void markState(State newState) {
    if (this.state != State.WALL) {
      this.state = newState;
    }
  }

  /**
   * Replaces the current state of the cell to reflect a new state, regardless of
   * its current state.
   *
   * @param newState the new state of this cell.
   */
  public void setState(State newState) {
    this.state = newState;
  }

  /**
   * Returns the distance between this cell and the end of the maze.
   *
   * @return the distance between this cell and the end of the maze.
   */
  public double getDistanceFromEnd() {
    return (1.0);
  }

  /**
   * @see Object#toString()
   */
  @Override
  public String toString() {
    return (String.format("(%s, %s) -> %s", row, column, state.toString()));
  }

  /**
   * Compares two cells based on which is closer to the end of the maze.
   *
   * @param cell the cell to compare with.
   * @return a negative integer, a positive integer, or zero based on if
   * this cell is closer to the end, further from the end, or equidistant
   * from the end relative to the specified cell.
   */
  @Override
  public int compareTo(Cell cell) {
    return Double.compare(this.getDistanceFromEnd(), cell.getDistanceFromEnd());
  }

  /**
   * Returns true if this cell has the same row, column, and state as
   * the specified cell, and false otherwise.
   *
   * @param cell the cell to compare with.
   * @return true or false based on whether this cell has the same content as
   * the specified other cell.
   */
  public boolean equals (Cell cell) {
    return (this.row == cell.row && this.column == cell.column && this.state == cell.state);
  }

}
