import gameStates.firstGameState;

/**
 * Created by Charlie on 26/09/2017.
 */
public class bootcampGame {

    public static int GameStateLevel = 1;
    public static void main(String[] args) {
        gameState();
    }

    public static void gameState() {
        if (GameStateLevel == 1){
            firstGameState firstGameState = new firstGameState();
            firstGameState.gsFirstCharCreation();
        }else if (GameStateLevel == 2){

        }else if (GameStateLevel == 3){

        }else if (GameStateLevel == 4){

        }else {
            System.out.println("Game Error, Restarting....");
            gameState();
        }

    }

}
