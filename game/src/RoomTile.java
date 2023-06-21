import java.util.Random;
public class RoomTile {
    private boolean isSafe; //means that this cell would be along the intended path
    public char drawnType;
    private char actualType; 
    public char itemType;
    Random r = new Random();

    RoomTile(boolean s, char dt, char at, Character it){ //given type
        
    }

    RoomTile(){ //randomly generated
        actualType = (char)r.nextInt(15);
        drawnType = 0;

    }
}
