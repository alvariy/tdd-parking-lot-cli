package com.oocl.cultivation;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(ParkingLot parkingLot, ParkingLot secondParkingLot) {
        super(parkingLot, secondParkingLot);
    }

    @Override
    public ParkingTicket park(Car car) {

        ParkingTicket ticket;

        if(checkParkingSpace())
        {
            ticket = getSecondParkingLot().addCar(car);
        }
        else
        {
            ticket = getParkingLot().addCar(car);
        }

        return ticket;
    }

    private boolean checkParkingSpace() {
        return getParkingLot().getAvailableParkingPosition() < getSecondParkingLot().getAvailableParkingPosition();
    }
}
