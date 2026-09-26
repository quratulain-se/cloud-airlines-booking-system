package backend;

import java.util.ArrayList;

public class FlightSearch {

    public static ArrayList<Flight> searchFlights(String from, String to) {

        ArrayList<Flight> results = new ArrayList<>();

        for (Flight flight : FlightsData.flights) {

            if (flight.getFrom().equalsIgnoreCase(from)
                    && flight.getTo().equalsIgnoreCase(to)) {

                results.add(flight);
            }
        }

        return results;
    }
}
