import java.util.Random;
public class RoomTile {
    private boolean isSafe; //means that this cell would be along the intended path
    public char drawnType;
    private char actualType; 
    public char itemType;

    RoomTile(boolean s, char dt, char at, Character it){ //given type
        
    }

    RoomTile(){ //randomly generated
        Random r = new Random();
        
    }
}
