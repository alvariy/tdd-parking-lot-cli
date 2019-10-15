package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    public int getCapacity() {
        return capacity;
    }

    private int capacity;

    private Map<ParkingTicket, Car> cars = new HashMap<>();

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableParkingPosition() {
        return capacity - cars.size();
    }

    public ParkingTicket addCar(Car car) {

        if(getAvailableParkingPosition() == 0)
        {
            return null;
        }
        ParkingTicket ticket = new ParkingTicket();
        cars.put(ticket,car);
        return ticket;

    }

    public Car removeCar(ParkingTicket ticket) {

        Car car = cars.get(ticket);
        cars.remove(ticket);
        return car;
    }
}
