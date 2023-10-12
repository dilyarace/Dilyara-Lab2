package observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

// The Subject interface defines methods for registering, unregistering, and notifying observers.
interface Subject {
    void register(Observer obj);
    void unregister(Observer obj);
    void notifyObservers();
}

// The `DeliveryData` class is a concrete implementation of the Subject interface.
class DeliveryData implements Subject {
    private List<Observer> observers;
    private String location;

    public DeliveryData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (Observer obj : observers) {
            obj.update(location);
        }
    }

    public void locationChanged() {
        this.location = getLocation();
        notifyObservers(); // Notify all registered observers about the location change.
    }

    public String getLocation() {
        return "YPlace"; // Simulated location.
    }
}

// The Observer interface declares an `update` method that concrete observers must implement.
interface Observer {
    void update(String location);
}

// Concrete observer - Seller.
class Seller implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Notification at Seller - Current Location: " + location);
    }
}

// Concrete observer - User.
class User implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Notification at User - Current Location: " + location);
    }
}

// Concrete observer - Delivery Warehouse Center.
class DeliveryWarehouseCenter implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Notification at Warehouse - Current Location: " + location);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        DeliveryData topic = new DeliveryData();

        Observer obj1 = new Seller();
        Observer obj2 = new User();
        Observer obj3 = new DeliveryWarehouseCenter();

        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        topic.locationChanged(); // Simulate a location change event.
        topic.unregister(obj3); // Unregister the Warehouse Center observer.

        System.out.println();
        topic.locationChanged(); // Simulate another location change event.
    }
}
