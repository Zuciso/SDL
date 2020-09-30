import java.io.Serializable;
import java.util.Comparator;

class The_Comparator implements Comparator<Vehicle> , Serializable {
    public int compare(Vehicle v1, Vehicle v2)
    {

        return v1.priority-v2.priority;

    }
}