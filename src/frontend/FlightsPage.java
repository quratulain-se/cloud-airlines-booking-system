package frontend;

import javax.swing.*;

import backend.Flight;

import java.awt.*;
import java.util.ArrayList;

public class FlightsPage extends JFrame {

    private JButton fromButton;
private JButton toButton;
private JButton searchButton;

private JRadioButton oneWayRadio;
 private JRadioButton roundTripRadio;

    public FlightsPage() {

        setTitle("Search Flights");
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

        UItheme.GlowButton backButton = new UItheme.GlowButton("← Back");
backButton.setBounds(30, 100, 110, 36);
backButton.setFont(new Font("Arial", Font.BOLD, 13));
panel.add(backButton);

backButton.addActionListener(e -> {
    new LoginPage();
    dispose();
});

        // =========================
        // HEADING
        // =========================

        JLabel heading = new JLabel("Search Flights");
        heading.setBounds(0, 115, 900, 50);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Century Gothic", Font.BOLD, 30));
        panel.add(heading);

        // =========================
        // SUBHEADING
        // =========================

        JLabel subheading = new JLabel(
                "Select your Departure and Arrival city to See available flights."
        );

        subheading.setBounds(0, 165, 900, 30);
        subheading.setHorizontalAlignment(SwingConstants.CENTER);
        subheading.setForeground(new Color(210, 220, 240));
        subheading.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(subheading);

        // =========================
        // FROM LABEL
        // =========================

        JLabel fromLabel = new JLabel("Departure");
        fromLabel.setBounds(250, 215, 180, 25);
        fromLabel.setForeground(Color.WHITE);
        fromLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(fromLabel);

        // =========================
        // FROM BUTTON
        // =========================

        fromButton = new JButton("Select Departure City");
        fromButton.setBounds(250, 240, 180, 50);

        fromButton.setFont(new Font("Arial", Font.BOLD, 13));
        fromButton.setForeground(new Color(20, 40, 70));
        fromButton.setBackground(Color.WHITE);
        fromButton.setFocusPainted(false);
        fromButton.setBorder(BorderFactory.createLineBorder(
                new Color(150, 180, 210), 1
        ));

        panel.add(fromButton);

        fromButton.addActionListener(e -> {
            showCitySelector("Select Departure City", fromButton);
        });

        // =========================
        // TO LABEL
        // =========================

        JLabel toLabel = new JLabel("Arrival");
        toLabel.setBounds(470, 215, 180, 25);
        toLabel.setForeground(Color.WHITE);
        toLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(toLabel);

        // =========================
        // TO BUTTON
        // =========================

        toButton = new JButton("Select Arrival City");
        toButton.setBounds(470, 240, 180, 50);

        toButton.setFont(new Font("Arial", Font.BOLD, 13));
        toButton.setForeground(new Color(20, 40, 70));
        toButton.setBackground(Color.WHITE);
        toButton.setFocusPainted(false);
        toButton.setBorder(BorderFactory.createLineBorder(
                new Color(150, 180, 210), 1
        ));

        panel.add(toButton);

        toButton.addActionListener(e -> {
            showCitySelector("Select Arrival City", toButton);
        });
// =========================
// FLIGHT TYPE
// =========================

JLabel flightTypeLabel = new JLabel("Flight Type");
flightTypeLabel.setBounds(0, 315, 900, 25);
flightTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
flightTypeLabel.setForeground(Color.WHITE);
flightTypeLabel.setFont(new Font("Arial", Font.BOLD, 14));
panel.add(flightTypeLabel);


// =========================
// ONE WAY RADIO BUTTON
// =========================

oneWayRadio = new JRadioButton("One Way");
oneWayRadio.setBounds(335, 345, 100, 30);

oneWayRadio.setForeground(Color.WHITE);
oneWayRadio.setBackground(new Color(0, 0, 0, 0));
oneWayRadio.setFont(new Font("Arial", Font.BOLD, 13));
oneWayRadio.setFocusPainted(false);
oneWayRadio.setOpaque(false);

panel.add(oneWayRadio);


// =========================
// ROUND TRIP RADIO BUTTON
// =========================

roundTripRadio = new JRadioButton("Round Trip");
roundTripRadio.setBounds(455, 345, 120, 30);

roundTripRadio.setForeground(Color.WHITE);
roundTripRadio.setBackground(new Color(0, 0, 0, 0));
roundTripRadio.setFont(new Font("Arial", Font.BOLD, 13));
roundTripRadio.setFocusPainted(false);
roundTripRadio.setOpaque(false);

panel.add(roundTripRadio);


// =========================
// GROUP RADIO BUTTONS
// =========================

ButtonGroup flightTypeGroup = new ButtonGroup();

flightTypeGroup.add(oneWayRadio);
flightTypeGroup.add(roundTripRadio);


// =========================
// SEARCH BUTTON
// =========================

searchButton = new JButton("Search Flights");
searchButton.setBounds(350, 395, 200, 50);

searchButton.setFont(new Font("Arial", Font.BOLD, 15));
searchButton.setForeground(Color.WHITE);
searchButton.setBackground(new Color(20, 60, 110));
searchButton.setFocusPainted(false);
searchButton.setBorder(BorderFactory.createLineBorder(
        new Color(150, 190, 230), 1
));

panel.add(searchButton);


// =========================
// SEARCH BUTTON ACTION
// =========================

searchButton.addActionListener(e -> {

    String departure = fromButton.getText();
    String arrival = toButton.getText();

    if (departure.equals("Select Departure City") ||
        arrival.equals("Select Arrival City")) {
        JOptionPane.showMessageDialog(
                this,
                "Please select both Departure and Arrival cities.",
                "Missing Information",
                JOptionPane.WARNING_MESSAGE
        );
        return;
    }


    if (!oneWayRadio.isSelected() &&
        !roundTripRadio.isSelected()) {
        JOptionPane.showMessageDialog(
                this,
                "Please select a flight type.",
                "Missing Information",
                JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    String flightType;
    if (oneWayRadio.isSelected()) {
        flightType = "One Way";
    } else {
        flightType = "Round Trip";
    }
  boolean oneWay = oneWayRadio.isSelected();

    JOptionPane.showMessageDialog(
            this,
            "Searching flights...\n\n"
            + "Departure: " + departure
            + "\nArrival: " + arrival
            + "\nFlight Type: " + flightType,
            "Flight Search",
            JOptionPane.INFORMATION_MESSAGE
    );

    
    ArrayList<Flight> availableFlights = new ArrayList<>();

    for (Flight flight : backend.FlightsData.flights) {
        if (flight.getFrom().equals(departure) && flight.getTo().equals(arrival)) {
            availableFlights.add(flight);
        }
    }

    new FlightDetailPage(availableFlights, oneWay);
    dispose();
    
});
        // =========================
        // PUT PANEL INTO FRAME
        // =========================

        setContentPane(panel);

        setVisible(true);
    }

    // =====================================================
    // CITY SELECTOR
    // =====================================================

    private void showCitySelector(String title, JButton targetButton) {

        JDialog dialog = new JDialog(this, title, true);

        dialog.setSize(380, 400);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);
        dialog.setLayout(null);

        // =========================
        // DIALOG BACKGROUND
        // =========================

        JPanel mainPanel = new JPanel(null);
        mainPanel.setBackground(new Color(239, 245, 252));
        mainPanel.setBounds(0, 0, 380, 430);

        dialog.add(mainPanel);

        // =========================
        // DIALOG HEADER
        // =========================

        JPanel dialogHeader = new JPanel(null);
        dialogHeader.setBackground(new Color(8, 14, 28));
        dialogHeader.setBounds(0, 0, 380, 70);

        mainPanel.add(dialogHeader);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setBounds(20, 10, 340, 25);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Century Gothic", Font.BOLD, 17));
        dialogHeader.add(titleLabel);

        JLabel instruction = new JLabel("Choose a city");
        instruction.setBounds(20, 37, 340, 20);
        instruction.setForeground(new Color(190, 210, 235));
        instruction.setFont(new Font("Arial", Font.PLAIN, 12));
        dialogHeader.add(instruction);

        // =========================
        // CITY PANEL
        // =========================

        JPanel cityPanel = new JPanel();
        cityPanel.setLayout(new GridLayout(9, 1, 0, 4));
        cityPanel.setBackground(new Color(239, 245, 252));
        cityPanel.setBounds(25, 85, 330, 300);

        mainPanel.add(cityPanel);

        // =========================
        // RADIO BUTTONS
        // =========================

        String[] cities = {
                "London",
                "New York",
                "Berlin",
                "Zurich",
                
        };

        ButtonGroup group = new ButtonGroup();

        for (String city : cities) {

            JRadioButton radioButton = new JRadioButton(city);

            radioButton.setFont(new Font("Arial", Font.BOLD, 14));
            radioButton.setForeground(new Color(25, 45, 70));
            radioButton.setBackground(new Color(239, 245, 252));

            radioButton.setFocusPainted(false);
            radioButton.setBorderPainted(false);
            radioButton.setOpaque(true);

            group.add(radioButton);
            cityPanel.add(radioButton);

            // =========================
            // WHEN CITY IS SELECTED
            // =========================

            radioButton.addActionListener(e -> {

                targetButton.setText(city);

                dialog.dispose();
            });
        }

        // =========================
        // SHOW DIALOG
        // =========================

        dialog.setVisible(true);
    }
}