package org.example.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Bus("vehicle1", "bus1"));
        vehicles.add(new Car("vehicle1", "car1"));

        List<Bus> buses = new ArrayList<>();
        buses.add(new Bus("vehicle2", "bus2"));

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("vehicle2", "car2"));

        Print print = new Print();
        List<? extends Vehicle> vehicleList = new ArrayList<>(print.setPrintValues(vehicles));
        List<? extends Vehicle> carsList = print.setPrintValues(cars);
    }
}
