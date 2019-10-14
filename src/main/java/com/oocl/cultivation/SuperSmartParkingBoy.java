package com.oocl.cultivation;

public class SuperSmartParkingBoy extends ParkingBoy{

    public SuperSmartParkingBoy(ParkingLot parkingLot, ParkingLot secondParkingLot) {
        super(parkingLot, secondParkingLot);
    }

    @Override
    public ParkingTicket park(Car car) {

        ParkingTicket ticket;

        if((Double.parseDouble(Integer.toString(parkingLot.getAvailableParkingPosition()))/Double.parseDouble(Integer.toString(parkingLot.getCapacity())))
                > (Double.parseDouble(Integer.toString(secondParkingLot.getAvailableParkingPosition()))/Double.parseDouble(Integer.toString(secondParkingLot.getCapacity()))))
        {
            ticket = parkingLot.addCar(car);
        }
        else
        {
            ticket = secondParkingLot.addCar(car);
        }

        return ticket;
    }
}
