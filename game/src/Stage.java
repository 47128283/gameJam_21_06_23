import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 * instance of stage is the current game stage/client
 */
class Stage extends Seedable {

  public static long mapGridSeed;
  public static int mapGridSize;
  public static long getMapGridSize(){ return mapGridSize; }
  public static long getMapGridSeed(){ return mapGridSeed; }

  /* ##################################################################################### */
  /* ===================================================================================== */
  /* ----------------------->> Stage instance implementation <<--------------------------- */
  /* ===================================================================================== */
  /* --                                                                                 -- */
  /* --  * big picture game wide instance                                               -- */
  /* --                                                                                 -- */
  /* ===================================================================================== */
  /* ##################################################################################### */

  // map grid instance of the current stage
  MapGrid mapgrid;

  Stage(long seedIn) {
    // use the seedable super construction
    super(seedIn);
    // // then get our mapgrid instance
    //mapgrid = new MapGrid( this.rollLong(), 400 );
    mapGridSeed = this.rollLong();
    mapGridSize = 400;

    // proclaim our seed
    System.out.println("Stage using seed: "+this.getSeedLong());
  }

  /**
   * @brief called by app whenever there's a mouse event, providing the mouse event that happened
   * @param e
   */
  public void handleMouseEvent(MouseEvent e){
    // add code to loop over mouse queued mouse events i guess?
  }

  /**
   * @brief paints a frame of the stage
   * @param g
   */
  void paint(Graphics g, Point mousePos) {
    mapgrid.paint(g, mousePos);
    
  }
  
}
