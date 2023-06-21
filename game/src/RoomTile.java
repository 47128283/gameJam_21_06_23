import java.awt.*;

class RoomTile extends Rectangle {
    // RoomTile properties
    protected static int size = RoomGrid.tileSize;
    protected int col;
    protected int row;
    protected TileType type;

    // // tile container
    // protected Tile tile;

    public RoomTile(int inCol, int inRow, int inX, int inY, char type) {
        super(inX, inY, size, size);
        col = inCol;
        row = inRow;
        // set the default bgColor

    }

    // handle RoomTile background
    void paintRoomTileBackground(Graphics g, Point mousePos){
        if (contains(mousePos)) {
            g.setColor(Color.GRAY);
        } else {
            g.setColor(type.tileColor);
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

    TileType setTileType(char t) {
        switch(t) {
            case '#':
                return new Boundary();
            case '*':
                return new Walkable();
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
        return Character.toString(col) + Integer.toString(row) + ":" + description;
    }
}