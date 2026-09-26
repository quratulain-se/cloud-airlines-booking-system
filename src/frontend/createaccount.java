package frontend;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import backend.signupinfo;
import java.awt.*;
import backend.signupinfo;

public class createaccount extends JFrame {
 public createaccount() {
        signupinfo account = new signupinfo();

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
        card.setBounds(300, 220, 320, 320);
        card.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 80), 1));
        panel.add(card);

        JLabel userLabel = new JLabel("Create Username");
        userLabel.setBounds(30, 25, 200, 20);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Arial", Font.BOLD, 13));
        card.add(userLabel);

        JTextField userField = new JTextField();
        UItheme.styleField(userField);
        userField.setBounds(30, 33, 240, 38);
        card.add(userField);

        JLabel passLabel = new JLabel("Create Password");
        passLabel.setBounds(30, 80, 200, 20);
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(new Font("Arial", Font.BOLD, 13));
        card.add(passLabel);

        JPasswordField passField = new JPasswordField();
        UItheme.styleField(passField);
        passField.setBounds(30, 88, 240, 38);
        card.add(passField);

        JLabel cnfrmpassLabel = new JLabel("Confirm Password");
        cnfrmpassLabel.setBounds(30, 130, 200, 20);
        cnfrmpassLabel.setForeground(Color.WHITE);
        cnfrmpassLabel.setFont(new Font("Arial", Font.BOLD, 13));
        card.add(cnfrmpassLabel);

        JPasswordField cnfrmpassField = new JPasswordField();
        UItheme.styleField(cnfrmpassField);
        cnfrmpassField.setBounds(30, 150, 240, 38);
        card.add(cnfrmpassField);

         UItheme.Glowtext backtext = new UItheme.Glowtext( "Back to Login Page");
        backtext.setBounds(98,250,240,40);
        card.add(backtext);

        backtext.addMouseListener(new MouseAdapter() {

    @Override
    public void mouseClicked(MouseEvent e) {
        new LoginPage();
        dispose();
    }

});

      UItheme.GlowButton signUpButton = new UItheme.GlowButton("Sign UP");
        signUpButton.setBounds(30, 210, 240, 45);
        card.add(signUpButton);

        
        signUpButton.addActionListener(e -> {

    String username = userField.getText().trim();
    String password = new String(passField.getPassword());
    String confirmPassword = new String(cnfrmpassField.getPassword());

    if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Please fill all fields.",
                "Sign UP Failed",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    if (!password.equals(confirmPassword)) {

        JOptionPane.showMessageDialog(
                this,
                "Passwords do not match.",
                "Sign UP Failed",
                JOptionPane.ERROR_MESSAGE
        );

        return;
    }

    // Save username and password
    account.setUsername(username);
    account.setPassword(password);

    JOptionPane.showMessageDialog(
            this,
            "Account created successfully!",
            "Sign UP Successful",
            JOptionPane.INFORMATION_MESSAGE
    );

    // Go back to Sign In page
    new LoginPage();
    dispose();
});

        add(panel);
        setVisible(true);
    }
}
