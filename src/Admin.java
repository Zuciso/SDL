import java.util.PriorityQueue;
import java.util.Scanner;

public class Admin {
    static Scanner me = new Scanner(System.in);
    String username;
    String pass;

    Admin(String s, String p) {
        this.username = s;
        this.pass = p;

    }
    static  void view(){
        Client cli = new Client("localhost",5000);
        cli.socket_write("viewlist");
        PriorityQueue<Vehicle> Pqueue =  cli.socket_read();

        Integer z=1;
        for(Vehicle i:Pqueue){
            System.out.println("----------------------");
            System.out.println("Priority no:"+ z);
            i.Display();
            System.out.println("----------------------");
            z++;
        }
    }
    static void update(){
        Client cli= new Client("localhost",5000);
        cli.socket_write("update");
        String s= (String)cli.socket_read();
        System.out.println(s);
    }
    static void info(){

        System.out.println("1)Number\n2)Model\n");
        int c;
        c=me.nextInt();
        if(c==1){
            System.out.println("Number: ");
            Integer co;
            co=me.nextInt();
            Service.getVehicle(co);
        }
        else{
            System.out.println("Model: ");
            String co;
            co= me.next();
            Service.getVehicle(co);

        }

    }
    static void menu(){

            int admin_choice;
            do {

                System.out.println("Enter : \n1.View the list\n2.Update the Status\n3.Vehicle Info\n4.GO BACK");
                 admin_choice = me.nextInt();
                switch (admin_choice) {
                    case 1:
                        view();
                        break;

                    case 2:
                        update();
                        break;
                    case 3:
                        info();
                        break;

                    default:
                        admin_choice = 0;
                }
            }while(admin_choice!=0);


    }


}
