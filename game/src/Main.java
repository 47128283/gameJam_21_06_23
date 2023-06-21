import java.awt.Dimension;
import java.awt.Graphics;
import java.time.Duration;
import java.time.Instant;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @brief game object class and starting point of the program
 */
class Main extends JFrame{
  /**
   * @brief nested class for our actual app that's then attached to the 'Main'
   *        object to be our working thingy
   */
  class App extends JPanel {
    // stage instance reference
    Stage stage;

    /**
     * @brief construct App instance by dimensions
     */
    public App(int widthIn,int heightIn){
      setPreferredSize(new Dimension(widthIn,heightIn));
      // make new stage by random untracked long
      stage = new Stage(CorbLib.getUntrackedRandomLong());
    }

    @Override
    public void paint(Graphics g){
      // handoff to stage for painting
      stage.paint(g);
    }
  }

  /**
   * @brief main landing point for the program
   * @param args
   */
  public static void main(String[] args){
    // prepare corblib stuffs
    CorbLib.corblibmain(args);

    // setup and run window
    Main window = new Main(600,400);
    window.run();
  }

  /**
   * @brief privated constructor the application instance
   */
  private Main(int widthIn, int heightIn){
    // closing program behaviour
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // create instance of our app
    App app = new App(widthIn,heightIn);
    // put it in the JFrame
    this.setContentPane(app);
    // arrangement of components in the JFrame
    this.pack();
    // make it seeable
    this.setVisible(true);
  }

  /**
   * @brief game run loop
   */
  public void run() {
    // run till we fail
    while (true) {
      // peep time
      Instant startTime = Instant.now();
      // do a painting
      this.repaint();
      // re-peep time
      Instant endTime = Instant.now();
      // check dif of peeps
      long howLong = Duration.between(startTime, endTime).toMillis();
      // try snooze for the rest of the period before the "next" start should
      //  happen
      try {
        Thread.sleep(20L - howLong);
      } catch (InterruptedException e) {
        System.out.println("thread was interrupted, but who cares?");
      } catch (IllegalArgumentException e) {
        System.out.println("application can't keep up with framerate");
      }
    }
}
}