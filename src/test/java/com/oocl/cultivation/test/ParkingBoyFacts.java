package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
    @Test
    void parkingBoy_should_park_the_car_and_return_a_ticket() {

        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car =  new Car();

        //when
        ParkingTicket ticket = parkingBoy.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void parkingBoy_should_fetch_the_car_using_ticket() {

        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket ticket = new ParkingTicket();

        //when
        Car car = parkingBoy.fetch(ticket);

        //then
        assertNotNull(car);
    }

    @Test
    void should_park_two_cars_in_parking_lot() {

        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Car car1 = new Car();

        //when
        parkingBoy.park(car);
        parkingBoy.park(car1);

        //then
        assertEquals(8, parkingLot.getAvailableParkingPosition());

    }

    @Test
    void should_fetch_the_car_according_to_ticket() {

        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car nissan = new Car();

        //when
        ParkingTicket ticket = parkingBoy.park(nissan);
        Car car = parkingBoy.fetch(ticket);

        //then
        assertEquals(nissan, car);

    }

    @Test
    void should_not_fetch_car_if_it_is_an_invalid_ticket() {

        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket parkingTicket = new ParkingTicket();

        //when
        Car car = parkingBoy.fetch(parkingTicket);

        //then
        assertEquals(null, car);

    }

    @Test
    void should_not_fetch_car_if_no_ticket_was_given() {

        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Car car = parkingBoy.fetch(null);

        //then
        assertEquals(null, car);
    }

    @Test
    void should_not_fetch_car_if_the_ticket_has_already_been_used() {

        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car nissan = new Car();

        ParkingTicket ticket = parkingBoy.park(nissan);
        parkingBoy.fetch(ticket);

        //when

        //then
        assertEquals(null, parkingBoy.fetch(ticket));
    }

    @Test
    void should_not_be_able_to_give_ticket_if_no_available_slots_in_the_parking_lot() {

        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);


        //when
        for(int i = 1 ; i<= parkingLot.getCapacity(); i++)
        {
            Car car = new Car();
            parkingBoy.park(car);
        }

        ParkingTicket ticket = parkingBoy.park(new Car());
        System.out.println(parkingLot.getAvailableParkingPosition());
        //then
        assertEquals(null, ticket);
    }
}
