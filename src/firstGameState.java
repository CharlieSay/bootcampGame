import userCharData.characterData;

import java.util.Scanner;

/**
 * Created by Charlie on 28/09/2017.
 */
public class firstGameState {

    private boolean tooktheMick = false;

    public void gsFirstCharCreation(){
        // Hello Traveller, What should I call you? (Insert Name)
        // What a noble name! What is your class (Mage/Warrior/Dwarf/Hobbit)
        // Amazing, what is your gender.
        // Randomly choose Lord Name
        // Well, lets start our adventure.
        // You wake up in your house, in bed.
        // Wait for matching of "Get out of bed" // You turn in your bed // You go back to sleep.
        // You get out of bed.
        util util = new util();
        util.printOut("Hello Traveller, what should I call you? ");
        Scanner nameScanner = new Scanner(System.in);
        String userName = nameScanner.nextLine();
        util.printOut(userName + " What a name! \nWhat is your class? ");
        String userClass = nameScanner.nextLine();
        util.printOut(userClass + " Thats our favourite class. \nNow remind me of your gender? ");
        String userGender = nameScanner.nextLine();
        characterData c = new characterData();
        c.characterStore(userName,userClass,userGender);
        textFormatting.clearScreen();
        textFormatting.userBanner();
        util.printOut("Lets start our A D V E N T U R E");
        //Calling next stage in the First Gamestate.
        gsFirstGetOutOfBed();

    }

    private void gsFirstGetOutOfBed(){

        //Actual Game State
        //Getting userBanner() Method from textFormatting.java
        textFormatting.userBanner();
        //JEW SCANNER
        Scanner nameScanner = new Scanner(System.in);
        util.printOut("You wake up in your house, in your bed.");
        //If the player has taken the mick, and put it in a few wrong times as shon on line 66, it'll take the piss back.
        int numberofTimesWrong = 0;
        //UNtil they get out of the bed and move on, it'll keep repeating this bit.
        while (true) {
            //Choice for the user to do, to see what it manages.
            String choice = nameScanner.nextLine();
            if (choice.contentEquals("get out") || (choice.contentEquals("get up"))) {
                util.printOut("You get up out of bed.");
                //Goes to second game state in this class which is gsFirstMoveAroundRoom,
                //Then passes the scanner to it so it doesnt make a new instance.
                gsFirstMoveAroundRoom(nameScanner);
            } else if (choice.contentEquals("turn over")) {
                util.printOut("You turn over in your bed.");
                util.printOut("Wow you're tired better go back to sle-");
                //Restarts method cause they're an idiot
                gsFirstGetOutOfBed();
                break;
            } else if ((choice.contentEquals("go back to sleep")) || (choice.contentEquals("sleep"))) {
                util.printOut("Wow you're tired better go back to sle-");
                //Restarts method cause they're an idiot
                gsFirstGetOutOfBed();
                break;
            } else {
                numberofTimesWrong++;
                //Taking the mick thing.
                if (numberofTimesWrong >= 5){
                    tooktheMick = true;
                util.printOut("Seriously?\n You're in bed, what else can you do?\n Other than get out of bed or go back to sleep.");
                }else if(numberofTimesWrong >= 10){
                    util.printOut("Are you okay? GET OUT OF THE BED OR GO BACK TO SLEEP.");
                }else if(numberofTimesWrong >= 15){
                    util.printOut("No, there is something wrong. Were gonna go head and stop the game.");
                    System.exit(1);
                }
            }
        }
    }

    private void gsFirstMoveAroundRoom(Scanner scan) {
        //There is a door, a chest, a stove and a bed (I wouldn't recommend going back to sleep NAME)
        util.printOut("There is a door, a chest, a stove, and a bed. \nHowever I wouldnt recommend going to bed, because you just got out.");
        while (true) {
            String choice = scan.nextLine();
        }
    }

    private void gsExitRoom(Scanner scan) {
        if (tooktheMick == false) {

        } else if (tooktheMick == true) {

        } else {
            util.printOut("Something went wrong. \nRestarting.");
            System.exit(1);
        }
    }

}

