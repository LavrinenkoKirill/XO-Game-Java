package Controller;
import View.GameView;
import View.MainMenu;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Client {
    protected static Socket socket;
    protected static String name = "Anon";
    public static class ClientSend implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("Start: ");
                while (true) {
                    Scanner inFromUser = new Scanner(System.in);
                    String sentence = inFromUser.nextLine();
                    String[] words = sentence.split(" ");

                    if (words[0].equals("@quit"))
                        System.exit(0);
                    if ((words[0].equals("@name")) && (words.length > 1)) {
                        name = words[1];
                        sentence = name + " join to chat";
                    }
                    System.out.println("Me: " + sentence);

                    sentence = name + ": " + sentence;
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(sentence);
                }
            } catch (IOException err) {
                err.getMessage();
            }
        }
    }

    public static class ClientReceive implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    if (in.ready()) {
                        String sentence = in.readLine();

                        String[] words = sentence.split(" ");

                        if((words[1].equals("@senduser")) && (words.length > 2)) {
                            if (name.equals(words[2])) {
                                sentence = words[0] + " ";
                                for (int i = 3; i < words.length; i++)
                                    sentence +=  words[i] + " ";
                                System.out.println(sentence);
                            }
                        }
                        else
                            System.out.println(sentence);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        try {
            socket = new Socket("localhost", 8888);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        new MainMenu();
        Thread send = new Thread(new ClientSend());
        Thread receive = new Thread(new ClientReceive());
        send.start();
        receive.start();
    }
}