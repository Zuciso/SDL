
import java.io.Serializable;
import java.util.*;
import java.lang.*;



public class Service implements Serializable {

      static Scanner me = new Scanner(System.in);
      static PriorityQueue<Vehicle>Pqueue = new PriorityQueue<Vehicle>(new The_Comparator());

      static HashSet<String> username =new HashSet<String>();
      static ArrayList<Vehicle> Vehicle_list =new ArrayList<Vehicle>();
      static ArrayList<Customer> Customers = new ArrayList<Customer>();
    //Maps user -> paswords



    static <T> void getVehicle(T element)
    {
        int f=0;
        for(Vehicle p : Vehicle_list)
        {
            if(p.equals(element)) {
                p.Display();
                f=1;
            }
        }
        if(f==0){
            System.out.println("No such Vehicle");
        }

    }
    static void signup(){
        Customer  c = new Customer();
        Client cli = new Client("localhost", 5000);
        cli.socket_write("signup");
        Customers.add(c);
        cli.socket_write(c);
        System.out.println("User registered successfully ");

    }
    static void login(){
        System.out.println("Username : ");
        String name,pass;
        name = me.next();
        System.out.println("Password : ");
        pass = me.next();
        Client c = new Client("localhost", 5000);
        c.socket_write("login");
        c.socket_write(name);
        c.socket_write(pass);
        String valid=(String)c.socket_read();

        if(valid.equals("yes"))
        {
            System.out.println("Welcome back,");
            if(name.equals("Admin"))
            {
                Admin.menu();
            }
            else
            {
                int where=-1;
                for(int i=0;i<Customers.size();i++){
                    Customer temp=Customers.get(i);

                    if(temp.userName.equals(name)){
                        where=i;
                    }
                }
                Customers.get(where).menu();
            }

        }
        else
        {
            System.out.println("---------------------------------------------------------------");
            System.out.println("Incorrect username or  password :( " );
            System.out.println("---------------------------------------------------------------");

        }


    }
    static void menu(){
        int op1,op2;
        do {
            System.out.println("ENTER YOUR CHOICE: ");
            System.out.println("1.SIGN UP \n2.LOGIN IN\n3.EXIT");
            System.out.print(" Option : ");
            op1=me.nextInt();
            op2=1;
            System.out.println();
            switch (op1) {
                case 1:
                    signup();
                    break;
                case 2:
                    login();
                    break;
                default:
                    op2=0;
                    break;
            }



        }while(op2!=0);
    }


    public static void main(String[] args) {

        username.add("Admin");
        menu();


    }
}






/* Output
ENTER YOUR CHOICE:
1.SIGN UP
2.LOGIN IN
3.EXIT
1
User Name
bhavik
Password
1234
Phone Number
9028535149
Address
Maheshnagar
MemberShip type
1.PLATINUM
2.GOLD
3.SILVER
1
User registered successfully
ENTER YOUR CHOICE:
1.SIGN UP
2.LOGIN IN
3.EXIT
1
User Name
aniket
Password
aniket
Phone Number
9843753759
Address
pune
MemberShip type
1.PLATINUM
2.GOLD
3.SILVER
3
User registered successfully
ENTER YOUR CHOICE:
1.SIGN UP
2.LOGIN IN
3.EXIT
2
Please Enter your Name and Password
aniket
aniket
Welcome back,
Enter
1.Add vehicle to service
2.Check status of all your vehicles
3.GO BACK
1
Enter Vehicle Number
9879
Enter Vehicle Model
A
Enter
1.Add vehicle to service
2.Check status of all your vehicles
3.GO BACK
2
-------------------------
Vehicle Number 9879
Vehicle Model A
Owners Name aniket
Vehicle Priority 3
Status PENDING
-------------------------
Enter
1.Add vehicle to service
2.Check status of all your vehicles
3.GO BACK
3
ENTER YOUR CHOICE:
1.SIGN UP
2.LOGIN IN
3.EXIT
2
Please Enter your Name and Password
bhavik
1234
Welcome back,
Enter
1.Add vehicle to service
2.Check status of all your vehicles
3.GO BACK
1
Enter Vehicle Number
9999
Enter Vehicle Model
A

Enter
1.Add vehicle to service
2.Check status of all your vehicles
3.GO BACK
2
-------------------------
Vehicle Number 9999
Vehicle Model A
Owners Name bhavik
Vehicle Priority 1
Status PENDING
-------------------------
Enter
1.Add vehicle to service
2.Check status of all your vehicles
3.GO BACK
3
ENTER YOUR CHOICE:
1.SIGN UP
2.LOGIN IN
3.EXIT
2
Please Enter your Name and Password
af
fas
---------------------------------------------------------------
Incorrect username or  password :(
---------------------------------------------------------------
ENTER YOUR CHOICE:
1.SIGN UP
2.LOGIN IN
3.EXIT
2
Please Enter your Name and Password
admin
admin
---------------------------------------------------------------
Incorrect username or  password :(
---------------------------------------------------------------
ENTER YOUR CHOICE:
1.SIGN UP
2.LOGIN IN
3.EXIT
2
Please Enter your Name and Password
Admin
Admin
Welcome back,
Enter :
1.View the list
2.Update the Status
3.Vehicle Info
4.GO BACK
1
----------------------
Priority no:1
Vehicle Number 9999
Vehicle Model A
Owner Name bhavik
----------------------
----------------------
Priority no:2
Vehicle Number 9879
Vehicle Model A
Owner Name aniket
----------------------
Enter :
1.View the list
2.Update the Status
3.Vehicle Info
4.GO BACK
2
Enter :
1.View the list
2.Update the Status
3.Vehicle Info
4.GO BACK
1
----------------------
Priority no:1
Vehicle Number 9879
Vehicle Model A
Owner Name aniket
----------------------
Enter :
1.View the list
2.Update the Status
3.Vehicle Info
4.GO BACK
2
NO MORE WORK
Enter :
1.View the list
2.Update the Status
3.Vehicle Info
4.GO BACK
1
Enter :
1.View the list
2.Update the Status
3.Vehicle Info
4.GO BACK
3
1)Number
2)Model

2
Model:
A
Vehicle Number 9879
Vehicle Model A
Owner Name aniket
Vehicle Number 9999
Vehicle Model A
Owner Name bhavik
Enter :
1.View the list
2.Update the Status
3.Vehicle Info
4.GO BACK
4
ENTER YOUR CHOICE:
1.SIGN UP
2.LOGIN IN
3.EXIT
2
Please Enter your Name and Password
bhavik
1234
Welcome back,
Enter
1.Add vehicle to service
2.Check status of all your vehicles
3.GO BACK
2
-------------------------
Vehicle Number 9999
Vehicle Model A
Owners Name bhavik
Vehicle Priority 1
Status DONE
-------------------------
Enter
1.Add vehicle to service
2.Check status of all your vehicles
3.GO BACK
3
ENTER YOUR CHOICE:
1.SIGN UP
2.LOGIN IN
3.EXIT
3

Process finished with exit code 0
 */