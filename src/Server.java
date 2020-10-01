import java.net.*;
import java.io.*;

public class Server {
    public ServerSocket server = null;
    public Socket socket = null;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException io) {
            System.out.println(io);
        }
    }

    void createServer() {
        while (true) {
            try {
                Socket s = server.accept();
                Thread t = new ClientHandler(s);
                t.start();
            } catch (IOException io) {
                System.out.println(io);
            }
        }
    }
}
