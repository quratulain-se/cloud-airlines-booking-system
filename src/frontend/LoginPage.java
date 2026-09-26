package frontend;

import javax.swing.*;

import backend.signupinfo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

public class LoginPage extends JFrame {

    public LoginPage() {
        setTitle("Cloud Airlines - Login");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        UItheme.GradientPanel panel = new UItheme.GradientPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 900, 600);

        // Header
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
        slogan.setBounds(650, 28, 350, 40);
        slogan.setForeground(new Color(200, 220, 255));
        slogan.setFont(new Font("Arial", Font.PLAIN, 15));
        header.add(slogan);

        JLabel title = new JLabel("Welcome To Cloud AirLines");
        title.setBounds(0, 130, 900, 40);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Century Gothic", Font.BOLD, 26));
        panel.add(title);

        JLabel subtitle = new JLabel("Sign in to book your journey");
        subtitle.setBounds(0, 170, 900, 30);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        subtitle.setForeground(new Color(210, 220, 240));
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(subtitle);

        // Glass login card
        UItheme.RoundedPanel card = new UItheme.RoundedPanel(25, new Color(255, 255, 255, 35));
        card.setLayout(null);
        card.setBounds(300, 220, 300, 300);
        card.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 80), 1));
        panel.add(card);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(30, 25, 200, 20);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Arial", Font.BOLD, 13));
        card.add(userLabel);

        JTextField userField = new JTextField();
        UItheme.styleField(userField);
        userField.setBounds(30, 48, 240, 38);
        card.add(userField);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(30, 100, 200, 20);
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(new Font("Arial", Font.BOLD, 13));
        card.add(passLabel);

        JPasswordField passField = new JPasswordField();
        UItheme.styleField(passField);
        passField.setBounds(30, 123, 240, 38);
        card.add(passField);

        UItheme.Glowtext createaccounttext = new UItheme.Glowtext( "Create Account");
        createaccounttext.setBounds(100,250,240,40);
        card.add(createaccounttext);

        createaccounttext.addMouseListener(new MouseAdapter() {

    @Override
    public void mouseClicked(MouseEvent e) {
        new createaccount();
        dispose();
    }

});

       UItheme.GlowButton signInButton = new UItheme.GlowButton("Sign In");
signInButton.setBounds(30, 190, 240, 45);
card.add(signInButton);

signInButton.addActionListener(e -> {

    String username = userField.getText().trim();
    String password = new String(passField.getPassword());

    if (username.isEmpty() || password.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Please enter both username and password.",
                "Login Failed",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    signupinfo account = new signupinfo();

    // Compare entered information with stored signup information
    if (username.equals(account.getUsername())
            && password.equals(account.getPassword())) {

        // Correct credentials
        new FlightsPage();
        dispose();

    } else {

        // Incorrect credentials
        JOptionPane.showMessageDialog(
                this,
                "Incorrect username or password.",
                "Login Failed",
                JOptionPane.ERROR_MESSAGE
        );
    }
});
        add(panel);
        setVisible(true);
    }
}