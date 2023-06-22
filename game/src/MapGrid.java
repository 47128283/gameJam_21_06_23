import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;
import java.util.List;

/**
 * @brief is the object for which a game "map" is stored inside,
 *        featuring a grid of "rooms" that the player can navigate.
 *        Generated based on a provided seed.
 */
class MapGrid extends Seedable implements Iterable<MapCell>{
  // positioiniing of the mapgrid
  int x,y;
  // the rows and columns of our grid
  int cellCountX,cellCountY;
  // all our rooms
  MapCell[][] rooms;

  public MapGrid(long mapSeed){
    // does our map seed stuff
    super(mapSeed);
    // positioning
    x = 10; y = 10;
    // grab 2 randoms for the cols/rows
    this.rollInt();this.rollInt(); // placeholder

    // make the rooms
    rooms = new MapCell[cellCountX][cellCountY];
    
    // then fill out the cell seeds
    for(int i = 0; i < cellCountX; i++){
      for(int k = 0; k < cellCountY; k++){
        char currCellType = Lib.getDefault_MapCellType();
        rooms[i][k] = new MapCell(this.rollLong(),currCellType,i,k);
      }
    }


  }

  /**
   * @brief paint function for all cells in our grid
   * @param g
   */
  void paint(Graphics g, Point mousePos) {
    // loop over all cells in our grid
    for(MapCell c : this){
      // paint it
      c.paint(g,mousePos);
    }
  }
  

  /**
   * @brief takes a tile list and paints an overlay over them
   * @param g the graphics object
   * @param cellListIn the cell list to paint over
   * @param overlayColor the color of overlay (should be alpha <1.0 tbh)
   */
  public void paintOverlay(Graphics g, List<MapCell> cellListIn, Color overlayColor) {
    // loop all tiles iin the list
    for (MapCell t : cellListIn) {
      Lib.drawBox(g, x+t.x + 2, y+t.y + 2, t.diam - 4, t.diam - 4, overlayColor);
    }
  }

  /**
   * @override using the new genericable cell iterator based on
   *            what was made by Damian during the Object Orientated
   *            Programming Practices unit at MQU
   */
  @Override
  public Iterator<MapCell> iterator() {
    // make the iterator and return
    return new CellIterator<MapCell>(rooms);
  }
}