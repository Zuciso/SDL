import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.net.*;
import java.io.*;
import java.util.*;

public class ClientHandler extends Thread{

    Socket socket = null;
    ObjectInputStream instream = null;
    ObjectOutputStream outstream = null;
    static Server s;
    static Admin admin;
    static ArrayList<Customer> customers = new ArrayList<Customer>();
    static HashMap<String,String> passwords = new HashMap<String,String>();
    static PriorityQueue<Vehicle> Pqueue = new PriorityQueue<Vehicle>(new The_Comparator());
    static ArrayList<Vehicle> Vehicle_list =new ArrayList<Vehicle>();

    public ClientHandler(Socket s) {
        try {
            this.socket = s;
            outstream = new ObjectOutputStream(socket.getOutputStream());
            instream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException io) {
            System.out.println(io);
        }

    }
     void login(){
        String name,pass;
        name=(String)socket_read();
        pass=(String)socket_read();
        System.out.println(name);
        String valid;
        if(pass.equals(passwords.get(name))){
            valid="yes";

        }
        else{
            valid="no";
        }
        socket_write(valid);
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
                socket_write(customers.get(where));
            }

        }

    }
     void update(){
        Vehicle V = Pqueue.poll();
        if(Pqueue.size()==0){
            socket_write("Empty");

        }
        socket_write("Done");
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
     void signup(){
        Customer c=(Customer)socket_read();
        customers.add(c);
        passwords.put(c.userName,c.userPassword);
    }
     void viewlist(){
        socket_write(Pqueue);
    }
     void addvehicle(){
        Vehicle v =(Vehicle)socket_read();
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
     void disveh(){
        String name;
        name=(String)socket_read();
        int where=-1;
        for(int i=0;i<customers.size();i++){
            Customer temp=customers.get(i);

            if(temp.userName.equals(name)){
                where=i;
            }
        }
        socket_write(customers.get(where).Vehicles);
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

    public void run() {
        System.out.println(Thread.currentThread().getName());
        String type = socket_read();
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

        close();
        Thread.currentThread().interrupt();

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

    public static void main(String args[]) {

        admin = new Admin("admin", "admin");
        passwords.put("Admin","Admin");
        Server s = new Server(5000);
        s.createServer();

    }
}
