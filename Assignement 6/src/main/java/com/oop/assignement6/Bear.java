/*
 **Program Name:	CS Objecto Oriented Computing
 **Author:			Luis Courcelle
 **Date:			February 18th, 2024
 **Course:			CPSC 1181
 **Compiler			JDK 20.02
 */

/*
** This program will create a Bear draw
 */

package com.oop.assignement6;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Bear {

    private Ellipse head;
    private Ellipse body;
    private Ellipse leg1;
    private Ellipse leg2;
    public Bear(int xCoordinate, int yCoordinates, int xRadius, int yRadius){

        head = new Ellipse(xCoordinate, yCoordinates, xRadius, yRadius);
        head.setFill(Color.BROWN);
        head.setStrokeWidth(3);
        head.setStroke(Color.BLACK);

        body = new Ellipse(xCoordinate, (yCoordinates + yRadius * 2), (xRadius * 1.5), (yRadius * 1.5));
        body.setFill(Color.BROWN);
        body.setStroke(Color.BLACK);
        body.setStrokeWidth(3);

        leg1 = new Ellipse(xCoordinate, yCoordinates + yRadius, xRadius * 2, yRadius/3);
        leg1.setFill(Color.BROWN);

        leg2 = new Ellipse(xCoordinate, yCoordinates + (yRadius * 3.18), xRadius * 2, yRadius/3);
        leg2.setFill(Color.BROWN);

    }
    public Node[] getAllNodes(){
        return new Node[] {head, body, leg1, leg2};
    }

}
