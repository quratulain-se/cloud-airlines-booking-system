package frontend;

import backend.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CardPaymentForm extends JFrame {

    public CardPaymentForm(String user, String dob, Flight flight, ArrayList<Flight> previousResults, boolean oneWay) {
        setTitle("Card Payment");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        UItheme.GradientPanel panel = new UItheme.GradientPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 900, 700);

        JPanel header = new JPanel(null);
        header.setBackground(new Color(8, 14, 28, 190));
        header.setBounds(0, 0, 900, 90);
        panel.add(header);

        JLabel logo = new JLabel("ABC AirLines");
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
            new BookingForm(flight, previousResults, oneWay, user, dob);
            dispose();
        });

        JLabel heading = new JLabel("Card Payment Details");
        heading.setBounds(0, 115, 900, 50);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Century Gothic", Font.BOLD, 28));
        panel.add(heading);

        UItheme.RoundedPanel card = new UItheme.RoundedPanel(25, new Color(255, 255, 255, 35));
        card.setLayout(null);
        card.setBounds(150, 190, 600, 430);
        card.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 80), 1));
        panel.add(card);

        JLabel bankLabel = new JLabel("Bank Name");
        JLabel accountLabel = new JLabel("Account No");
        JLabel cardLabel = new JLabel("Card Number");
        JLabel expiryLabel = new JLabel("Expiry Date");
        JLabel cvvLabel = new JLabel("CVV");
        JLabel[] labels = {bankLabel, accountLabel, cardLabel, expiryLabel, cvvLabel};

        JTextField bankField = new JTextField();
        JTextField accountField = new JTextField();
        JTextField cardField = new JTextField();
        JTextField expiryField = new JTextField();
        JPasswordField cvvField = new JPasswordField();
        JTextField[] fields = {bankField, accountField, cardField, expiryField, cvvField};

        int y = 30;
        for (int i = 0; i < labels.length; i++) {
            labels[i].setBounds(30, y, 150, 20);
            labels[i].setForeground(Color.WHITE);
            labels[i].setFont(new Font("Arial", Font.BOLD, 14));
            card.add(labels[i]);

            UItheme.styleField(fields[i]);
            fields[i].setBounds(30, y + 22, 540, 34);
            card.add(fields[i]);

            y += 62;
        }

        UItheme.GlowButton payButton = new UItheme.GlowButton("Pay Now");
        payButton.setBounds(190, y + 15, 220, 50);
        card.add(payButton);

        payButton.addActionListener(e -> {
            boolean success = PaymentManager.processCardPayment(
                    bankField.getText(),
                    accountField.getText(),
                    cardField.getText(),
                    expiryField.getText(),
                    new String(cvvField.getPassword())
            );
            if (success) {
                Booking booking = new Booking(user, dob, flight, "Card", oneWay);
                BookingManager.bookFlight(booking);
                new SuccessPage();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please complete all card details");
            }
        });

        add(panel);
        setVisible(true);
    }
}