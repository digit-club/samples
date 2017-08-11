package sockets;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer
{
    private static final int PORT = 1992;

    public static void main(String[] args) throws IOException {

        System.out.println("Waiting for clients...");
        try (ServerSocket server = new ServerSocket(PORT);
             Socket client = server.accept();
             PrintWriter clientOut = new PrintWriter(client.getOutputStream(), true))
        {
            System.out.println("Accepted a connection with : " + client.getInetAddress() + ":" + client.getPort());
            serve(clientOut);
        }
    }

    private static void serve(PrintWriter out) throws IOException {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        String message;
        while ((message = in.next()) != null)
        {
            out.println(message);
        }
    }

}
