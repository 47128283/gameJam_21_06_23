import java.util.Iterator;

/**
 * @brief generically implemented iterator thingy for our cell like
 *        objects in our grid like objects.
 *        [null or empty array references passed are treated as
 *        having already completed their iteration as they have
 *        no "next" reference to be returned and actioned on]
 */
public class CellIterator<T> implements Iterator<T> {
  // cells data
  T[][] cells;

  // the array index we're looking at
  int currArrayIdx;
  // the item in the current array index we're watching
  int currItemIdx;

  // keep track of if we're done
  boolean finishedIteration;

  /**
   * @brief construct by a given cells array
   */
  public CellIterator(T[][] cellsIn){
    // reference copy them
    this.cells = cellsIn;
    // set to start
    currArrayIdx = 0;
    currItemIdx = 0;
    // based on if cells is bad
    finishedIteration = (
      cells==null || // null protection
      cells.length==0 || // empty array is already done
      (cells.length==1&&cells[0].length==0) // 1 empty array done
    );
  }

  /**
   * @override check if we "flipped the breaker" trying to get next
   */
  @Override
  public boolean hasNext() {
    // only when not finished
    return !finishedIteration;
  }

  /**
   * @override returns current position, and advances, flipping boolean
   *            for if we have more if we go too far
   */
  @Override
  public T next() {
    // declare and initialise our return cell
    //  ticking our item index
    T returnCell = cells[currArrayIdx][currItemIdx++];
    // check if we went too far
    if( currItemIdx >= cells[currArrayIdx].length){
      //then wrap our item index to 0
      currItemIdx=0;
      // increase the array index
      currArrayIdx++;
      // check if we went too far in our arrays instead
      if( currArrayIdx >= cells.length){
        // we've finished them
        finishedIteration = true;
      }
    }
    // now give them the cell we were looking at
    return returnCell;
  }
}
