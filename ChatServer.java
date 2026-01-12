import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static Set<ClientHandler> clientHandlers = new HashSet<>();

    public static void main(String[] args) {
        int port = 12345; // Server port
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Chat server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandlers.add(clientHandler);

                Thread thread = new Thread(clientHandler);
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Broadcast message to all clients
    public static void broadcast(String message, ClientHandler sender) {
        for (ClientHandler client : clientHandlers) {
            if (client != sender) { // don't send to the sender
                client.sendMessage(message);
            }
        }
    }

    // Remove client when disconnected
    public static void removeClient(ClientHandler client) {
        clientHandlers.remove(client);
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String name;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Ask client for name
            out.println("Enter your name: ");
            this.name = in.readLine();
            out.println("Welcome " + name + "! Type 'exit' to leave the chat.");
            ChatServer.broadcast(name + " has joined the chat.", this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message;
        try {
            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println(name + ": " + message);
                ChatServer.broadcast(name + ": " + message, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ChatServer.removeClient(this);
                socket.close();
                ChatServer.broadcast(name + " has left the chat.", this);
                System.out.println(name + " disconnected.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
