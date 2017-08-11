package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyClient {

    private static final int PORT = 1992;
    private static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {

        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())))
        {
            String message = "";
            while (message != null)
            {
                message = in.readLine();
                System.out.println("From server : " + message);
            }
        }
        System.out.println("Finishing");
    }

}
