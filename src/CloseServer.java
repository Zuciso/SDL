import java.io.IOException;
import java.net.*;

public class CloseServer {
    public static void main(String args[]) {
        Client c = new Client("localhost", 5000);
        c.socket_write("over");
        c.close();
    }
}
