import java.awt.Graphics;
import java.util.Map;
import java.util.Random;

class MapGrid{
  public long mapSeed;
  public Random mapSeedInstance;
  // the rows and columns of our grid
  int cellCountX,cellCountY;
  // all our rooms
  MapCell[][] rooms;

  public MapGrid(long mapSeed){
    // copy our map seed
    this.mapSeed = mapSeed;
    // get the map seed instance
    mapSeedInstance = new Random(mapSeed);
    // grab 2 randoms for the cols/rows
    mapSeedInstance.nextInt();mapSeedInstance.nextInt();

    // make the rooms
    rooms = new MapCell[cellCountX][cellCountY];
    
    // then fill out the cell seeds
    for(int i = 0; i < cellCountX; i++){
      for(int k = 0; k < cellCountY; k++){
        rooms[i][k] = new MapCell(mapSeedInstance.nextLong(),0,i,k);
      }
    }

    
  }
  //...
  void paint(Graphics g) {
    
  }
}