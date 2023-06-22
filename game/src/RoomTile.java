import java.awt.*;

class RoomTile extends Rectangle {
    // RoomTile properties
    protected static int size = RoomGrid.tileSize;
    protected int col;
    protected int row;

    protected char hiddenType;
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
    void paint(Graphics g, Point mousePos) {
      // draw a box by the thing in lib
      CorbLib.drawBox(g, x, y, width, height, CorbLib.getTileColor(drawnType));
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