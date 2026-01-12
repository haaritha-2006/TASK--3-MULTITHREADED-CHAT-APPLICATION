import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        String host = "localhost"; // Server IP
        int port = 12345;

        try (Socket socket = new Socket(host, port)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            // Thread to listen for messages from server
            Thread listener = new Thread(() -> {
                String msgFromServer;
                try {
                    while ((msgFromServer = in.readLine()) != null) {
                        System.out.println(msgFromServer);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            });
            listener.start();

            // Main thread to send messages
            while (true) {
                String msgToSend = scanner.nextLine();
                out.println(msgToSend);
                if (msgToSend.equalsIgnoreCase("exit")) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
