import java.util.Comparator;

class The_Comparator implements Comparator<Vehicle> {
    public int compare(Vehicle v1, Vehicle v2)
    {

        return v1.priority-v2.priority;

    }
}