package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
    @Test
    void parkingBoy_should_park_the_car_and_return_a_ticket() {

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car =  new Car();

        ParkingTicket ticket = parkingBoy.park(car);

        assertNotNull(ticket);
    }

    @Test
    void parkingBoy_should_fetch_the_car_using_ticket() {

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        ParkingTicket ticket = parkingBoy.park(car);
        Car car1 = parkingBoy.fetch(ticket);

        assertNotNull(car1);
    }

    @Test
    void should_park_two_cars_in_parking_lot() {

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Car car1 = new Car();
        int expectedValue = 8;

        parkingBoy.park(car);
        parkingBoy.park(car1);
        int actualValue = parkingLot.getAvailableParkingPosition();

        assertEquals(expectedValue, actualValue);

    }

    @Test
    void should_fetch_the_car_according_to_ticket() {

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car expectedCar = new Car();

        ParkingTicket ticket = parkingBoy.park(expectedCar);
        Car actualCar = parkingBoy.fetch(ticket);

        assertEquals(expectedCar, actualCar);

    }

    @Test
    void should_not_fetch_car_if_it_is_an_invalid_ticket() {

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket parkingTicket = new ParkingTicket();

        Car actualValue = parkingBoy.fetch(parkingTicket);

        assertEquals(null, actualValue);

    }

    @Test
    void should_not_fetch_car_if_no_ticket_was_given() {

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        Car actualValue = parkingBoy.fetch(null);

        assertEquals(null, actualValue);
    }

    @Test
    void should_not_fetch_car_if_the_ticket_has_already_been_used() {

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car dummyCar = new Car();

        ParkingTicket ticket = parkingBoy.park(dummyCar);
        parkingBoy.fetch(ticket);
        Car actualValue = parkingBoy.fetch(ticket);


        assertEquals(null, actualValue);
    }

    @Test
    void should_not_be_able_to_give_ticket_if_no_available_slots_in_the_parking_lot() {

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        for(int i = 1 ; i<= parkingLot.getCapacity(); i++)
        {
            Car car = new Car();
            parkingBoy.park(car);
        }

        ParkingTicket actualValue = parkingBoy.park(new Car());
        assertEquals(null, actualValue);
    }

    @Test
    void should_get_message_if_no_car_was_fetched() {

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket parkingTicket = new ParkingTicket();

        parkingBoy.fetch(parkingTicket);
        String actualErrorMessage = parkingBoy.getLastErrorMessage();

        assertEquals("Unrecognized parking ticket.", actualErrorMessage);

    }

    @Test
    void should_get_message_if_no_car_was_fetched_and_ticket_is_null() {

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        parkingBoy.fetch(null);
        String actualErrorMessage = parkingBoy.getLastErrorMessage();

        assertEquals("Please provide your parking ticket.", actualErrorMessage);

    }

    @Test
    void should_get_message_not_enough_position_if_the_parking_boy_parked_in_a_full_parking_lot() {

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        for(int i = 0; i <= parkingLot.getCapacity() ; i++)
        {
            Car car = new Car();
            parkingBoy.park(car);
        }

        String actualErrorMessage = parkingBoy.getLastErrorMessage();

        assertEquals("Not enough position.", actualErrorMessage);
    }

    @Test
    void should_park_in_the_second_parking_lot_if_the_first_one_is_full() {

        ParkingLot parkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot, secondParkingLot);

        for(int i = 0; i <= parkingLot.getCapacity() ; i++)
        {
            Car car = new Car();
            parkingBoy.park(car);
        }

        int expectedCarSize = 9;
        int actualCarSize = secondParkingLot.getAvailableParkingPosition();

        assertEquals(expectedCarSize, actualCarSize);
    }

    @Test
    void smart_parking_boy_should_park_in_the_most_empty_parking_lot() {

        ParkingLot parkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingBoy secondParkingBoy = new ParkingBoy(secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot, secondParkingLot);

        for(int i = 1; i <= 3 ; i++)
        {
            Car car = new Car();
            parkingBoy.park(car);
        }
        for(int i = 1; i <= 2 ; i++)
        {
            Car car = new Car();
            secondParkingBoy.park(car);
        }

        Car nissan = new Car();
        smartParkingBoy.park(nissan);

        int actualCarSize = secondParkingLot.getAvailableParkingPosition();


        assertEquals(7, actualCarSize);
    }

    @Test
    void super_saiyan_parking_boy_should_park_car_with_the_highest_ratio_parking_lot() {

        ParkingLot parkingLot = new ParkingLot(10);
        ParkingLot parkingLot1 = new ParkingLot(20);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot,parkingLot1);

        Car car = new Car();
        superSmartParkingBoy.park(car);

        int actualCarSize = parkingLot1.getAvailableParkingPosition();

        assertEquals(19, actualCarSize);
    }
}
