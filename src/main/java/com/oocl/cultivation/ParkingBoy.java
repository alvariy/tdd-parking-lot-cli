package com.oocl.cultivation;

public class ParkingBoy {

    private ParkingLot parkingLot;
    private ParkingLot secondParkingLot;
    private String lastErrorMessage;
    private static final String CONST_NO_POSITION_AVAILABLE = "Not enough position.";
    private static final String CONST_ERROR_PROVIDE_PARKING_TICKET = "Please provide your parking ticket.";
    private static final String CONST_ERROR_INVALID_PARKING_TICKET = "Unrecognized parking ticket.";

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

        if(isParkingTicketNull(parkingTicket) && secondParkingLot != null)
        {
            parkingTicket = secondParkingLot.addCar(car);
                if(isParkingTicketNull(parkingTicket))
                {
                    lastErrorMessage = CONST_NO_POSITION_AVAILABLE;
                }
        }
        else
        {
            lastErrorMessage = CONST_NO_POSITION_AVAILABLE;
        }

        return parkingTicket;
    }

    private boolean isParkingTicketNull(ParkingTicket parkingTicket) {
        return parkingTicket == null;
    }

    public Car fetch(ParkingTicket ticket) {

        Car car = parkingLot.removeCar(ticket);
        if(isParkingTicketNull(ticket))
        {
            lastErrorMessage = CONST_ERROR_PROVIDE_PARKING_TICKET;
        }
        else if(car == null)
        {
            lastErrorMessage = CONST_ERROR_INVALID_PARKING_TICKET;
        }

        return car;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    public ParkingLot getSecondParkingLot() {
        return secondParkingLot;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }
}
