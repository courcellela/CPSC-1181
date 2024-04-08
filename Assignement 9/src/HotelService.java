/*
 **Program Name:	CS Objecto Oriented Computing
 **Author:			Luis Courcelle
 **Date:			April 7th, 2024
 **Course:			CPSC 1181
 **Compiler			JDK 20.02
 */

/*
 **This application will do all the operations requested by the client
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;


public class HotelService implements Runnable{
    private Socket s;
    private DataInputStream in;
    private DataOutputStream out;
    private Hotel luxury;

    public HotelService(Socket socket, Hotel hotel) {
        s = socket;
        luxury = hotel;
    }
    //Override the run method from interface Runnable
    public void run(){
        try{
            try {

                in = new DataInputStream(s.getInputStream());
                out = new DataOutputStream(s.getOutputStream());
                doService();
            }
            finally {
                s.close();
            }
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
    }
    public void doService() throws IOException{
        // step 1 send a welcome message to user
        out.writeUTF("Welcome to Hotel Luxury");
        out.flush();

        //step 2 read the word user and name
        String connection = in.readUTF();
        String name = in.readUTF();

        //step 3 Check for proper KEY and name
        if (!connection.equalsIgnoreCase("USER") || name.equalsIgnoreCase("")){
            out.writeUTF("Invalid Command, Closing connections");
            out.flush();
            s.close();
        }
        //Welcome the user
        else {
            out.writeUTF("Hello, " + name);
            out.flush();
        }
        // step 4 read the command from Client
        while (true){
                //Check for command quit and close connection to server
            String command = in.readUTF();
            if (command.equalsIgnoreCase("QUIT")){
                out.writeUTF("Closing connection");
                return;
            }
            //check for INVALID and close connection.
            else if (command.equalsIgnoreCase("INVALID")){
                out.writeUTF("Invalid, command, closing connection");
                return;
            }
            //Execute the menu's choice from client
            else {
                commandExecute(command);
            }
        }
    }
    //Execute the command chosen by user
    public void commandExecute(String command) throws IOException{
        if (command.equalsIgnoreCase("reserve")) {
            String user = in.readUTF();
            int first = in.readInt();
            int last = in.readInt();
            if (luxury.requestReservation(user, first, last)){
                out.writeUTF("Reservation successul to " + user + " from " + first + " to " + last);
            }
            else {
                out.writeUTF("Reservation unsuccessul to " + user + " from " + first + " to " + last);
            }
            out.flush();
        } if (command.equalsIgnoreCase("cancel")) {
            String user = in.readUTF();
            if (luxury.cancelReservation(user)){
                out.writeUTF("Reservation successfully cancel");
            }
            else {
                out.writeUTF("Reservation not cancel");
            }
            out.flush();
        } if (command.equalsIgnoreCase("AVAIL")){
            out.writeUTF(luxury.toString());
            out.flush();
        }

    }
}
