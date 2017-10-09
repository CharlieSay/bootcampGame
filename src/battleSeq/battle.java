package battleSeq;

import userCharData.characterData;
import utilities.textFormatting;
import utilities.util;

import java.util.Scanner;

/**
 * Created by Charlie on 29/09/2017.
 */
public class battle {

    private int userHealth;
    private int fighterHealth;
    private int chance = 0;
    public characterData character = new characterData();


    public static void battle(String fighterName, int fighterHealthPassed, Scanner scan){
        battle b = new battle();
        b.battleSetUp(fighterName,fighterHealthPassed,scan);
    }

    public void battleSetUp(String fighterName, int fighterHealthPassed, Scanner scan){
        if (character.swordLevelReturn() == 1) {
            chance = 20;
        }else if (character.swordLevelReturn() == 2){
            chance = 40;
        }else if (character.swordLevelReturn() == 3){
            chance = 60;
        }else if (character.swordLevelReturn() == 4){
            chance = 80;
        }else if (character.swordLevelReturn() == 5){
            chance = 100;
        }else{
            System.out.println("Something went wrong, and by magic your sword is super magic.");
            chance = 100;
            character.setSwordLevel(5);
        }
        util.printOut("BATTLE COMMENCE");
        userHealth = 100;
        fighterHealth = 20;
        battleBanner(fighterName);
        userHealth = 100;
        util.printOut("As you are " + character.lordandNameReturn() +" you get to go first.");
        battleMechanism("Goblin",scan);
    }

    public void battleMechanism(String fightername, Scanner scan){
        util.printOut("Do you want to \nHit, Run or Heal?");
        String hrhInput = scan.nextLine().toLowerCase();
        if (hrhInput.contains("hit")){
            util.printOut("You Hit " + fightername);
            userAttack(fightername);
        }else if (hrhInput.contains("run")){
            util.printOut("You ran sucessfully");
        }else if (hrhInput.contains("heal")){
            util.printOut("You healed");
        }else{
            util.printOut("You do NOTHING! - turn over.");
        }
    }

    public boolean doesHit(){
        return true;
    }

    private void userAttack(String fightername){
        int hitPower = character.swordLevelReturn()*10;
        if (hitPower > fighterHealth){
            System.out.println(fightername);
        }else
    }

    private void fighterAttack(){

    }



    private void battleBanner(String fighterName){
        textFormatting t = new textFormatting();
        characterData c = new characterData();
        t.equalLine();
        util.printOut("| Name - " + c.nameReturn() + " "+c.lordNameReturn() + "    | HEALTH - " + userHealth);
        util.printOut("| Enemy - " + fighterName + " |  HEALTH - " + fighterHealth);
        t.equalLine();
    }

}
