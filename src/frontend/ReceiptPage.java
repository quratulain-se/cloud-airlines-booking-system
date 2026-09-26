
package frontend;

import backend.Booking;
import backend.Flight;
import javax.swing.*;
import java.awt.*;

public class ReceiptPage extends JFrame {

    public ReceiptPage(Booking booking) {
        setTitle("E-Ticket");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        UItheme.GradientPanel panel = new UItheme.GradientPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 900, 650);

        JPanel header = new JPanel(null);
        header.setBackground(new Color(8, 14, 28, 190));
        header.setBounds(0, 0, 900, 90);
        panel.add(header);

        JLabel logo = new JLabel("Cloud AirLines");
        logo.setBounds(30, 18, 300, 50);
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Serif", Font.BOLD, 28));
        header.add(logo);

        JLabel slogan = new JLabel("Safe | Reliable | On Time");
        slogan.setBounds(620, 28, 350, 40);
        slogan.setForeground(new Color(200, 220, 255));
        slogan.setFont(new Font("Arial", Font.PLAIN, 15));
        header.add(slogan);

        JLabel heading = new JLabel("E-Ticket / Receipt");
        heading.setBounds(0, 110, 900, 45);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Century Gothic", Font.BOLD, 28));
        panel.add(heading);

        UItheme.RoundedPanel card = new UItheme.RoundedPanel(25, new Color(255, 255, 255, 35));
        card.setLayout(null);
        card.setBounds(175, 150, 550, 400);
        card.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 80), 1));
        panel.add(card);

        if (booking == null) {
            JLabel noBooking = new JLabel("No booking found.");
            noBooking.setBounds(0, 170, 550, 40);
            noBooking.setHorizontalAlignment(SwingConstants.CENTER);
            noBooking.setForeground(Color.WHITE);
            noBooking.setFont(new Font("Arial", Font.BOLD, 18));
            card.add(noBooking);
        } else {
            Flight flight = booking.getFlight();
            String tripType = booking.isOneWay() ? "One Way" : "Round Trip";

            String[] rowLabels = {
                    "Booking Reference", "Passenger Name", "Date of Birth",
                    "Flight Number", "Route", "Departure Time", "Arrival Time",
                    "Trip Type", "Payment Method", "Total Amount Paid"
            };

            String[] rowValues = {
                    booking.getBookingId(),
                    booking.getPassengerName(),
                    booking.getDob(),
                    flight.getFlightNumber(),
                    flight.getFrom() + "  →  " + flight.getTo(),
                    flight.getDepartureTime(),
                    flight.getArrivalTime(),
                    tripType,
                    booking.getPaymentMethod(),
                    "$" + String.format("%.0f", booking.getTotalPrice())
            };

            int y = 25;
            for (int i = 0; i < rowLabels.length; i++) {
                JLabel label = new JLabel(rowLabels[i] + ":");
                label.setBounds(35, y, 220, 24);
                label.setForeground(new Color(200, 220, 245));
                label.setFont(new Font("Arial", Font.BOLD, 14));
                card.add(label);

                boolean emphasize = rowLabels[i].equals("Total Amount Paid");
                JLabel value = new JLabel(rowValues[i]);
                value.setBounds(265, y, 260, 24);
                value.setForeground(Color.WHITE);
                value.setFont(new Font("Arial", emphasize ? Font.BOLD : Font.PLAIN, emphasize ? 18 : 14));
                card.add(value);

                y += 32;
            }
        }

        UItheme.GlowButton homeButton = new UItheme.GlowButton("Back To Home Page");
        homeButton.setBounds(325, 585, 250, 45);
        panel.add(homeButton);

        homeButton.addActionListener(e -> {
            new LoginPage();
            dispose();
        });

        add(panel);
        setVisible(true);
    }
}