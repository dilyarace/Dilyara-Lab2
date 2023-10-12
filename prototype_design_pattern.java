package prototype_design_pattern;

import java.util.ArrayList;
import java.util.List;

// The base class, Vehicle, is made cloneable.
class Vehicle implements Cloneable {
    private List<String> vehicleList;

    public Vehicle() {
        this.vehicleList = new ArrayList<String>();
    }

    public Vehicle(List<String> list) {
        this.vehicleList = list;
    }

    public void insertData() {
        vehicleList.add("Honda Amaze");
        vehicleList.add("Audi A4");
        vehicleList add("Hyundai Creta");
        vehicleList.add("Maruti Baleno");
        vehicleList.add("Renault Duster");
    }

    public List<String> getVehicleList() {
        return this.vehicleList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> tempList = new ArrayList<String>();

        for (String s : this.getVehicleList()) {
            tempList.add(s);
        }

        return new Vehicle(tempList);
    }
}

public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        Vehicle a = new Vehicle();
        a.insertData();

        Vehicle b = (Vehicle) a.clone(); // Clone the Vehicle object.
        List<String> list = b.getVehicleList();
        list.add("Honda New Amaze"); // Modify the cloned list.

        System.out.println(a.getVehicleList()); // Original list is unaffected.
        System.out.println(list); // Cloned list with modifications.

        b.getVehicleList().remove("Audi A4"); // Modify the cloned list further.
        System.out.println(list); // Cloned list after another modification.
        System.out.println(a.getVehicleList()); // Original list is still unchanged.
    }
}
