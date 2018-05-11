package cs1302.fxgame;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Region;
import javafx.geometry.Bounds;
import javafx.scene.text.Font;
import javafx.scene.Node;
import java.awt.Component;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * This is the testgame for this application.
 * This class holds methods that allow the user to interact with the GUI in order to play a game of Brick Breaker.
 * @author SAMANTHA CARLILE <sjc13678@uga.edu>
 * @author BRIAN WEBER <bw75762@uga.edu>
 */

public class TestGame extends Game {

    //variables
    int level = 1;
    int bxcord = 315;
    int bycord = 420;
    int bsize = 10;
    int padelX = 270;
    int padelY = 440; 
    int padelWidth = 100;
    int padelHeight = 10;
    int xMove = -2;
    int yMove = -2;
    boolean playing = false;
    boolean bricksOpen = false;
    int count = 0;
    Bounds [] positions = new Bounds [36];
    Rectangle [] bricks = new Rectangle[36];
    int [] hits = new int [36];
    int row = 80;
    int col = 80;
    int numOfBricks = 0;
    
    // rectangle to hold the background
    private Rectangle bg = new Rectangle(0, 0, 640, 480) {{ 
         setFill(Color.BLACK); 
    }};

    // rectangle padel
    private Rectangle rt = new Rectangle(100, 10) {{
         setTranslateX(270);
         setTranslateY(440);
         setFill(Color.WHITE);
    }};
    
    // rectangle ball
    private Rectangle ball = new Rectangle(10, 10) {{
         setTranslateX(315);
         setTranslateY(420);
         setFill(Color.WHITE);
    }};
    
    // score
    public int scoreValue = 0;
    private Text score = new Text() {{
         setTranslateX(540);
         setTranslateY(40);
         setFill(Color.WHITE);
    }};
    
    // lifes
    public int numberLives = 3;
    private Text lives = new Text() {{
         setTranslateX(20);
         setTranslateY(40);
         setFill(Color.WHITE);
    }};
    
    // welcome
    private Text welcome = new Text() {{
        setFont(new Font(30));
        setTranslateX(60);
        setTranslateY(320);
        setFill(Color.WHITE);
        setText("Press the space bar twice to play");
    }};
    
    //welcome 2
    private Text welcome2 = new Text() {{
        setFont(new Font(30));
        setTranslateX(60);
        setTranslateY(380);
        setFill(Color.WHITE);
        setText("Press R & L arrow to move paddle" );
    }};
    
    //restart question
    private Button restart = new Button() {{
        setFont(new Font(35));
        setTranslateX(60);
        setTranslateY(360);
        setStyle("-fx-text-fill: black;");
    }};
    
    //winner text
    private Text winner = new Text() {{
        setFont(new Font(30));
        setTranslateX(60);
        setTranslateY(380);
        setFill(Color.WHITE);
    }}; 
    

    /**
     * Constructs a new test game.
     * This method does not have a return value.
     * This method builds the GUI through calling other methods and setting the stage by adding nodes to it. 
     * @param stage the primary stage
     */
    
    public TestGame(Stage stage) {
        super(stage, "Breaker", 60, 640, 480); //call to super
        getSceneNodes().getChildren().addAll(bg, rt, ball, score, lives, welcome,welcome2);
        for (int i = 0; i < hits.length; i++) { //intialization
          hits[i] = 0;
        }
        level();
    }//TestGame 
/**
 * This method does not accept any parameters or return any.
 * This method determines what level the user is one and adds the bricks accordingly to the array that is added to the stage.
 * It also initailizes the position array that will be used to determine if the user hit a brick or the paddle. 
 */ 
    public void level(){
      if(level == 1){ //level one
          level = 1;
          numOfBricks = 24;
          numberLives = 3;
          xMove = -2;
          yMove = -2;
          rt.setTranslateX(270);
          rt.setTranslateY(440);
          ball.setTranslateX(315);
          ball.setTranslateY(420);
          for (int i = 0; i < hits.length; i++) {
              hits[i] = 0;
          }
          for (int i = 0; i < 24; i++) {
              bricks[i] = new Rectangle(row, col, 80, 30);
              if (i == 5) {              
               row = -2;
               col = 112;
  
              }
              if(i == 11){
                row = -2;
                col = 144;  
                            
              }
              if(i == 17){
                row = -2;
                col = 176; 
                             
              }
              if(i == 23){
                row = -2;
                col = 208;            
              }
              row += 82;
              bricks[i].setFill(Color.TEAL);
              positions[i] = bricks[i].getBoundsInParent(); 
              getSceneNodes().getChildren().addAll(bricks[i]);
              }//for loop
        }//level 1
        if(level == 2){ //level two 
          level = 2;
          numOfBricks = 30;
          xMove = -4;
          yMove = -4;
          rt.setTranslateX(270);
          rt.setTranslateY(440);
          ball.setTranslateX(315);
          ball.setTranslateY(420);
          numberLives = 4;
          for (int i = 0; i < hits.length; i++) {
            hits[i] = 0;
          }
          for (int i = 0; i < 30; i++) {
              bricks[i] = new Rectangle(row, col, 80, 30);
              if (i == 5) {              
               row = -2;
               col = 112;
  
              }
              if(i == 11){
                row = -2;
                col = 144;  
                            
              }
              if(i == 17){
                row = -2;
                col = 176; 
                             
              }
              if(i == 23){
                row = -2;
                col = 208;            
              }
              if(i == 29){
                row = -2;
                col = 240;
              
              }
              row += 82;
              bricks[i].setFill(Color.TEAL);
              positions[i] = bricks[i].getBoundsInParent(); 
              getSceneNodes().getChildren().addAll(bricks[i]);
              }//for loop
        }//level 2
       if(level == 3){ //level three
          level = 3;
          numOfBricks = 36;
          xMove = -6;
          yMove = -6;
          rt.setTranslateX(270);
          rt.setTranslateY(440);
          ball.setTranslateX(315);
          ball.setTranslateY(420);
          numberLives = 5;
          for (int i = 0; i < hits.length; i++) {
            hits[i] = 0;
          }
          for (int i = 0; i < 36; i++) {
              bricks[i] = new Rectangle(row, col, 80, 30);
              if (i == 5) {
               row = -2;
               col = 112;
                 
              }
              if(i == 11){
                row = -2;
                col = 144;  
                            
              }
              if(i == 17){
                row = -2;
                col = 176; 
                             
              }
              if(i == 23){
                row = -2;
                col = 208;  
                          
              }
              if(i == 29){
                row = -2;
                col = 240; 
                             
              }
              if(i == 35){
                row = -2;
                col = 272; 
                             
              }
              row += 82;
              bricks[i].setFill(Color.TEAL);
              positions[i] = bricks[i].getBoundsInParent(); 
              getSceneNodes().getChildren().addAll(bricks[i]);
              }// for loop 
        }//level 3    

    }//level method
    
/**
 * This method does not return any values. 
 * This method determines what to do if the user presses a key to interact with the game. It also determines if the user hit a brick, the paddle, the edge, or fell off. By doing this, it determines if the user moves to the next level or loses. 
 * @param game 
 * @param gameTime
 */ 
    @Override
    public void update(Game game, GameTime gameTime) {
        lives.setText("Lives: " + numberLives);
        score.setText("Score: " + scoreValue);
        if (game.getKeyManager().isKeyPressed(KeyCode.SPACE)) {
          welcome.setText(null);
          welcome2.setText(null);
          playing = true;
          bricksOpen = true;
        }// starts the game
        if (game.getKeyManager().isKeyPressed(KeyCode.LEFT) && playing == true) {
            if(level == 1){
            rt.setTranslateX(rt.getTranslateX() - 4);  
            }
            if(level == 2){
            rt.setTranslateX(rt.getTranslateX() - 6);
            }
            if(level == 3){
            rt.setTranslateX(rt.getTranslateX() - 8);  
            }    
        }// moves paddle left 
        if (game.getKeyManager().isKeyPressed(KeyCode.RIGHT) && playing == true) {
          if(level == 1){
            rt.setTranslateX(rt.getTranslateX() + 4);  
            }
            if(level == 2){
            rt.setTranslateX(rt.getTranslateX() + 6);
            }
            if(level == 3){
            rt.setTranslateX(rt.getTranslateX() + 8);  
            } 
        }//moves paddle right
        if (rt.getTranslateX() >= 540) {
          rt.setTranslateX(540);
        }
        if (rt.getTranslateX() <= 0) {
          rt.setTranslateX(0);
        }
        if (playing == true && bricksOpen == true && numberLives >= 0){
          ball.setTranslateX(ball.getTranslateX() + xMove);
          ball.setTranslateY(ball.getTranslateY() + yMove);

              if(ball.getTranslateX() <= 0){
               xMove = -xMove;
              }//hit edge
              if(ball.getTranslateX() >= 630){
               xMove = -xMove;
              }//hit edge
              if(ball.getTranslateY() >= 480){
                numberLives = numberLives - 1;
                ball.setTranslateX(315);
                ball.setTranslateY(420);
                rt.setTranslateX(270);
                rt.setTranslateY(440);
                playing = false;
                yMove = -yMove;
              }//hit edge- lose
              if(ball.getTranslateY() <= 0){
                yMove = -yMove;
              }//hit edge
       
          for (int i = 0; i < 36; i++) { //determines what the ball hits 
           if (ball.getBoundsInParent().intersects(positions[i])) {
             if (hits[i] == 0) {
              hits[i] = 1;
              bricks[i].setFill(Color.GREY); //changes colors accordingly 
             }
             else if (hits[i] == 1) {
               hits[i] = 2;
               bricks[i].setFill(Color.WHITE);
             }
             else if (hits[i] == 2) {
               hits[i] = 3;
               bricks[i].setFill(Color.TRANSPARENT);
               bricks[i] = null;
               positions[i] = null;
               scoreValue++;
               numOfBricks--;
             }
             
             yMove = -yMove;
             
             if(i == 0){
               xMove = -xMove;
             }             
             if(i == 5){
               xMove = -xMove;
             }             
             if(i == 6){
               xMove = -xMove;
             } 
             if(i == 10){
               xMove = -xMove;
             }
             if(i == 11){
               xMove = -xMove;
             } 
             if(i == 12){
               xMove = -xMove;
             } 
             if(i == 17){
               xMove = -xMove;
             } 
             if(i == 18){
               xMove = -xMove;
             } 
             if(i == 20){
               xMove = -xMove;
             }
             if(i == 24){
               xMove = -xMove;
             }
             if(i == 28){
               xMove = -xMove;
             }
             if(i == 30){
               xMove = -xMove;
             }
             if(i == 31){
               xMove = -xMove;
             }
             if(i == 34){
               xMove = -xMove;
             }
             if(i == 35){
               xMove = -xMove;
             }
          }

       }//for loop

        if(ball.getBoundsInParent().intersects(rt.getBoundsInParent())){
          yMove = -yMove;
        }// ball hits paddle
        
        if (numberLives == 0){
          restart.setText("You lose. Score: " + scoreValue );
          getSceneNodes().getChildren().addAll(restart);          
        }
        
        if (numOfBricks == 0){
          bricksOpen = false;
          level++;
          if(level == 3){
            winner.setText("Winner! Score: " + scoreValue );
            getSceneNodes().getChildren().addAll(winner);
            System.exit(0);
          }
          level();
        } //user wins
    }//if playing statement 
  
    
}//update

} // TestGame

