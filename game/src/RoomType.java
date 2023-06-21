import java.awt.*;
public class RoomType {
    public String rooms;
    RoomType() {
        rooms = "";
    }
    
    RoomType(String input) {
        rooms = input;
    }
    private class LShape extends RoomType {
        LShape() {
            super("#**#**###");
        }
    }

    private class BackwardsLShape extends RoomType {
        BackwardsLShape() {
            super("**#**####");
        }
    }

    private class TShape extends RoomType {
        TShape() {
            super("***#*##*#");
        }
    }

    private class PlusShape extends RoomType {
        PlusShape() {
            super("#*#***#*#");
        }
    }

    private class LineShape extends RoomType {
        LineShape() {
            super("#*##*##*#");
        }
    }
}
