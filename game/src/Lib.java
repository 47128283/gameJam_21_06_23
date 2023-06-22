import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Random;

public class Lib {

  /* ======================================================================== */
  /* --------------------------- lib stubs ---------------------------------- */
  /* ======================================================================== */

  /**
   * @brief called by the Main.main(String[]) and just handles some on run stuffs
   * @param args
   */
  public static void libmain(String[] args){
    loadCourFont();

    setupUntrackedRandomisation();

    
  }

  /* ======================================================================== */
  /* ------------------------------------------------------------------------ */
  /* ======================================================================== */


  /* ======================================================================== */
  /* ------------------------------ Tile stuffs ----------------------------- */
  /* ======================================================================== */

  public static char getDefault_MapCellType() {
    return ROOM_PLUS;
  }
  public static char getDefault_tileByRoomType(char type) {
    //return getDefault_MapCellType();
    return 'E';
  }
  

  /* ======================================================================== */
  /* ------------------------------------------------------------------------ */
  /* ======================================================================== */

  /* ======================================================================== */
  /* --------------------------- type handling ------------------------------ */
  /* ======================================================================== */

  // TODO: add in type handle function
  // TODO: draw by string


  /**
   * @brief draw box to the frame with a color and no outline
   * @param g graphics object
   * @param x pos
   * @param y pos
   * @param w x dim
   * @param h y dim
   * @param c color fill
   */
  public static void drawBox(Graphics g, int x, int y, int w, int h, Color c){
    // check the grpahics object
    if(g==null) return;
    // handle null color
    Color usingColor= (c!=null)? c : Lib.getColorByType('\0');
    // check fully transparent and dont bother
    if(usingColor.getAlpha()==0.0f) return;
    // set color handling null
    g.setColor( usingColor );
    g.fillRect(x, y, w, h);
  }

  /**
   * @brief interfacer for rectangle object drawing a pixel
   * @param g
   * @param drawSpace
   * @param c the color
   */
  public static void drawBoxRect(Graphics g, Rectangle drawSpace, Color c){
    Lib.drawBox(g, drawSpace.x,drawSpace.y,drawSpace.width,drawSpace.height, c);
  }

  /**
   * @brief interfacer for rectangle object drawing a pixel
   * @param g
   * @param drawSpace
   */
  public static void drawDefaultRectangle(Graphics g, Rectangle drawSpace){
    Lib.drawBox(g, drawSpace.x,drawSpace.y,drawSpace.width,drawSpace.height, null);
  }


  /**
   * @brief draw pixels liek the pixel  box used to do
   * @param g the graphics object to draw with
   * @param pixelTypeArr the char array containing the pixel color typings
   * @param drawSpace the space to draw in
   */
  public static void drawPixels( Graphics g, char[][] pixelTypeArr, Rectangle drawSpace ){
    // return no graphics object
    if(g== null) { System.err.println("null graphics object given to drawPixels"); return; }
    // handle null char arr
    if(pixelTypeArr==null) { System.err.println("null pixel type arr given to drawPixels"); return; }
    // handle empty array
    if(pixelTypeArr.length==0 || pixelTypeArr[0].length==0) {
      System.out.println("empty pixels array given to drawPixels");
      Lib.drawDefaultRectangle(g,drawSpace);
      return;
    }
    // handle null drawspace
    if(drawSpace==null) { System.err.println("null drawspace given to drawPixels"); return; }

    // setup cols and rows
    int cols = pixelTypeArr.length, rows = pixelTypeArr[0].length;
    // size of a pixel
    float pxWidth = 1.0f*drawSpace.width/cols, pxHeight = 1.0f*drawSpace.height/rows;
    // for all pixels
    for( int x = 0; x < cols; x++ ){
      for( int y = 0; y < rows; y++ ){
        // do the pixel
        drawBox(
          g, // graphiic obj
          (int)(drawSpace.x + x*pxWidth), (int)(drawSpace.y + y*pxHeight), // pos
          (int)(pxWidth), (int)(pxHeight), // size
          Lib.getColorByType(pixelTypeArr[x][y]) // get color
          );
      }
    }
  }

  /**
   * @brief draw by a given tile/cell/room/shape string
   * @param g the graphics object to draw with
   * @param shapeStringIn the shape string to draw
   * @param drawSpace the space to draw in
   */
  public static void drawPixels( Graphics g, String shapeStringIn, Rectangle drawSpace ){
    drawPixels( g, stringToPixelTypeArray(shapeStringIn), drawSpace );
  }

  /**
   * @brief fetch the color for a given type char
   * @param typeIn the type char
   * @return the color instance
   * @return fully transparent color if '\0' / null byte char
   */
  public static Color getColorByType(char typeIn){
    switch(typeIn){
      // ------------------------------------------
      // empty / transparent
      default:
      case '\0':
        return new Color(0.0f,0.0f,0.0f,0.0f);
      // ------------------------------------------
      // black?
      case '#':
      // black
      case '0':
        return new Color(0.0f,0.0f,0.0f);
      // ------------------------------------------
      // grey
      case '1':
        return new Color(0.5f,0.5f,0.5f);
      // ------------------------------------------
      // lightish grey
      case '2':
        return new Color(0.8f,0.8f,0.8f);
      // ------------------------------------------
      // white
      case '3':
        return new Color(1.0f,1.0f,1.0f);
      // ------------------------------------------
    }
  }

  /**
   * @brief convert a shape to a char array of the type characterss
   * @param shapeIn the shape string to use
   * @return return it in a character array with dimensiioins by getSizeByStringLength
   * @warning may return null if given a null string or empty string
   */
  public static char[][] stringToPixelTypeArray(String shapeIn){
    // shortcut bad strings
    if(shapeIn==null||shapeIn.isEmpty()) return null;
    // get the size
    int size = Lib.getSizeByStringLength( shapeIn.length() );
    // declare and init the px arr
    char[][] pxArr = new char[size][size];
    
    // pos in the string
    int charIdx = 0;
    // loop for every character
    for(int x = 0; x < size; x++){
      for(int y = 0; y < size; y++,charIdx++){
        // copy the char from the string
        pxArr[x][y] = shapeIn.charAt(charIdx);
      }
    }
    // now return the char arrays
    return pxArr;
  }

  /**
   * @brief will just spit out the 
   * @param shapeStringLengthIn
   * @return
   */
  public static int getSizeByStringLength( int shapeStringLengthIn ){
    // empty is empty
    if(shapeStringLengthIn==0)return 0;
    // powers array
    int[] powers = {1,4,9,16,25,36,49,64};
    // handle too big
    if(shapeStringLengthIn > powers[powers.length-1]) return powers[powers.length-1];
    // loop and find one
    //  loops till we find and return i'th
    //  or are too big and returns last
    for(int i = 0; i < powers.length; i++){
      // handle if foudn
      if( shapeStringLengthIn == powers[i] ) return powers[i];
      // safe to return prev bc we have a thing that handle if it's larger than the last one
      if( shapeStringLengthIn < powers[i] ) return powers[i-1];
    }
    //otherwise just return 1 bc we should've already found
    //  very spooky to get here
    System.err.println("somehow didnt find a correct size bracket for Lib.getSizeByStringLength(int), V E R Y  S P O O K Y");
    return 1;
  }

  /* ======================================================================== */
  /* ------------------------------------------------------------------------ */
  /* ======================================================================== */

  /* ======================================================================== */
  /* --------------------- room typign stirngs ------------------------------ */
  /* ======================================================================== */

  /**
   * @brief makes sbasiede on the size given of the char tiile type
   * @param tileTypeIn tile type char
   * @param stringLength the striing were'er using
   * @return the rooms tirng
   */
  public static String fillRoomStringWithTile(char tileTypeIn,int stringLength){
    // base
    String returnableString = "";
    // loop for the ssize of the string and add
    for(int i = 0; i < stringLength; i++) returnableString = returnableString + tileTypeIn;
    // done
    return returnableString;
  }


  
  /**
   * @brief tile char constants
   */

  public static final char TILE_DEAD     = '\0';
  public static final char TILE_BOUNDARY = '#';
  public static final char TILE_WALKABLE = '.';
  public static final char TILE_SPECIAL  = '*';
  public static final char TILE_ERROR  = 'E';

  /**
   * @brief room char constants
   */

  public static final char ROOM_EMPTY    = '0';
  public static final char ROOM_L        = '1';
  public static final char ROOM_L_REV    = '2';
  public static final char ROOM_L_INV    = '3';
  public static final char ROOM_L_INVREV = '4';
  public static final char ROOM_T        = '5';
  public static final char ROOM_T_INV    = '6';
  public static final char ROOM_T_LEFT   = '7';
  public static final char ROOM_T_RIGHT  = '8';
  public static final char ROOM_BAR_H    = '9';
  public static final char ROOM_BAR_V    = 'a';
  public static final char ROOM_PLUS     = 'b';

  /**
   * @brief make a rooms string
   * @param roomTypeIdx
   * @return
   */
  public static String getRoomStringByType(char roomTypeIdx){
    switch (roomTypeIdx) {
      // ------------------------------------------
      default:
      case '\0': return "\0";
      // ------------------------------------------
      case ROOM_EMPTY:
      return
        "###"+
        "###"+
        "###";
      // ------------------------------------------
      case ROOM_L:
      return
        "*##"+
        "*##"+
        "***";
      case ROOM_L_REV:
      return
        "##*"+
        "##*"+
        "***";
      case ROOM_L_INV:
      return
        "***"+
        "*##"+
        "*##";
      case ROOM_L_INVREV:
      return
        "***"+
        "##*"+
        "##*";
      // ------------------------------------------
      case ROOM_T:
      return
        "***"+
        "#*#"+
        "#*#";
      case ROOM_T_INV:
      return
        "#*#"+
        "#*#"+
        "***";
      // ------------------------------------------
      case ROOM_BAR_H:
      return
        "###"+
        "***"+
        "###";
      case ROOM_BAR_V:
      return
        "#*#"+
        "#*#"+
        "#*#";
      // ------------------------------------------
      case ROOM_PLUS:
      return
        "#*#"+
        "***"+
        "#*#";
      // ------------------------------------------
      // case '': return "\0";
      // ------------------------------------------
    }
  }

  /* ======================================================================== */
  /* ------------------------------------------------------------------------ */
  /* ======================================================================== */


  /* ======================================================================== */
  /* ----------------- untracked randomisation ------------------------------ */
  /* ======================================================================== */
  /** 
   * @brief used for generating the untracked seed/rng/random generations
   * @warning dont use this for anything you want to reproduce later,
   *            this is spookie
   */
  private static Random untrackedRandomSeed;
  /**
   * @brief purely for generation of random numbers that arent needing to be predetermined values at all
   *        as they will be untracked and purely random
   */
  private static void setupUntrackedRandomisation() {
    // generate it by the time
    untrackedRandomSeed = new Random(getSeedLong());
  }
  /**
   * @brief produces a 'long' that can be used to seed a rng seed
   * @return 'long' generated by current epoch seconds long seed
   */
  private static long getSeedLong() {
    // make a random roller based off epoch time
    Random rand = new Random(Instant.now().getEpochSecond());
    // return the next rolled random long
    return rand.nextLong();
  }
  public static long getUntrackedRandomLong(){
    return untrackedRandomSeed.nextLong();
  }
  public static long getUntrackedRandomLong(long bound){
    return untrackedRandomSeed.nextLong(bound);
  }
  public static int getUntrackedRandomInt(){
    return untrackedRandomSeed.nextInt();
  }
  public static int getUntrackedRandomInt(int bound){
    return untrackedRandomSeed.nextInt(bound);
  }
  
  /* ======================================================================== */
  /* ------------------------------------------------------------------------ */
  /* ======================================================================== */


  /* ======================================================================== */
  /* ----------------------- font stuffs ------------------------------------ */
  /* ======================================================================== */
  /**
   * @brief tries to load in our courier font
   */
  public static void loadCourFont(){
    try{
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      File cour = new File("./game/data/cour.ttf");
      ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, cour));
    } catch(IOException e){
      System.err.println("cant load cour.ttf properly in path './game/data/cour.ttf'");
    } catch(Exception e){
      System.err.println("large scoped exception catcher for Lib.loadCourFont()" );
    }
  }
  /* ======================================================================== */
  /* ------------------------------------------------------------------------ */
  /* ======================================================================== */

  public static Color getTileColor(char drawnType) {
    return null;
  }

  public static Color getOverlayColor() {
    return new Color(0x1d/255.0f,0x29/255.0f,0x51/255.0f,0.25f);
  }













}
