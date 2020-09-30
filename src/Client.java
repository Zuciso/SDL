import java.net.*;
import java.io.*;

public class Client {
    public Socket socket = null;
    public ObjectInputStream instream = null;
    public ObjectOutputStream outstream = null;

    public Client(String ip, int port) {
        try {
            socket = new Socket(ip, port);
            System.out.println("Connected to server");
            instream = new ObjectInputStream(socket.getInputStream());
            outstream = new ObjectOutputStream(socket.getOutputStream());
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException io) {
            System.out.print(io);
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
            socket.close();
        } catch (IOException io) {
            System.out.println(io);
        }
    }


}
