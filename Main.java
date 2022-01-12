import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);
    boolean checkOn = false;
    Timer timer = new Timer();

    System.out.println("Enter total time in minutes (ex. 5min45sec = 5.75)");
    double totalTime = (myScanner.nextDouble() * 60);
    System.out.println("Enter speaking time in seconds");
    int speakingTime = myScanner.nextInt();
    myScanner.nextLine();

    int numSpeakers = (int) Math.floor(totalTime / speakingTime);
    System.out.println("Enter " + numSpeakers + " country names, enter stop to stop");

    String names[] = new String[numSpeakers + 1];
    int count = 1;
    String check1 = "test";
    for (int j = 1; j <= numSpeakers; j++) {
      check1 = myScanner.nextLine();
      if (check1.contains("stop")) {
        break;
      } // if stop
      else {
        names[j] = check1;
        count++;
        System.out.println(j + ": " + names[j]);
      }
    } // for

    System.out.println("Press 1 to begin when delegates are ready.");
    int check = myScanner.nextInt();
    myScanner.nextLine();
    if (check == 1) {
      checkOn = true;
    } // if check==1
    if (checkOn == true) {
      checkOn = false;
      for (int j = 1; j <= numSpeakers; j++) {
        if (names[j]==null) {
          break;
        }
        System.out.println("Press 1 to begin when " + names[j] + " is ready.");
        check = myScanner.nextInt();
        myScanner.nextLine();
        if (check == 1) {
          checkOn = true;
          int check2 = 0;
          System.out.println(names[j] + ", you have the floor for " + speakingTime + " seconds. Press 1 to yield.");
          
          Warning task2= new Warning();
          timer.schedule(task2, (speakingTime-10)*1000);
          
          Wait task = new Wait();
          timer.schedule(task, speakingTime * 1000);

          check2 = myScanner.nextInt();
          myScanner.nextLine();
          if (check2 == 1) {
            task.cancel();
            task2.cancel();
            check2 = 0;
          }
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
        count = 1;
        check1 = "test";
        for (int j = 1; j <= 10; j++) {
          check1 = myScanner.nextLine();
          if (check1.contains("stop")) {
            break;
          } // if stop
          else {
            names2[j] = check1;
            count++;
            System.out.println(j + ": " + names2[j]);
          }
        } // for

        System.out.println("Press 1 to begin when delegates are ready.");
        check = myScanner.nextInt();
        myScanner.nextLine();
        if (check == 1) {
          checkOn = true;
        } // if check==1
        if (checkOn == true) {
          checkOn = false;
          for (int j = 1; j <= count; j++) {
            if (names2[j]==null) {
              break;
            }
            System.out.println("Press 1 to begin when " + names2[j] + " is ready.");
            check = myScanner.nextInt();
            myScanner.nextLine();
            if (check == 1) {
              checkOn = true;
              int check2 = 0;
              System.out.println(names2[j] + ", you have the floor for " + speakingTime + " seconds. Press 1 to yield.");

              Warning task2= new Warning();
              timer.schedule(task2, (speakingTime-10)*1000);

              Wait task = new Wait();
              timer.schedule(task, speakingTime * 1000);

              check2 = myScanner.nextInt();
              myScanner.nextLine();
              if (check2 == 1) {
                task.cancel();
                task2.cancel();
                check2 = 0;
              }
            } // if check==1
          } // for
        } // if checkOn==true
      } // if check==1
    } // if checkOn==true
  }// psv main

}// class Main
