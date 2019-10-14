package com.oocl.cultivation;

public class ParkingBoy {

    public ParkingLot parkingLot;
    public ParkingLot secondParkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot, ParkingLot secondParkingLot) {
        this.parkingLot = parkingLot;
        this.secondParkingLot = secondParkingLot;
    }
    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {

        ParkingTicket parkingTicket;

        parkingTicket = parkingLot.addCar(car);

        if(parkingTicket == null && secondParkingLot != null)
        {
            parkingTicket = secondParkingLot.addCar(car);

                if(parkingTicket == null)
                {
                    lastErrorMessage = "Not enough position.";
                }
        }
        else
        {
            lastErrorMessage = "Not enough position.";
        }

        return parkingTicket;
    }

    public Car fetch(ParkingTicket ticket) {

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
