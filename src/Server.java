import java.io.*;
import java.net.*;

public class Server {
    public ServerSocket server = null;
    public Socket socket = null;
    public ObjectInputStream instream = null;
    public ObjectOutputStream outstream = null;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
            socket = server.accept();
            System.out.println("Client connected");
            outstream = new ObjectOutputStream(socket.getOutputStream());
            instream = new ObjectInputStream(socket.getInputStream());
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException io) {
            System.out.println(io);
        }
    }

    public <T> void socket_write(T obj) {
        try {
            outstream.writeObject(obj);
        } catch (IOException io) {
            System.out.println(io);
        }
    }

    public <T> T socket_read() {
        T obj = null;
        try {
            obj = (T) instream.readObject();
            return obj;
        } catch (IOException io) {
            System.out.println(io);
        } catch (ClassNotFoundException c) {
            System.out.println(c);
        }
        return obj;
    }

    public void close() {
        try {
            instream.close();
            outstream.close();
            server.close();
            socket.close();
        } catch (IOException io) {
            System.out.println(io);
        }
    }

}