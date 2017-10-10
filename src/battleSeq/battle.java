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
    public int fighterHealth;
    public String fighterName;
    public double chance = 0;
    public int missCounter = 0;
    public characterData character = new characterData();


    public static void battle(String fighterName, int fighterHealthPassed, Scanner scan){
        battle b = new battle();
        b.battleSetUp(fighterName,fighterHealthPassed,scan);
    }

    public void battleSetUp(String fighterNamePassed, int fighterHealthPassed, Scanner scan){
        this.fighterHealth=fighterHealthPassed;
        this.fighterName = fighterNamePassed;
        if (character.swordLevelReturn() == 1) {
            chance = 0.8;
        }else if (character.swordLevelReturn() == 2){
            chance = 0.6;
        }else if (character.swordLevelReturn() == 3){
            chance = 0.4;
        }else if (character.swordLevelReturn() == 4){
            chance = 0.2;
        }else if (character.swordLevelReturn() == 5){
            chance = 0.001;
        }else{
            System.out.println("Something went wrong, and by magic your sword is super magic.");
            chance = 0.001;
            character.setSwordLevel(5);
        }
        util.printOut("BATTLE COMMENCE");
        battleBanner();
        userHealth = 100;
        util.printOut("As you are " + character.lordandNameReturn() +" you get to go first.");
        battleMechanism(scan);
    }

    public void battleMechanism(Scanner scan){
        util.printOut("Do you want to : \nHit, Run or Heal?");
        //String hrhInput = scan.nextLine().toLowerCase();
        String hrhInput = "hit";
        if (hrhInput.contains("hit")){
            userAttack();
        }else if (hrhInput.contains("run")){
            util.printOut("You ran sucessfully");
        }else if (hrhInput.contains("heal")){
            util.printOut("You healed");
        }else{
            util.printOut("You do NOTHING! - turn over.");
        }
    }

    public boolean doesHit() {
        double d = Math.random();
        if (missCounter == 2){
            util.printOut("you missed alot, so you swung in agony and hit.");
            missCounter=0;
            return true;
        }else if (chance == d){
            //Equal
            return true;
        }else if (chance < d){
            //Hit
            return true;
        }else if (chance > d){
            //Miss
            missCounter++;
            return false;
        }else{
            util.printOut("Something went wrong");
            doesHit();
        }
        missCounter++;
        return false;
    }

    public void userAttack(){
        int hitPower = character.swordLevelReturn()*10;
        if (doesHit()==true){
           if (hitPower < fighterHealth){
                util.printOut("YOU HIT "+fighterName);
               fighterHealth -= hitPower;
                util.printOut("They have" + fighterHealth + " left");
            }else if (hitPower > fighterHealth){
               util.printOut(fighterName + " fainted \n You win this BATTLE!");
           }
        }else{
            util.printOut("You missed!");
        }
    }

    private void fighterAttack(){

    }



    private void battleBanner(){
        textFormatting t = new textFormatting();
        characterData c = new characterData();
        t.equalLine();
        util.printOut("| Name - " + c.nameReturn() + " "+c.lordNameReturn() + "    | HEALTH - " + userHealth);
        util.printOut("| Enemy - " + fighterName + " |  HEALTH - " + fighterHealth);
        t.equalLine();
    }

}
