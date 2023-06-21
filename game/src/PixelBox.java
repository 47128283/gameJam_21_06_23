import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @brief used for a drawn pixel space as a rectangle like box
 */
public class PixelBox extends Rectangle{
  int pixelCountX,pixelCountY;
  Color[][] pixels;

  private static Color outlineColor = new Color(0.0f,0.0f,0.0f);
  // private static Color hoverOverlayColor = new Color(0.8f,0.8f,1.0f,0.3f); // for later

  public PixelBox(Color[][] pixels, int x, int y, int w, int h){
    // use parent construction
    super(x, y, w, h);
    // copy the pixels instance
    this.pixels = pixels;
  }
  public PixelBox(char[][] pixelChars, int x, int y, int w, int h){
    // use parent construction
    super(x, y, w, h);
    
    // handles the length of the arrays and defaults to 3
    pixelCountX = (pixelChars!=null)? pixelChars.length : 3;
    pixelCountY = (pixelChars.length > 0 && pixelChars[0]!=null)? pixelChars[0].length : 3;

    // copy the pixels instance
    this.pixels = new Color[pixelCountX][pixelCountY];

    // loop all pixels and convert from char to color
    for(int i = 0; i < pixelChars.length; i++){
      for(int k = 0; k < pixelChars[i].length; k++){
        pixels[i][k] = charToColor(pixelChars[i][k]);
      }
    }
  }
  
  /**
   * paint the pixel box
   * @param g
   */
  public void paint(Graphics g){
    // stash whatever the color is
    Color prevColor = g.getColor();
    
    // get the pixel sizing
    float pxWidth = width*1.0f/pixelCountX;
    float pxHeight = height*1.0f/pixelCountY;
    // loop for all of them and draw the thing
    for(int x = 0; x < pixelCountX; x++){
      for(int y = 0; y < pixelCountY; y++){
        // set the colour
        g.setColor(pixels[x][y]);
        // draw it
        g.fillRect(
            (int)(this.x+(x*pxWidth)), (int)(this.y+(y*pxHeight)),
            (int)(pxWidth), (int)(pxHeight)
          );
      }
    }
    // draw outline
    g.setColor(outlineColor);
    g.drawRect(this.x, this.y, this.width, this.height);
    // // overlay fill color
    // g.setColor(hoverOverlayColor);
    // g.fillRect(this.x, this.y, this.width, this.height);

    // change it back
    g.setColor(prevColor);
  }


  public static Color charToColor(char inputChar){
    switch(inputChar){
      default:
      case '\0':
        return new Color(0.0f,0.0f,0.0f);
      case '0':
        return new Color(0.3f,0.3f,0.3f);
      case '1':
        return new Color(0.5f,0.5f,0.5f);
      case '2':
        return new Color(0.8f,0.8f,0.8f);
      case '3':
        return new Color(1.0f,1.0f,1.0f);
    }
  }
}
