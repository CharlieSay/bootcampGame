import userCharData.characterData;


/**
 * Created by Charlie on 26/09/2017.
 */
public class textFormatting extends characterData {

    public static void userBanner() {
        textFormatting t = new textFormatting();
        characterData c = new characterData();
        t.equalLine();
        util.printOut("| Name - " + c.nameReturn() + " "+c.lordNameReturn() + "    | Class - " + c.classReturn() + "    | Gender - " + c.genderReturn());
        t.equalLine();
    }

    public static void clearScreen() {System.out.print("\033[H\033[2J");}
    public void equalLine(){System.out.println("==================================================");}
}



