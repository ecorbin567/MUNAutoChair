import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);

    boolean checkOn = false;

    System.out.println("Enter total time in minutes (ex. 5min45sec = 5.75)");
    double totalTime = (myScanner.nextDouble() * 60);
    System.out.println("Enter speaking time in seconds");
    int speakingTime = myScanner.nextInt();
    myScanner.nextLine();

    int numSpeakers = (int) Math.floor(totalTime / speakingTime);
    System.out.println("Enter " + numSpeakers + " country names");

    String names[] = new String[numSpeakers + 1];
    for (int j = 1; j <= numSpeakers; j++) {
      names[j] = myScanner.nextLine();
      System.out.println(j + ": " + names[j]);
    }

    // long start = System.nanoTime();
    // long end = System.nanoTime();
    // long elapsedTime = end - start;

    System.out.println("Press 1 to begin when delegates are ready.");
    int check = myScanner.nextInt();
    myScanner.nextLine();
    if (check == 1) {
      checkOn = true;
    } // if check==1
    if (checkOn == true) {
      checkOn = false;
      for (int j = 1; j <= numSpeakers; j++) {
        System.out.println("Press 1 to begin when " + names[j] + " is ready.");
        check = myScanner.nextInt();
        myScanner.nextLine();
        if (check == 1) {
          checkOn = true;
          System.out.println(names[j] + ", you have the floor for " + speakingTime + " seconds.");
          wait(1000 * speakingTime - 10);
          System.out.println(names[j] + ", you have ten seconds.");
          wait(10000);
          System.out.println("Thank you, " + names[j] + ".");
          wait(2000);
        } // if check==1
      } // for

      checkOn = false;
      System.out.println("Press 1 to add more delegates.");
      check = myScanner.nextInt();
      myScanner.nextLine();

      if (check == 1) {
        checkOn = true;
        System.out.println("Enter more country names- enter stop to stop");
        String names2[] = new String[10];
        int count = 1;
        String check1 = "test";
        for (int j = 1; j <= 10; j++) {
          names2[j] = myScanner.nextLine();
          check1 = names2[j];
          count++;
          System.out.println(j + ": " + names2[j]);
          //System.out.println(check1);
          if (check1.contains("stop")) {
            // System.out.println("breaking");
            break;
          } // if stop
        } // for
        // System.out.println("broken");
        System.out.println("Press 1 to begin when delegates are ready.");
        check = myScanner.nextInt();
        myScanner.nextLine();
        if (check == 1) {
          checkOn = true;
        } // if check==1
        if (checkOn == true) {
          checkOn = false;
          for (int j = 1; j <= count; j++) {
            System.out.println("Press 1 to begin when " + names2[j] + " is ready.");
            check = myScanner.nextInt();
            myScanner.nextLine();
            if (check == 1) {
              checkOn = true;
              System.out.println(names2[j] + ", you have the floor for " + speakingTime + " seconds.");
              wait(1000 * speakingTime - 10);
              System.out.println(names2[j] + ", you have ten seconds.");
              wait(10000);
              System.out.println("Thank you, " + names2[j] + ".");
              wait(2000);
            } // if check==1
          } // for
        } // if checkOn==true
      } // if check==1
    } // if checkOn==true
  }// public static void main

  public static void wait(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }

}// class Main
