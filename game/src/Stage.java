import java.awt.Graphics;

class Stage {
  // the seed we're using for our game
  Long currSeed;
  MapGrid mapgrid;

  Stage() {
    // then get our mapgrid instance
    mapgrid = new MapGrid();

    // proclaim our seed
    System.out.println("Stage using seed: "+Lib.getSeed());

  }

  void paint(Graphics g) {
      mapgrid.paint(g);
  }
  
}
