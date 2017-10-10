import battleSeq.battle;
import org.junit.jupiter.api.Test;
import userCharData.characterData;

import java.util.Scanner;

/**
 * Created by Charlie on 10/10/2017.
 */
public class testing {

    public Scanner scan = new Scanner(System.in);

    @Test
    public void test(){
        characterData character = new characterData();
        battle battle2 = new battle();
        character.setSwordLevel(1);
        battle2.fighterHealth = 200;
        battle2.fighterName = "Goblin";
        battle2.chance = 0.6;
        for (int i=0; i<40; i++){
            battle2.userAttack();
        }
    }
}
