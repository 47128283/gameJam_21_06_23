import java.awt.Graphics;
import java.util.Iterator;
import java.util.Random;

/**
 * @brief is the object for which a game "map" is stored inside,
 *        featuring a grid of "rooms" that the player can navigate.
 *        Generated based on a provided seed.
 */
class MapGrid extends Seedable implements Iterable<MapCell>{
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
    //...
  }

  /**
   * @override using the new genericable cell iterator based on
   *            what was made by Damian during the Object Orientated
   *            Programming Practices unit at MQU
   */
  @Override
  public Iterator<MapCell> iterator() {
    // make the iterator and return
    return new CellIterator<MapCell>(rooms);
  }
}