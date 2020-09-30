import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Customer implements Serializable {
     Service se=new Service();
    static Scanner me = new Scanner(System.in);
    String userName;
    String userPassword;
    long userNumber;
    String userAddress;
    int userType;
    ArrayList<Vehicle> Vehicles = new ArrayList<Vehicle>();
    Customer(String admin_name,String admin_password,long number,String add,int membership)
    {
        userName = admin_name;
        userPassword = admin_password;
        userNumber=number;
        userAddress=add;
        userType=membership;
    }
    Customer(){
        System.out.print("User Name : ");
        userName = me.next();
        while (Service.username.contains(userName)){
            System.out.println("User Name Already taken\nEnter Again");
            userName = me.next();
        }
        Service.username.add(userName);

        System.out.print("Password : ");
        userPassword = me.next();
        System.out.print("Phone Number : ");
        userNumber = me.nextLong();
        System.out.print("Address : ");
        userAddress= me.next();
        System.out.println("MemberShip type \n1.PLATINUM\n2.GOLD\n3.SILVER");
        userType = me.nextInt();
        Service.passwords.put(userName,userPassword);

    }

    void menu()
    {
        int flagOfStudent =1;
        while(flagOfStudent==1)
        {
            System.out.println("Enter \n1.Add vehicle to service\n2.Check status of all your vehicles \n3.GO BACK");
            int choiceOfCustomer = me.nextInt();
            if(choiceOfCustomer==1)
            {
                add_vehicle();

            }
            else if(choiceOfCustomer == 2)
            {
                Display();

            }


            else flagOfStudent=0;
        }
    }
    void add_vehicle()
    {
        String vmodel="";
        Integer vnumber;
        System.out.print("Enter Vehicle Number : ");
        vnumber = me.nextInt();
        System.out.print("Enter Vehicle Model : ");
        vmodel = me.next();
        Vehicle temp = new Vehicle(vnumber,vmodel,userName,userType);
        Service.Pqueue.add(temp);
        Vehicles.add(temp);
        Service.Vehicle_list.add(temp);
    }
    void Display(){
        System.out.println("My Vehicles");
        for(int i=0;i<Vehicles.size();i++){
            System.out.println("-------------------------");
            System.out.println("Vehicle Number " + Vehicles.get(i).number);
            System.out.println("Vehicle Model " + Vehicles.get(i).model);
            System.out.println("Owners Name " + Vehicles.get(i).owner_name);
            System.out.println("Vehicle Priority " + Vehicles.get(i).priority);
            System.out.println("Status " + Vehicles.get(i).status);
            System.out.println("-------------------------");
        }
    }


}