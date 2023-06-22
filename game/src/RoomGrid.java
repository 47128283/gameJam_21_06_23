import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;
import java.util.function.Consumer;
 
class RoomGrid extends MapCell implements Iterable<RoomTile> {

    public static int tileSize = 35;
    public static int colCount = 3;
    public static int rowCount = 3;
    public static int horizMargin = 10;
    public static int vertiMargin = 10;

    // the tiles array
    // TODO: change to be initialised only in the constructor
    RoomTile[][] tiles = new RoomTile[colCount][rowCount];

    // holds the default tile type for this room

    char defaultTile;
    /**
     * @brief default constructor
     */
    protected RoomGrid() {
        // default MapCell construction
        super();
        // setup the cells
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                int x = horizMargin + tileSize * i;
                int y = vertiMargin + tileSize * j;
                // tiles[i][j] = new RoomTile(i, j, x, y,'#');
                tiles[i][j] = new RoomTile(i, j, x, y, CorbLib.getDefault_tileByRoomType(this.type));
            }
        }
    }

    // /**
    //  * @brief constructor only being given a room type
    //  * @param t the type given to generate the room by
    //  */
    // protected RoomGrid(RoomType t) {
    //     int count = 0;
    //     for (int i = 0; i < tiles.length; i++) {
    //         for (int j = 0; j < tiles[i].length; j++) {
    //             int x = horizMargin + tileSize * i;
    //             int y = vertiMargin + tileSize * j;
    //             char[] tt = t.rooms.toCharArray();
    //             tiles[i][j] = new RoomTile(i, j, x, y, tt[count]);
    //             count ++;
    //         }
    //     }
    // }

    /**
     * @brief constructor with the seed and type input
     * @param seedIn seed long for the room grid provided by MapGrid
     * @param typeIn the type for this room
     * @param colIn the col this room is in the map's grid
     * @param rowIn the row this room is in the map's grid
     */
    public RoomGrid(long seedIn, char typeIn, int colIn, int rowIn){
        // make seedable instance by seed
        super(seedIn, typeIn, colIn, rowIn);

        // loop all tiles
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                int x = horizMargin + tileSize * i;
                int y = vertiMargin + tileSize * j;
                // char[] tt = t.rooms.toCharArray();
                // TODO: should be given by some "getTileString"
                char currTile = CorbLib.getDefault_tileByRoomType(this.type);
                tiles[i][j] = new RoomTile(i, j, x, y, currTile);
                // count ++;
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
     * @param color the color of overlay (should be alpha <1.0 tbh)
     */
    public void paintOverlay(Graphics g, List<RoomTile> tileListIn, Color color) {
        g.setColor(color);
        for (RoomTile t : tileListIn) {
            g.fillRect(t.x + 2, t.y + 2, t.width - 4, t.height - 4);
        }
    }

    /**
     * @brief the painting of room grid with mousepos
     */
    public void paint(Graphics g, Point mousePos){
      // paint as map cell
      this.paint(g,mousePos);
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

    public String toString() {
      String retval = "";
      for(RoomTile t : this){
        retval = retval + t.toString();
      }
      return retval;
    }
}