/*
 **Program Name:	CS Objecto Oriented Computing
 **Author:			Luis Courcelle
 **Date:			March 11th, 2024
 **Course:			CPSC 1181
 **Compiler			JDK 20.02
 */

/*
 ** This program will create an interactive Draw
 */

package com.assignement.assignement7;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;


public class Scenary extends Application {
    private Group tree;
    private Group sun;
    private Group rainbow;
    private CheckBox rainbowBox;
    private CheckBox sunBox;
    private Text writeMessage;
    private TextField writeHere;
    private Pane drawPane;
    private Button changeText;
    private VBox mainPane;
    private RadioButton degree0;
    private RadioButton degree90;
    private RadioButton degree180;
    private RadioButton degree270;
    private ToggleGroup degrees;


    public static void main(String[] args) {launch(args);}

    /*
     **This applications will create the drawings
     */
    public void start(Stage primaryStage){

        //Main Pain
        drawPane = new Pane();
        drawPane.setPrefWidth(300);
        drawPane.setPrefHeight(400);
        Rectangle clip = new Rectangle(0,0,300,400);
        drawPane.setClip(clip);

        //Grass
        Rectangle ground = new Rectangle(0, 300, 300, 100);
        ground.setFill(Color.DARKGREEN);
        drawPane.getChildren().add(ground);

        //Tree
        tree = new Group();
        Rectangle trunk = new Rectangle(40,220,20,100);
        Ellipse leaves = new Ellipse(50,220, 40, 50);
        leaves.setFill(Color.rgb(30,120,80));
        trunk.setFill(Color.SADDLEBROWN);
        tree.getChildren().addAll(trunk,leaves);

        //Rainbow
        rainbow = new Group();
        Color[] rainbowColors = {Color.RED, Color.ORANGE, Color.YELLOW,
                Color.GREEN, Color.BLUE, Color.INDIGO, Color.PURPLE};
        int radiusX = 250;
        int radiusY = 200;
        for (int i = 0; i < rainbowColors.length; i++)
        {
            Ellipse rainbows = new Ellipse(150,280,radiusX,radiusY);
            rainbows.setStroke(rainbowColors[i]);
            rainbows.setStrokeWidth(5);
            rainbows.setFill(Color.TRANSPARENT);
            radiusX -= 5;
            radiusY -= 5;
            rainbow.getChildren().addAll(rainbows);
        }
        rainbow.setVisible(false);

        //Sun
        sun = new Group();
        sun.getChildren().add(new Circle(200,90,80,Color.YELLOW));
        sun.getChildren().add(new Arc(200,100,50,40,180,180));
        sun.getChildren().add(new Ellipse(170,60,10,20));
        sun.getChildren().add(new Ellipse(230,60,10,20));
        sun.setVisible(false);

        //Add groups to Pane
        drawPane.getChildren().addAll(tree, rainbow, sun);

        //Background
        Text background = new Text( "Background");
        background.setFont(Font.font("Arial"));

        //Checkboxes
        rainbowBox = new CheckBox("Rainbow");
        sunBox = new CheckBox("Sun");
        HBox checkBoxes = new HBox(20, rainbowBox, sunBox);
        checkBoxes.setPadding(new Insets(20));
        HideHandler check = new HideHandler();
        rainbowBox.setOnAction(check);
        sunBox.setOnAction(check);

        //Radio Buttons
        degrees = new ToggleGroup();
        degree0 = new RadioButton("0 Degrees");
        degree90 = new RadioButton("90 Degrees");
        degree180 = new RadioButton("180 Degrees");
        degree270 = new RadioButton("270 Degrees");
        degree0.setToggleGroup(degrees);
        degree90.setToggleGroup(degrees);
        degree180.setToggleGroup(degrees);
        degree270.setToggleGroup(degrees);
        VBox radioButtons = new VBox(10, degree0, degree90, degree180, degree270);

        RotateFig select = new RotateFig();
        degree0.setOnAction(select);
        degree90.setOnAction(select);
        degree180.setOnAction(select);
        degree270.setOnAction(select);

        //Caption
        Text caption = new Text(10, 10, "Caption");
        caption.setFont(Font.font("Arial"));


        //Text field and Button
        writeHere = new TextField();
        writeHere.setPrefWidth(200);
        writeMessage = new Text();
        changeText = new Button("Change Text");

        MessageEventHandler writeE = new MessageEventHandler();
        changeText.setOnAction(writeE);

        //VBox mainPane
        mainPane = new VBox(10,background, checkBoxes, radioButtons, caption, writeHere, changeText, writeMessage);
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setPadding(new Insets(20));
        VBox.setMargin(caption, new Insets(20,0,0,0));

        //Close Button
        Button closeButton = new Button("Close");
        HBox close = new HBox(closeButton);
        close.setAlignment(Pos.BASELINE_RIGHT);
        close.setPadding(new Insets(15));
        CloseWindow end = new CloseWindow();
        closeButton.setOnAction(end);

        //Border Pane root
        BorderPane root = new BorderPane();
        root.setCenter(drawPane);
        root.setLeft(mainPane);
        root.setBottom(close);

        Scene scene = new Scene(root);
        primaryStage.setTitle("JavaFX Scenary");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /*
     **This application will display the input text
     */
    private class MessageEventHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            drawPane.getChildren().remove(writeMessage);
            writeMessage.setText(writeHere.getText());
            writeMessage.setFont(Font.font("Arial", 40));
            writeMessage.setFill(Color.BLUEVIOLET);
            writeMessage.setLayoutX(50);
            writeMessage.setLayoutY(350);
            drawPane.getChildren().add(writeMessage);
        }
    }
    /*
     **This application will Hide/show two drawings
     */
    private class HideHandler implements  EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            rainbow.setVisible(false);
            sun.setVisible(false);
            if (rainbowBox.isSelected()){
                rainbow.setVisible(true);
            }
            if (sunBox.isSelected()){
                sun.setVisible(true);
            }
        }
    }
    /*
     **This application will rotate a figure
     */
    private class RotateFig implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            if (degree0.isSelected()){
                tree.setRotate(0);
            }
            if (degree90.isSelected()){
                tree.setRotate(90);
            }
            if (degree180.isSelected()){
                tree.setRotate(90*2);

            }
            if (degree270.isSelected()){
                tree.setRotate(90*3);
            }
        }
    }
    /*
     **This application will terminate the program
     */
    private class CloseWindow implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            Platform.exit();
        }
    }
}

