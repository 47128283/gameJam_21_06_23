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
  /* ======================================== */
  /* ======================================== */
  
  // singleton

  private static MapGrid instance;
  public static MapGrid getInstance(){
    if( instance==null ){ instance = new MapGrid( Stage.getMapGridSeed(), Stage.getMapGridSize() ); }
    return instance;
  }
  // TODO: have private constructor ask Stage for seed/size
  
  /* ======================================== */
  /* ======================================== */

  // margins
  public static int horizMargin = 10, vertiMargin = 10;
  // positioiniing of the mapgrid
  int x,y;
  int gridDiam;
  // the rows and columns of our grid
  int cellCountX,cellCountY;
  // all our rooms
  MapCell[][] rooms;

  int focusedCol;
  int focusedRow;
  MapCell focusedCell;
  boolean isfocused;

  public MapGrid(long mapSeed, int sizeIn){
    // does our map seed stuff
    super(mapSeed);
    // announce the annoucement
    System.out.println("MapGrid constructing with seed: "+mapSeed);
    // positioning
    x = horizMargin; y = vertiMargin;
    cellCountX = 3;
    cellCountY = 3;
    // stash the sizing
    gridDiam = sizeIn;
    int cellDiam = sizeIn/cellCountX;
    // grab 2 randoms for the cols/rows
    this.rollInt();this.rollInt(); // placeholder

    // make the rooms
    rooms = new MapCell[cellCountX][cellCountY];
    
    System.out.println("Room layout:\n");
    // then fill out the cell seeds
    for(int i = 0; i < cellCountX; i++){
      for(int k = 0; k < cellCountY; k++){
        char currCellType = Lib.getDefault_MapCellType();
        rooms[i][k] = new MapCell(
            this.rollLong(),
            currCellType,
            i,k,
            cellDiam
          );
      }
      System.out.println("");// free newline
    }
    System.out.println("");// free newline



    //decide to do more with centre one
    MapCell modify = rooms[1][1];
    // testing
    rooms[1][1] = new RoomGrid(modify.getSeedLong(), modify.type, modify.col, modify.row, modify.diam);
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
      if(c.contains(mousePos)){
        paintOverlay(g, List.of(c), Lib.getOverlayColor());
      }
    }
  }


  public boolean contains(Point p) {
    if (p != null) {
      return (
        (
          ( this.x<=p.x) && ( this.y<=p.y )
        ) &&
        (
        ( (this.x+this.gridDiam)>=p.x ) && ( (this.y+this.gridDiam)>=p.y )

        )
      );
    } else {
      return false;
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
      Lib.drawBox(
          g,
          t.x + MapCell.horizMargin, t.y + MapCell.vertiMargin,
          t.diam - (MapCell.horizMargin*2), t.diam - (MapCell.vertiMargin*2),
          overlayColor
        );
    }
  }

  /**
   * @brief makes the MapGrid focus onto the given MapCell
   */
  void focusOn(MapCell c) {
    this.focusedCell = c;
    this.isfocused = true;
    this.focusedCol = c.col;
    this.focusedRow = c.row;
  }

  /**
   * @brief makes the MapGrid unfocus from a MapCell
   * @sets focusedCol to -1 and focusedRow to -1
   */
  void unfocus() {
    this.focusedCell = null;
    this.isfocused = false;
    this.focusedCol = -1;
    this.focusedRow = -1;
  }

  MapCell getCell(int col, int row) {
    return this.rooms[col][row];
  }

  MapCell getFocusedCell() {
    return this.focusedCell;
  }

  int getFocusedCol() {
    return this.focusedRow;
  }

  int getFocusedRow() {
    return this.focusedCol;
  }

  boolean getIsFocused() {
    return this.isfocused;
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