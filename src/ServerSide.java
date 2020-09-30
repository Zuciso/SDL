import java.util.ArrayList;

public class ServerSide {

    static Server s;
    static Admin admin;
    static ArrayList<Customer> customers = new ArrayList<Customer>();
    public static void main(String args[]) {

        admin = new Admin("admin", "admin");

        int i = 0;
        while (true) {
            s = new Server(5000);
            String type = s.socket_read();
            System.out.println(type);
            if(type.equals("signup")){
                Customer c=(Customer)s.socket_read();
                customers.add(c);
            }
            s.close();
            i++;
        }

    }
}
