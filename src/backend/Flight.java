package backend;

public class Flight {

    private String flightNumber;
    String from;
    String to;
    private String departureTime;
    private String arrivalTime;
    private double price;

    public Flight(String flightNumber, String from, String to,
                   String departureTime, String arrivalTime, double price) {

        this.flightNumber = flightNumber;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public double getPrice() {
        return price;
    }
}