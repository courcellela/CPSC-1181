package com.oop.assignement6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Scenery extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Rectangle ground = new Rectangle(0, 400, 600, 100);
        ground.setFill(Color.DARKGREEN);
        root.getChildren().add(ground);

        Tree t1 = new Tree(100, 320, 30, 100,
                50, 70, 4, 90, 20);
        Tree t2 = new Tree(180, 380, 50, 60,
                50, 50, 80, 100, 80);
        Tree t3 = new Tree(250, 290, 30, 150,
                50, 120, 115, 130, 30);

        root.getChildren().addAll(t1.getAllNodes());
        root.getChildren().addAll(t2.getAllNodes());
        root.getChildren().addAll(t3.getAllNodes());

        Color[] rainbowColors = {Color.RED, Color.ORANGE, Color.YELLOW,
                Color.GREEN, Color.BLUE, Color.INDIGO, Color.PURPLE};
        int radiusX = 400;
        int radiusY = 300;
        for (int i = 0; i < rainbowColors.length; i++)
        {
            Ellipse rainbow = new Ellipse(300,350,radiusX,radiusY);
            rainbow.setStroke(rainbowColors[i]);
            rainbow.setStrokeWidth(5);
            rainbow.setFill(Color.TRANSPARENT);
            radiusX -= 5;
            radiusY -= 5;
            root.getChildren().addAll(rainbow);
        }

        Bear b1 = new Bear(400, 320, 30, 30);
        root.getChildren().addAll(b1.getAllNodes());

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("JavaFX Trees");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
