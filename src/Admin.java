import java.util.Scanner;

public class Admin {
    static Scanner me = new Scanner(System.in);

    static  void view(){
        Integer z=1;
        for(Vehicle i:Service.Pqueue){
            System.out.println("----------------------");
            System.out.println("Priority no:"+ z);
            i.Display();
            System.out.println("----------------------");
            z++;
        }
    }
    static void update(){
        Vehicle V = Service.Pqueue.poll();
        if(Service.Pqueue.size()==0){
            System.out.println("NO MORE WORK");

        }
        int where=-1;
        for(int i=0;i<Service.Customers.size();i++){
            Customer temp=Service.Customers.get(i);

            if(temp.userName.equals(V.owner_name)){
                where=i;
            }
        }

        Customer S = Service.Customers.get(where);
        for(int i=0;i<S.Vehicles.size();i++){
            if(S.Vehicles.get(i).number==(V.number)) {
                S.Vehicles.get(i).status="DONE";
            }

        }
        //S.Vehicles=temp;
        Service.Customers.set(where,S);
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
