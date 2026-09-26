package frontend;

import backend.*;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class BookingForm extends JFrame {

    public BookingForm(Flight flight, ArrayList<Flight> previousResults, boolean oneWay) {
        this(flight, previousResults, oneWay, "", "");
    }

    public BookingForm(Flight flight, ArrayList<Flight> previousResults, boolean oneWay,
                        String prefillName, String prefillDob) {
        setTitle("Booking Form");
        setSize(900, 650);
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

        UItheme.GlowButton backButton = new UItheme.GlowButton("← Back");
        backButton.setBounds(30, 100, 110, 36);
        backButton.setFont(new Font("Arial", Font.BOLD, 13));
        panel.add(backButton);

        backButton.addActionListener(e -> {
            new FlightDetailPage(previousResults, oneWay);
            dispose();
        });

        JLabel heading = new JLabel("Passenger Details");
        heading.setBounds(0, 115, 900, 50);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Century Gothic", Font.BOLD, 28));
        panel.add(heading);

        UItheme.RoundedPanel card = new UItheme.RoundedPanel(25, new Color(255, 255, 255, 35));
        card.setLayout(null);
        card.setBounds(150, 190, 600, 380);
        card.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 80), 1));
        panel.add(card);

        JLabel nameLabel = new JLabel("Full Name");
        nameLabel.setBounds(30, 30, 200, 20);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        card.add(nameLabel);

        JTextField nameField = new JTextField(prefillName);
        UItheme.styleField(nameField);
        nameField.setBounds(30, 52, 540, 36);
        card.add(nameField);

        JLabel dobLabel = new JLabel("Date of Birth (DD/MM/YYYY)");
        dobLabel.setBounds(30, 105, 200, 20);
        dobLabel.setForeground(Color.WHITE);
        dobLabel.setFont(new Font("Arial", Font.BOLD, 14));
        card.add(dobLabel);

        JTextField dobField = new JTextField(prefillDob);
        UItheme.styleField(dobField);
        dobField.setBounds(30, 127, 540, 36);
        card.add(dobField);

        JLabel paymentLabel = new JLabel("Payment Method");
        paymentLabel.setBounds(30, 185, 200, 20);
        paymentLabel.setForeground(Color.WHITE);
        paymentLabel.setFont(new Font("Arial", Font.BOLD, 14));
        card.add(paymentLabel);

        JRadioButton cash = new JRadioButton("Cash");
        cash.setFocusPainted(false);
        cash.setOpaque(false);
        cash.setForeground(Color.WHITE);
        cash.setFont(new Font("Arial", Font.PLAIN, 15));
        cash.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cash.setBounds(30, 210, 100, 35);
        card.add(cash);

        JRadioButton card_ = new JRadioButton("Card");
        card_.setFocusPainted(false);
        card_.setOpaque(false);
        card_.setForeground(Color.WHITE);
        card_.setFont(new Font("Arial", Font.PLAIN, 15));
        card_.setCursor(new Cursor(Cursor.HAND_CURSOR));
        card_.setBounds(140, 210, 100, 35);
        card.add(card_);

        ButtonGroup group = new ButtonGroup();
        group.add(cash);
        group.add(card_);

        UItheme.GlowButton continueButton = new UItheme.GlowButton("Continue");
        continueButton.setBounds(180, 280, 240, 50);
        card.add(continueButton);

        continueButton.addActionListener(e -> {
            String name = nameField.getText();
            String dob = dobField.getText();

            if (name.isEmpty() || dob.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all details");
                return;
            }

            if (!isValidDob(dob)) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a valid Date of Birth in DD/MM/YYYY format .",
                        "Invalid Date", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (cash.isSelected()) {
                Booking booking = new Booking(name, dob, flight, "Cash", oneWay);
                BookingManager.bookFlight(booking);
                new SuccessPage();
                dispose();
            } else if (card_.isSelected()) {
                new CardPaymentForm(name, dob, flight, previousResults, oneWay);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Select payment method");
            }
        });

        add(panel);
        setVisible(true);
    }

    private boolean isValidDob(String dob) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                .withResolverStyle(java.time.format.ResolverStyle.STRICT);
        try {
            LocalDate date = LocalDate.parse(dob, formatter);
            return !date.isAfter(LocalDate.now());
        } catch (DateTimeParseException ex) {
            return false;
        }
    }
}