import java.util.ArrayList;
import java.util.HashMap;

public class ServerSide {

    static Server s;
    static Admin admin;
    static ArrayList<Customer> customers = new ArrayList<Customer>();
    static HashMap<String,String> passwords = new HashMap<String,String>();
    public static void main(String args[]) {

        admin = new Admin("admin", "admin");
        passwords.put("Admin","Admin");

        int i = 0;
        while (true) {
            s = new Server(5000);
            String type = s.socket_read();
            System.out.println(type);
            if(type.equals("signup")){
                Customer c=(Customer)s.socket_read();
                customers.add(c);
                passwords.put(c.userName,c.userPassword);

            }
            else if(type.equals("login")){
                String name,pass;
                name=(String)s.socket_read();
                pass=(String)s.socket_read();
                System.out.println(name);
                String valid;
                if(pass.equals(passwords.get(name))){
                    valid="yes";
                }
                else{
                    valid="no";
                }
                s.socket_write(valid);

            }
            s.close();
            i++;
        }

    }
}
