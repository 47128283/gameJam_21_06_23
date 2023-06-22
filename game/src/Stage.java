import java.awt.Graphics;
import java.awt.Point;

/**
 * instance of stage is the current game stage/client
 */
class Stage extends Seedable{
  // map grid instance of the current stage
  MapGrid mapgrid;

  Stage(long seedIn) {
    // use the seedable super construction
    super(seedIn);
    // then get our mapgrid instance
    mapgrid = new MapGrid(this.rollLong());

    // proclaim our seed
    System.out.println("Stage using seed: "+this.getSeedLong());
  }

  /**
   * @brief paints a frame of the stage
   * @param g
   */
  void paint(Graphics g, Point mousePos) {
    mapgrid.paint(g, mousePos);
  }
  
}
