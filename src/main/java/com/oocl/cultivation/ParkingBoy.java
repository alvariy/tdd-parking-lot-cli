package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        // TODO: Please implement the method

        ParkingTicket parkingTicket = parkingLot.addCar(car);
        if(parkingTicket == null)
        {
            lastErrorMessage = "Not enough position.";
        }

        return parkingTicket;
    }

    public Car fetch(ParkingTicket ticket) {
        // TODO: Please implement the method

        Car car = parkingLot.removeCar(ticket);
        if(ticket == null)
        {
            lastErrorMessage = "Please provide your parking ticket.";
        }
        else if(car == null)
        {
            lastErrorMessage = "Unrecognized parking ticket.";
        }

        return car;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
