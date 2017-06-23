package main.client;

import main.Message;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

class ClientSocket {
    void run() {
        int serverPort = 6666;
        Socket socket = null;
        ObjectOutputStream toServer = null;
        ObjectInputStream fromServer = null;

        while (true) {
            try {
                InetAddress serverHost = InetAddress.getByName("localhost");
                System.out.println("Connecting to server on port " + serverPort);
                socket = new Socket(serverHost, serverPort);
                System.out.println("Just connected to " + socket.getRemoteSocketAddress());
                toServer = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));

                System.out.print("Enter value or exit: ");
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                String line = keyboard.readLine();
                if (line.length() == 0 || line.equals("exit")) {
                    System.out.println("Need 1 argument");
                    System.exit(1);
                }
                int number = 1;
                try {
                    number = Integer.parseInt(line);
                } catch (Exception e){
                    System.exit(1);
                }
                Message msgToSend = new Message(number);
                toServer.writeObject(msgToSend);
                toServer.flush();
                fromServer = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
                Message msgFromReply = (Message) fromServer.readObject();
                System.out.println(number + " * " + number + " = " + msgFromReply.number);

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                System.exit(1);
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
