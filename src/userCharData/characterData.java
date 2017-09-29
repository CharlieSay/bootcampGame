package userCharData;

import java.util.Random;

/**
 * Created by Charlie on 26/09/2017.
 */
public class characterData {

    // Static because they wont change.
    private static String userName;
    private static String userClass;
    private static String userGender;
    private static String[] lordList = {"The Baron","The Lord","The Knight","The Maiden","The Noble"};
    private static String lordName;

    public void characterStore(String characterName, String characterClass, String characterGender){
        userName = characterName.toUpperCase();
        userClass = characterClass.toUpperCase();
        userGender = characterGender.toUpperCase();
        int indexValue = new Random().nextInt(lordList.length);
        lordName = (lordList[indexValue].toUpperCase());
    }

    public String nameReturn(){
        return userName;
    }

    public String classReturn(){
        return userClass;
    }

    public String genderReturn(){
        return userGender;
    }

    public String lordNameReturn() { return lordName;}
}
