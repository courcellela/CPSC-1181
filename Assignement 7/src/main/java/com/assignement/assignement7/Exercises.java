package com.assignement.assignement7;

import javafx.application.Application;
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
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//Create a JavaFX class implementing Application
public class Exercises extends Application {

    private Pane mainPane;
    private Group myGroup;

    private CheckBox checkBox;
    private RadioButton radio1;
    private RadioButton radio2;
    private TextField text;


    //Syntax of main for JavaFX
    public static void main(String[] args) {launch(args);}

    //Override method need when implements Application
    public void start(Stage primaryStage){

        mainPane = new Pane();
        mainPane.setPrefHeight(300); //Set the heigth of the window
        mainPane.setPrefWidth(600); // Set width of the window
        //This code will cut a rectangle of same side that the window
        Rectangle clip = new Rectangle(0,0,300,600);
        mainPane.setClip(clip);

        //Create a group that contains different objects shapes
        myGroup = new Group();
        Rectangle example1 = new Rectangle(40,220,20,100);
        Ellipse example2 = new Ellipse(50,220, 40, 50);
        example1.setFill(Color.BLACK); //fill the rectangel with black color
        example2.setFill(Color.RED);
        myGroup.getChildren().addAll(example1, example2); // Add the object to the group

        //Hide or make visible an object False Hide, true visible
        myGroup.setVisible(false); //

        //create text
        Text background = new Text( "Background");
        background.setFont(Font.font("Arial"));


        //1. Create a checkbox
        checkBox = new CheckBox("CheckboxName");

        //1.1 create a HBOX and add objects
        HBox hBox = new HBox(20, checkBox);
        hBox.setPadding(new Insets(20)); // Creates padding inside the HBOX

        //1.2 Link the checkbox to an EventHandler
        CheckHandler check= new CheckHandler(); // First we create the Eventhandler object
        checkBox.setOnAction(check); // Second link the object with the Eventhandler


        //2 Radio Buttons
        ToggleGroup toggle = new ToggleGroup(); // Create an object of toggle group to group the buttons
        radio1 = new RadioButton("Radio 1");
        radio2 = new RadioButton("Radio 1");
        radio1.setToggleGroup(toggle); // Link the radio to the group
        radio2.setToggleGroup(toggle);

        //2.1 Create a VBox and link the radios t
        VBox radioButtons = new VBox(10, radio1, radio2);

        //2.2 Link the Radio buttons to an EvenHandler
        radio1.setOnAction(check);
        radio2.setOnAction(check);


        //3 Text field and Button
        text = new TextField();
        text.setPrefWidth(200); // Indicate the width of the field
        //3.1 Create the text object
        Text write = new Text();
        write.setText(text.getText()); // Get and link the text to the Texfield
        //3.2 create a button
        Button ofText = new Button("Change Text");
        //3.3 Link the objects to an EventHandler
        MessageEventHandler submit = new MessageEventHandler();
        ofText.setOnAction(submit);

        //Alignt items inside and Hbox or Vbox
        radioButtons.setAlignment(Pos.CENTER);
        //Set a margin in VBox
        VBox.setMargin(write, new Insets(20,0,0,0)); // this code set the margin on write object

        //Border Pane root
        BorderPane root = new BorderPane(); // creates the root object
        root.setCenter(mainPane); //Assigne mainPane to the center
        root.setLeft(hBox);
        root.setBottom(write);

        // Code for closing the stage
        Scene scene = new Scene(root);
        primaryStage.setTitle("JavaFX title");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false); // make the window fix
        primaryStage.show();

    }

    //Create an EventHandler for mouse
    private class CheckHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            //write the code you want
        }
    }
    private class MessageEventHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            //write the code you want
        }
    }

    //List of the differents types of even
    //node.setOnMouseClicked (EventHandler MouseEvent)
    //node.setOnMousePressed (EventHandler MouseEvent)
    //node.setOnMouseReleaseed (EventHandler MouseEvent)
    //node.setOnMouseMoved (EventHandler MouseEvent)
    //node.setOnMouseDragged (EventHandler MouseEvent)
}
