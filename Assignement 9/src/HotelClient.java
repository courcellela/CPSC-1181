/*
 **Program Name:	CS Objecto Oriented Computing
 **Author:			Luis Courcelle
 **Date:			April 7th, 2024
 **Course:			CPSC 1181
 **Compiler			JDK 20.02
 */

/*
**This application will handle hotel reservations
 */

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class HotelClient {

    public static void main(String[] args) throws IOException {

        final int SHP_PORT = 8888;
        Socket s = new Socket("localhost", SHP_PORT);

        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        Scanner input = new Scanner(System.in);

        //step 1 read the welcome message from the server
        System.out.println(in.readUTF());

        //step 2 Send the USER and NAME to the server
        System.out.println("Enter the Keyword USER");
        String user = input.nextLine();
        out.writeUTF(user);
        System.out.println("Enter your name");
        String name = input.nextLine(); // Make the name a variable
        out.writeUTF(name);
        out.flush();

        // step 3 read the message from connection
        System.out.println(in.readUTF());
        if (user.equalsIgnoreCase("user")) {
            // Send the command to server
            while (true) {
                System.out.println("Write one option: RESERVE CANCEL AVAIL QUIT");
                String command = input.nextLine();

                //Request days for reservation
                if (command.equalsIgnoreCase("reserve")) {
                    System.out.println("Enter the start day");
                    int firstDay = Integer.parseInt(input.nextLine());
                    System.out.println("Enter the end day");
                    int endDay = Integer.parseInt(input.nextLine());

                    // Send all the input to the server
                    out.writeUTF(command);
                    out.writeUTF(name);
                    out.writeInt(firstDay);
                    out.writeInt(endDay);
                    out.flush();

                    // Receive the RESERVE response from the server
                    System.out.println(in.readUTF());

                }// send cancel information to server
                else if (command.equalsIgnoreCase("cancel")) {
                    out.writeUTF(command);
                    out.writeUTF(name);
                    out.flush();

                    // Receive the cancel response from the server
                    System.out.println(in.readUTF());

                }// Send avail to server
                else if (command.equalsIgnoreCase("avail")) {
                    out.writeUTF(command);
                    out.flush();

                    // Receive the avail response from the server
                    System.out.println(in.readUTF());

                }// Send quit to server
                else if (command.equalsIgnoreCase("QUIT")) {
                    out.writeUTF(command);
                    out.flush();

                    // Receive the avail response from the server
                    System.out.println(in.readUTF());
                    return;
                }
                //Send INVALID command to server
                else{
                    command = "INVALID";
                    out.writeUTF(command);
                    out.flush();

                    //Receive the avail response from server
                    System.out.println(in.readUTF());
                    return;
                }
            }
        }
    }
}
