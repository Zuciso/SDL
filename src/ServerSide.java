import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ServerSide {

    static Server s;
    static Admin admin;
    static ArrayList<Customer> customers = new ArrayList<Customer>();
    static HashMap<String,String> passwords = new HashMap<String,String>();
    static PriorityQueue<Vehicle> Pqueue = new PriorityQueue<Vehicle>(new The_Comparator());
    static ArrayList<Vehicle> Vehicle_list =new ArrayList<Vehicle>();

    static void login(){
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
        if(valid.equals("yes")){

            if(name.equals("Admin")){

            }
            else {
                int where = -1;
                for (int i = 0; i < customers.size(); i++) {
                    Customer temp = customers.get(i);

                    if (temp.userName.equals(name)) {
                        where = i;
                    }
                }
                s.socket_write(customers.get(where));
            }

        }

    }
    static void update(){
        Vehicle V = Pqueue.poll();
        if(Pqueue.size()==0){
            s.socket_write("Empty");

        }
        s.socket_write("Done");
        int where=-1;
        for(int i=0;i<customers.size();i++){
            Customer temp=customers.get(i);

            if(temp.userName.equals(V.owner_name)){
                where=i;
            }
        }

        Customer S = customers.get(where);
        for(int i=0;i<S.Vehicles.size();i++){
            if(S.Vehicles.get(i).number==(V.number)) {
                S.Vehicles.get(i).status="DONE";
            }

        }
        customers.set(where,S);
    }
    static void signup(){
        Customer c=(Customer)s.socket_read();
        customers.add(c);
        passwords.put(c.userName,c.userPassword);
    }
    static void viewlist(){
        s.socket_write(Pqueue);
    }
    static void addvehicle(){
        Vehicle v =(Vehicle)s.socket_read();
        Pqueue.add(v);
        Vehicle_list.add(v);
        int where=-1;
        for(int i=0;i<customers.size();i++){
            Customer temp=customers.get(i);

            if(temp.userName.equals(v.owner_name)){
                where=i;
            }
        }
        Customer temp =customers.get(where);
        temp.Vehicles.add(v);
        customers.set(where,temp);


    }
    static void disveh(){
        String name;
        name=(String)s.socket_read();
        int where=-1;
        for(int i=0;i<customers.size();i++){
            Customer temp=customers.get(i);

            if(temp.userName.equals(name)){
                where=i;
            }
        }
        s.socket_write(customers.get(where).Vehicles);
    }
    public static void main(String args[]) {

        admin = new Admin("admin", "admin");
        passwords.put("Admin","Admin");


        while (true) {
            s = new Server(5000);
            String type = s.socket_read();
            System.out.println(type);
            if(type.equals("signup")){
                signup();
            }
            else if(type.equals("login")){
                login();
            }
            else if(type.equals("viewlist")){
                viewlist();
            }
            else if(type.equals("update")){
                update();
            }
            else if(type.equals("addvehicle")){
                addvehicle();
            }
            else if(type.equals("vedhdis")){
                disveh();
            }

            s.close();

        }

    }
}
