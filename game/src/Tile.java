import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 * TODO : change adjacency over to weightings
 *
 * this is what the procedural thingy needs for painting
 *      and also handles the painting of it
 */
public class Tile {
    public static String tileInstanceName = "Tile";

    String tileName;

    // list of shapes for our Tile
    Shape[] shapeList;

    /**
     * the main housing for deciding what a tile can be adjacent to
     *
     * allowedAdjacentTo[A][B]:
     *      [A] - direction from current tile
     *          length: 8, 0 is up, goes clockwise
     *      [B] - is allowed next to tile index
     *          length: Lib.TILE_COUNT, matches each allowable tile
     *
     * *** need to be wary of keeping options that majority of tiles can be next to ***
     * *** as may end up deadlocking if we have too strict rules for our adjacency
     */
    boolean[][] allowedAdjacency;

    // max shape constant
    final int MAX_SHAPES = Lib.MAX_TILE_SHAPES;

    // constructor
    public Tile(){
        // // setup our shapes with max shape thing
        // shapeList = new Shape[MAX_SHAPES];
        // // 8 being the number of directions
        // allowedAdjacency = new boolean[8][Lib.TILE_COUNT];
        // // setup a basic shape for handling stuff
        // this.setBasicSquareTile()
        //         .setupShape()
        //         .setupAdjacency()
        //         .setName(Tile.tileInstanceName);
    }



    /**
     * tile painter called by Grid/Cell
     */
    public void paint(Graphics g, int x, int y, int width, int height){
        // // loop through the shapes until we find a null
        // for(int idx = 0; idx < shapeList.length && shapeList[idx] != null; idx++){
        //     // get the current poly to draw
        //     Polygon currPoly = shapeList[idx].convertToPaintablePolygon(x,y,width,height);
        //     // get our shape fill color
        //     Color currPolyFill = shapeList[idx].getFill();
        //     // use the Lib.ERROR_COLOR if we have a null color
        //     if(currPolyFill == null)
        //         g.setColor(Lib.ERROR_COLOR);
        //     else
        //         g.setColor(currPolyFill);

        //     // now fill it
        //     g.fillPolygon(currPoly);

        //     // time for drawing the outline
        //     if(shapeList[idx].drawOutline){
        //         g.setColor(shapeList[idx].outline);
        //         g.drawPolygon(currPoly);
        //     }
        // }
    }

    /**
     * builder setName
     * @param inStr : string to set it to
     * @return reference to this
     */
    public Tile setName(String inStr){
        this.tileName = inStr;
        return this;
    }
    public String getTileName(){
        return this.tileName;
    }



    /*
     * TODO: REFACTOR ADJACENCY METHODS TO BE NEATER
     */

    // ADJACENCY METHODS

    public void addAllowedAdjacency(int tileIdx, int dirIdx){
        allowedAdjacency[dirIdx][tileIdx] = true;
    }
    public void remAllowedAdjacency(int tileIdx, int dirIdx){
        allowedAdjacency[dirIdx][tileIdx] = false;
    }

    /**
     * check if this Tile is allowed to face Lib.TILE_OPTIONS[tileIdx]
     *      in direction index dirIdx
     * @param tileIdx : the tile index in Lib.TILE_OPTIONS
     * @param dirIdx : the direction index where 0 is up, going clockwise
     * @return true if there's no rule against it
     */
    public boolean canFaceTileInDirection(int tileIdx, int dirIdx){
        return allowedAdjacency[dirIdx][tileIdx];
    }

    /**
     * used for setting up the shape if it's different to the standard
     *      square shape
     * @return : reference to this for builder
     */
    protected Tile setupShape(){
        return this;
    }

    protected Tile setupAdjacency(){
        return this.setCanFaceAnything(true);
    }

    public Tile setCanFace(int tileIdx, int dirIdx, boolean canFace){
        if(validTileIndex(tileIdx))
            this.allowedAdjacency[dirIdx][tileIdx] = canFace;
        return this;
    }
    public Tile setCanFaceAnyDirection(String inTileName, boolean canFace){
        // int tileIdx = Lib.getTileIndex(inTileName);
        // // if we get a -1 index then we dont try to set it, otherwise we do
        // return (validTileIndex(tileIdx)) ? this.setCanFaceAnyDirection(tileIdx,canFace) : this ;
        return this;
    }
    public Tile setCanFaceAnyDirection(String inTileName){
        return this.setCanFaceAnyDirection(inTileName, true);
    }
    public Tile setCanFaceAnyDirection(int tileIdx, boolean canFace){
        if(!validTileIndex(tileIdx))
            return this;
        for(int dirIdx = 0; dirIdx < 8; dirIdx++){
            this.allowedAdjacency[dirIdx][tileIdx] = canFace;
        }
        return this;
    }
    public Tile setCanFaceAnyDirection(int tileIdx){
        return this.setCanFaceAnyDirection(tileIdx,true);
    }
    public Tile setCanFaceAnything(boolean canFace){
        // for(int tileIdx = 0; tileIdx < Lib.TILE_COUNT; tileIdx++){
        //     this.setCanFaceAnyDirection(tileIdx, canFace);
        // }
        return this;
    }
    public Tile setCanFaceAnything(){
        return this.setCanFaceAnything(true);
    }
    public Tile setCantFaceAnything(){
        return this.setCanFaceAnything(false);
    }
    public Tile setCanOnlyFace(String[] tileNameArr, boolean canFace){
        this.setCanFaceAnything(!canFace);
        // for (String tileName : tileNameArr) {
        //     int tileIdx = Lib.getTileIndex(tileName);
        //     // only if our tileIdx is valid
        //     if (validTileIndex(tileIdx))
        //         this.setCanFaceAnyDirection(tileIdx, canFace);
        //     else
        //         System.err.println("Failed to 'setCanOnlyFace(String[])' on " + tileName);
        // }
        return this;
    }
    public Tile setCanOnlyFace(String[] tileNameArr){
        return this.setCanOnlyFace(tileNameArr, true);
    }
    public Tile setOnlyCantFace(String[] tileNameArr){
        return this.setCanOnlyFace(tileNameArr,false);
    }
    /**
     * setCanFaceAnything(false) then loop through the idx array we were
     *      given and set those to true
     * @param tileIdxArr : array of indexes we can face still
     * @return : reference to this
     */
    public Tile setCanOnlyFace(int[] tileIdxArr, boolean canFace){
        this.setCanFaceAnything(false);
        for (int idx : tileIdxArr) {
            this.setCanFaceAnyDirection(idx, canFace);
        }
        return this;
    }
    public Tile setCanOnlyFace(int[] tileIdxArr){
        return this.setCanOnlyFace(tileIdxArr, true);
    }
    public Tile setOnlyCantFace(int[] tileIdxArr){
        this.setCanFaceAnything(true);
        for(int idx: tileIdxArr){
            this.setCanFaceAnyDirection(idx, false);
        }
        return this;
    }

    /**
     * currently not needed because we just ignore invalid indices
     * @param tileIdxArr : a
     * @return : a
     */
    public Tile setOnlyCantFace(List<Integer> tileIdxArr){
        //TODO
        return this;
    }

    // TODO : currently this will brick in corners of L shapes.
    //          need to have GridBuilder ask our Tile if it likes
    //          another Tile in dirIdx from it
    public Tile setCanFaceDiagonally(int[] tileIdxArr, boolean canFace){
        for(int tileIdx : tileIdxArr){
            this.setCanFace(tileIdx, 1, canFace);
            this.setCanFace(tileIdx, 3, canFace);
            this.setCanFace(tileIdx, 5, canFace);
            this.setCanFace(tileIdx, 7, canFace);
        }
        return this;
    }

    /**
     * check if we have a valid tile index
     * @param tileIdx : tile index to check
     * @return : true if valid otherwise false
     */
    public static boolean validTileIndex(int tileIdx){
        // return (tileIdx > -1 && tileIdx < Lib.TILE_COUNT);
        return false;
    }
    // override this when you wanna change the colour of first shape
    protected Color getColor(){
        return Lib.DEFAULT_SHAPE_FILL_COLOR;
    }
    protected Tile setBasicSquareTile(){
        this.shapeList = new Shape[MAX_SHAPES];
        // // setup a basic shape for handling stuff
        // this.shapeList[0] = Shape.getBasicSquare(this.getColor());
        return this;
    }

    /**
     * this method just makes the tile a checker tile
     * @return : reference to this for builder pattern
     */
    protected Tile makeCheckerTile(Color color1, Color color2){
        // // check if we have the space in our shape list
        // if(this.shapeList.length >= 2){
        //     // setup the first shape as the color1 square
        //     this.shapeList[0] = Shape.getBasicSquare(color1);
        //     this.shapeList[1] = Shape.getCheckerOverlay(color2);
        // }
        return this;
    }

    /**
     * TODO: implement this to be used in deciding if a tile should be used
     * @param currentCount : the current count of this tile in play
     * @return : a percentage double of how likely it'll happen for rolling the dice
     */
    protected double getLikelyhood(int currentCount){
        // // since this is a stub we'll return 100.0 to say it's always likely
        // // but normally you'd say:
        // // our preferences
        // double minimChance = 1.0;
        // double preferredMaximPercent = (Grid.colCount*Grid.rowCount)/((Lib.TILE_COUNT)*1.0);

        // return getLikelyhood(
        //         minimChance,
        //         preferredMaximPercent,
        //         preferredMaximPercent, currentCount);
        return 0.0;
    }

    /**
     *
     * weighted percent chance of this tile being chosen
     * @param minim : minimum percent chance out of 100
     * @param maxim : maximum percent chance out of 100
     * @param overallPercent : target percentage of grid as this tile out of 100
     * @param currCount : current count of
     * @return : likelyhood percentage out of 0 to 100
     */
    protected double getLikelyhood(double minim, double maxim,
                                   double overallPercent, int currCount){
        // difference in chance, tends towards 0
        double diffBetweenMinMax = maxim-minim;
        // total tiles in the grid
        double gridTileCount = Grid.colCount*Grid.rowCount;
        // current percentage of this tile in the grid
        double currPercen = (currCount/gridTileCount)*100.0;
        // target count of this tile in the grid
        double targetCount = ((overallPercent/100.0)*gridTileCount);
        // the percentage of overallPercent that this tile is in the grid
        double percenOfTargetCount = (overallPercent > currPercen) ?
                currCount/targetCount*100.0 : 100.0;
        // the overall percentage of diffBetweenMinMax we want to keep
        double keepingPercentOfDiff = diffBetweenMinMax - ((percenOfTargetCount/100.0)*(diffBetweenMinMax/100.0));
        double likelyhood = minim + keepingPercentOfDiff;
        // return our weighted percentage
        return likelyhood;

    }
}

