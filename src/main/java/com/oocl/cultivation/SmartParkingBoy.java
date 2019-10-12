package com.oocl.cultivation;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(ParkingLot parkingLot, ParkingLot parkingLot2) {
        super(parkingLot, parkingLot2);
    }

    @Override
    public ParkingTicket park(Car car) {

        ParkingTicket ticket;
        if(parkingLot.getAvailableParkingPosition() < parkingLot2.getAvailableParkingPosition())
        {
            ticket = parkingLot2.addCar(car);
        }
        else
        {
            ticket = parkingLot.addCar(car);
        }

        return ticket;
    }
}
