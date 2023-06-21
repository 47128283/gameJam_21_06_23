import java.util.Random;

public class Seedable {
  private long seedLong;
  public Random seedInstance;
  public int seedCalls = 0;

  /**
   * default constructor
   */
  public Seedable(){
    seedInstance = new Random();
    seedLong = seedInstance.nextLong();
    seedInstance = new Random(seedLong);
  }
  /**
   * constructor with seed
   */
  public Seedable(long seedLongIn){
    seedLong = seedLongIn;
    seedInstance = new Random(seedLong);
  }
  /**
   * constructor with seed and usage count
   */
  public Seedable(long seedLongIn, int seedCalls){
    seedLong = seedLongIn;
    seedInstance = new Random(seedLong);
    // had calls at all
    if(seedCalls > 0){
      // just roll as many times as we need for it to be correct
      for(int i = 0; i < seedCalls; i++){
        rollInt();
      }
    }
  }

  public int rollInt(){
    seedCalls++;
    return seedInstance.nextInt();
  }
  public int rollInt(int bound){
    seedCalls++;
    return seedInstance.nextInt(bound);
  }
  public long rollLong(){
    seedCalls++;
    return seedInstance.nextLong();
  }
  public long rollLong(long bound){
    seedCalls++;
    return seedInstance.nextLong(bound);
  }

  
}
