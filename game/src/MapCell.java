import java.awt.*;
import java.util.Random;

class MapCell extends Seedable{
    // the map cell seed instance
    public Random cellSeedInstance;
    
    public Color color;
    public char Type;
    public int row;
    public int col;

    MapCell(long s,char t, int c, int r) {
        final Random rand = new Random(s);
        if(t == 0) {

        }
    }

    MapCell() {}
    void paint(Graphics g) {
      
    }
  }