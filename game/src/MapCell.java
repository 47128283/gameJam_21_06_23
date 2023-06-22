import java.awt.*;
// import java.util.Random;

class MapCell extends Seedable{
    // relative position of the cell in map grid
    public int x,y;
    // diameter of the cell
    public int diam;

    // the colourings of this cell
    public Color bgColor,lineColor;

    // the store for what type this cell is
    public char type;

    // grid position information
    public int row,col;

    // whether we draw the bg/outline stuff
    public boolean drawBase;

    /**
     * @brief constructor with informatiion
     * @param seedIn the seed for this cell
     * @param typeIn the type for this cell
     * @param colIn the col this cell is
     * @param rowIn the row this cell is
     */
    MapCell(long seedIn,char typeIn, int colIn, int rowIn) {
        // hand off for seedable setup
        super(seedIn);
        // say to draw the base by default
        drawBase = true;
        // possitioning in the map grid
        this.col = colIn;
        this.row = rowIn;
        // room type stuff
        this.type = typeIn;

    }

    /**
     * @brief default constructor
     * @warning thiiss uses an untrack seed!
     */
    MapCell() {
        // you didnt provide a seed, get heckd
        super(CorbLib.getUntrackedRandomLong());
        // say to draw the base by default
        drawBase = true;

        // possitioning in the map grid
        this.col = -1;
        this.row = -1;
        // room type stuff
        this.type = CorbLib.getDefault_MapCellType();
    }

    /**
     * @brief basic paint method for our map cell
     * @param g the graphics object
     * @param mousePos the pos of mouse
     */
    void paint(Graphics g, Point mousePos) {
        // return if we shouldnt paint the background
        if(!drawBase) return;
        
        // bg color
        g.setColor(bgColor);
        // background
        g.fillRect(
            (int)(x), (int)(y),
            diam, diam
        );
        // outline color
        g.setColor(lineColor);
        // outline
        g.drawRect(
            (int)(x), (int)(y),
            diam, diam
        );
    }
  }