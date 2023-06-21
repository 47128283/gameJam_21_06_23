import java.util.Random;

public class Seedable {
  private long seedLong;
  public Random seedInstance;
  public int seedCalls;

  public Seedable(long seedLongIn){
    seedLong = seedLongIn;
    seedInstance = new Random(seedLong);
  }
}
