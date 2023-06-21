import java.awt.*;

/**
 * code was gutted from COMP2000 code
 *      TODO: make this unique enough that it's not providing answers to
 *              course content.
 *
 */
class Cell extends Rectangle {
    // cell properties
    protected static int size = Grid.cellSize;
    protected char col;
    protected int row;
    protected final Color DEFAULT_COLOR = new Color(235,235,235);
    protected Color bgColor;
    protected String description;

    // // tile container
    // protected Tile tile;

    public Cell(char inCol, int inRow, int inX, int inY) {
        super(inX, inY, size, size);
        col = inCol;
        row = inRow;
        // set the default bgColor
        bgColor = DEFAULT_COLOR;
    }

    // handle cell background
    void paintCellBackground(Graphics g, Point mousePos){
        if (contains(mousePos)) {
            g.setColor(Color.GRAY);
        } else {
            g.setColor(bgColor);
        }
        g.fillRect(x, y, size, size);
    }

    // handle Tile Polygons
    void paintTile(Graphics g, Point mousePos){
        // // tbh just ignore dead tiles
        // if(tile != null){
        //     tile.paint(g,x,y,width,height);
        // }

    }
    // handle base outline
    void paintCellOutline(Graphics g, Point mousePos){
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }

    // general tile painter method called from Grid class
    void paint(Graphics g, Point mousePos) {
        // handle cell background
        paintCellBackground(g,mousePos);

        // handle Tile Polygons
        paintTile(g,mousePos);

        // now draw outline
        paintCellOutline(g,mousePos);

    }

    @Override
    public boolean contains(Point p) {
        if (p != null) {
            return (super.contains(p));
        } else {
            return false;
        }
    }

    public int leftOfComparison(Cell c) {
        return Character.compare(col, c.col);
    }

    public int aboveComparison(Cell c) {
        return Integer.compare(row, c.row);
    }

    public String toString() {
        return Character.toString(col) + Integer.toString(row) + ":" + description;
    }

    // /**
    //  * TODO : maybe this should be overloaded to take idx when we move
    //  *          Lib.TILE_OPTIONS into the Tile class
    //  * set tile by tile reference
    //  * @param tileIn : reference to the tile
    //  */
    // public void setTile(Tile tileIn){
    //     tile = tileIn;
    // }
}