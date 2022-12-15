package View;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    protected static ServerSocket serverSocket;
    protected static ArrayList<ClientThread> clients;
    protected static ArrayList<Room> rooms;

    static class ClientThread extends Thread {
        private Socket curSocket;
        private BufferedReader in;
        private PrintWriter out;

        ClientThread(Socket s) {
            curSocket = s;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(curSocket.getInputStream()));
                out = new PrintWriter(curSocket.getOutputStream(), true);

                while (!curSocket.isClosed()) {
                    String command = in.readLine();
                    System.out.println(command);
                    if (command.contains("create")){
                        String[] words = command.split("-");
                        Room rm = new Room(words[1],Integer.parseInt(words[2]));
                        rooms.add(rm);
                    }

                }
                in.close();
                out.close();
                curSocket.close();
                System.out.println("Disconnect!");
            } catch (IOException e) {
                e.getMessage();
            }
        }

    }


    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(5555);
            clients = new ArrayList<>();
            rooms = new ArrayList<>();
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected!");
                ClientThread cliThread = new ClientThread(clientSocket);
                clients.add(cliThread);
                cliThread.start();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static class Room{
        protected String name;
        protected int gameMode;
        protected boolean full;

        public Room(String str,int size){
            name = str;
            gameMode = size;
            full = false;
        }
    }


}
