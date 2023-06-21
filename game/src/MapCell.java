import java.awt.*;
import java.util.Random;

class MapCell extends Seedable{
    // the map cell seed instance
    
    public Color color;
    public char Type;
    public int row;
    public int col;

    MapCell(long s,char t, int c, int r) {
        super(s);
        if(t == 0) {

        }
    }

    MapCell() {
        super(0);
    }
    void paint(Graphics g) {
      
    }
  }