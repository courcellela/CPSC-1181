/*
 **Program Name:	CS Object Oriented Computing
 **Author:			Luis Courcelle
 **Date:			March 23th, 2024
 **Course:			CPSC 1181
 **Compiler			JDK 20.02
 */

package org.assignements.assignement8;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

/*
**This application will create a ball game
 */
public class Game extends Application {
    private BorderPane root;
    private Pane centerPane;
    private HBox scores, downPane;
    private Ellipse ball;
    private Rectangle background;
    private Button pause, reset;
    private Text hitsText, missesText, missesNum, hitsNum, gameOver;
    private int hits, misses, xVelocity=2, radX=50, radY=50, onOff=0;
    private GameAnimation animate;

    public static void main(String[] args) {launch(args);}

    /*
    **This application creates the game framework
     */
    public void start(Stage primaryStage){

        centerPane = new Pane();
        centerPane.setPrefHeight(500);
        centerPane.setPrefWidth(500);

        //creates the background
        background = new Rectangle(0,0,500,500);
        background.setFill(Color.BLACK);

        //creates the text score and misses
        hitsText = new Text("Hits: ");
        missesText = new Text("   Misses: ");
        hitsNum = new Text();
        missesNum = new Text();
        textStart();

        // Place Score and Misses in an Hbox
        scores = new HBox(hitsText,hitsNum,missesText,missesNum);
        scores.setPadding(new Insets(20));

        //creates the ball
        ball = new Ellipse(50,250,radX,radY);
        ball.setFill(Color.WHITE);

        //Add the Hbox to the Pain
        centerPane.getChildren().addAll(background,scores, ball);
        animate = new GameAnimation();
        animate.start();

        //Create the buttons
        pause = new Button("Pause");
        reset = new Button("Reset");
        downPane = new HBox();
        downPane.setAlignment(Pos.BASELINE_RIGHT);
        downPane.getChildren().addAll(pause,reset);
        HBox.setMargin(reset, new Insets(20));

        //Create root BorderPane
        root = new BorderPane();

        //Order elements inside borderPane
        root.setCenter(centerPane);
        root.setBottom(downPane);

        //Link the objects to an EventHandler
        ball.setOnMouseClicked(new ClickCircle());
        pause.setOnAction(new PauseBottom());
        reset.setOnAction(new RessetGame());
        Scene scene = new Scene(root);
        primaryStage.setTitle("JavaFX Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    /*
    **This application will create the animation of the game
     */
    private class GameAnimation extends AnimationTimer{
        @Override
        public void handle(long now){
            double x = ball.getCenterX();
            x += xVelocity;
            if (x > 450){
                misses ++;
                missesNum.setText(" " + String.valueOf(misses));
                background.setFill(randomColor());
                x = 50;
                if (misses > 4){
                    gameOver();
                }
            }
            ball.setCenterX(x);
        }
    }
    /*
    **This application create the click event of the ball
     */
    public class ClickCircle implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent e){
             hits++;
             ball.setCenterX(0);
             radX -=5;
             radY -=5;
             ball.setRadiusX(radX);
             ball.setRadiusY(radY);
             ball.setFill(randomColor());
             xVelocity *= 1.5;
             hitsNum.setText(" " + String.valueOf(hits));
        }
    }
    /*
    **Generates random colors
     */
    private Color randomColor(){
        Random colors = new Random();
        return Color.rgb(colors.nextInt(256), colors.nextInt(256), colors.nextInt(256));
    }
    /*
    **Creates the functionality of the bottoms
     */
    public class PauseBottom implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            onOff +=1;
            if (onOff == 1){
                animate.stop();
                ball.setDisable(true);
            }
            if (onOff == 2){
                animate.start();
                ball.setDisable(false);
                onOff = 0;
            }
        }
    }
    /*
    **This applicaiton resets the game
     */
    public class RessetGame implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            textStart();
            ballStart();
        }
    }
    /*
    **Add the functionalitu to Text nodes
     */
    public void textStart(){
        misses = 0;
        hits = 0;
        missesNum.setText(" " + String.valueOf(misses));
        hitsNum.setText(" " + String.valueOf(hits));
        hitsText.setFill(Color.WHITE);
        missesText.setFill(Color.WHITE);
        hitsNum.setFill(Color.WHITE);
        missesNum.setFill(Color.WHITE);
    }
    /*
    **Reset the ball to initial values
     */
    public void ballStart(){
        centerPane.getChildren().remove(gameOver);
        ball.setFill(Color.WHITE);
        ball.setVisible(true);
        background.setFill(Color.BLACK);
        radX = 50;
        radY = 50;
        ball.setCenterX(50);
        ball.setRadiusX(radX);
        ball.setRadiusY(radY);
        xVelocity = 2;
        animate.start();
    }
    /*
    **Display the text when the game is over.
     */
    public void gameOver(){
        misses = 0;
        animate.stop();
        ball.setVisible(false);
        gameOver = new Text("Game Over");
        gameOver.setFill(Color.WHITE);
        gameOver.setFont(Font.font("Arial", 40));
        gameOver.setX(150);
        gameOver.setY(250);
        centerPane.getChildren().add(gameOver);
    }

}
