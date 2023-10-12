package builder_design_pattern;

// Vehicle class with private attributes, representing a complex object
class Vehicle {
    private String engine;
    private int wheel;
    private int airbags;

    public String getEngine() {
        return this.engine;
    }

    public int getWheel() {
        return this.wheel;
    }

    public int getAirbags() {
        return this.airbags;
    }

    // Private constructor that takes a VehicleBuilder
    private Vehicle(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    // Static nested class representing the Builder
    public static class VehicleBuilder {
        private String engine;
        private int wheel;
        private int airbags;

        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        // Build method to create a Vehicle object using the builder
        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        // Create a car using the VehicleBuilder and set airbags
        Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();

        // Create a bike using the VehicleBuilder (no airbags specified)
        Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

        // Print the details of the car
        System.out.println("Car Engine: " + car.getEngine());
        System.out.println("Car Wheels: " + car.getWheel());
        System.out.println("Car Airbags: " + car.getAirbags());

        // Print the details of the bike
        System.out.println("Bike Engine: " + bike.getEngine());
        System.out.println("Bike Wheels: " + bike.getWheel());
        System.out.println("Bike Airbags: " + bike.getAirbags());
    }
}
