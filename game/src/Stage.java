// import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

class Stage {
    Grid grid;

    Stage() {

        // then get our grid instance
        grid = Grid.getInstance();


        // proclaim our seed
        // System.out.println("Using seed: "+Lib.getSeed());

    }

    void paint(Graphics g, Point mouseLoc) {
        grid.paint(g, mouseLoc);
    }

    void mouseClicked(int x, int y) {
        //...
    }

}
