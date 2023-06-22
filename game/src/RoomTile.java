import java.awt.*;

/**
 * @breif yeet
 * @param drawnType use hiddenType instead
 * @param hiddenType use this
*/
class RoomTile extends Rectangle {
    // RoomTile properties
    protected static int size = RoomGrid.tileSize;
    protected int col;
    protected int row;

    /**
     * @warning use hiddenType instead of drawnType
     */
    protected char hiddenType;
    /**
     * @warning use hiddenType instead of drawnType
     */
    protected char drawnType;



    // // tile container
    // protected Tile tile;

    public RoomTile(int inCol, int inRow, int inX, int inY, char type) {
      // rectangle super construction
      super(inX, inY, size, size);
      col = inCol;
      row = inRow;
      // handoff the type
      hiddenType = type;
      // handoff the drawable type
    }

    // general tile painter method called from Grid class
    void paint(Graphics g, Point mousePos, int mCol, int mRow) {
      // draw a box by the thing in lib
      int xsize = 400/3/3;
      int ysize = 400/3/3;
      Lib.drawBox(g, (xsize*(mRow*3))+(xsize*row), (ysize*(mCol*3))+(ysize*col), xsize, ysize,  Lib.getTileColor(hiddenType));
    }

    @Override
    public boolean contains(Point p) {
      if (p != null) {
        return (super.contains(p));
      } else {
        return false;
      }
    }

    // switch(t) {
    //     case '#':
    //         return new Boundary();
    //     case '*':
    //         return new Walkable();
    //     default:
    //         return null;
    // }

    void setHiddenType(char t) {
      hiddenType = t;
    }

    void setDrawnType(char t) {
      drawnType = t;
    }

    /**
     * @brief Checks if the player can move to this tile.
     * 
     * @returns A Boolean value which returns true if you can walk on it, false if you can't, and null if it is a bad input.
     */
    public Boolean canMoveTo() {
      switch(this.hiddenType) {
        case Lib.TILE_BOUNDARY: //boundary
          return false;
        case Lib.TILE_WALKABLE: //walkable
          return true;
        case Lib.TILE_SPECIAL: //item
          return true;
        default: 
          return null;
      }
    }

    public int leftOfComparison(RoomTile c) {
        return Integer.compare(col, c.col);
    }

    public int aboveComparison(RoomTile c) {
        return Integer.compare(row, c.row);
    }

    public String toString() {
        // return Character.toString(col) + Integer.toString(row) + ":" /*+ description*/;
        return ""+this.drawnType;
    }
}