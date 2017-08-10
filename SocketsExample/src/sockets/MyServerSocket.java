package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServerSocket
{
    private static final int PORT = 1992;

    public static void main(String[] args) throws IOException {

        try (ServerSocket server = new ServerSocket(PORT);
             Socket client = acceptClient(server);
             PrintWriter clientOut = new PrintWriter(client.getOutputStream(), true))
        {
            serve(clientOut);
        }
    }

    private static Socket acceptClient(ServerSocket server) throws IOException {
        System.out.println("Waiting for clients...");
        Socket socket = server.accept();
        System.out.println("Accepted a connection with : " + socket.getInetAddress() + ":" + socket.getPort());
        return socket;
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
