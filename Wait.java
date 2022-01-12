import java.util.*;
public class Wait extends TimerTask {
  private int done=0;
  
  public void run(){
    done=1;
    System.out.println("Time is up, thank you. Press 1 to continue");
  }
  public int getDone(){
    return done;
  }
}
