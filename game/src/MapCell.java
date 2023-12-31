import java.awt.*;
// import java.util.Random;

class MapCell extends Seedable{
    // margins inside a cell
    public static int horizMargin = 2, vertiMargin = 2;
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

    public static Color lightFillColor = new Color( (0x87), (0xce), (0xeb) );
    public static Color  darkFillColor = new Color( (0x17), (0x98), (0xc1) );

    /**
     * @brief constructor with informatiion
     * @param seedIn the seed for this cell
     * @param typeIn the type for this cell
     * @param colIn the col this cell is
     * @param rowIn the row this cell is
     */
    MapCell(long seedIn,char typeIn, int colIn, int rowIn, int sizeIn) {
        // hand off for seedable setup
        super(seedIn);
        // append the console with the cell type
        System.out.print(""+ ( (typeIn!='\0')?typeIn:'!' ) );
        // say to draw the base by default
        drawBase = true;

        // possitioning in the map grid
        this.col = colIn;
        this.row = rowIn;
        // room type stuff
        this.type = typeIn;

        // sizing
        diam = sizeIn;

        // default the colors
        bgColor = ((colIn+rowIn)%2==0)? lightFillColor : darkFillColor;
        lineColor = Color.BLACK;

        x = MapGrid.horizMargin + colIn*diam;
        y = MapGrid.vertiMargin + rowIn*diam;
    }


    public boolean contains(Point p) {
      if (p != null) {
        return (
          (
            ( this.x<=p.x) && ( this.y<=p.y )
          ) &&
          (
          ( (this.x+this.diam)>=p.x ) && ( (this.y+this.diam)>=p.y )

          )
        );
      } else {
        return false;
      }
    }

    /**
     * @brief basic paint method for our map cell
     * @param g the graphics object
     * @param mousePos the pos of mouse
     */
    void  paint(Graphics g, Point mousePos) {
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