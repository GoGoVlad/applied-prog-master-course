package client;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] ar) {
        int serverPort = 6666;
        String address = "127.0.0.1";

        try {
            InetAddress ipAddress = InetAddress.getByName(address);
            System.out.println("Connecting to " + address + " and port " + serverPort);
            Socket socket = new Socket(ipAddress, serverPort);
            System.out.println("Connected successfully!");

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            // Создаем поток для чтения с клавиатуры.
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            System.out.println("Type in something and press enter.");
            System.out.println();

            while (true) {
                line = keyboard.readLine(); // ждем пользователя
                System.out.println("Sending this line to the server...");
                out.writeUTF(line); // отсылаем введенную строку текста серверу.
                out.flush(); // заставляем поток закончить передачу данных.
                line = in.readUTF(); // ждем пока сервер отошлет строку текста.
                System.out.println("Server sent me this : " + line);
                System.out.println("Go ahead and enter more lines!");
                System.out.println();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
