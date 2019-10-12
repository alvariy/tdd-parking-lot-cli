package com.oocl.cultivation;

public class SuperSmartParkingBoy extends ParkingBoy{

    public SuperSmartParkingBoy(ParkingLot parkingLot, ParkingLot parkingLot2) {
        super(parkingLot, parkingLot2);
    }

    @Override
    public ParkingTicket park(Car car) {

        ParkingTicket ticket;

        if((Double.parseDouble(Integer.toString(parkingLot.getAvailableParkingPosition()))/Double.parseDouble(Integer.toString(parkingLot.getCapacity())))
                > (Double.parseDouble(Integer.toString(parkingLot2.getAvailableParkingPosition()))/Double.parseDouble(Integer.toString(parkingLot2.getCapacity()))))
        {
            ticket = parkingLot.addCar(car);
        }
        else
        {
            ticket = parkingLot2.addCar(car);
        }

        return ticket;
    }
}
