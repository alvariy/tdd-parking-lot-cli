package com.oocl.cultivation;

public class SuperSmartParkingBoy extends ParkingBoy{

    public SuperSmartParkingBoy(ParkingLot parkingLot, ParkingLot secondParkingLot) {
        super(parkingLot, secondParkingLot);
    }

    @Override
    public ParkingTicket park(Car car) {

        ParkingTicket ticket;

        if(hasMoreRatio())
        {
            ticket = getParkingLot().addCar(car);
        }
        else
        {
            ticket = getSecondParkingLot().addCar(car);
        }

        return ticket;
    }

    private boolean hasMoreRatio() {
        return (Double.parseDouble(Integer.toString(getParkingLot().getAvailableParkingPosition()))/Double.parseDouble(Integer.toString(getParkingLot().getCapacity())))
                > (Double.parseDouble(Integer.toString(getSecondParkingLot().getAvailableParkingPosition()))/Double.parseDouble(Integer.toString(getSecondParkingLot().getCapacity())));
    }


}
