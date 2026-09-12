public class Main {
// Question 2: Vehicle hierarchy System
    // Interface
    interface ElectricVehicle {
        void chargeBattery();
        int batteryPercentage();
    }

    // Abstract Class
    static abstract class Vehicle {
        protected String brand;
        protected String model;
        protected int year;

        public Vehicle(String brand, String model, int year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
        }

        public abstract void startEngine();

        public void displayInfo() {
            System.out.println("Vehicle: " + brand + " " + model + " (" + year + ")");
        }
    }

    // Car Class
    static class Car extends Vehicle {
        private int numberOfDoors;

        public Car(String brand, String model, int year, int numberOfDoors) {
            super(brand, model, year);
            this.numberOfDoors = numberOfDoors;
        }

        @Override
        public void startEngine() {
            System.out.println("Car engine started with key");
        }
    }

    // ElectricCar Class
    static class ElectricCar extends Car implements ElectricVehicle {
        private int batteryLevel;

        public ElectricCar(String brand, String model, int year,
                           int numberOfDoors, int batteryLevel) {
            super(brand, model, year, numberOfDoors);
            this.batteryLevel = batteryLevel;
        }

        @Override
        public void startEngine() {
            System.out.println("Electric car started silently");
        }

        @Override
        public void chargeBattery() {
            batteryLevel = 100;
        }

        @Override
        public int batteryPercentage() {
            return batteryLevel;
        }
    }

    // Motorcycle Class
    static class Motorcycle extends Vehicle {
        private boolean hasSidecar;

        public Motorcycle(String brand, String model, int year, boolean hasSidecar) {
            super(brand, model, year);
            this.hasSidecar = hasSidecar;
        }

        @Override
        public void startEngine() {
            System.out.println("Motorcycle engine started with kick");
        }
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car("Toyota", "Camry", 2020, 4),
                new ElectricCar("Tesla", "Model 3", 2022, 4, 75),
                new Motorcycle("Harley", "Davidson", 2021, false)
        };

        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
            vehicle.startEngine();

            if (vehicle instanceof ElectricCar) {
                ElectricCar ec = (ElectricCar) vehicle;
                System.out.println("Battery level: "
                        + ec.batteryPercentage() + "%");
            }
            System.out.println();
        }
    }
}