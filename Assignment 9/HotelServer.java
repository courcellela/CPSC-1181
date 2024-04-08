/*
 **Program Name:	CS Objecto Oriented Computing
 **Author:			Luis Courcelle
 **Date:			April 7th, 2024
 **Course:			CPSC 1181
 **Compiler			JDK 20.02
 */

/*
 **This application will create the server for the Hotel
 */
import java.io.*;
import java.net.*;

public class HotelServer {
    public static void main(String[] args) throws IOException{
        //assign the port and create the hotel object
        final int SHP_PORT = 8888;
        Hotel hotel = new Hotel();

        //Create the socket from the server side
        ServerSocket server = new ServerSocket(SHP_PORT);
        System.out.println("Waiting for the client to connect");

        try{
            //allow the socket to be continue open
            while(true){
                Socket s = server.accept();
                System.out.println("Client is connected");
                //create a class that encapsulates the socket and hotel object
                HotelService service = new HotelService(s, hotel);
                //Assign the program into a thread
                Thread t = new Thread(service);
                //Start the tread
                t.start();
            }
        }
        finally {
            server.close();
        }
    }
}
