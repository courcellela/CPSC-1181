package com.oop.assignement6;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Tree {
    private Rectangle trunk;
    private Ellipse leaves;
    private Rectangle box;

    public Tree(int xCoordinates, int yCoordinates, int trunkWidth, int trunkHigth,
                int xLeavesRadius, int yLeavesRadius, int rgbColor1, int rgbColor2, int rgbColor3){

        trunk = new Rectangle(xCoordinates, yCoordinates, trunkWidth, trunkHigth);
        trunk.setFill(Color.SADDLEBROWN);
        box = new Rectangle(xCoordinates, yCoordinates, 5, 5);

        leaves = new Ellipse(xCoordinates + trunkWidth/2, yCoordinates - trunkHigth/3, xLeavesRadius, yLeavesRadius);
        leaves.setFill(Color.rgb(rgbColor1, rgbColor2, rgbColor3));
    }
    public Node[] getAllNodes(){
        return new Node[] {trunk, leaves, box};
    }
}
