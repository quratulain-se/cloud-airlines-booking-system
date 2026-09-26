package backend;

import java.util.ArrayList;

public class FlightsData {

    public static ArrayList<Flight> flights = new ArrayList<>();

    static {

        // 1. New York → London
        flights.add(new Flight(
            "AB-101",
            "London",
            "New York",
            "08:30 AM",
            "08:45 PM",
            650
        ));

        // 2. London → Berlin
        flights.add(new Flight(
            "AB-102",
            "London",
            "Berlin",
            "10:15 AM",
            "01:20 PM",
            280
        ));

        // 3. Berlin → Munich
        flights.add(new Flight(
            "AB-103",
            "London",
            "Zurich",
            "02:30 PM",
            "03:40 PM",
            180
        ));

        // 4. Miami → New York
        flights.add(new Flight(
            "AB-104",
            "New York",
            "London",
            "09:00 AM",
            "12:15 PM",
            220
        ));

        // 5. Chicago → Atlanta
        flights.add(new Flight(
            "AB-105",
            "New York",
            "Berlin",
            "11:45 AM",
            "02:35 PM",
            190
        ));

        // 6. London → New York
        flights.add(new Flight(
            "AB-106",
            "New York",
            "Zurich",
            "04:00 PM",
            "07:15 PM",
            620
        ));

        // 7. Dallas → San Francisco
        flights.add(new Flight(
            "AB-107",
            "Berlin",
            "New York",
            "07:30 AM",
            "09:15 AM",
            240
        ));

        // 8. Munich → London
        flights.add(new Flight(
            "AB-108",
            "Berlin",
            "London",
            "01:00 PM",
            "02:00 PM",
            300
        ));

        // 9. Los Angeles → New York
        flights.add(new Flight(
            "AB-109",
            "Berlin",
            "Zurich",
            "06:45 AM",
            "03:15 PM",
            420
        ));

        // 10. San Francisco → Los Angeles
        flights.add(new Flight(
            "AB-110",
            "Zurich",
            "London",
            "05:30 PM",
            "07:00 PM",
            160
        ));

        // 11. Zurich → New York
        flights.add(new Flight(
            "AB-111",
            "Zurich",
            "New York",
            "06:15 PM",
            "02:30 AM",
            310
        
        ));

        // 12. Zurich → Berlin
        flights.add(new Flight(
            "AB-112",
            "Zurich",
            "Berlin",
            "07:00 PM",
            "08:40 AM",
            110
        
        ));
    }
}