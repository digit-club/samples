package sample;

import java.io.*;
import java.net.Socket;

public class MyClient extends Thread
{
    private Socket socket;
    private Controller controller;

    public MyClient() throws IOException {
        start();
    }

    @Override
    public void run()
    {
        try {

            listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listen() throws IOException {
        System.out.println("Creating client. Connecting...");
        socket = new Socket(MyServer.HOST, MyServer.PORT);
        try (
             BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ) {
            System.out.println("Connection established.");
            String message;
            while(true) {
                message = in.readLine();
                if (message == null)
                    break;
                controller.addMessage(message);
                controller.refresh();
            }
        } finally {
            socket.close();
        }
        System.out.println("Client has been closed.");
    }

    public void send(String s) throws IOException {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.println(s);
        writer.flush();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
