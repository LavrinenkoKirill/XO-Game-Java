package Controller;

import View.BoardView;

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
            serverSocket = new ServerSocket(8888);
            clients = new ArrayList<>();

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
}
