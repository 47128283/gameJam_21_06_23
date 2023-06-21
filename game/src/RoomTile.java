import java.awt.*;

class RoomTile extends Rectangle {
    // RoomTile properties
    protected static int size = RoomGrid.RoomTileSize;
    protected char col;
    protected int row;
    protected final Color DEFAULT_COLOR = new Color(235,235,235);
    protected Color bgColor;
    protected String description;

    // // tile container
    // protected Tile tile;

    public RoomTile(char inCol, int inRow, int inX, int inY) {
        super(inX, inY, size, size);
        col = inCol;
        row = inRow;
        // set the default bgColor
        bgColor = DEFAULT_COLOR;
    }

    // handle RoomTile background
    void paintRoomTileBackground(Graphics g, Point mousePos){
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
    void paintRoomTileOutline(Graphics g, Point mousePos){
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }

    // general tile painter method called from Grid class
    void paint(Graphics g, Point mousePos) {
        // handle RoomTile background
        paintRoomTileBackground(g,mousePos);

        // handle Tile Polygons
        paintTile(g,mousePos);

        // now draw outline
        paintRoomTileOutline(g,mousePos);

    }

    @Override
    public boolean contains(Point p) {
        if (p != null) {
            return (super.contains(p));
        } else {
            return false;
        }
    }

    public int leftOfComparison(RoomTile c) {
        return Character.compare(col, c.col);
    }

    public int aboveComparison(RoomTile c) {
        return Integer.compare(row, c.row);
    }

    public String toString() {
        return Character.toString(col) + Integer.toString(row) + ":" + description;
    }
}