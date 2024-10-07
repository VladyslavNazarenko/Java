package Hw5;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Car {
    protected String model;
    protected double price;
    protected double fuelConsumption;
    protected int maxSpeed;

    public Car(String model, double price, double fuelConsumption, int maxSpeed) {
        this.model = model;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
    }

    public double getPrice() {return price;}
    public double getFuelConsumption() {return fuelConsumption;}
    public int getMaxSpeed() {return maxSpeed;}

    @Override
    public String toString() {
        return "Model: " + model + ", price: " + price + ", fuel consumption: " + fuelConsumption
        		+ " l/100 km, max speed: " + maxSpeed + " km/h";
    }
}

class Sedan extends Car {
    public Sedan(String model, double price, double fuelConsumption, int maxSpeed) {
        super(model, price, fuelConsumption, maxSpeed);
    }
}

class Crossover extends Car {
    public Crossover(String model, double price, double fuelConsumption, int maxSpeed) {
        super(model, price, fuelConsumption, maxSpeed);
    }
}

class SportsCar extends Car {
    public SportsCar(String model, double price, double fuelConsumption, int maxSpeed) {
        super(model, price, fuelConsumption, maxSpeed);
    }
}

class TaxiPark {
    private List<Car> cars;
    public TaxiPark() {cars = new ArrayList<>();}
    
    public void addCar(Car car) {cars.add(car);}

    public double taxiParkTotalCost() {
        double totalCost = 0;
        for (Car car : cars) {
            totalCost += car.getPrice();
        }
        return totalCost;
    }

    public void sortCarsByFuelConsumption() {
        cars.sort(Comparator.comparingDouble(Car::getFuelConsumption));
    }

    public List<Car> findBySpeedRange(int minSpeed, int maxSpeed) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMaxSpeed() >= minSpeed && car.getMaxSpeed() <= maxSpeed) {
                result.add(car);
            }
        }
        return result;
    }

    public void carList() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}

public class TaxiParkMain {
    public static void main(String[] args) {
        TaxiPark taxiPark = new TaxiPark();

        taxiPark.addCar(new Sedan("Toyota Prius", 30000, 4.0, 180));
        taxiPark.addCar(new Crossover("Hyundai Santa Fe", 60000, 8.5, 220));
        taxiPark.addCar(new SportsCar("Dodge Challenger", 110000, 10.5, 280));
        taxiPark.addCar(new Sedan("Honda Accord", 25000, 7.5, 220));
        taxiPark.addCar(new Sedan("ZAZ 968", 400, 7.0, 115));

        System.out.println("Total cost: " + taxiPark.taxiParkTotalCost() + " $");

        System.out.println("\nSorted by fuel consumption:");
        taxiPark.sortCarsByFuelConsumption();
        taxiPark.carList();

        System.out.println("\nSorted by speed range 170 - 230 km/h:");
        List<Car> carsInRange = taxiPark.findBySpeedRange(170, 230);
        for (Car car : carsInRange) {
            System.out.println(car);
        }
    }
}
