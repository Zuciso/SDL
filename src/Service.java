
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.*;
import java.lang.*;



public class Service implements Serializable {

      static Scanner me = new Scanner(System.in);

      static HashSet<String> username =new HashSet<String>();


    //Maps user -> paswords



    static <T> void getVehicle(T element)
    {

        int f=0;
        for(Vehicle p : ClientHandler.Vehicle_list)
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
            if(name.equals("Admin")){
                Admin.menu();
            }
            else{
                Customer cus=(Customer)c.socket_read();
                cus.menu();
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
            new home();
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
        new home();
        menu();


    }
}

class home extends JFrame implements ActionListener {
    JButton b1,b2;
    public home(){

        b1=new JButton("Login");
        b2=new JButton("Signup");
        JPanel ok = new JPanel();
        ok.setLayout(new GridLayout(2,1));
        ok.add(b1);
        ok.add(b2);
        add(ok);
        b1.addActionListener(this);
        b2.addActionListener(this);

        setVisible(true);
        setSize(200,200);
        setLayout(new FlowLayout());
        setLocation(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==b1){
                new Signupgui();
                System.out.println("ok");
                dispose();
            }
            else{
                new Logingui();
                dispose();
            }
    }
}
class Signupgui extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5;
    JButton b1;
    public Signupgui() {

        t1=new JTextField("UserName");
        t2=new JTextField("PassWord");
        t3=new JTextField("Mobile Number");
        t4=new JTextField("Address");
        b1=new JButton("Submit");

        JPanel j = new JPanel();
        j.setLayout(new GridLayout(5,1));
        j.add(t1);
        j.add(t2);
        j.add(t3);
        j.add(t4);
        j.add(b1);
        add(j);
        b1.addActionListener(this);
        setVisible(true);
        setSize(200, 200);
        setLayout(new FlowLayout());
        setLocation(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
class Logingui extends JFrame implements ActionListener{
    JTextField t1,t2;
    JButton b1;
    public Logingui(){
        t1=new JTextField("UserName");
        t2=new JTextField("PassWord");
        b1=new JButton("Submit");

        JPanel j = new JPanel();
        j.setLayout(new GridLayout(3,1));
        j.add(t1);
        j.add(t2);
        j.add(b1);
        add(j);
        setVisible(true);
        b1.addActionListener(this);
        setSize(200, 200);
        setLayout(new FlowLayout());
        setLocation(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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