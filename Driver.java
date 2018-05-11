
package cs1302.fxgame;

import com.michaelcotterell.game.Game;
import javafx.application.Application;
import javafx.stage.Stage;
/**
 * This is the driver for this application.
 * This class holds methods that start the application and allow the stage to show and the game to run. 
 * @author SAMANTHA CARLILE <sjc13678@uga.edu>
 * @author BRIAN WEBER <bw75762@uga.edu>
 */

public class Driver extends Application {

/**
 * This method creates a new game object for the user to play and sets the stage
 * no return values
 * @param primaryStage
 */
    @Override
    public void start(Stage primaryStage) throws Exception { 
        Game game = new TestGame(primaryStage);
        primaryStage.setTitle(game.getTitle());
        primaryStage.setScene(game.getScene());
        primaryStage.show();
        game.run();
    } // start
 /**
 * This this the main method with no return values. 
 * @param String [] args
 */
    public static void main(String[] args) {
        launch(args);
    } // main

} // Driver

