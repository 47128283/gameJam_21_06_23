import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
// import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;
// import java.util.stream.Collectors;
// import java.util.stream.IntStream;

class RoomGrid implements Iterable<RoomTile> {
    public static int tileSize = 35;
    public static int colCount = 3;
    public static int rowCount = 3;
    public static int horizMargin = 10;
    public static int vertiMargin = 10;

    RoomTile[][] tiles = new RoomTile[colCount][rowCount];

    protected RoomGrid() {
        // setup the cells
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                int x = horizMargin + tileSize * i;
                int y = vertiMargin + tileSize * j;
                tiles[i][j] = new RoomTile(i, j, x, y,'#');
            }
        }
    }

    protected RoomGrid(RoomType t) {
        int count = 0;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                int x = horizMargin + tileSize * i;
                int y = vertiMargin + tileSize * j;
                char[] tt = t.rooms.toCharArray();
                tiles[i][j] = new RoomTile(i, j, x, y, tt[count]);
                count ++;
            }
        }
    }

    /**
     * Takes a cell consumer (i.e. a function that has a single `Cell` argument and
     * returns `void`) and applies that consumer to each cell in the grid.
     *
     * @param func The `Cell` to `void` function to apply at each spot.
     */
    public void doToEachCell(Consumer<Cell> func) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                func.accept(cells[i][j]);
            }
        }
    }

    public void paintOverlay(Graphics g, List<Cell> cells, Color color) {
        g.setColor(color);
        for (Cell c : cells) {
            g.fillRect(c.x + 2, c.y + 2, c.width - 4, c.height - 4);
        }
    }

    public List<Cell> getRadius(Cell from, int size) {
        int i = labelToCol(from.col);
        int j = from.row;
        Set<Cell> inRadius = new HashSet<Cell>();
        if (size > 0) {
            cellAtColRow(colToLabel(i), j - 1).ifPresent(inRadius::add);
            cellAtColRow(colToLabel(i), j + 1).ifPresent(inRadius::add);
            cellAtColRow(colToLabel(i - 1), j).ifPresent(inRadius::add);
            cellAtColRow(colToLabel(i + 1), j).ifPresent(inRadius::add);
        }

        for (Cell c : inRadius.toArray(new Cell[0])) {
            inRadius.addAll(getRadius(c, size - 1));
        }
        return new ArrayList<Cell>(inRadius);
    }

    // yucky we barely use this, fix that probably
    @Override
    public CellIterator iterator() {
        return new CellIterator(cells);
    }

    public String toString() {
        String retval = new String();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                retval = retval + cells[i][j];
            }
        }
        return retval;
    }
}