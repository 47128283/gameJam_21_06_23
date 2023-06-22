import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;
import java.util.function.Consumer;
 
class RoomGrid extends MapCell implements Iterable<RoomTile> {

    // bad irl
    public static int tileSize = 35;
    public int colCount = 3;
    public int rowCount = 3;

    // the tiles array
    RoomTile[][] tiles;

    String roomBaseString;
    // holds the default tile type for this room

    char defaultTile;

    /**
     * @brief constructor with the seed and type input
     * @param seedIn seed long for the room grid provided by MapGrid
     * @param typeIn the type for this room
     * @param colIn the col this room is in the map's grid
     * @param rowIn the row this room is in the map's grid
     */
    public RoomGrid(long seedIn, char typeIn, int colIn, int rowIn, int sizeIn){
        // make seedable instance by seed
        super(seedIn, typeIn, colIn, rowIn, sizeIn);
        // fetch the room string
        roomBaseString = Lib.getRoomStringByType(typeIn);
        // int roomSize = Lib.getSizeByStringLength(roomBaseString.length());
        // colCount = roomSize; rowCount = roomSize;
        colCount = 3; rowCount = 3;
        // make the tiles arrays
        tiles = new RoomTile[colCount][rowCount];
        // the index to grab from the string
        int currCharIdxInString = 0;
        // loop all tiles
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++,currCharIdxInString++) {
                int x = horizMargin + tileSize * i;
                int y = vertiMargin + tileSize * j;
                // grab the char from the string
                char currTile = roomBaseString.charAt(currCharIdxInString);
                // the tile init
                tiles[i][j] = new RoomTile(i, j, x, y, currTile);
            }
        }
    }

    /**
     * Takes a tile consumer (i.e. a function that has a single `RoomTile` argument and
     * returns `void`) and applies that consumer to each tile in the grid.
     *
     * @param func The `RoomTile` to `void` function to apply at each spot.
     */
    public void doToEachCell(Consumer<RoomTile> func) {
        // loop all cells
        for(RoomTile t : this){
            // apply function
            func.accept(t);
        }
    }

    /**
     * @brief takes a tile list and paints an overlay over them
     * @param g the graphics object
     * @param tileListIn the tile list to paint over
     * @param overlayColor the color of overlay (should be alpha <1.0 tbh)
     */
    public void paintOverlay(Graphics g, List<RoomTile> tileListIn, Color overlayColor) {
      // loop all tiles iin the list
      for (RoomTile t : tileListIn) {
        Lib.drawBox(g, t.x + 2, t.y + 2, t.width - 4, t.height - 4, overlayColor);
      }
    }

    /**
     * @brief the painting of room grid with mousepos
     */
    public void paint(Graphics g, Point mousePos){
      // then paint the tiles over
      for(RoomTile t : this){
        t.paint(g,mousePos);
      }
    }


    /* corb: "huh" */
    // public List<Cell> getRadius(Cell from, int size) {
    //     int i = labelToCol(from.col);
    //     int j = from.row;
    //     Set<Cell> inRadius = new HashSet<Cell>();
    //     if (size > 0) {
    //         cellAtColRow(colToLabel(i), j - 1).ifPresent(inRadius::add);
    //         cellAtColRow(colToLabel(i), j + 1).ifPresent(inRadius::add);
    //         cellAtColRow(colToLabel(i - 1), j).ifPresent(inRadius::add);
    //         cellAtColRow(colToLabel(i + 1), j).ifPresent(inRadius::add);
    //     }

    //     for (Cell c : inRadius.toArray(new Cell[0])) {
    //         inRadius.addAll(getRadius(c, size - 1));
    //     }
    //     return new ArrayList<Cell>(inRadius);
    // }

    /**
     * @override using the new cell iterator with generics
     */
    @Override
    public CellIterator<RoomTile> iterator() {
      return new CellIterator<RoomTile>(tiles);
    }

    /**
     * @brief Checks if the player can move to a tile within this RoomGrid.
     * 
     * @returns A Boolean value which returns true if you can walk on it, false if you can't, and null if it is a bad input.
     */
    public Boolean canMoveTo(int inCol, int inRow) {
      if((inCol > this.col) || (inCol < 0) || (inRow > this.row) || (inRow < 0)) {
        return null;
      } else {
        return this.tiles[inCol][inRow].canMoveTo();
      }
    }

    /**
     * @brief should just give back a string fo rthe cell types
     */
    public String toString() {
      String retval = "";
      for(RoomTile t : this){
        retval = retval + t.toString();
      }
      return retval;
    }
}