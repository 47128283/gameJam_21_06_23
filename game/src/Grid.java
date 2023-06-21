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

class Grid implements Iterable<Cell> {
    // this allows us to change the grid a little
    // probably dont change these at runtime tho until
    // you have something to handle the change in array
    public static int cellSize = 35;
    public static int colCount = 7;
    public static int rowCount = 7;
    public static int horizMargin = 10;
    public static int vertiMargin = 10;

    Cell[][] cells = new Cell[colCount][rowCount];

    protected Grid() {
        // setup the cells
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                char c = colToLabel(i);
                int x = horizMargin + cellSize * i;
                int y = vertiMargin + cellSize * j;
                cells[i][j] = new Cell(c, j, x, y);
            }
        }
        // get our GridBuilder list of indexes
        // int[][] builtGrid = GridBuilder.buildGrid();

        // // make sure we caught a big one
        // if(builtGrid != null){
        //     // now run through and attempt to build our grid
        //     for (int x = 0; x < colCount; x++){
        //         for(int y = 0; y < rowCount; y++){
        //             // get index from our builtGrid
        //             int idx = builtGrid[x][y];
        //             // handle error tile
        //             if(idx == -1)
        //                 cells[x][y].setTile(Lib.errorTile());
        //             else // otherwise handle tile option
        //                 cells[x][y].setTile(Lib.TILE_OPTIONS[idx]);

        //         }
        //     }
        // }
        // else{
        //     // assign all cell.tile to error tile and scream?
        //     // TODO : handle when we werent able to build i guess?
        //     System.err.println("Failed to build grid, GridBuilder.buildGrid(); returned a null");
        // }


    }

    protected static Grid uniqueGrid; // singleton grid reference
    public static Grid getInstance() {
        if(Grid.uniqueGrid == null)
            Grid.uniqueGrid = new Grid();
        return Grid.uniqueGrid;
    }

    private char colToLabel(int col) {
        return (char) (col + 65);
    }

    private int labelToCol(char col) {
        return (int) col - 65;
    }

    public void paint(Graphics g, Point mousePos) {
        doToEachCell((Cell c) -> c.paint(g, mousePos));
    }

    private Optional<Cell> cellAtColRow(int c, int r) {
        if (c >= 0 && c < cells.length && r >= 0 && r < cells[c].length) {
            return Optional.of(cells[c][r]);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Cell> cellAtColRow(char c, int r) {
        return cellAtColRow(labelToCol(c), r);
    }

    public Optional<Cell> cellAtPoint(Point p) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].contains(p)) {
                    return Optional.of(cells[i][j]);
                }
            }
        }
        return Optional.empty();
    }

    public List<Cell> cellsInRange(char c1, int r1, char c2, int r2) {
        int c1i = labelToCol(c1);
        int c2i = labelToCol(c2);
        List<Cell> output = new ArrayList<Cell>();
        for (int i = c1i; i <= c2i; i++) {
            for (int j = r1; j <= r2; j++) {
                cellAtColRow(colToLabel(i), j).ifPresent(output::add);
            }
        }
        return output;
    }

    public void replaceCell(Cell old, Cell replacement) {
        cells[labelToCol(old.col)][old.row] = replacement;
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


    // /**
    //  * @param dirIdx : ajacent array direction index
    //  * @return x idx change
    //  */
    // public static int dirX(int dirIdx){
    //     switch(dirIdx){
    //         case 0:
    //         case 4:
    //         default:
    //             return 0;
    //         case 1:
    //         case 2:
    //         case 3:
    //             return 1;
    //         case 5:
    //         case 6:
    //         case 7:
    //             return -1;
    //     }
    // }

    // /**
    //  * @param dirIdx : ajacent array direction index
    //  * @return y idx change
    //  */
    // public static int dirY(int dirIdx){
    //     switch(dirIdx){
    //         case 0:
    //         case 1:
    //         case 7:
    //             return -1;
    //         case 2:
    //         case 6:
    //         default:
    //             return 0;
    //         case 3:
    //         case 4:
    //         case 5:
    //             return 1;
    //     }
    // }


}