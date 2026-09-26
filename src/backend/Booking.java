package backend;

public class Booking {
     String passengerName;
     String dob;
     Flight flight;
     String paymentMethod;
     boolean oneWay;
     String bookingId;

    public Booking(String passengerName, String dob, Flight flight, String paymentMethod, boolean oneWay) {
        this.passengerName = passengerName;
        this.dob = dob;
        this.flight = flight;
        this.paymentMethod = paymentMethod;
        this.oneWay = oneWay;
        this.bookingId = "CA-" + (100000 + (int) (Math.random() * 900000));
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getDob() {
        return dob;
    }

    public Flight getFlight() {
        return flight;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isOneWay() {
        return oneWay;
    }

    public String getBookingId() {
        return bookingId;
    }

    public double getTotalPrice() {
        return oneWay ? flight.getPrice() : flight.getPrice() * 2;
    }

    @Override
    public String toString() {
        return passengerName + " (" + dob + ") - " + flight.getFlightNumber() + " - " + paymentMethod;
    }
}