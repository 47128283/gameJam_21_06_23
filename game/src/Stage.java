import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 * instance of stage is the current game stage/client
 */
class Stage extends Seedable {

  /* ##################################################################################### */
  /* ===================================================================================== */
  /* --------------------------->> Stage static variables <------------------------------- */
  /* ===================================================================================== */
  /* --                                                                                 -- */
  /* ===================================================================================== */
  /* ##################################################################################### */

  public static int mapGridSize;
  public static long mapGridSeed = 0l;
  public static long playerSeed = 0l;
  public static int getMapGridSize(){ return mapGridSize; }
  public static long getMapGridSeed(){ return mapGridSeed; }
  public static long getPlayerSeed(){ return playerSeed; }

  /* ===================================================================================== */
  /* ------------------------------------------------------------------------------------- */
  /* ===================================================================================== */
  /* ##################################################################################### */


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
    // setup mapgrid seed if not yet
    mapGridSeed = (mapGridSeed==0l)?this.rollLong():mapGridSeed;
    // and size
    mapGridSize = 400;
    mapgrid = new MapGrid(mapGridSeed, mapGridSize);

    // setup player seed if not yet
    playerSeed = (playerSeed==0l)?this.rollLong():playerSeed;

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
    // handoff to paint the map grid
    mapgrid.paint(g, mousePos);

    // painting stat blocks here

    // tell the player to paint
    Player.getInstance().paint(g);

    // painting overlay/context menus would go here
  }

  /* ===================================================================================== */
  /* ------------------------------------------------------------------------------------- */
  /* ===================================================================================== */
  /* ##################################################################################### */
  
}
