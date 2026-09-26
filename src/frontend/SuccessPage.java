package frontend;

import backend.BookingManager;
import javax.swing.*;
import java.awt.*;

public class SuccessPage extends JFrame {

    public SuccessPage() {
        setTitle("Booking Successful");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        UItheme.GradientPanel panel = new UItheme.GradientPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 900, 600);

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

        UItheme.RoundedPanel card = new UItheme.RoundedPanel(25, new Color(255, 255, 255, 35));
        card.setLayout(null);
        card.setBounds(200, 150, 500, 380);
        card.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 80), 1));
        panel.add(card);

        JLabel success = new JLabel("Booking Successful!");
        success.setBounds(0, 30, 500, 50);
        success.setHorizontalAlignment(SwingConstants.CENTER);
        success.setForeground(Color.WHITE);
        success.setFont(new Font("Century Gothic", Font.BOLD, 28));
        card.add(success);

        JLabel message = new JLabel("You can only cancel booking now.");
        message.setBounds(0, 90, 500, 30);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        message.setForeground(new Color(210, 220, 240));
        message.setFont(new Font("Arial", Font.PLAIN, 16));
        card.add(message);

        UItheme.GlowButton cancelButton = new UItheme.GlowButton("Cancel Booking");
        cancelButton.setBounds(130, 150, 240, 48);
        card.add(cancelButton);

        UItheme.GlowButton viewReceiptButton = new UItheme.GlowButton("View Receipt");
        viewReceiptButton.setBounds(130, 210, 240, 48);
        card.add(viewReceiptButton);

        UItheme.GlowButton homeButton = new UItheme.GlowButton("Back To Home Page");
        homeButton.setBounds(130, 270, 240, 48);
        card.add(homeButton);

        cancelButton.addActionListener(e -> {
            BookingManager.cancelBooking();
            JOptionPane.showMessageDialog(this, "Booking Cancelled");
        });

        viewReceiptButton.addActionListener(e -> {
            new ReceiptPage(BookingManager.getCurrentBooking());
            dispose();
        });

        homeButton.addActionListener(e -> {
            new LoginPage();
            dispose();
        });

        add(panel);
        setVisible(true);
    }
}