import java.awt.Graphics;
import java.util.Map;
import java.util.Random;

class MapGrid extends Seedable{
  // the see long
  public long mapSeed;
  public Random mapSeedInstance;
  // the rows and columns of our grid
  int cellCountX,cellCountY;
  // all our rooms
  MapCell[][] rooms;

  public MapGrid(long mapSeed){
    // does our map seed stuff
    super(mapSeed);
    // grab 2 randoms for the cols/rows
    mapSeedInstance.nextInt();mapSeedInstance.nextInt();

    // make the rooms
    rooms = new MapCell[cellCountX][cellCountY];
    
    // then fill out the cell seeds
    for(int i = 0; i < cellCountX; i++){
      for(int k = 0; k < cellCountY; k++){
        rooms[i][k] = new MapCell(mapSeedInstance.nextLong(),'\0',i,k);
      }
    }


  }
  //...
  void paint(Graphics g) {
    
  }
}