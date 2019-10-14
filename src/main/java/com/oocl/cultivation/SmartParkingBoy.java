package com.oocl.cultivation;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(ParkingLot parkingLot, ParkingLot secondParkingLot) {
        super(parkingLot, secondParkingLot);
    }

    @Override
    public ParkingTicket park(Car car) {

        ParkingTicket ticket;
        if(parkingLot.getAvailableParkingPosition() < secondParkingLot.getAvailableParkingPosition())
        {
            ticket = secondParkingLot.addCar(car);
        }
        else
        {
            ticket = parkingLot.addCar(car);
        }

        return ticket;
    }
}
