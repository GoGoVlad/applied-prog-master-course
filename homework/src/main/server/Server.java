package main.server;

import main.Message;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] ar) {

        int port = 6666;
        Socket socket = null;
        ObjectInputStream fromClient = null;
        ObjectOutputStream toClient = null;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            while(true) {
                socket = serverSocket.accept();
                System.out.println("Just connected to " + socket.getRemoteSocketAddress());
                toClient = new ObjectOutputStream( new BufferedOutputStream(socket.getOutputStream()));
                fromClient = new ObjectInputStream( new BufferedInputStream(socket.getInputStream()));
                Message msgRequest = (Message) fromClient.readObject();
                int number = msgRequest.number;
                toClient.writeObject(new Message(number*number));
                toClient.flush();
            }
        }
//            while (true) {
//                toClient = new ObjectOutputStream( new BufferedOutputStream(socket.getOutputStream()));
//                fromClient = new ObjectInputStream( new BufferedInputStream(socket.getInputStream()));
//                line = in.readUTF(); // ожидаем пока клиент пришлет строку текста
//                System.out.println("Client just sent me this line : " + line);
//                Message msgRequest = (Message) fromClient.readObject();
//                int number = msgRequest.number;
//                toClient.writeObject(new Message(number*number));
//                toClient.flush();
//
//                /*out.write(number * number);
//                out.flush();*/
//                System.out.println("Waiting for the next line...");
//                System.out.println();
//            }
        catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
