class Vehicle{
    Integer number;
    String model;
    String owner_name;
    String status;
    Integer priority;


    Vehicle(int vehicle_number,String vehicle_model,String on,int pr)
    {
        status="PENDING";
        number = vehicle_number;
        model =vehicle_model;
        owner_name=on;
        priority=pr;
    }
    void Display(){
        System.out.println("Vehicle Number "+number);
        System.out.println("Vehicle Model "+model);
        System.out.println("Owner Name "+ owner_name);
    }

    @Override
    public boolean equals(Object o)
    {
        if(o == this) return true;
        if(o instanceof Integer)
        {
            if(this.number.equals((Integer)o)) return true;
        }
        if(o instanceof String)
        {
            if(this.model.equals((String)(o))) return true;
        }
        return false;
    }
}