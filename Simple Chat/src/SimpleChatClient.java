import java.io.*;
import java.net.Socket;

/**
 * Simple Chat Client
 */
public class SimpleChatClient {

    private Socket socket;
    private BufferedReader inputBufferedReader;
    private BufferedWriter outputBufferedWriter;

    /**
     * Simple Chat Client constructor
     * @param host ip address
     * @param port port number
     */
    public SimpleChatClient(String host, int port) {

        System.out.println("Connecting, please wait...");

        try {
            socket = new Socket(host, port);
            System.out.println("Connected to: " + socket);
            setupSocketStreams();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            System.exit(1);
        }

        String line = "";

        // while the client doesn't quit
        while (!line.equals("/quit")) {

            try {

                // read the message from the console
                line = inputBufferedReader.readLine();

                // write the message to the output buffer
                outputBufferedWriter.write(line);
                outputBufferedWriter.newLine();
                outputBufferedWriter.flush();

            } catch (IOException exception) {

                System.out.println("Sending error: " + exception.getMessage() + ", closing client...");
                break;
            }
        }

        // close the client socket
        stop();
    }

    /**
     * Init the buffers
     * @throws IOException
     */
    public void setupSocketStreams() throws IOException {

        inputBufferedReader = new BufferedReader(new InputStreamReader(System.in));
        outputBufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    /**
     * Close the socket
     */
    public void stop() {

        try {

            if (socket != null) {
                System.out.println("Closing the socket");
                socket.close();
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }
    }

    /**
     * Start the Simple Chat Client
     * @param args
     */
    public static void main(String[] args) {

        String host = "127.0.0.1";
        int port = Integer.parseInt("8000");

        System.out.println("Java Simple Chat Client:\nHost " + host + "\nPort " + port);

        new SimpleChatClient(host, port);
    }
}