package frontend;

import backend.Flight;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FlightDetailPage extends JFrame {
        

    public FlightDetailPage(ArrayList<Flight> availableFlights, boolean oneWay) {

        setTitle("Available Flights");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // =========================
        // MAIN BACKGROUND
        // =========================

        UItheme.GradientPanel panel = new UItheme.GradientPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 900, 600);


        // BACK BUTTON
UItheme.GlowButton backButton = new UItheme.GlowButton("← Back");
backButton.setBounds(30, 100, 110, 36);
backButton.setFont(new Font("Arial", Font.BOLD, 13));
panel.add(backButton);

backButton.addActionListener(e -> {
    new FlightsPage();
    dispose();
});


        // =========================
        // HEADER
        // =========================

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

        // =========================
        // HEADING
        // =========================

        JLabel heading = new JLabel("Available Flights");
        heading.setBounds(0, 115, 900, 50);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Century Gothic", Font.BOLD, 30));
        panel.add(heading);

        // =========================
        // NO FLIGHTS FOUND
        // =========================

        if (availableFlights.isEmpty()) {

            JLabel noFlights = new JLabel("No flights available for this route.");
            noFlights.setBounds(0, 230, 900, 40);
            noFlights.setHorizontalAlignment(SwingConstants.CENTER);
            noFlights.setForeground(Color.WHITE);
            noFlights.setFont(new Font("Arial", Font.BOLD, 18));

            panel.add(noFlights);

        } else {

            // =========================
            // FLIGHT RESULTS PANEL
            // =========================

            JPanel flightsPanel = new JPanel();
            flightsPanel.setLayout(new BoxLayout(flightsPanel, BoxLayout.Y_AXIS));
            flightsPanel.setOpaque(false);

            int cardHeight = 150;
            int totalHeight = availableFlights.size() * (cardHeight + 15);

            flightsPanel.setBounds(150, 180, 600, totalHeight);

            // =========================
            // CREATE FLIGHT CARDS
            // =========================

            for (Flight flight : availableFlights) {

                UItheme.RoundedPanel card =
                        new UItheme.RoundedPanel(
                                25,
                                new Color(255, 255, 255, 45)
                        );

                card.setLayout(null);
                card.setPreferredSize(new Dimension(600, cardHeight));
                card.setMaximumSize(new Dimension(600, cardHeight));
                card.setMinimumSize(new Dimension(600, cardHeight));

                card.setBorder(BorderFactory.createLineBorder(
                        new Color(255, 255, 255, 80), 1
                ));

                // =========================
                // FLIGHT NUMBER
                // =========================

                JLabel flightNumber = new JLabel(
                        "Flight " + flight.getFlightNumber()
                );

                flightNumber.setBounds(25, 15, 180, 30);
                flightNumber.setForeground(Color.WHITE);
                flightNumber.setFont(
                        new Font("Arial", Font.BOLD, 18)
                );

                card.add(flightNumber);

                // =========================
                // ROUTE
                // =========================

                JLabel route = new JLabel(
                        flight.getFrom() + "  →  " + flight.getTo()
                );

                route.setBounds(25, 50, 300, 30);
                route.setForeground(Color.WHITE);
                route.setFont(
                        new Font("Arial", Font.BOLD, 16)
                );

                card.add(route);

                // =========================
                // TIME
                // =========================

                JLabel time = new JLabel( "Time: " +
                        flight.getDepartureTime()
                        + "  →  "
                        + flight.getArrivalTime()
                );

                time.setBounds(25, 85, 300, 25);
                time.setForeground(new Color(210, 225, 245));
                time.setFont(
                        new Font("Arial", Font.PLAIN, 14)
                );

                card.add(time);

                //==========================
                //Price
                //==========================

        JLabel price = new JLabel();    {
                if (oneWay) {
                        
                
                 price.setText(
                        "$" + String.format("%.0f", flight.getPrice())
                );

                
                }
        else{
            price.setText(
                        "$" + String.format("%.0f", flight.getPrice()*2)
                );
 
        }    
        price.setBounds(380, 30, 170, 35);
                price.setHorizontalAlignment(SwingConstants.RIGHT);
                price.setForeground(Color.WHITE);
                price.setFont(
                        new Font("Arial", Font.BOLD, 22)
                ); 
                card.add(price);   
        
        }

                // =========================
                // BOOK NOW BUTTON
                // =========================

                UItheme.GlowButton bookNow =
                        new UItheme.GlowButton("Book Now");

                bookNow.setBounds(390, 80, 170, 40);

                card.add(bookNow);

                // =========================
                // BOOK BUTTON ACTION
                // =========================

                bookNow.addActionListener(e -> {
    new BookingForm(flight, availableFlights, oneWay);
    dispose();
});

                               flightsPanel.add(card);

                // Space between cards
                flightsPanel.add(Box.createVerticalStrut(15));
        }

            panel.add(flightsPanel);
        }

        // =========================
        // PUT PANEL INTO FRAME
        // =========================

        setContentPane(panel);

        setVisible(true);
    }
}