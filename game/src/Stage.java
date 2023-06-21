import java.awt.Graphics;
import java.util.Random;

/**
 * instance of stage is the current game stage/client
 */
class Stage {
  // the seed we're using for our game
  private static Random seedInstance = new Random();
  public static long seedLong;
  MapGrid mapgrid;


  Stage() {
    // then get our mapgrid instance
    mapgrid = new MapGrid();
    // generate seed
    seedLong = seedInstance.nextLong();
    
    // proclaim our seed
    System.out.println("Stage using seed: "+seedLong);
  }

  void paint(Graphics g) {
      mapgrid.paint(g);
  }
  
}
