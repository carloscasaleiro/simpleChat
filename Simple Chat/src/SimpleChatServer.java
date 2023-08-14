import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Simple Chat Server
 */
public class SimpleChatServer {

    private Socket clientSocket;
    private ServerSocket serverSocket;
    private BufferedReader inputBufferedReader;

    /**
     * Simple Chat Server constructor
     * @param port
     */
    public SimpleChatServer(int port){

        // connect socket to port

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started: " + serverSocket);

            // wait for a client to connect
            System.out.println("Waiting for a client...");
            clientSocket = serverSocket.accept();

            // client found
            System.out.println("Client found: " + clientSocket);
            setupSocketStream();

        while (true) {

                // read line from reader
                String line = inputBufferedReader.readLine();

                // if /quit break
                if (line == null || line.equals("/quit")) {

                    System.out.println("Client left, exiting");
                    break;

                }

                // show the line to the console
                System.out.println(line);
        }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        finally {

        close();

        }
    }

    /**
     * Init input buffer
     * @throws IOException
     */
    public void setupSocketStream() throws IOException {
        inputBufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    /**
     * Close the socket
     */
    public void close() {

        try {

            if (clientSocket != null) {
                System.out.println("Closing client socket");
                clientSocket.close();
            }

            if (serverSocket != null) {
                System.out.println("Closing server socket");
                serverSocket.close();
            }


        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

    }

    /**
     * Start the Simple Chat Server
     * @param args
     */
    public static void main(String[] args){

        int port = Integer.parseInt("8000");

        System.out.println("Java Simple Chat Server:\nPort " + port);

        new SimpleChatServer(port);
    }
}