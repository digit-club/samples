package sample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
    public static final String HOST = "localhost";
    public static final int PORT = 15000;

    static String[] messages = new String[]{
            "Cover me!",
            "The bomb has been planted",
            "Fire in the hole!",
            "Roger that.",
            "Counter-terrorists win!"
    };

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Creating server. Waiting for connection...");
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket client = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        Scanner s = new Scanner(System.in);

        new Thread(() -> {
            while (s.hasNext()) {
                String str = s.next();
                try {
                    out.write(str + "\n");
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        String clientMessage;

        // создадим экземпляр бота
        BotDjigit bot = new BotDjigit();

        while ((clientMessage = in.readLine()) != null) {
            // скармливаем сообщение боту
            // узнать хочет ли бот что-то делать
            // взять результат

            String botSays = bot.Do(clientMessage);

            System.out.println("-> " + clientMessage);

            if (!botSays.isEmpty()) {
                System.out.println("bot " + botSays);
                out.write("Bot-Djigit: " + botSays + "\n");
                out.flush();
            }
        }

        System.out.println("Server socket has been closed.");
    }

}
